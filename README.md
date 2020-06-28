# spring-boot-reactive-redis-pubsub-example 

> ตัวอย่างการเขียน Spring-boot Reactive Redis Pub/Sub

<img src="./redis-pubsub.png" width="700">

# Redis

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

