
---

### **Microservices with Java (Spring Boot)**

#### Key Concepts:
- **Microservices**: Small, independently deployable services that handle a specific business capability.
- **Spring Boot**: Simplifies development of production-ready microservices with built-in configurations.
- **RESTful Services**: Microservices typically expose APIs for communication.

#### Basic Microservice Example:
```java
@SpringBootApplication
public class MyMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyMicroserviceApplication.class, args);
    }
}

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Microservice!";
    }
}
```

#### Key Spring Boot Annotations for Microservices:
- **@RestController**: Defines a REST controller for handling HTTP requests.
- **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**: Map HTTP methods to controller methods.
- **@RequestBody**: Maps the body of a POST/PUT request to a method parameter.
- **@PathVariable**: Extracts values from URL path parameters.

#### Service Discovery with Netflix Eureka:
1. **Eureka Server**:
   ```java
   @SpringBootApplication
   @EnableEurekaServer
   public class EurekaServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServerApplication.class, args);
       }
   }
   ```
    - `application.yml` configuration:
   ```yaml
   server:
     port: 8761
   eureka:
     client:
       register-with-eureka: false
       fetch-registry: false
   ```

2. **Eureka Client**:
   ```java
   @SpringBootApplication
   @EnableEurekaClient
   public class MyMicroserviceApplication {
       public static void main(String[] args) {
           SpringApplication.run(MyMicroserviceApplication.class, args);
       }
   }
   ```
    - `application.yml` configuration for client:
   ```yaml
   eureka:
     client:
       service-url:
         defaultZone: http://localhost:8761/eureka/
   ```

#### Load Balancing with Ribbon:
```java
@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/users")
    List<User> getUsers();
}
```

#### Resilience with Hystrix (Circuit Breaker):
```java
@RestController
public class MyServiceController {
    @GetMapping("/data")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getData() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Service failed!");
        }
        return "Service Data";
    }
    public String fallbackMethod() {
        return "Fallback response";
    }
}
```

#### API Gateway with Spring Cloud Gateway:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://user-service
          predicates:
            - Path=/users/**
```

#### Distributed Tracing with Sleuth and Zipkin:
- **Sleuth** and **Zipkin** configuration:
```yaml
spring:
  sleuth:
    sampler:
      probability: 1.0
  zipkin:
    base-url: http://localhost:9411
    enabled: true
```

#### Security in Microservices with OAuth 2.0 and JWT:
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/auth/realms/myrealm
```

#### Centralized Configuration with Spring Cloud Config:
1. **Config Server**:
   ```java
   @SpringBootApplication
   @EnableConfigServer
   public class ConfigServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(ConfigServerApplication.class, args);
       }
   }
   ```
    - `application.yml`:
   ```yaml
   spring:
     cloud:
       config:
         server:
           git:
             uri: https://github.com/myorg/myconfigrepo
   ```

#### Dockerfile for a Java Microservice:
```dockerfile
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/my-microservice.jar /app/my-microservice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/my-microservice.jar"]
```

#### Kubernetes Deployment Example:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-microservice
spec:
  replicas: 3
  selector:
    matchLabels:
      app: my-microservice
  template:
    metadata:
      labels:
        app: my-microservice
    spec:
      containers:
      - name: my-microservice
        image: my-microservice:latest
        ports:
        - containerPort: 8080
```

#### Horizontal Scaling in Kubernetes:
```yaml
apiVersion: autoscaling/v1
kind: HorizontalPodAutoscaler
metadata:
  name: my-microservice-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: my-microservice
  minReplicas: 2
  maxReplicas: 10
  targetCPUUtilizationPercentage: 80
```

#### Microservices Design Patterns:
- **Service Discovery**: Use Eureka or Consul for dynamic service registration and discovery.
- **API Gateway**: Use Spring Cloud Gateway as a centralized entry point for requests.
- **Circuit Breaker**: Implement fallback mechanisms using Hystrix to handle failures.
- **Event-Driven Architecture**: Use Kafka or RabbitMQ for asynchronous communication between microservices.
- **Database per Service**: Each microservice should own its own database to ensure loose coupling.

---
