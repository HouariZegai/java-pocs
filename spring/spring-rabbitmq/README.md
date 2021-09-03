### Run RabbitMQ
```bash
docker run -d --hostname ny-rabbit --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
