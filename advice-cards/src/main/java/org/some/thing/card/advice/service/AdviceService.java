package org.some.thing.card.advice.service;

import org.some.thing.card.advice.entity.AdviceCard;
import org.some.thing.card.entity.UserData;
import reactor.core.publisher.Flux;

public interface AdviceService {
    Flux<AdviceCard> defineAdvices(UserData userData);
}
