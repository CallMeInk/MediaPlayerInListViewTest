# MediaPlayerInListViewTest

实验了三种视频控件在ListView上的表现

1.SurfaceView + MediaPlayer
  SurfaceView的部分在经过多次滑动后，小概率会暴露出上一个Activity的内容，不安全。在开启另一个Activity并back时，不会自动播放
  
2.VideoView + MediaPlayer
  VideoView会露出类似进度条的东西，即使把进度条的view设置成gone，滑动不流畅
  
3.TextureView + MediaPlayer
  破费，滑动流畅，进入该页面和返回该页面时均能自动播放。
  
跑通程序后需要在手机内置sd根目录中放一个视频 test.mp4
