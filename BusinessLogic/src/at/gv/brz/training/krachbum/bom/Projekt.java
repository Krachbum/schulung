package at.gv.brz.training.krachbum.bom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Projekt implements Serializable {

  private static final long serialVersionUID = -1633408786859368297L;

  private String name;
  private Manager projektleiter;
  private final int kontingent;

  private List<Arbeitszeit> arbeitszeiten = new ArrayList<>();

  public Projekt(int fixesKontingent, String name, Manager manager) {
    this.kontingent = fixesKontingent;
    this.name = name;
    this.projektleiter = manager;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) { throw new IllegalArgumentException(); }
    this.name = name;
  }

  public Manager getProjektleiter() {
    return projektleiter;
  }

  public void setProjektleiter(Manager projektleiter) {
    this.projektleiter = projektleiter;
  }

  public List<Arbeitszeit> getArbeitszeiten() {
    return arbeitszeiten;
  }

  public void addArbeitszeit(Arbeitszeit arbeitszeit) {
    this.arbeitszeiten.add(arbeitszeit);
  }

  public int getKontingent() {
    return kontingent;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + kontingent;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((projektleiter == null) ? 0 : projektleiter.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Projekt other = (Projekt) obj;
    if (kontingent != other.kontingent) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if ( !name.equals(other.name)) return false;
    if (projektleiter == null) {
      if (other.projektleiter != null) return false;
    } else if ( !projektleiter.equals(other.projektleiter)) return false;
    return true;
  }

  public boolean istKontingentNichtErschoepft() {
    int summe = 0;
    for (Arbeitszeit arbeitszeit : this.arbeitszeiten) {
      summe += (int) ((arbeitszeit.getBis().getTime() - arbeitszeit.getVon().getTime()) / 3600000);
    }

    return (this.kontingent - summe) >= 0;

  }
}
