# spring-boot-reactive-redis-pubsub-example 

> ตัวอย่างการเขียน Spring-boot Reactive Redis Pub/Sub

<img src="./redis-pubsub.png" width="700">

# 1. เตรียม Redis

ในที่นี้จะใช้ Docker น่ะ 

```sh
$ docker run -d \
-p 6379:6379 \
-v /root/redis/data:/data \
--name redis-server \
--restart=always \
redis:latest \
--requirepass 7fXu85kAnaRfqRMgYU84TSCh3tn6EwHLhh7ydVX6
```

เอกสารการติดตั้ง Redis 

- [ติดตั้ง Redis ด้วย Docker บน Ubuntu 18.04](https://www.jittagornp.me/blog/install-docker-redis-on-ubuntu-18.04/)

# 2. Start Master Node

```sh
cd master-publisher
chmod +x deploy.sh
./deploy.sh
```

# 3. Start Slave Nodes

```sh
cd slave-subscriber
chmod +x deploy.sh
./deploy.sh
```

# เอกสาร Redis

- [https://redis.io/topics/pubsub](https://redis.io/topics/pubsub)

# Google Chrome Extension ไว้อ่านเอกสาร Redis 

- [https://github.com/jittagornp/css-for-redis.io](https://github.com/jittagornp/css-for-redis.io)
