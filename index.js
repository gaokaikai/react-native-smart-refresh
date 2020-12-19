import React from 'react';
import {
    View,
    Text,
    requireNativeComponent,
    StyleSheet, ScrollView,
} from 'react-native';
import PropTypes from 'prop-types';
const RNSmartRefresh = requireNativeComponent('RNSmartRefreshView');
export default class SmartRefresh extends React.PureComponent{
    constructor(props) {
        super(props);
    }

    render() {
        const {children} = this.props;
        return (
            <RNSmartRefresh
                {...this.props}
            >
                <View
                    style={styles.container}
                >
                    {children}
                </View>
            </RNSmartRefresh>
        );
    }
}

SmartRefresh.prototype={
    style:PropTypes.object,
    onRefreshing:PropTypes.func,
    refreshing:PropTypes.bool,
}
SmartRefresh.defaultProps={
    styles:styles.container,
    onRefreshing:()=>{},
    refreshing:false,
}
const styles = StyleSheet.create({
    container:{
        flex:1
    }
})
