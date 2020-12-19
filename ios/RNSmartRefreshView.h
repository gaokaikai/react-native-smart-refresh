//
//  RNTRefreshView.h
//  JChat
//
//  Created by 高凯 on 2020/12/18.
//

#import <UIKit/UIKit.h>
#import <React/RCTComponent.h>
#import "MJRefresh.h"
NS_ASSUME_NONNULL_BEGIN

@interface RNSmartRefreshView : UIScrollView
@property (nonatomic) BOOL *refreshing;
@property (nonatomic,copy) RCTBubblingEventBlock onRefreshing;
@end

NS_ASSUME_NONNULL_END
