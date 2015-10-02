package com.pusher.PusherReactNative;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

/**
 * Created by jamiepatel on 02/10/2015.
 */
public class PusherReactNativeModule extends ReactContextBaseJavaModule {

    Pusher pusher;

    public PusherReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Pusher";
    }

    @ReactMethod
    public void connect(String key){
        pusher = new Pusher(key);
        pusher.connect();
    }

    @ReactMethod
    public void subscribe(String channelName){
        if (channelName.startsWith("private-")) {
            pusher.subscribePrivate(channelName);
        } else if (channelName.startsWith("presence-")){
            pusher.subscribePresence(channelName);
        } else{
            pusher.subscribe(channelName);
        }
    }

    @ReactMethod
    public void mPrivateSubscribe(String channelName){
        pusher.subscribePrivate(channelName);
    }

    @ReactMethod
    public void mListen(String channelName, String eventName, final Callback listener){
        final Channel channel = pusher.getChannel(channelName);
        channel.bind(eventName, new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, String data) {
                listener.invoke(data);
            }
        });
    }


}
