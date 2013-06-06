package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArbeitszeitFunctionalTest {
  Arbeitszeit arbeitszeit;
  Projekt projekt;
  SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");

  @Given("^ich lege eine neue Arbeitszeit mit von \"([^\"]*)\" und bis \"([^\"]*)\" an$")
  public void ich_lege_eine_neue_Arbeitszeit_mit_von_und_bis_an(String von, String bis) throws Throwable {
    Date vonDate = df.parse(von);
    Date bisDate = df.parse(bis);
    arbeitszeit = new Arbeitszeit(vonDate, bisDate);
  }

  @Then("^sollte die Arbeitszeit von \"([^\"]*)\" und bis \"([^\"]*)\"  als Zeiten haben.$")
  public void sollte_die_Arbeitszeit_von_und_bis_als_Zeiten_haben(String von, String bis) throws Throwable {
    Date vonDate = df.parse(von);
    Date bisDate = df.parse(bis);
    assertEquals(vonDate, arbeitszeit.getVon());
    assertEquals(bisDate, arbeitszeit.getBis());
  }

  @When("^ich ein Projekt habe$")
  public void ich_ein_Projekt_habe() {
    projekt = new Projekt(0, null, null);
  }

  @When("^ich die Arbeitszeit einem Projekt zuordne$")
  public void ich_die_Arbeitszeit_einem_Projekt_zuordne() {
    List<Arbeitszeit> arbeitszeiten = new ArrayList<>();
    arbeitszeiten.add(arbeitszeit);
    projekt.setArbeitszeiten(arbeitszeiten);
  }

  @Then("^sollte das Projekt die Arbeitszeit haben$")
  public void sollte_das_Projekt_die_Arbeitszeit_haben() {
    List<Arbeitszeit> arbeitszeiten = projekt.getArbeitszeiten();
    assertNotNull(arbeitszeiten);
    assertEquals(arbeitszeit, arbeitszeiten.get(0));
  }

  @When("^ich die Projekt speichere$")
  public void ich_die_Projekt_speichere() throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }

  @When("^ich das Projekt neu lade$")
  public void ich_das_Projekt_neu_lade() throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }
}
