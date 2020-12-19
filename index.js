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
    static propTypes = {
        style:PropTypes.object,
        onRefreshing:PropTypes.func,
        refreshing:PropTypes.bool,
    }
    static defaultProps = {
        style:{flex:1},
        onRefreshing:()=>{},
        refreshing:false,
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

const styles = StyleSheet.create({
    container:{
        flex:1
    }
})
