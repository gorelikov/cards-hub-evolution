package org.some.thing.card.hub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.hub.client.CardClient;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
  private final List<CardClient> cardClients;

  @Override
  public List<Card> loadCards(UserData userData) {
    return cardClients.stream()
        .parallel()
        .flatMap(client -> getCards(userData, client).stream())
        .collect(Collectors.toList());
  }

  @SuppressWarnings("unchecked")
  private List<Card> getCards(UserData userData, CardClient client) {
    try {
      return client.getCards(userData.getUserId(),
          userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
          userData.getCurrentDate());
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }
}
