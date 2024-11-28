package com.ddlab.rnd.api;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {
	
	@Bean
	public Function<Message<?>, Message<?>> enrich() { //GET http://localhost:8080/enrich
	    return message -> MessageBuilder.fromMessage(message).setHeader("foo", "bar").build();
	}
	
	@Bean
	public Supplier<Message<String>> getSome() {
		return () -> MessageBuilder.withPayload("Hello Mr").build();
	}
	
	@Bean
	public Consumer<Message<String>> consumeSome() {
		return msg -> {
			System.out.println("Some Randome Message: "+msg);
			System.out.println("Message Payload---->"+msg.getPayload());
		};
		
	}

}
