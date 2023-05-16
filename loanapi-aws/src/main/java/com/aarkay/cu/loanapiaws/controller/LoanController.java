package com.aarkay.cu.loanapiaws.controller;

import com.aarkay.cu.loanapiaws.model.Application;
import com.aarkay.cu.loanapiaws.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ApplicationRepository applicationRepository;

    @GetMapping(path="/application/{applicationId}", produces = "application/json")
    public ResponseEntity<Application> getApplicationById(@PathVariable String applicationId) {
        return applicationRepository.findByApplicationId(applicationId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path="/customer/{customerId}/application", produces = "application/json")
    public ResponseEntity<List<Application>> getApplicationByCustomerId(@PathVariable String customerId) {
        List<Application> applications = applicationRepository.findCustomersById(customerId);
        if (applications.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(applications);
        }
    }

}
