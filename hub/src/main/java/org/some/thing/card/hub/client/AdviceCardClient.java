package org.some.thing.card.hub.client;

import org.some.thing.card.hub.client.dto.AdviceCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AdviceCardClient implements CardClient<AdviceCard> {
  private final BaseCardClient cardClient;

  public AdviceCardClient(@Value("${hub.adviceURL}") String url) {
    this.cardClient = new BaseCardClient(url);
  }

  public List<AdviceCard> getCards(String userId,
                                 BigDecimal longitude,
                                 BigDecimal latitude,
                                 Long currentDate) {
    return cardClient.<AdviceCard>getCards(userId, longitude, latitude, currentDate, MediaType.APPLICATION_JSON)
        .getBody();
  }
}
