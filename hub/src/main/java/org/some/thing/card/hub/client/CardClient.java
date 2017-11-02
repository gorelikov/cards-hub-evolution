package org.some.thing.card.hub.client;


import org.some.thing.card.entity.Card;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

public interface CardClient<T extends Card> {
    Flux<T> getCards(String userId,
                     BigDecimal longitude,
                     BigDecimal latitude,
                     Long currentDate);
}
