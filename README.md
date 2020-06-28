# Spring-boot Reactive Redis Pub/Sub Example 

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

# 2. Start Master App

```sh
cd master-publisher
chmod +x deploy.sh
./deploy.sh
```

# 3. Start Slave Apps

```sh
cd slave-subscriber
chmod +x deploy.sh
./deploy.sh
```

# 4. ทดสอบ

ลองยิง API 

- `/api/services/start` 
- `/api/services/stop` 
- `/api/services/restart` 

ของเครื่องที่ติดตั้งดู เช่น 

```sh
POST http://<SERVER_IP>/api/services/start
```

แล้วลองดู log ของ slave-app ทั้ง 3 apps 

# เอกสาร Redis

- [https://redis.io/topics/pubsub](https://redis.io/topics/pubsub)

# Google Chrome Extension ไว้อ่านเอกสาร Redis 

- [https://github.com/jittagornp/css-for-redis.io](https://github.com/jittagornp/css-for-redis.io)
