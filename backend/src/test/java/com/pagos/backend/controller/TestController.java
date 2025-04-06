package com.pagos.backend.controller;

import com.pagos.backend.model.TestEntity;
import com.pagos.backend.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/api/test")
    public List<TestEntity> getAllTests() {
        return testRepository.findAll();
    }
}
