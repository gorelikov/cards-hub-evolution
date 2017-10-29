package org.some.thing.card.hub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.some.thing.card.entity.Card;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.hub.client.CardClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
  private final List<CardClient> cardClients;

  @Override
  public Flux<List<Card>> loadCards(UserData userData) {
    final List<Mono<List<Card>>> monoList = cardClients.stream()
            .map(client -> getCards(userData, client))
            .collect(Collectors.toList());
    return Flux.merge(monoList);
  }

  @SuppressWarnings("unchecked")
  private Mono<List<Card>> getCards(UserData userData, CardClient client) {
      return Mono.<List<Card>>fromCallable(() ->
              client.getCards(userData.getUserId(),
                      userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
                      userData.getCurrentDate()))
              .subscribeOn(Schedulers.elastic());
  }
}
