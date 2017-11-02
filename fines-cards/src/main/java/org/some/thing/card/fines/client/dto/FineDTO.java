package org.some.thing.card.fines.client.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.some.thing.card.fines.entity.FineType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class FineDTO {
    private String id;
    private BigDecimal amount;
    private FineType fineType;
    private Date dueDate;
}
