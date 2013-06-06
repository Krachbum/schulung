package dataaccess;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Spch05
 */
public class MitarbeiterDaoTest {

  private ObjectDao dao;

  @Before
  public void setUp() {
    dao = new ObjectDao();
  }

  /**
   * Test method for {@link dataaccess.MitarbeiterDao#saveAllObjects(ArrayList), @link dataaccess.MitarbeiterDao#getAllObjects(ArrayList)}.
   * 
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Test
  public void testSaveGetAllObjects() throws IOException, ClassNotFoundException {
    List<Serializable> liste = getTestList(44);

    dao.saveAllObjects(liste);

    List<Object> res = dao.getAllObjects();
    assertEquals(liste, res);

  }

  @Test
  public void testSaveGetAllObjectsWithBothLists() throws IOException, ClassNotFoundException {
    List<Serializable> liste = getTestList(44);
    List<Serializable> liste2 = getTestList(5);
    dao.saveAllObjects(liste, liste2);

    List<Object> res = dao.getAllObjects().getMitarbeiterListe();
    assertEquals(liste2, res);

    res = dao.getAllObjects().getProjekteListe();
    assertEquals(liste, res);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsEmptyMitarbeiter() throws IOException {
    List<Serializable> liste = getTestList(0);

    dao.saveAllObjects(liste);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsNullMitarbeiter() throws IOException {
    List<Serializable> liste = null;

    dao.saveAllObjects(liste);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsEmptyProjekte() throws IOException {
    List<Serializable> liste = getTestList(0);

    dao.saveAllObjects(liste, null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsNullProjekte() throws IOException {
    List<Serializable> liste = null;

    dao.saveAllObjects(liste, null);

  }

  private List<Serializable> getTestList(int anzahlElemente) {
    List<Serializable> liste = new ArrayList<>();
    for (int j = 0; j < anzahlElemente; j++ ) {
      TestModel model = new TestModel(j);
      liste.add(model);
    }
    return liste;
  }

}
