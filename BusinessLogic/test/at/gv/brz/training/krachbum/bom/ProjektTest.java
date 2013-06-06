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

    this.testInstanceBigger = new Projekt(40, PROJEKTNAME, testManager);
    this.testInstanceBigger.addArbeitszeit(this.testArbeitszeit);
  }

  @Test
  public void testConstructor() {
    assertEquals(40, testInstanceBigger.getKontingent());
    assertEquals(PROJEKTNAME, testInstanceBigger.getName());
    assertEquals(von, testInstanceBigger.getArbeitszeiten().get(0).getVon());
    assertEquals(Projekt.class, testInstanceBigger.getClass());
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
    assertEquals(this.von, testInstanceBigger.getArbeitszeiten().get(0).getVon());
    assertEquals(this.bis, testInstanceBigger.getArbeitszeiten().get(0).getBis());
  }

  @Test
  public void testGetKontingent() {
    assertEquals(1, testInstance.getKontingent());
  }

  @Test(expected = IllegalStateException.class)
  public void testIstKontingentErschoepft() {
    assertTrue(this.testInstance.istKontingentErschoepft(this.testArbeitszeit));
    assertFalse(this.testInstanceBigger.istKontingentErschoepft(this.testArbeitszeit));

    testInstance.addArbeitszeit(new Arbeitszeit(von, bis));

  }
}
