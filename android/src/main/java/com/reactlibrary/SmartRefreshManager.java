package com.reactlibrary;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.ReactEventEmitter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

import static com.facebook.react.views.textinput.ReactTextInputManager.TAG;

public class SmartRefreshManager extends ViewGroupManager<SmartRefreshLayout> {
    public static final String REACT_CLASS = "RNSmartRefreshView";
    //    刷新
    public static final String EVETN_NAME_ONREFRESH = "onRefreshing";

    ReactApplicationContext mCallerContext;

    public SmartRefreshManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }
    //返回名字
    @Override
    public String getName() {
        return REACT_CLASS;
    }
    //    初始化
    @Override
    public SmartRefreshLayout createViewInstance(ThemedReactContext context) {
        final SmartRefreshLayout smartrefresh = new SmartRefreshLayout(context);
        return smartrefresh;
    }
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                 layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });

    }
    //    监听事件 下拉
    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final SmartRefreshLayout view) {
        view.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                WritableMap map = Arguments.createMap();
                map.putBoolean("refreshing",true);
                reactContext.getJSModule(RCTEventEmitter.class)
                        .receiveEvent(view.getId(),EVETN_NAME_ONREFRESH,map);
            }
        });
    }
    /**

     * 自定义事件

     */

    @Nullable
    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(EVETN_NAME_ONREFRESH, MapBuilder.of("registrationName",EVETN_NAME_ONREFRESH));

    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(SmartRefreshLayout view,Boolean refreshing){
        view.finishRefresh(true);
    }

}
