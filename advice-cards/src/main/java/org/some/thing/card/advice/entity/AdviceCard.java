package org.some.thing.card.advice.entity;

import lombok.Builder;
import lombok.Data;
import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.CardType;

import java.math.BigDecimal;

@Data
public class AdviceCard extends Card {
  private AdviceType adviceType;

  @Builder
  public AdviceCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, AdviceType adviceType) {
    super(id, userId, type, amount, executionUrl);
    this.adviceType = adviceType;
  }
}
