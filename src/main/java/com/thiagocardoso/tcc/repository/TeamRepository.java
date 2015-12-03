package com.thiagocardoso.tcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiagocardoso.tcc.entities.Team;

public interface TeamRepository extends MongoRepository<Team, String> {

}
