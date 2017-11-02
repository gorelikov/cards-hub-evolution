package org.some.thing.card.hub.service;

import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.UserData;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CardsService {
    Flux<List<Card>> loadCards(UserData userData);
}
