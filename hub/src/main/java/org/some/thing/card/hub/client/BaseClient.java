package org.some.thing.card.hub.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class BaseClient {

    private final RestTemplate client;
    private final String baseUrl;

    BaseClient(String baseUrl) {
        this.client = new RestTemplate();
        this.baseUrl = baseUrl;
    }

    protected <T> ResponseEntity<List<T>> getClient(String uri, Map<String, String> variables,
                                                    MultiValueMap<String, String> headers,
                                                    MediaType mediaType) {
        return client.exchange(baseUrl + uri, HttpMethod.GET, new HttpEntity(headers),
                new ParameterizedTypeReference<List<T>>() {
                }, variables);
    }

}
