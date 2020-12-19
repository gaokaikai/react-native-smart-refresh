import React from 'react';
import {
    View,
    Text,
    requireNativeComponent,
    StyleSheet, ScrollView,
} from 'react-native';
const RNSmartRefresh = requireNativeComponent('RNSmartRefreshView',SmartRefresh);
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
                <View>
                    {children}
                </View>
            </RNSmartRefresh>
        );
    }
}
