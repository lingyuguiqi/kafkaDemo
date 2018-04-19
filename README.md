1.下载并部署zookeeper
https://zookeeper.apache.org/releases.html#download
2.下载并部署Kafka
http://kafka.apache.org/downloads
3.启动zookeeper
4.启动Kafka
 如果出现Java heap space 修改kafka-server-start.bat 中的KAFKA_HEAP_OPTS=-Xmx256M -Xms256M
 如果出现map fail请检查你的jvm是32位还是64位  （32位检测）java -d32 或者 （64位检测）java -d64然后重新安装jdk
5.现在程序就可以运行了
