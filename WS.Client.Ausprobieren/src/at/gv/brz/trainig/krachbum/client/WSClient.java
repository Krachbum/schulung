package at.gv.brz.trainig.krachbum.client;

import at.gv.brz.trainig.krachbum.server.Mathe;
import at.gv.brz.trainig.krachbum.server.MatheImplService;

public class WSClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MatheImplService service = new MatheImplService();
    Mathe mathe = service.getMatheImplPort();

    int i = 6;
    int j = 82;
    System.out.println("Addiere :" + i + " mit :" + j + " = ");
    System.out.println(mathe.addiere(i, j));

  }

}
