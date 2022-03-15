version: '2.2'
services:
  eureka-service:
    build: eureka-serverProject
    image: bootcamp/eurekaService
    restart: always
    ports:
      - 8880:8880

  config-server:
    build: projecto1-configServer
    image: configServer
    restart: always
    ports:
      - 8888:8888

  gateway-service:
    build: gateway-serverproject
    image: bootcamp/gateway-service
    restart: always
    depends_on:
      eurekaService:
        condition: service_started
    environment:
      eureka.client.serviceUrl.defaultZone: http://eureka-service:8020/eureka/
    ports:
      - 8070:8070

  project1-service:
    build: project1
    image: bootcamp/projecto1-service
    restart: always
    depends_on:
      config-server:
        condition: service_started
      eureka-service:
        condition: service_started
      mongodb:
        condition: service_started
    environment:
      eureka.client.serviceUrl.defaultZone: http://eureka-service:8761/eureka/
      spring.data.mongodb.host: mongodb
    ports:
      - 8081:8081
  mongodb:
    restart: always
    image: mongo:4.0-xenial
    hostname: mongo
    ports:
      - "27017:27017"
  
 