package com.project.common.jsbrigelibrary;

import jsbridge.CallBackFunction;

/**
 * Created by Bryan on 2017/10/16.
 */

public interface BridgeListener {

    void onBrigeCalled(String name, String data, CallBackFunction function);

    void OnBrigeResponse(String name, String data);
}
