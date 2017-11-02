package org.some.thing.card.hub.service;

import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.UserData;

import java.util.List;

public interface CardsService {
    List<Card> loadCards(UserData userData);
}
