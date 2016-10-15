# RabbitMQ Integration #

Example of how to integrate a Spring Boot application with RabbitMQ using Spring Integration.

If you don't have RabbitMQ installed but use Docker you can create the image running:

```bash
cd docker/rabbitmq
./build.sh

# To start the docker container
./run.sh
```

Please note that both `Producer` and `Consumer` are configured to use the Docker RabbitMQ instance. If you are using another RabbitMQ you need to change the configuration in the `application.yml` file in each application.

```yml
rabbitmq:
  host: 172.17.0.2
  port: 5672
  username: guest
  password: guest
```