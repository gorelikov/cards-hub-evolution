package org.some.thing.card.advice.controller;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.advice.entity.AdviceCard;
import org.some.thing.card.advice.service.AdviceService;
import org.some.thing.card.entity.GeoPosition;
import org.some.thing.card.entity.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdviceController {
  private final AdviceService adviceService;


  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<AdviceCard> loadAdvices(@RequestHeader("userId") String userId,
                                      @RequestHeader("longitude") BigDecimal longitude,
                                      @RequestHeader("latitude") BigDecimal latitude,
                                      @RequestParam("currentDate") Long currentDate) {
    return adviceService.defineAdvices(UserData.builder()
        .currentDate(currentDate)
        .userId(userId)
        .geoPosition(GeoPosition.builder()
            .latitude(latitude)
            .longitude(longitude)
            .build())
        .build());
  }
}
