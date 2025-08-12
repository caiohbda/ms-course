package com.microservices.hrpayroll.feignclients;

import com.microservices.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker")
public interface WorkerFeignClients {

    @GetMapping(value = "/workers/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
