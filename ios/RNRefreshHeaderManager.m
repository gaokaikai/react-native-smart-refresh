//
//  RNRefreshHeaderManager.m
//  react-native-smart-refresh
//
//  Created by apple on 2020/12/27.
//

#import "RNRefreshHeaderManager.h"

@implementation RNRefreshHeaderManager
RCT_EXPORT_MODULE(RNRefreshHeader)
- (UIView *)view {
    return [[RNRefreshHeader alloc] init];
}
@end
