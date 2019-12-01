git pull
mvn clean package
cp target/web-car.jar /nginx/html-container/ba90e737c3fe42189f96c9fb624bcb82/
cp src/main/resources/index.html /nginx/html-container/ba90e737c3fe42189f96c9fb624bcb82/
echo 'cp done'
