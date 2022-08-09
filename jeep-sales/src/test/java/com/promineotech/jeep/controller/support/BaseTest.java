package com.promineotech.jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
  @LocalServerPort 
  private int serverPort;
  
  //Test Rest Template? Inject the copy of TestRestTemplate with Autowired
  @Autowired
  @Getter
  private
   TestRestTemplate restTemplate;
  
  
  
  public TestRestTemplate getRestTemplate() {
    return restTemplate;
  }



  //retrieve the uri (Uniform Resource Identifier -> URL is Uniform Resource Locator under URI
  protected String getBaseUri() {
    return String.format("http://localhost:%d/jeeps", serverPort);
  }
 
}
