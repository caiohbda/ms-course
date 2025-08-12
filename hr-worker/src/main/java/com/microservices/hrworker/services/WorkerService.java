package com.microservices.hrworker.services;

import com.microservices.hrworker.entities.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkerService {
    ResponseEntity<List<Worker>> findAll();
    ResponseEntity<Worker> findById(Long id);
}
