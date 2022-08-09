package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport {

  @Test
  //test should be self describing
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
 // Given: A valid model, trim, and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    
    
 // When: a connection is made to the URI
    
    /*
     * throw http at rest controller, sends http request to service layer, 
     * receives the response and formats it to go back to the client
     */
    
    ResponseEntity<Jeep> response = 
        getRestTemplate().getForEntity(uri, Jeep.class);
    
    
 // Then: a valid status code (OK - 200) is returned 
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
}

}
