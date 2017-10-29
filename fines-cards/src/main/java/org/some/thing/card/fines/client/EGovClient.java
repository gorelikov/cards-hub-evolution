package org.some.thing.card.fines.client;

import org.some.thing.card.fines.client.dto.FineDTO;
import org.some.thing.card.fines.client.dto.FinesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EGovClient {

  private final RestTemplate restTemplate;
  private final String baseURL;

  public EGovClient(@Value("${fines.egovURL}") String baseURL) {
    restTemplate = new RestTemplate();
    this.baseURL = baseURL;
  }

  public List<FineDTO> getFines(String userId) {
    return restTemplate.getForObject(baseURL+"/fines?userId={userId}", FinesResponse.class, userId );
  }
}
