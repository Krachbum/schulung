package at.gv.brz.trainig.krachbum.server;

import javax.jws.WebService;

import at.gv.brz.trainig.krachbum.server.interfaces.Mathe;

@WebService(endpointInterface = "at.gv.brz.trainig.krachbum.server.interfaces.Mathe")
public class MatheImpl implements Mathe {

  @Override
  public int addiere(int z1, int z2) {
    int erg = z1 + z2;

    return erg;
  }

}
