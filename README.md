# web-car
web-control-car based on raspberry pi
  
##  function  
1. move(go,stop,back,left,right)  
2. camera view (work with fswebcam and common.io)  

## TODO  
1. test and fix issue


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
