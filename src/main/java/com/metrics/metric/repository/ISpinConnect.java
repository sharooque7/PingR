package com.metrics.metric.repository;

import com.metrics.metric.entities.spinconnect.SpinConnect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISpinConnect extends MongoRepository<SpinConnect,Integer> {
}
