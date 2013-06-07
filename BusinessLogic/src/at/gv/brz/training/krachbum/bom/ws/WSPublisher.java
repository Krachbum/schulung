package at.gv.brz.training.krachbum.bom.ws;

import javax.xml.ws.Endpoint;

import at.gv.brz.training.krachbum.bom.Zeitverwaltung;

public class WSPublisher {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/WS/Zeitverwaltung", new Zeitverwaltung());
  }

}
