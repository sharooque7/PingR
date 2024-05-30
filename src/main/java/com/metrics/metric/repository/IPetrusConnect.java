package com.metrics.metric.repository;

import com.metrics.metric.entities.petrusconnect.PetrusConnect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPetrusConnect extends MongoRepository<PetrusConnect ,Integer> {
}
