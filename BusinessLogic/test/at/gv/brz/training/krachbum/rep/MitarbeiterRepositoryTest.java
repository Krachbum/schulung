package at.gv.brz.training.krachbum.rep;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import at.gv.brz.training.krachbum.bom.Manager;
import at.gv.brz.training.krachbum.bom.Mitarbeiter;

/**
 * @author Spch05
 */
public class MitarbeiterRepositoryTest {

  private MitarbeiterRepository repository;

  @Before
  public void setUp() {
    repository = new MitarbeiterRepository();
  }

  /**
   * Test method for {@link at.gv.brz.training.krachbum.rep.MitarbeiterRepository#saveAllMitarbeiter(ArrayList), @link
   * at.gv.brz.training.krachbum.rep.MitarbeiterRepository#getAllMitarbeiter(ArrayList)}.
   * 
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Test
  public void testSaveGetAllMitarbeiter() throws IOException, ClassNotFoundException {
    List<Mitarbeiter> liste = getTestList(44, true);

    repository.saveAllMitarbeiter(liste);

    List<Mitarbeiter> res = repository.getAllMitarbeiter();
    assertEquals(liste, res);

  }

  @Test
  public void testSaveGetAllMitarbeiterWithManager() throws IOException, ClassNotFoundException {
    List<Mitarbeiter> liste = getTestList(44, false);

    repository.saveAllMitarbeiter(liste);

    List<Mitarbeiter> res = repository.getAllMitarbeiter();
    assertEquals(liste, res);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllMitarbeiterEmpty() throws IOException {
    List<Mitarbeiter> liste = getTestList(0, false);

    repository.saveAllMitarbeiter(liste);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllMitarbeiterNull() throws IOException {
    List<Mitarbeiter> liste = null;

    repository.saveAllMitarbeiter(liste);

  }

  private List<Mitarbeiter> getTestList(int anzahlElemente, Boolean ohneManager) {
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

}
