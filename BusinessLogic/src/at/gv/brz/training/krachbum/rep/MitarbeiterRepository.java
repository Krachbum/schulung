package at.gv.brz.training.krachbum.rep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import at.gv.brz.training.krachbum.bom.Mitarbeiter;
import dataaccess.MitarbeiterDao;

public class MitarbeiterRepository {

  private MitarbeiterDao mitarbeiterDAO = new MitarbeiterDao();

  public List<Mitarbeiter> getAllMitarbeiter() throws FileNotFoundException, ClassNotFoundException, IOException {

    List<Mitarbeiter> maListe = new ArrayList<>();

    List<Object> res = mitarbeiterDAO.getAllObjects().get("mitarbeiter");

    for (Object object : res) {
      maListe.add((Mitarbeiter) object);
    }
    return maListe;

  }

  public void saveAllMitarbeiter(List<Mitarbeiter> mitarbeiterListe) throws IOException {

    if (mitarbeiterListe == null || mitarbeiterListe.isEmpty())
      throw new IllegalArgumentException("Da gibts keine valide Mitarbeiterliste");

    List<Serializable> maListe = new ArrayList<>();
    for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
      maListe.add(mitarbeiter);
    }

    mitarbeiterDAO.saveAllObjects(null, maListe);
  }
}
