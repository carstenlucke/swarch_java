package de.thm.swarch.ws;


import de.thm.swarch.ws.customerservice.service.CustomerService;
import de.thm.swarch.ws.helloworld.service.HelloService;

import javax.xml.ws.Endpoint;

public class WsStarter {

  public static final String WS_HOST = "localhost";
  public static final String WS_PORT = "9999";

  public static void main(String[] argv) {
    System.out.println("Running soap webservices ...");

    Object implementor = new HelloService();
    // TODO: Publish WS-endpoint
    // Endpoint.publish(...);

    Object customerservice = new CustomerService();
    // TODO: Publish WS-endpoint
    // Endpoint.publish(...);
  }
}
