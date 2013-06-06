package at.gv.brz.training.krachbum.rep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import at.gv.brz.training.krachbum.bom.Mitarbeiter;
import at.gv.brz.training.krachbum.bom.Projekt;
import dataaccess.ObjectDao;

public class ObjectRepository {

  private ObjectDao objectDAO = new ObjectDao();

  public List<Object> getAllObjects() throws FileNotFoundException, ClassNotFoundException, IOException {
    return objectDAO.getAllObjects();

  }

  public void saveAllObjects(List<Projekt> projListe, List<Mitarbeiter> mitarbeiterListe) throws IOException {

    if (projListe == null || projListe.isEmpty()) throw new IllegalArgumentException("Da gibts keine valide Projektliste");
    if (mitarbeiterListe == null || mitarbeiterListe.isEmpty())
      throw new IllegalArgumentException("Da gibts keine valide Mitarbeiterliste");

    List<Serializable> liste = new ArrayList<>();
    for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
      liste.add(mitarbeiter);
    }
    for (Projekt projekt : projListe) {
      liste.add(projekt);
    }

    objectDAO.saveAllObjects(liste);
  }
}
