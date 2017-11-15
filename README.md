# EXiYou
项目介绍：
  APP采用MVP模式+Retrofit+RxJava。介绍每个城市的详情以及商城社区讨论等。
项目要点：
1.视图层搭建：采用BaseActivity、BasePresenter、BaseModel等MVP架构进行搭建。ListView中的布局采用协调者布局构建。
2.分为首页、目的地、商城和社区四大界面，采用ViewPager配合ToolBar实现界面滑动。图片采用ImageLoader和Picasso进行加载以及内存优化。
3.目的地左边ListView跟右边详细国家称是列表进行联动，点击进入城市详情
4.二级详情页面上边采用Design包的协调者布局进行图片无限轮播，滑动时进行隐藏并显示出来ToolBar。
5.商城以及社区界面采用RecyclerView进行显示并插入头布局，RecyclerView的点击事件需要自定义。
最近访问采用SharedPreferences进行存储最近访问的四个城市列表，在点击进入城市页面进行更改SharedPreferences里的数据，返回主界面时更新数据。


为2017级河工大毕业设计使用 数据若侵权 请联系我删除（QQ 1058296811）
此项目仅供学习使用
