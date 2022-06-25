package com.wf.kafka.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wf.kafka.model.Tutorial;

public interface SportsRepo extends MongoRepository<Tutorial, String> {}
