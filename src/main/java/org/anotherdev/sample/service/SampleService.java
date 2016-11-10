package org.anotherdev.sample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Anouar
 *
 */
@Component
public class SampleService {

  @Value("${client.country:FRA}")
  private String clientCountry;

//  public SampleService(@Value("${client.country:FRA}") final String clientCountry) {
//    this.clientCountry = clientCountry;
//  }

  public String getClientCountry() {
    return clientCountry;
  }

}
