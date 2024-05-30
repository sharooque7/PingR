package com.metrics.metric.entities.petrusconnect;

import com.metrics.metric.entities.core.Asset;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.Document;

@Profile("petrusConnect")
@Document(collection = "Assets")
public class PetrusConnect extends Asset {
}
