package org.some.thing.card.advice.service;

import org.some.thing.card.advice.entity.AdviceCard;
import org.some.thing.card.entity.UserData;

import java.util.List;

public interface AdviceService {
  List<AdviceCard> defineAdvices(UserData userData);
}
