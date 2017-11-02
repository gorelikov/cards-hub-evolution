package org.some.thing.card.regular.entity;

import lombok.Builder;
import lombok.Data;
import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.CardType;

import java.math.BigDecimal;

@Data
public class RegularCard extends Card {
    private String targetAccount;
    private Long dueDate;

    @Builder
    public RegularCard(String id, String userId, CardType type, BigDecimal amount,
                       String executionUrl, String targetAccount, Long dueDate) {
        super(id, userId, type, amount, executionUrl);
        this.targetAccount = targetAccount;
        this.dueDate = dueDate;
    }
}
