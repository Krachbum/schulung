package at.gv.brz.training.krachbum.bom.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IZeitverwaltung {

  @WebMethod
  boolean bucheZeit(int maNr, Date von, Date bis, String projektName);

}
