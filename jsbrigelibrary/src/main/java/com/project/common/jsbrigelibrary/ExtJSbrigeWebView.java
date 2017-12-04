package com.project.common.jsbrigelibrary;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.List;

import jsbridge.BridgeHandler;
import jsbridge.BridgeWebView;
import jsbridge.CallBackFunction;
import jsbridge.DefaultHandler;

/**
 * Created by Bryan on 2017/10/16.
 */

public class ExtJSbrigeWebView extends BridgeWebView {
    public ExtJSbrigeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtJSbrigeWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ExtJSbrigeWebView(Context context) {
        super(context);
    }



    public void registerHandlers(String [] names,BridgeListener listener){

        if(names!=null&&names.length>0){
            for(int i=0;i<names.length ;i++){
                String name = names[i];
                JsBrigeHandlerImpl jsBrigeHandler = new JsBrigeHandlerImpl(name);
                jsBrigeHandler.setBrigeListener(listener);
                this.registerHandler(name, jsBrigeHandler);
            }
        }
    }
    public void callHandlers(List<JsBrigeInfo> list, BridgeListener listener){

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size() ;i++){
                JsBrigeInfo jsBrigeInfo = list.get(i);
                JSCallbackImpl jsCallback = new JSCallbackImpl(jsBrigeInfo.getHandler_name());
                jsCallback.setListener(listener);
                this.callHandler(jsBrigeInfo.getHandler_name(),jsBrigeInfo.getData(), jsCallback);
            }
        }
    }


    public void  init(){
        setWebView();
        this.setDefaultHandler(new DefaultHandler());
    }

    private void setWebView() {
        this.clearCache(true);
        WebSettings settings = this.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(false);

        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        //启用地理定位
        settings.setGeolocationEnabled(true);
        //开启DomStorage缓存
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String cachePath = getContext().getCacheDir().getAbsolutePath();
        if (Build.VERSION.SDK_INT <= 20) {
            //4.4以下需手动设置database路径,方使domstorage生效
            cachePath += "/database";
            settings.setDatabasePath(cachePath);
        }
        settings.setAppCachePath(cachePath);
        settings.setAllowFileAccess(true);
        settings.setGeolocationDatabasePath(getContext().getFilesDir().getPath());
        //启用数据库
        settings.setDatabaseEnabled(true);

    }

    private void setcookie(String domain,String cookie) {
        //检查cookie为空吗,为空就要从文件拿


        CookieSyncManager.createInstance(getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();//移除
        if (!TextUtils.isEmpty(cookie)) {
            cookieManager.setCookie(domain, cookie);//cookies是在HttpClient中获得的cookie
        }
        CookieSyncManager.getInstance().sync();


    }

    public  void ondestroy() {



        this.destroy();

    }


}
