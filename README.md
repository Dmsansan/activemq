## java服务器消息中间件
activemq,rabbitmq,kafaka;某个服务向多个服务传递消息，异步传递不，统一注册消息到中间件，
消费端获取消息；

1、消息回话产生的两种方式，queue和topic

* queque 队列方式，产生消息->消费消息

* topic 先消费者创建监听器，然后生产者产生消息才能消费
