package com.reactlibrary;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class RCTRefreshHeaderManager extends ViewGroupManager<RCTRefreshHeader> {
    final String CLASS_NAME = "RNRefreshHeader";
    @NonNull
    @Override
    public String getName() {
        return CLASS_NAME;
    }

    @NonNull
    @Override
    protected RCTRefreshHeader createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RCTRefreshHeader(reactContext);
    }
}
