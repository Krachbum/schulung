package at.gv.brz.training.krachbum.bom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import at.gv.brz.training.krachbum.bom.ws.IZeitverwaltung;
import at.gv.brz.training.krachbum.listener.FileChangeListener;
import at.gv.brz.training.krachbum.rep.ObjectRepository;

@WebService(endpointInterface = "at.gv.brz.training.krachbum.bom.ws.IZeitverwaltung")
public class Zeitverwaltung implements IZeitverwaltung, FileChangeListener {
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

  @Override
  public boolean bucheZeit(int maNr, Date von, Date bis, String projektName) {

    boolean mafound = false;
    Projekt mitMirbuchen = null;

    mafound = isMitarbeitderValid(maNr);

    mitMirbuchen = findProjektByName(projektName);

    if (bis.before(von)) { throw new IllegalArgumentException("Von muss vor Bis liegen"); }

    if (mafound && mitMirbuchen != null) {
      mitMirbuchen.addArbeitszeit(new Arbeitszeit(von, bis));
      return true;
    }
    return false;

  }

  private boolean isMitarbeitderValid(int maNr) {
    for (Mitarbeiter m : lMitarbeiter) {
      if (m.getMaNr() == maNr) { return true; }
    }
    return false;
  }

  // Methode sollte schlussendlich in Projekt.java liegen
  private Projekt findProjektByName(String projektName) {
    for (Projekt pr : lProjekte) {
      if (pr.getName().equals(projektName)) { return pr; }
    }
    return null;
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

  @Override
  public void fileChangedEvent() {
    try {
      System.out.println("Yuhu neue Files");
      this.reloadAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
