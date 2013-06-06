package dataaccess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataTransferObjectTest {
  private List<Object> liste = new ArrayList<>();

  DataTransferObject testInstance;

  @Before
  public void setUp() {
    testInstance = new DataTransferObject();
  }

  @Test
  public void testGetSetProjekteListe() {
    testInstance.setProjekteListe(liste);
    assertEquals(liste, testInstance.getProjektListe());
  }

  @Test
  public void testGetSetMitarbeiterListe() {
    testInstance.setMitarbeiterListe(liste);
    assertEquals(liste, testInstance.getMitarbeiterListe());
  }

}
