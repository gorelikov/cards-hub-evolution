package org.some.thing.card.regular.service;

import org.some.thing.card.entity.UserData;
import org.some.thing.card.regular.entity.RegularCard;

import java.util.List;

public interface RegularService {
    List<RegularCard> loadRegular(UserData userData);
}
