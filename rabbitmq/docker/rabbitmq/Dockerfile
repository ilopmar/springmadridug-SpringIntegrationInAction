FROM rabbitmq:3.6.5-management

RUN rabbitmq-plugins enable --offline rabbitmq_management
RUN echo "[{rabbit, [{loopback_users, []}]}]." > /etc/rabbitmq/rabbitmq.config

EXPOSE 15672 5672
