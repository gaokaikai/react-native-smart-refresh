import React from 'react';
import {
    View,
    Text,
    requireNativeComponent,
    StyleSheet, ScrollView,Platform
} from 'react-native';
import PropTypes from 'prop-types';
const RNSmartRefresh = requireNativeComponent('RNSmartRefreshView');
const RNSmartRefreshHeader = requireNativeComponent('RNRefreshHeader');
import RefreshAnimateHeader from "./src/RefreshAnimateHeader";
import RefreshNormalHeader from "./src/RefreshNormalHeader";

export class SmartRefresh extends React.PureComponent{
    constructor(props) {
        super(props);
    }
    static propTypes = {
        style:PropTypes.object,
        onRefresh:PropTypes.func,
        onChangeState:PropTypes.func,
        onChangeOffset:PropTypes.func,
        refreshing:PropTypes.bool,
    }
    static defaultProps = {
        style:Platform.OS==='android'?{flex:1}:{position:'absolute',left:0,top:0,right:0},
        onRefresh:()=>{},
        onChangeOffset:()=>{},
        refreshing:false,
    }
    render() {
        const {children} = this.props;
        if(Platform.OS=='android'){
            return (
                <View
                    style={{flex:1,overflow:'hidden'}}
                >
                    <RNSmartRefresh
                        {...this.props}
                    >
                        {children}
                    </RNSmartRefresh>
                </View>
            )
        }
        return (
            <RNSmartRefresh
                {...this.props}
            >
                {children}
            </RNSmartRefresh>
        );
    }
}
export class SmartRefreshHeader extends React.PureComponent{
    constructor(props) {
        super(props);
    }
    render() {
        const {children} = this.props;
        return (
            <RNSmartRefreshHeader
                {...this.props}
            >
                   {children}
            </RNSmartRefreshHeader>
        );
    }
}

export {
    RefreshNormalHeader,
    RefreshAnimateHeader
}
const styles = StyleSheet.create({
    container:{
        flex:1
    }
})
