package org.some.thing.card.regular.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.some.thing.card.regular.database")
public class RepoConfiguration {
}
