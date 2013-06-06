package at.gv.brz.training.krachbum.rep;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import at.gv.brz.training.krachbum.bom.Manager;
import at.gv.brz.training.krachbum.bom.Mitarbeiter;
import at.gv.brz.training.krachbum.bom.Projekt;

/**
 * @author Spch05
 */
public class ObjectRepositoryTest {

  private ObjectRepository repository;

  @Before
  public void setUp() {
    repository = new ObjectRepository();
  }

  /**
   * Test method for {@link at.gv.brz.training.krachbum.rep.MitarbeiterRepository#saveAllMitarbeiter(ArrayList), @link
   * at.gv.brz.training.krachbum.rep.MitarbeiterRepository#getAllMitarbeiter(ArrayList)}.
   * 
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Test
  public void testSaveGetAllObjects() throws IOException, ClassNotFoundException {
    List<Mitarbeiter> mListe = getMitarbeiterTestList(44, true);
    List<Projekt> pListe = getProjektTestList(6);
    List<Object> liste = new ArrayList<>();
    for (Object object : mListe) {
      liste.add(object);

    }
    for (Object object : pListe) {
      liste.add(object);
    }

    repository.saveAllObjects(pListe, mListe);

    List<Object> res = repository.getAllObjects();
    assertEquals(liste, res);

  }

  @Test
  public void testSaveGetAllMitarbeiterWithManager() throws IOException, ClassNotFoundException {
    List<Mitarbeiter> mListe = getMitarbeiterTestList(44, false);
    List<Projekt> pListe = getProjektTestList(6);
    List<Object> liste = new ArrayList<>();
    for (Object object : mListe) {
      liste.add(object);

    }
    for (Object object : pListe) {
      liste.add(object);
    }

    repository.saveAllObjects(pListe, mListe);

    List<Object> res = repository.getAllObjects();
    assertEquals(liste, res);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllMitarbeiterEmpty() throws IOException {
    List<Mitarbeiter> mListe = getMitarbeiterTestList(0, false);
    List<Projekt> pListe = getProjektTestList(0);

    repository.saveAllObjects(pListe, mListe);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllMitarbeiterNull() throws IOException {
    List<Mitarbeiter> mListe = null;
    List<Projekt> pListe = null;

    repository.saveAllObjects(pListe, mListe);

  }

  private List<Mitarbeiter> getMitarbeiterTestList(int anzahlElemente, Boolean ohneManager) {
    List<Mitarbeiter> liste = new ArrayList<>();
    for (int j = 1; j <= anzahlElemente; j++ ) {
      Mitarbeiter model;

      if (ohneManager) {
        model = new Mitarbeiter(j, "Bsc", "Hubert", "Meier");
      } else {
        model = new Manager(j, "Bsc", "Hubert", "Meier");
      }
      liste.add(model);
    }
    return liste;
  }

  private List<Projekt> getProjektTestList(int anzahlElemente) {
    List<Projekt> liste = new ArrayList<>();
    Manager manager = new Manager(6, "Bsc", "Hubert", "Meier");
    for (int j = 1; j <= anzahlElemente; j++ ) {
      Projekt model = new Projekt(j, "Hubert", manager);
      liste.add(model);
    }
    return liste;
  }
}
