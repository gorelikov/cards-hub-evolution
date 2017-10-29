package org.some.thing.card.advice.entity;

public enum AdviceType {
  GIFT,
  TAXI,
  CURRENCY;

  public static AdviceType fromInt(int i) {
    return AdviceType.values()[i];
  }
}
