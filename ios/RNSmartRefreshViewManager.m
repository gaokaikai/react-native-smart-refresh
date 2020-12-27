//
//  RNTRefreshViewManager.m
//  JChat
//
//  Created by 高凯 on 2020/12/18.
//

#import "RNSmartRefreshViewManager.h"

@implementation RNSmartRefreshViewManager
RCT_EXPORT_MODULE(RNSmartRefreshView);
RCT_EXPORT_VIEW_PROPERTY(onChangeState, RCTDirectEventBlock);
RCT_EXPORT_VIEW_PROPERTY(onChangeOffset, RCTDirectEventBlock);
RCT_EXPORT_VIEW_PROPERTY(refreshing, BOOL);
- (UIView *)view{
    RNRefreshView *view = [[RNRefreshView alloc] init];
  return view;
}
@end
