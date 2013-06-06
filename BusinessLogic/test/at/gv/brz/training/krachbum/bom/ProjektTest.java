package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProjektTest {

  private static final String PROJEKTNAME = "So heiﬂt das Projekt Nummer 1";
  private static final String NACHNAME = "Mustermann";
  private static final String VORNAME = "Kurt";
  protected Projekt testInstance;
  protected Manager testManager;
  protected Arbeitszeit testArbeitszeit;
  protected Projekt testInstanceBigger;

  private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
  private Date von;
  private Date bis;

  @Before
  public void setUp() throws ParseException {
    this.testManager = new Manager(1, "Dr.", VORNAME, NACHNAME);
    this.testInstance = new Projekt(1, PROJEKTNAME, testManager);
    von = df.parse("01.02.2013 09:55");
    bis = df.parse("01.02.2013 12:55");
    this.testArbeitszeit = new Arbeitszeit(von, bis);

    List<Arbeitszeit> liste = new ArrayList<>();
    liste.add(this.testArbeitszeit);
    this.testInstance.setArbeitszeiten(liste);

    this.testInstanceBigger = new Projekt(40, PROJEKTNAME, testManager);
    this.testInstanceBigger.setArbeitszeiten(liste);
  }

  @Test
  public void testConstructor() {
    assertEquals(1, testInstance.getKontingent());
    assertEquals(PROJEKTNAME, testInstance.getName());
    assertEquals(von, testInstance.getArbeitszeiten().get(0).getVon());
    assertEquals(Projekt.class, testInstance.getClass());
  }

  @Test
  public void testSetAndGetName() {
    assertEquals(PROJEKTNAME, testInstance.getName());
    testInstance.setName("Ge‰nderter Name");
    assertEquals("Ge‰nderter Name", testInstance.getName());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGetNameWithNull() {
    testInstance.setName(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGetNameWithNone() {
    testInstance.setName("");
  }

  @Test
  public void testSetAndGetProjektleiter() {
    assertEquals(testManager, testInstance.getProjektleiter());
    testManager.setVorname("Franz");
    testInstance.setProjektleiter(testManager);
    assertEquals("Franz", testInstance.getProjektleiter().getVorname());
  }

  @Test
  public void testSetAndGetArbeitszeiten() {
    assertEquals(this.von, testInstance.getArbeitszeiten().get(0).getVon());
    assertEquals(this.bis, testInstance.getArbeitszeiten().get(0).getBis());
  }

  @Test
  public void testGetKontingent() {
    assertEquals(1, testInstance.getKontingent());
  }

  @Test
  public void testIstKontingentErschoepft() {

    assertFalse(this.testInstance.istKontingentNichtErschoepft());
    assertTrue(this.testInstanceBigger.istKontingentNichtErschoepft());

  }
}
