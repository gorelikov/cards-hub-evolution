package org.some.thing.card.advice.service;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.advice.configuration.AdviceProperties;
import org.some.thing.card.advice.entity.AdviceCard;
import org.some.thing.card.advice.entity.AdviceType;
import org.some.thing.card.entity.CardType;
import org.some.thing.card.entity.UserData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AIAdviceService implements AdviceService {
  private final static Random rnd = new Random();
  private final AdviceProperties adviseProperties;

  @Override
  public List<AdviceCard> defineAdvices(UserData userData) {
    return IntStream.range(0, 10)
        .mapToObj( ind -> AdviceCard.builder()
            .userId(userData.getUserId())
            .amount(BigDecimal.valueOf(rnd.nextLong()))
            .adviceType(AdviceType.fromInt(rnd.nextInt(AdviceType.values().length - 1)))
            .id(UUID.randomUUID().toString())
            .executionUrl(adviseProperties.getExecuteUrl())
            .type(CardType.ADVISE)
            .build())
        .collect(Collectors.toList());
  }
}
