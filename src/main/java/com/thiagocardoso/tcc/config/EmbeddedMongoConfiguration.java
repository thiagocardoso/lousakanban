package com.thiagocardoso.tcc.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.thiagocardoso.tcc.annotations.IntegrationTest;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

@IntegrationTest
@Configuration
public class EmbeddedMongoConfiguration {
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "lousakanban");
	}
	
	@Bean(destroyMethod = "close")
	public Mongo mongo() throws IOException {
		return new EmbeddedMongoBuilder().version("2.4.5").bindIp("127.0.0.1").port(12345).build();
	}
}
