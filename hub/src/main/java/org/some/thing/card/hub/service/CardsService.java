package org.some.thing.card.hub.service;

import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.UserData;
import reactor.core.publisher.Flux;

public interface CardsService {
  Flux<Card> loadCards(UserData userData);
}
