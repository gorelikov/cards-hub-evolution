package org.some.thing.card.fines.service;

import org.some.thing.card.entity.UserData;
import org.some.thing.card.fines.entity.FineCard;
import reactor.core.publisher.Flux;

public interface FinesService {
  Flux<FineCard> loadFines(UserData userData);
}
