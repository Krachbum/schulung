package at.gv.brz.training.krachbum.bom.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.gv.brz.training.krachbum.bom.Mitarbeiter;
import at.gv.brz.training.krachbum.bom.Projekt;

@WebService
public interface IZeitverwaltung {

  @WebMethod
  boolean bucheZeit(Mitarbeiter ma, Date von, Date bis, Projekt p);

}
