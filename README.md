# web-car
web-control-car based on raspberry pi
  
##  function  
1. move(go,stop,back,left,right)  
2. camera view (work with fswebcam and common.io)  
3. phone control (TODO)
4. map space and find qr code (TODO)

## TODO  
1. test and fix issue
2. phone control 
3. find qr code

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
