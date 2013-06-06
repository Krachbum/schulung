package dataaccess;

import java.util.List;

public class DataTransferObject {
  private List<Object> projekteListe;
  private List<Object> mitarbeiterListe;

  public List<Object> getProjekteListe() {
    return projekteListe;
  }

  public void setProjekteListe(List<Object> projekte) {
    this.projekteListe = projekte;
  }

  public List<Object> getMitarbeiterListe() {
    return mitarbeiterListe;
  }

  public void setMitarbeiterListe(List<Object> mitarbeiter) {
    this.mitarbeiterListe = mitarbeiter;
  }

}
