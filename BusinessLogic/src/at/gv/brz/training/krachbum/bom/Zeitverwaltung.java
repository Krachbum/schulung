package at.gv.brz.training.krachbum.bom;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import at.gv.brz.training.krachbum.bom.ws.IZeitverwaltung;

@WebService(endpointInterface = "at.gv.brz.training.krachbum.bom.ws.IZeitverwaltung")
public class Zeitverwaltung implements IZeitverwaltung {
  private List<Projekt> lProjekte;
  private List<Mitarbeiter> lMitarbeiter;

  public void reloadAll() {
    //
  }

  @Override
  public boolean bucheZeit(Mitarbeiter ma, Date von, Date bis, String projektName) {

    boolean mafound = false;
    Projekt mitMirbuchen = null;

    for (Mitarbeiter m : lMitarbeiter) {
      if (m.equals(ma)) {
        mafound = true;
        break;
      }
    }

    for (Projekt pr : lProjekte) {
      if (pr.getName().equals(projektName)) {
        mitMirbuchen = pr;
        break;
      }
    }

    if (bis.before(von)) { throw new IllegalArgumentException("Von muss vor Bis liegen"); }

    if (mafound && mitMirbuchen != null) {
      mitMirbuchen.addArbeitszeit(new Arbeitszeit(von, bis));
      return true;
    }
    return false;

  }

  public List<Projekt> getlProjekte() {
    return lProjekte;
  }

  public void setlProjekte(List<Projekt> lProjekte) {
    this.lProjekte = lProjekte;
  }

  public List<Mitarbeiter> getlMitarbeiter() {
    return lMitarbeiter;
  }

  public void setlMitarbeiter(List<Mitarbeiter> lMitarbeiter) {
    this.lMitarbeiter = lMitarbeiter;
  }

}
