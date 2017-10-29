package org.some.thing.card.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
  private String id;
  private String userId;
  private CardType type;
  private BigDecimal amount;
  private String executionUrl;
}
