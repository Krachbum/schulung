package at.gv.brz.training.krachbum.bom;

import java.util.List;

public class Zeitverwaltung {
  private List<Projekt> lProjekte;
  private List<Mitarbeiter> lMitarbeiter;

  public void reloadAll() {
    //
  }

  //
  // public void bucheZeit(Mitarbeiter ma, Date von, Date bis, Projekt project) {
  // //
  // }

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
