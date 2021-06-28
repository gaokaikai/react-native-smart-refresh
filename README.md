# react-native-smart-refresh

## 使用预览

![image](https://github.com/gaokaikai/react-native-smart-refresh/blob/master/example/lottie.gif)

![image](https://github.com/gaokaikai/react-native-smart-refresh/blob/master/example/normal.gif)

## Getting started

`$ yarn add react-native-smart-refresh`

### Mostly automatic installation

`$ react-native link react-native-smart-refresh`

## Usage
```javascript
import {RefreshAnimateHeader} from 'react-native-smart-refresh';

// TODO: What to do with the module?
// 使用Lottie动画Header，source为自定义Lottie动画的Json，可以使用源码中的，可以参考官网生成
// AnimateHeader支持属性：refreshing, onRefresh, source='', containerStyle, lottieStyle, lottieOptions，参考源码
<ScrollView
  refreshControl={
    <RefreshAnimateHeader
      refreshing={this.state.refreshing}
      onRefresh={this.onRefresh}
      source={require('../../../lib/lottie/41420-pending.json')}
    />
  }
>
</ScrollView>

// 使用Normal Header，兼容刘海屏情况
// Normal Header支持属性：refreshing, onRefresh, children, activityIndicatorProps, arrowIcon, containerStyle, titleStyle, timeStyle, leftContainerStyle, rightContainerStyle, imageStyle，参考源码
<ScrollView
  // onRefresh={onRefresh}
  // offsetTop={245}
  refreshControl={
  <RefreshNormalHeader
    refreshing={isRefreshing}
    onRefresh={onRefresh}
    containerStyle={{ marginBottom: 20, alignItems: 'flex-end' }}
    titleStyle={{ fontSize: 14 }}
    timeStyle={{ fontSize: 14 }}
    leftContainerStyle={{ marginBottom: 8 }}
    activityIndicatorProps={{ color: Colors.SunColor }}
   />
  }
>
</ScrollView>
```
