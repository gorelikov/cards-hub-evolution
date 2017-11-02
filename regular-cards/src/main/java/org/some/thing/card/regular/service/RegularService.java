package org.some.thing.card.regular.service;

import org.some.thing.card.entity.UserData;
import org.some.thing.card.regular.entity.RegularCard;
import reactor.core.publisher.Flux;

public interface RegularService {
    Flux<RegularCard> loadRegular(UserData userData);
}
