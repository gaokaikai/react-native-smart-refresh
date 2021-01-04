package com.reactlibrary;

import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.scroll.ReactScrollView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.scwang.smart.refresh.layout.util.SmartUtil;

public class RCTRefreshLayout extends SmartRefreshLayout {
    //    刷新
    public static final String EVETN_NAME_CHANGE_OFFSET = "onChangeOffset";
    public static final String EVETN_NAME_CHANGE_STATE = "onChangeState";
    private ThemedReactContext mCallerContext;
    private RCTEventEmitter eventEmitter;

    public RCTRefreshLayout(ThemedReactContext context) {
        super(context);
        mCallerContext = context;
        eventEmitter = context.getJSModule(RCTEventEmitter.class);
        this.setEnableLoadMore(false);
        this.setEnableOverScrollDrag(true);
        this.setOnMultiListener(new SimpleMultiListener() {
            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                WritableMap map = new WritableNativeMap();
                if (newState == RefreshState.None) {
                    map.putInt("state", 0);
                    eventEmitter.receiveEvent(getTargetId(), EVETN_NAME_CHANGE_STATE, map);
                } else if (newState == RefreshState.ReleaseToRefresh) {
                    map.putInt("state", 1);
                    eventEmitter.receiveEvent(getTargetId(), EVETN_NAME_CHANGE_STATE, map);
                } else if (newState == RefreshState.Refreshing) {
                    map.putInt("state", 2);
                    eventEmitter.receiveEvent(getTargetId(), EVETN_NAME_CHANGE_STATE, map);
                }
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                WritableMap map = new WritableNativeMap();
                map.putDouble("offset", SmartUtil.px2dp(offset));
                eventEmitter.receiveEvent(getTargetId(), EVETN_NAME_CHANGE_OFFSET, map);
            }
        });
    }
    private int getTargetId() {
        return this.getId();
    }

    @Override
    public void addView(View child, int index) {
        if (child instanceof RCTRefreshHeader) {
//             this.setRefreshHeader((RCTRefreshHeader) child);
            this.setRefreshHeader((RCTRefreshHeader) child,0,300);
        } else if (child instanceof ReactScrollView) {
            this.setRefreshContent(child);
        }
    }
}
