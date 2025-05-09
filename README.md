# spring-demos

## List of Examples
### Cloud config server
### distributed-tracing-example
### internationalization
### sidecar-authentication
### spring-aop-example
### spring-boot-admin
### spring-dao-security
### spring-reactive concurrency test
The project has two controllers Blocking Controller depicting regular synchronous call and a Reactive controller that uses Webflux library to 
create a reactive controller. Reactive controller will use non-blocking mechanism to support larger concurrency levels. Also note that client used sendAsync method when sending request to Reactive controllers.

#### BLOCKING API Statistics
![Blocking API call statistics](https://github.com/GauravPunhani/spring-demos/blob/master/spring-reactive-concurrency-test/Blocking.png)

#### Reactive API Statistics
![Reactive API call statistics](https://github.com/GauravPunhani/spring-demos/blob/master/spring-reactive-concurrency-test/Reactive.png)


### CI CD Pipeline
![CI CD](https://github.com/GauravPunhani/spring-demos/blob/master/typical-CI-CD/CI-CD.png)

## Links to other important spring boot projects
https://github.com/codywynn/spring-boot-cognito (Cognito authentication)
https://github.com/devxsb/spring-boot-microservices (Local setup using Eureka , Gateway , config-server)

## Become more productive . Write daily todo list , SMART goals and minutes of meetings using below free site
[TODO LIST , SMART GOALS , MOM , DRAW DESIGN](https://tasks-forme.com)