package org.some.thing.card.hub.client;

import org.some.thing.card.hub.client.dto.FineCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FinesCardClient implements CardClient<FineCard> {

  private final BaseCardClient cardClient;

  public FinesCardClient(@Value("${hub.finesURL}") String url) {
    this.cardClient = new BaseCardClient(url);
  }

  public List<FineCard> getCards(String userId,
                                 BigDecimal longitude,
                                 BigDecimal latitude,
                                 Long currentDate) {
    return cardClient.<FineCard>getCards(userId, longitude, latitude, currentDate, MediaType.APPLICATION_JSON)
        .getBody();
  }
}
