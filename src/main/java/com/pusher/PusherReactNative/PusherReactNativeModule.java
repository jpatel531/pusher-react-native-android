package com.pusher.PusherReactNative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/**
 * Created by jamiepatel on 02/10/2015.
 */
public class PusherReactNativeModule extends ReactContextBaseJavaModule {
    public PusherReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Pusher";
    }
}
