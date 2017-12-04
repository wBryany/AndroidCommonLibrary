package com.project.common.jsbrigelibrary;

import jsbridge.BridgeHandler;
import jsbridge.CallBackFunction;

/**
 * Created by Bryan on 2017/10/16.
 */

public class JsBrigeHandlerImpl implements BridgeHandler {
    private String handlername;
    private BridgeListener listener;


    public JsBrigeHandlerImpl(String handlername) {
        this.handlername = handlername;
    }


    public String getHandlername() {
        return handlername;
    }

    public void setHandlername(String handlername) {
        this.handlername = handlername;
    }

    @Override
    public void handler(String data, CallBackFunction function) {

        listener.onBrigeCalled(getHandlername(), data, function);

    }


    public void setBrigeListener(BridgeListener listener) {
        this.listener = listener;

    }


}
