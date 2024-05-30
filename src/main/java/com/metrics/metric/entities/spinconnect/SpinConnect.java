package com.metrics.metric.entities.spinconnect;

import com.metrics.metric.entities.core.Asset;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.Document;

@Profile("spinConnect")
@Document(collection = "Assets")
public class SpinConnect extends Asset {
}
