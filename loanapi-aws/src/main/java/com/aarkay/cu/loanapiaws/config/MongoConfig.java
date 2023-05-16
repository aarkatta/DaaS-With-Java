package com.aarkay.cu.loanapiaws.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.aarkay.cu.loanapiaws.repository")
public class MongoConfig {

    @Value("${loan-api.mongo.url}")
    private String mongoUrl;

    @Value("${loan-api.mongo.db}")
    private String mongoDb;

    /**
     * ServerAPI: This can help to ensure backward compatibility with older versions of MongoDB.
     * @return
     * @throws Exception
     */
    @Bean
    public MongoClient mongo() throws Exception {
        final ConnectionString connectionString = new ConnectionString(mongoUrl);
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
                .build();
        return com.mongodb.client.MongoClients.create(mongoClientSettings);

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), mongoDb);
    }
}
