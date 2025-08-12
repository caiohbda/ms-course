package com.microservices.hrworker.resources;

import com.microservices.hrworker.entities.Worker;
import com.microservices.hrworker.repositories.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> optionalWorker = repository.findById(id);

        if (optionalWorker.isPresent()) {
            Worker obj = optionalWorker.get();
            return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
