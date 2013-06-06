package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import at.gv.brz.training.krachbum.rep.ObjectRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MitarbeiterFunctionalTest {
  Mitarbeiter mitarbeiter;
  Projekt projekt = new Projekt(1, "projekt", (Manager) mitarbeiter);
  ObjectRepository mitarbeiterRepository = new ObjectRepository();

  @Given("^ich lege einen neuen Mitarbeiter mit Vorname \"([^\"]*)\" und Nachname \"([^\"]*)\" an$")
  public void ich_lege_einen_neuen_Mitarbeiter_mit_Vorname_und_Nachname_an(String vorname, String nachname) {
    mitarbeiter = new Mitarbeiter(1, "", vorname, nachname);
  }

  @Then("^sollte der Mitarbeiter den Vornamen \"([^\"]*)\" und den Nachnamen \"([^\"]*)\" haben.$")
  public void sollte_der_Mitarbeiter_den_Vornamen_und_den_Nachnamen_haben(String vorname, String nachname) {
    assertEquals(vorname, mitarbeiter.getVorname());
    assertEquals(nachname, mitarbeiter.getNachname());
  }

  @Given("^ich habe einen Mitarbeiter mit Vorname \"([^\"]*)\" und Nachname \"([^\"]*)\" und Mitarbeiternummer (\\d+)$")
  public void ich_habe_einen_Mitarbeiter_mit_Vorname_und_Nachname_und_Mitarbeiternummer(String vorname, String nachname, int maNr) {
    mitarbeiter = new Mitarbeiter(maNr, "", vorname, nachname);
  }

  @When("^ich dem Mitarbeiter den neuen Nachnamen \"([^\"]*)\" gebe$")
  public void ich_dem_Mitarbeiter_den_neuen_Nachnamen_gebe(String nachname) {
    mitarbeiter.setNachname(nachname);
    assertEquals(nachname, mitarbeiter.getNachname());
  }

  @Then("^sollte der Mitarbeiter den Nachnamen \"([^\"]*)\" haben$")
  public void sollte_der_Mitarbeiter_den_Nachnamen_haben(String nachname) {
    assertEquals(nachname, this.mitarbeiter.getNachname());
  }

  @Then("^die Mitarbeiternummer soll auf (\\d+) bleiben$")
  public void die_Mitarbeiternummer_soll_auf_bleiben(int maNr) {
    assertEquals(maNr, mitarbeiter.getMaNr());
  }

  @Given("^ich habe einen Manager mit Vorname \"([^\"]*)\" und Nachname \"([^\"]*)\" und Mitarbeiternummer (\\d+)$")
  public void ich_habe_einen_Manager_mit_Vorname_und_Nachname_und_Mitarbeiternummer(String vorname, String nachname, int maNr) {
    mitarbeiter = new Manager(maNr, "", vorname, nachname);
  }

  @When("^ich dem Manager den neuen Nachnamen \"([^\"]*)\" gebe$")
  public void ich_dem_Manager_den_neuen_Nachnamen_gebe(String nachname) {
    mitarbeiter.setNachname(nachname);
  }

  @Then("^sollte der Manager den Nachnamen \"([^\"]*)\" haben$")
  public void sollte_der_Manager_den_Nachnamen_haben(String nachname) {
    assertEquals(nachname, mitarbeiter.getNachname());
  }

  @Then("^ein Manager bleiben$")
  public void ein_Manager_bleiben() {
    assertEquals(Manager.class, this.mitarbeiter.getClass());
  }

  /**
   * @param managerOrMitarbeiter
   */
  @When("^ich den (Manager|Mitarbeiter) speichere$")
  public void ich_den_Manager_speichere(String managerOrMitarbeiter) throws Throwable {
    List<Mitarbeiter> liste = new ArrayList<>();
    liste.add(mitarbeiter);
    List<Projekt> pListe = new ArrayList<>();
    pListe.add(projekt);

    mitarbeiterRepository.saveAllObjects(pListe, liste);
  }

  /**
   * @param managerOrMitarbeiter
   */
  @When("^den (Manager|Mitarbeiter) wieder lade$")
  public void den_Manager_wieder_lade(String managerOrMitarbeiter) throws Throwable {
    List<Object> liste = mitarbeiterRepository.getAllObjects();
    mitarbeiter = (Mitarbeiter) liste.get(0);
  }
}
