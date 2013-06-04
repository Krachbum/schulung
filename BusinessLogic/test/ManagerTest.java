import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Spch03
 */
public class ManagerTest extends MitarbeiterTest {

  @Override
  @Before
  public void setUp() {
    testInstance = new Manager(1, "Titel", "Vorname", "Nachname");
  }

  @Override
  @Test
  public void testConstructor() {
    assertEquals(1, testInstance.getMaNr());
    assertEquals("Titel", testInstance.getTitel());
    assertEquals("Vorname", testInstance.getVorname());
    assertEquals("Nachname", testInstance.getNachname());
    assertEquals(Manager.class, testInstance.getClass());
  }
}
