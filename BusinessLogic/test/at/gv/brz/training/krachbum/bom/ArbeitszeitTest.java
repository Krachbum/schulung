package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ArbeitszeitTest {

  private Arbeitszeit testInstance;

  private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");

  private Date von;
  private Date bis;
  private Date anderesDatum;

  @Before
  public void setUp() throws Exception {
    von = df.parse("01.02.2013 09:55");
    bis = df.parse("01.02.2013 12:55");
    testInstance = new Arbeitszeit(von, bis);
    anderesDatum = df.parse("01.02.2013 15:55");
  }

  @Test
  public void testGetSetVon() {
    testInstance.setVon(anderesDatum);
    assertEquals(anderesDatum, testInstance.getVon());
  }

  @Test
  public void testGetSetBis() {
    testInstance.setBis(anderesDatum);
    assertEquals(anderesDatum, testInstance.getBis());
  }

  @Test
  public void testArbeitszeit() {
    assertEquals(von, testInstance.getVon());
    assertEquals(bis, testInstance.getBis());
    assertEquals(Arbeitszeit.class, testInstance.getClass());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArbeitszeitvonNull() {
    testInstance = new Arbeitszeit(null, bis);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArbeitszeitGleichesDatum() {
    testInstance = new Arbeitszeit(bis, bis);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArbeitszeitbisNull() {
    testInstance = new Arbeitszeit(von, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArbeitszeitvonbisNull() {
    testInstance = new Arbeitszeit(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArbeitszeitvonNachBis() {
    testInstance = new Arbeitszeit(bis, von);
  }

  @Test
  public void testEquals() {
    assertEquals(new Arbeitszeit(von, bis), new Arbeitszeit(von, bis));
  }

  @Test
  public void testEqualsUngleichesBis() {
    assertFalse(new Arbeitszeit(von, new Date(bis.getTime() + 1)).equals(new Arbeitszeit(von, bis)));
  }

  @Test
  public void testEqualsUngleichesVon() {
    assertFalse(new Arbeitszeit(new Date(von.getTime() + 1), bis).equals(new Arbeitszeit(von, bis)));
  }

  @Test
  public void testEqualsUngleichNull() {
    assertFalse(testInstance.equals(null));
  }

  @Test
  public void testEqualsGleichesObject() {
    assertTrue(testInstance.equals(testInstance));
  }

  @Test
  public void testEqualsUngleichString() {
    assertFalse(testInstance.equals("String"));
  }

  @Test
  public void testHash() {
    assertEquals(new Arbeitszeit(von, bis).hashCode(), testInstance.hashCode());
  }
}
