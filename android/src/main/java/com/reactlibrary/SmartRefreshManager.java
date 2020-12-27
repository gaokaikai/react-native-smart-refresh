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



//    @Override
//    public void addView(SmartRefreshLayout parent, View child, int index) {
//        if (child instanceof ReactScrollView) {
//            parent.setRefreshContent(child);
//        }else {
//            parent.setRefreshHeader((RefreshHeader) child);
//        }
//    }

//    //    监听事件 下拉
//    @Override
//    protected void addEventEmitters(final ThemedReactContext reactContext, final SmartRefreshLayout view) {
////        view.setOnRefreshListener(new OnRefreshListener() {
////            @Override
////            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
////                WritableMap map = Arguments.createMap();
////                map.putBoolean("refreshing",true);
////                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(),EVETN_NAME_ONREFRESH,map);
////            }
////        });
//        view.setOnMultiListener(new SimpleMultiListener() {
//            @Override
//            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
//                WritableMap map = new WritableNativeMap();
//                if (newState == RefreshState.None) {
//                    map.putInt("state", 0);
//                    eventEmitter.receiveEvent(view.getId(), EVETN_NAME_CHANGE_STATE, map);
//                } else if (newState == RefreshState.ReleaseToRefresh) {
//                    map.putInt("state", 1);
//                    eventEmitter.receiveEvent(view.getId(), EVETN_NAME_CHANGE_STATE, map);
//                } else if (newState == RefreshState.Refreshing) {
//                    map.putInt("state", 2);
//                    eventEmitter.receiveEvent(view.getId(), EVETN_NAME_CHANGE_STATE, map);
//                }
//            }
//
////            @Override
////            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
////                WritableMap map = new WritableNativeMap();
////                map.putDouble("offset", SmartUtil.px2dp(offset));
////                eventEmitter.receiveEvent(view.getId(), EVETN_NAME_CHANGE_OFFSET, map);
////            }
//        });
//    }
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
