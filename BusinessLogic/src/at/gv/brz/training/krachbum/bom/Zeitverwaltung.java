package at.gv.brz.training.krachbum.bom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.gv.brz.training.krachbum.rep.ObjectRepository;

public class Zeitverwaltung {
  private List<Projekt> lProjekte;
  private List<Mitarbeiter> lMitarbeiter;

  private ObjectRepository objectRepository = new ObjectRepository();

  public void reloadAll() throws FileNotFoundException, ClassNotFoundException, IOException {
    List<Object> lObjects = objectRepository.getAllObjects();
    lProjekte = new ArrayList<>();
    lMitarbeiter = new ArrayList<>();
    for (Object object : lObjects) {
      if (object.getClass().equals((Mitarbeiter.class))) {
        lMitarbeiter.add((Mitarbeiter) object);
      }
      if (object.getClass().equals((Projekt.class))) {
        this.lProjekte.add((Projekt) object);
      }
    }
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
