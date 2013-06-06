package at.gv.brz.trainig.krachbum.server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Mathe {
  @WebMethod
  int addiere(int z1, int z2);

}
