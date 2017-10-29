package org.some.thing.card.regular.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class RegularDocument {
  @Id
  private String id;
  private String targetAccount;
  private Date dueDate;
  private String userId;
  private BigDecimal amount;
}
