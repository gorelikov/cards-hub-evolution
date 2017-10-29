package org.some.thing.card.hub.client.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.CardType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AdviceCard extends Card {
  private AdviceType adviceType;

  @Builder
  public AdviceCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, AdviceType adviceType) {
    super(id, userId, type, amount, executionUrl);
    this.adviceType = adviceType;
  }

  public enum AdviceType {
    GIFT,
    TAXI,
    CURRENCY;

    public static AdviceType fromInt(int i) {
      return AdviceType.values()[i];
    }
  }
}
