package org.some.thing.card.fines.service;

import org.some.thing.card.entity.UserData;
import org.some.thing.card.fines.entity.FineCard;

import java.util.List;

public interface FinesService {
  List<FineCard> loadFines(UserData userData);
}
