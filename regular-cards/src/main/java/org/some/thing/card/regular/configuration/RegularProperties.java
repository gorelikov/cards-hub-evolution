package org.some.thing.card.regular.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "regular")
public class RegularProperties {
  private String executeUrl;
}
