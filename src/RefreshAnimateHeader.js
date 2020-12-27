'use strict';
import React, { useRef, useCallback, useMemo } from 'react';
import { StyleSheet, Animated, Platform, RefreshControl,View } from 'react-native';
import LottieView from 'lottie-react-native';
import {SmartRefresh,SmartRefreshHeader} from "../index";

function RefreshAnimateHeader(props) {
  const { refreshing, onRefresh=()=>{}, source } = props;

  const lottieRef = useRef(React.createRef());

  const onRefreshCallBack = useCallback(
    (state) => {
        lottieRef.current?.play();
      onRefresh(state);
    },
    [onRefresh],
  );

  const onIdleRefreshCallBack = useCallback((state) => {
      lottieRef.current?.reset();
  }, []);
  const onChangeStateCallBack = useCallback((event) => {
    const { state } = event.nativeEvent;
    switch (state) {
      case 0:
          onIdleRefreshCallBack();
        break;
      case 2:
        onRefreshCallBack();
        break;
      default:

    }
  }, []);
  return (
    <SmartRefresh
      refreshing={refreshing}
      onChangeState={onChangeStateCallBack}
    >
        <SmartRefreshHeader
          style={styles.container}
        >
          <LottieView
              ref={lottieRef}
              style={styles.lottery}
              resizeMode={'cover'}
              loop={true}
              autoSize={false}
              autoPlay={false}
              speed={2}
              source={require('./assets/cycle_animation.json')}
              hardwareAccelerationAndroid={true}
              cacheStrategy={'strong'}
          />
        </SmartRefreshHeader>
      {props.children}
    </SmartRefresh>
  );
}

const styles = StyleSheet.create({
  container: {
    height: 80,
    justifyContent: 'center',
    alignItems: 'center',
  },
  lottery: {
    height: 80,
  },
});

export default React.memo(RefreshAnimateHeader);
