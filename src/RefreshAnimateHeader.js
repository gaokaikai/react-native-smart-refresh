'use strict';
import React, { useRef, useCallback, useMemo,useState } from 'react';
import { StyleSheet, Animated, Platform, RefreshControl,View } from 'react-native';
import LottieView from 'lottie-react-native';
import {SmartRefresh,SmartRefreshHeader} from "../index";
import {AnimatedValue} from "react-native-reanimated";

function RefreshAnimateHeader(props) {
  const { refreshing, onRefresh=()=>{}, source='' } = props;

  const lottieRef = useRef(React.createRef());
  let offsetValue = new Animated.Value(0);
  let [currentState,setCurrentState] = useState(0);
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
    setCurrentState(state);
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
  const onChangeOffsetCallBack = useCallback((event)=>{
    const { offset } = event.nativeEvent;

    if(currentState==0 || currentState==1){
      offsetValue.setValue(offset);
    }
  });
  return (
    <SmartRefresh
      refreshing={refreshing}
      onChangeState={onChangeStateCallBack}
      onChangeOffset={onChangeOffsetCallBack}
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
              source={source || require('./assets/cycle_animation.json')}
              hardwareAccelerationAndroid={true}
              cacheStrategy={'strong'}
              progress={offsetValue.interpolate({
                inputRange:[0,300],
                outputRange:[0,1],
              })}
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
