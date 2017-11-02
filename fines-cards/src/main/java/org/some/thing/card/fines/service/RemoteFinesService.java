package org.some.thing.card.fines.service;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.entity.CardType;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.fines.client.EGovClient;
import org.some.thing.card.fines.configuration.FinesProperties;
import org.some.thing.card.fines.entity.FineCard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemoteFinesService implements FinesService {
    private final static Random rnd = new Random();
    private final FinesProperties properties;
    private final EGovClient eGovClient;

    @Override
    public List<FineCard> loadFines(UserData userData) {
        return eGovClient.getFines(userData.getUserId()).stream()
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
                ).collect(Collectors.toList());
    }
}
