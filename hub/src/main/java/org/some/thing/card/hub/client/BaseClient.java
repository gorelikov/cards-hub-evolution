package org.some.thing.card.hub.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

public class BaseClient {

  private final WebClient webClient;

  BaseClient(String baseUrl) {
    this.webClient = WebClient.create(baseUrl);
  }

  protected Mono<ClientResponse> getClient(String uri, Map<String, String> variables,
                                           Map<String, String> headers, MediaType mediaType) {
    return webClient.get()
            .uri(uriBuilder -> buildQuery(uriBuilder, uri, variables))
            .headers(cons -> cons.setAll(headers))
            .accept(mediaType)
            .exchange();
  }

  private URI buildQuery(UriBuilder uriBuilder, String uri, Map<String, String> variables) {
    uriBuilder.replacePath(uri);
    variables.forEach(uriBuilder::queryParam);
    return uriBuilder.build();
  }

}
