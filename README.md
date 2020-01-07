# web-car
web-control-car based on raspberry pi
基础架构为 软件服务中心和部署节点.
  软件服务中心负责编译源代码,打包可执行文件,发布到可下载容器
  部署节点负责从中心拉取二进制文件,运行文件

##  function  
1. move(go,stop,back,left,right)  
2. camera view (work with fswebcam)  
3. voice command 

## voice command
1. 放音乐
2. 倒计时
3. 

## TODO  
1. communication
2. voice command
3. 使用python重写

## shell for cd ci
center bash:
    PullBuildCopy.sh
    > pull from git
    > maven build
    > copy to nginx ftp  (code and ui)
node bash:
    CleanDownloadRestart.sh
    > clean old jar program file
    > download new file
    > kill old process
    > start new process

### log
2019年12月19日 fswebcam 正常,计划增加语音输入输出,更改操作逻辑
2019年12月19日 mplayer aplay arecode alsamixer 正常
