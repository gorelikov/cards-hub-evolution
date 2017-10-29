package org.some.thing.card.fines.controller;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.fines.entity.FineCard;
import org.some.thing.card.fines.service.FinesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinesController {
  private final FinesService finesService;


  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<FineCard> loadFines(@RequestHeader("userId") String userId) {
    return finesService.loadFines(UserData.builder()
        .userId(userId)
        .build());
  }
}
