//
//  RNRefreshView.m
//  react-native-smart-refresh
//
//  Created by 高凯 on 2020/12/24.
//

#import "RNRefreshView.h"

@implementation RNRefreshView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/
- (instancetype)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

///** 普通闲置状态 */
//MJRefreshStateIdle = 1,
///** 松开就可以进行刷新的状态 */
//MJRefreshStatePulling,
///** 正在刷新中的状态 */
//MJRefreshStateRefreshing,
///** 即将刷新的状态 */
//MJRefreshStateWillRefresh,
///** 所有数据加载完毕，没有更多的数据了 */
//MJRefreshStateNoMoreData

-(void)setState:(MJRefreshState)state{
    [super setState:state];
    if(self.onChangeState){
        switch (state) {
            case MJRefreshStateIdle:
                self.onChangeState(@{@"state":@0});
                break;
            case MJRefreshStatePulling:
                self.onChangeState(@{@"state":@1});
                break;
            case MJRefreshStateRefreshing:
                self.onChangeState(@{@"state":@2});
                break;
            case MJRefreshStateWillRefresh:
                self.onChangeState(@{@"state":@3});
                break;
            case MJRefreshStateNoMoreData:
                self.onChangeState(@{@"state":@4});
                break;
            default:
                self.onChangeState(@{@"state":@0});
                break;
        }
    }
}

- (void)scrollViewContentOffsetDidChange:(NSDictionary *)change{
    [super scrollViewContentOffsetDidChange:change];
    CGPoint newPoint = [change[@"new"] CGPointValue];
    CGPoint oldPoint = [change[@"old"] CGPointValue];
    if (!CGPointEqualToPoint(newPoint, oldPoint)) {
        self.onChangeOffset(@{@"offset":@(fabs(newPoint.y))});
    }
}
- (void)setRefreshing:(BOOL *)refreshing{
    if(!refreshing){
        [self endRefreshing];
    }
}

@end
