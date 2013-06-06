package at.gv.brz.training.krachbum.bom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProjektFunctionalTest {

  private Projekt proj;
  private Manager projektleiter = new Manager(3, "BSc", "Maxi", "Mustermann");
  private Manager projektleiter2 = new Manager(2, "Dr.", "Vlad", "Acula");

  @Given("^ich lege ein neues Projekt mit Name \"([^\"]*)\" und Kontingent (\\d+) und Projektleiter$")
  public void ich_lege_ein_neues_Projekt_mit_Name_und_Kontingent_und_Projektleiter(String projname, int kontingent) {
    this.proj = new Projekt(kontingent, projname, projektleiter);
  }

  @Then("^sollte das Projekt den Namen \"([^\"]*)\" und Kontingent (\\d+) haben und einen Projektleiter$")
  public void sollte_das_Projekt_den_Namen_und_Kontingent_haben_und_einen_Projektleiter(String projname, int kontingent) {
    assertEquals(kontingent, this.proj.getKontingent());
    assertEquals(projname, this.proj.getName());
  }

  @When("^ich dem Projekt den neuen Namen \"([^\"]*)\" gebe$")
  public void ich_dem_Projekt_den_neuen_Namen_gebe(String name) {
    this.proj.setName(name);
  }

  @Then("^sollte das Projekt den Namen \"([^\"]*)\" haben$")
  public void sollte_das_Projekt_den_Namen_haben(String name) {
    assertEquals(name, this.proj.getName());
  }

  @Then("^das Kontingent soll auf (\\d+) bleiben$")
  public void das_Kontingent_soll_auf_bleiben(int kont) {
    assertEquals(kont, this.proj.getKontingent());
  }

  @Then("^der Projektleiter gleich bleiben$")
  public void der_Projektleiter_gleich_bleiben() {
    assertEquals(this.projektleiter.getMaNr(), this.proj.getProjektleiter().getMaNr());

  }

  @When("^ich dem Projekt den neuen Projektleiter uebergebe$")
  public void ich_dem_Projekt_den_neuen_Projektleiter_uebergebe() {
    this.proj.setProjektleiter(this.projektleiter2);
  }

  @Then("^soll das Projekt den neuen Projektleiter haben$")
  public void soll_das_Projekt_den_neuen_Projektleiter_haben() {
    assertNotSame(this.projektleiter, this.proj.getProjektleiter());
  }

  @Then("^der Name soll auf \"([^\"]*)\" bleiben$")
  public void der_Name_soll_auf_bleiben(String name) {
    assertEquals(name, this.proj.getName());
  }

}
