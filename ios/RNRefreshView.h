//
//  RNRefreshView.h
//  react-native-smart-refresh
//
//  Created by 高凯 on 2020/12/24.
//

#import "MJRefreshHeader.h"
#import <React/RCTConvert.h>
#import <React/RCTComponent.h>
#import <React/RCTScrollableProtocol.h>
NS_ASSUME_NONNULL_BEGIN

@interface RNRefreshView : MJRefreshHeader<RCTCustomRefreshContolProtocol>
@property (nullable, nonatomic, copy) RCTDirectEventBlock onChangeState;
@property (nullable, nonatomic, copy) RCTDirectEventBlock onChangeOffset;
@property (nonatomic) BOOL *refreshing;
@end

NS_ASSUME_NONNULL_END
