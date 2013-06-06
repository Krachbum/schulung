package at.gv.brz.training.krachbum;

import javax.xml.ws.Endpoint;

import at.gv.brz.trainig.krachbum.server.MatheImpl;

public class WSPublisher {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Endpoint.publish("http://localhost:8080/WS/Mathe", new MatheImpl());

  }

}
