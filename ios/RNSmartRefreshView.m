//
//  RNTRefreshView.m
//  JChat
//
//  Created by 高凯 on 2020/12/18.
//

#import "RNSmartRefreshView.h"

@implementation RNSmartRefreshView

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
    MJRefreshNormalHeader *header = [MJRefreshNormalHeader headerWithRefreshingTarget:self refreshingAction:@selector(loadNewData)];
    self.mj_header = header;
    
  }
  return self;
}
-(void)loadNewData{
  self.onRefreshing(@{});
}
-(void)setRefreshing:(BOOL *)refreshing{
  if(!refreshing){
    [[self mj_header] endRefreshing];
  }
}
@end
