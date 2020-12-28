# react-native-smart-refresh

##使用预览
![image](https://gitee.com/gaokai1101731946/react-native-smart-refresh/blob/master/example/lottie.gif)
![image](https://gitee.com/gaokai1101731946/react-native-smart-refresh/blob/master/example/normal.gif)

## Getting started

`$ yarn add react-native-smart-refresh`

### Mostly automatic installation

`$ react-native link react-native-smart-refresh`

## Usage
```javascript
import {RefreshAnimateHeader} from 'react-native-smart-refresh';

// TODO: What to do with the module?
// 使用方法
 refreshControl={<RefreshAnimateHeader
                   refreshing={this.state.refreshing}
                   onRefresh={this.onRefresh}
               ></RefreshAnimateHeader>}
```
