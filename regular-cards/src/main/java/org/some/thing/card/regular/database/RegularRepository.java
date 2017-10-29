package org.some.thing.card.regular.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface RegularRepository extends MongoRepository<RegularDocument, String> {
  List<RegularDocument> findByUserIdAndDueDateBetween(String userId, Date from, Date to);
}
