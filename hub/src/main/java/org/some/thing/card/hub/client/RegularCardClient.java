package org.some.thing.card.hub.client;

import org.some.thing.card.hub.client.dto.RegularCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegularCardClient implements CardClient<RegularCard> {
  private final BaseCardClient cardClient;

  public RegularCardClient(@Value("${hub.regularURL}") String url) {
    this.cardClient = new BaseCardClient(url);
  }

  public Flux<RegularCard> getCards(String userId,
                                    BigDecimal longitude,
                                    BigDecimal latitude,
                                    Long currentDate) {
    return cardClient.getCards(userId, longitude, latitude, currentDate, MediaType.APPLICATION_STREAM_JSON)
            .flatMapMany(res -> res.bodyToFlux(RegularCard.class));
  }
}
