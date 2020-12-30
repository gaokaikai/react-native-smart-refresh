package com.reactlibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class SmartRefreshManager extends ViewGroupManager<RCTRefreshLayout> {
    public static final String REACT_CLASS = "RNSmartRefreshView";

    //返回名字
    @Override
    public String getName() {
        return REACT_CLASS;
    }
    //    初始化

    @NonNull
    @Override
    protected RCTRefreshLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RCTRefreshLayout(reactContext);
    }

    /**

     * 自定义事件

     */
    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        String onChangeStateEvent = RCTRefreshLayout.EVETN_NAME_CHANGE_STATE;
        String onChangeOffsetEvent = RCTRefreshLayout.EVETN_NAME_CHANGE_OFFSET;
        return MapBuilder.<String, Object>builder()
                .put(onChangeStateEvent, MapBuilder.of("registrationName", onChangeStateEvent))
                .put(onChangeOffsetEvent, MapBuilder.of("registrationName", onChangeOffsetEvent)).build();
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(RCTRefreshLayout view, Boolean refreshing) {
        if(!refreshing){
            view.finishRefresh();
        }
    }

}
