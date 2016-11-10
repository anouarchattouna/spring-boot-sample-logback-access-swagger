package org.anotherdev.sample.web.rest.v1;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;

import org.anotherdev.sample.domain.Sample;
import org.anotherdev.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author Anouar
 *
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Ping"}, description = "Sample Operation")
public class SampleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

  @Autowired
  private SampleService sampleService;

  @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sample> ping(HttpServletRequest request) {
    Sample sample = new Sample(request.getLocale().getISO3Country(), OffsetDateTime.now().toString());
    LOGGER.info(sample.toString());
    return new ResponseEntity<Sample>(sample, HttpStatus.OK);
  }

  @RequestMapping(value = "/ping1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sample> ping1() {
    Sample sample = new Sample(sampleService.getClientCountry(), OffsetDateTime.now().toString());
    LOGGER.info(sample.toString());
    return new ResponseEntity<Sample>(sample, HttpStatus.OK);
  }

}
