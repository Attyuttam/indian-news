# indian-news

Features of this project:
- Provides real time news on the UI
- Based on event driven architecture
- Two separate microservices interact with each other using kafka queues
- Uses spring cloud stream to listen and write into the queues, hence no boiler plate code to connect to messaging systems
- microservices are queue provider independent, can easily replace kafka with rabbitMQ
- the messaging servers are handled using docker
- the UI microservice(news-app-ui) has two parts:
  - springboot enabled backend
  - reactJS based front end
  - the frontend and the backend interacts with each other to get real time data using web sockets
  
As you can see, this is mostly a POC project to understand the plethora of concepts: 
  - Spring Cloud Stream
  - Docker basics
  - Kafka queues 
  - Web sockets
  
Enhancements that can be done:
- Most of the code of spring cloud stream is deprecated, this is because they haven't updated the docs so we can use the latest code snippets
- Web Sockets is not based on SockJS which is kind of a bummer to me as I find SockJS to be more elegant but I will update it
- The UI has not been integrated with the UI backend to run on the same port yet
