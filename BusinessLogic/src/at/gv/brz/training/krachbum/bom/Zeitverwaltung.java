package at.gv.brz.training.krachbum.bom;

import java.sql.Date;
import java.util.List;

public class Zeitverwaltung {
  private List<Projekt> lProjekte;
  private List<Mitarbeiter> lMitarbeiter;

  public void reloadAll() {
    //
  }

  public void bucheZeit(Mitarbeiter ma, Date von, Date bis, Projekt project) {

    boolean mafound = false;
    Projekt mitMirbuchen = null;

    for (Mitarbeiter m : lMitarbeiter) {
      if (m.equals(ma)) {
        mafound = true;
        break;
      }
    }

    for (Projekt p : lProjekte) {
      if (p.equals(project)) {
        mitMirbuchen = p;
        break;
      }
    }

    if (bis.before(von)) { throw new IllegalArgumentException("Von muss vor Bis liegen"); }

    if (mafound && mitMirbuchen != null) {
      mitMirbuchen.addArbeitszeit(new Arbeitszeit(von, bis));
    }

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
