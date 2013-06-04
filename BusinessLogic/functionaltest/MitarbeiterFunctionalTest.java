import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MitarbeiterFunctionalTest {
  Mitarbeiter mitarbeiter;

  @Given("^ich lege einen neuen Mitarbeiter mit Vorname \"([^\"]*)\" und Nachname \"([^\"]*)\" an$")
  public void ich_lege_einen_neuen_Mitarbeiter_mit_Vorname_und_Nachname_an(String vorname, String nachname) throws Throwable {
    mitarbeiter = new Mitarbeiter(1, "", vorname, nachname);
  }

  @Then("^sollte der Mitarbeiter den Vornamen \"([^\"]*)\" und den Nachnamen \"([^\"]*)\" haben.$")
  public void sollte_der_Mitarbeiter_den_Vornamen_und_den_Nachnamen_haben(String vorname, String nachname) {
    assertEquals(vorname, mitarbeiter.getVorname());
    assertEquals(nachname, mitarbeiter.getNachname());
  }

  /**
   * @param arg1
   * @param arg1
   * @param arg2
   * @param arg3
   */
  @Given("^ich habe einen Mitarbeiter mit Vorname \"([^\"]*)\" und Nachname \"([^\"]*)\" und Mitarbeiternummer (\\d+)$")
  public void ich_habe_einen_Mitarbeiter_mit_Vorname_und_Nachname_und_Mitarbeiternummer(String arg1, String arg2, int arg3)
      throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }

  /**
   * @param arg1
   */
  @When("^ich dem Mitarbeiter den neuen Nachnamen \"([^\"]*)\" gebe$")
  public void ich_dem_Mitarbeiter_den_neuen_Nachnamen_gebe(String arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }

  /**
   * @param arg1
   */
  @Then("^sollte der Mitarbeiter den Nachnamen \"([^\"]*)\" haben$")
  public void sollte_der_Mitarbeiter_den_Nachnamen_haben(String arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }

  /**
   * @param arg1
   */
  @Then("^die Mitarbeiternummer soll auf (\\d+) bleiben$")
  public void die_Mitarbeiternummer_soll_auf_bleiben(int arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }
}
