package com.project.common.jsbrigelibrary;

import jsbridge.CallBackFunction;

/**
 * Created by Bryan on 2017/10/17.
 */

public class JSCallbackImpl implements CallBackFunction {
    private String handlername;
    private BridgeListener listener;



    public JSCallbackImpl(String handlername) {
        this.handlername = handlername;
    }

    @Override
    public void onCallBack(String data) {
        listener.OnBrigeResponse(this.handlername,data);
    }

    public String getHandlername() {
        return handlername;
    }

    public void setHandlername(String handlername) {
        this.handlername = handlername;
    }
    public BridgeListener getListener() {
        return listener;
    }

    public void setListener(BridgeListener listener) {
        this.listener = listener;
    }


}
