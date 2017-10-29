package org.some.thing.card.fines.service;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.entity.CardType;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.fines.client.EGovClient;
import org.some.thing.card.fines.configuration.FinesProperties;
import org.some.thing.card.fines.entity.FineCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RemoteFinesService implements FinesService {
  private final FinesProperties properties;
  private final EGovClient eGovClient;

  @Override
  public Flux<FineCard> loadFines(UserData userData) {
    return eGovClient.getFines(userData.getUserId())
            .flatMapIterable(res -> res)
            .map(fine ->
                    FineCard.builder()
                            .userId(userData.getUserId())
                            .dueDate(fine.getDueDate().getTime())
                            .amount(fine.getAmount())
                            .fineType(fine.getFineType())
                            .id(fine.getId())
                            .executionUrl(properties.getExecuteUrl())
                            .type(CardType.FINES)
                            .build()
            );
  }
}
