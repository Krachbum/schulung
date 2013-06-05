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

  private MitarbeiterDao dao;

  @Before
  public void setUp() {
    dao = new MitarbeiterDao();
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

    dao.saveAllObjects(null, liste);

    List<Object> res = dao.getAllObjects().get("mitarbeiter");
    assertEquals(liste, res);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsEmpty() throws IOException {
    List<Serializable> liste = getTestList(0);

    dao.saveAllObjects(null, liste);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveAllObjectsNull() throws IOException {
    List<Serializable> liste = null;

    dao.saveAllObjects(null, liste);

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
