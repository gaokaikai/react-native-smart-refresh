//
//  RNTRefreshViewManager.m
//  JChat
//
//  Created by 高凯 on 2020/12/18.
//

#import "RNSmartRefreshViewManager.h"

@implementation RNSmartRefreshViewManager
RCT_EXPORT_MODULE(RNSmartRefreshView);
RCT_EXPORT_VIEW_PROPERTY(onRefreshing, RCTBubblingEventBlock);
RCT_EXPORT_VIEW_PROPERTY(refreshing, BOOL);
- (UIView *)view{
    RNSmartRefreshView *view = [[RNSmartRefreshView alloc] init];
  return view;
}
@end
