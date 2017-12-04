package jsbridge;

import android.webkit.WebView;

/**
 * Created by Bryan on 2017/3/18.
 */

public interface PageInterface {


   void  onPageFinshed(WebView view, String url);
   void  onPageStarted(WebView view, String url);
   void  onReceivedError(WebView view, int errorCode, String description, String failingUrl);
}
