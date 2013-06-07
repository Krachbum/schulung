package at.gv.brz.training.krachbum.bom.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.gv.brz.training.krachbum.bom.Mitarbeiter;

@WebService
public interface IZeitverwaltung {

  @WebMethod
  boolean bucheZeit(Mitarbeiter ma, Date von, Date bis, String projektName);

}
