
http://localhost:8080/charCounter/abcd

http://localhost:8080/greeter/John

You can also use both PUT and Post call
http://localhost:8080/myCheckFunction


Filtering ineligible functions
A typical Application Context may include beans that are valid java functions, but not intended to be candidates to be registered with FunctionCatalog.

For example,

spring.cloud.function.ineligible-definitions=foo,bar

Funtion or Supplier can be imperative(normal way) or reactive(Reactive type Flux or Mono)


--spring.cloud.function.definition=foo;bar
This will only export function foo and function bar regardless how many functions are available in catalog (e.g., localhost:8080/foo).

--spring.cloud.function.definition=foo|bar;baz
This will only export function composition foo|bar and function baz regardless how many functions are available in catalog (e.g., localhost:8080/foo,bar).



CRUD REST with Spring Cloud Function
By now it should be clear that functions are exported as REST endpoints and can be invoked using various HTTP methods. In other words a single function could be triggered via GET, POST, PUT etc.

However, it is not always desirable and certainly does not fit the CRUD concept. And while SCF does not support and has no intention of supporting all the features of Spring web stack, the framework does provide support for CRUD mappings where a single function could be mapped to a particular HTTP method(s). It is done via spring.cloud.function.http.<method-name> property.

For example,

spring.cloud.function.http.GET=uppercase;reverse;foo|bar
spring.cloud.function.http.POST=reverse
spring.cloud.function.http.DELETE=deleteById




<dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-function-web</artifactId>
        <version>4.0.5</version>
    </dependency>



https://cloud.spring.io/spring-cloud-function/reference/html/spring-cloud-function.html






