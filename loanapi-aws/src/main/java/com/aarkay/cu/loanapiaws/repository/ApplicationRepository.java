package com.aarkay.cu.loanapiaws.repository;

import com.aarkay.cu.loanapiaws.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends MongoRepository<Application, String>, QuerydslPredicateExecutor<Application> {

    @Query(value = "{ 'applicationId' : ?0 }")
    Optional<Application> findByApplicationId(String applicationId);

    @Query(value = "{ 'customerId' : ?0 }")
    List<Application> findCustomersById(String customerId);
}
