package com.testcompany.azuretest.service;

import com.testcompany.azuretest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Optional<String> getMessage() {
        return testRepository.getMessage();
    }
}
