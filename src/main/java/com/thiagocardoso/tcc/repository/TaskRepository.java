package com.thiagocardoso.tcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiagocardoso.tcc.entities.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
