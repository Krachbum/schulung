/**
 * 
 */
package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import at.gv.brz.training.krachbum.rep.ObjectRepository;

/**
 * TODO Document WHAT this type is used for.
 */
public class ZeitverwaltungTest {

  private ObjectRepository repository;
  private Zeitverwaltung verwaltung;

  @Before
  public void setUp() {
    repository = new ObjectRepository();
    verwaltung = new Zeitverwaltung();

  }

  /**
   * Test method for {@link at.gv.brz.training.krachbum.bom.Zeitverwaltung#reloadAll()}.
   * 
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Test
  public void testReloadAll() throws IOException, ClassNotFoundException {
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

    // test
    verwaltung.reloadAll();

    assertEquals(mListe, verwaltung.getlMitarbeiter());
    assertEquals(pListe, verwaltung.getlProjekte());
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
