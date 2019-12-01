rm web-car.jar
wget http://hcen.cc:19000/ba90e737c3fe42189f96c9fb624bcb82/web-car.jar
kill $(lsof -t -i:8090)
nohup java -jar  /home/pi/webCar/web-car.jar >> /var/log/car.log  &