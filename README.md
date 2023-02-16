# Kafka event driven architecture
## This project demonstrates the basic example of event driven architecture  design pattern.
## There are four microservices.
### 1)Domain
### 1)Order service
### 1)Stock service
### 1)Email service

## When Order service pulish events to kafka broker, then Stock service and Email service will consume this event.
