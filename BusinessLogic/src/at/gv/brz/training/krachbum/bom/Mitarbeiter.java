package at.gv.brz.training.krachbum.bom;
public class Mitarbeiter {
  private final int maNr;
  private String titel;
  private String vorname;
  private String nachname;

  // bittesehrsupersehr
  public Mitarbeiter(int maNr, String titel, String vorname, String nachname) throws IllegalArgumentException {
    if (maNr <= 0) { throw new IllegalArgumentException("MaNr must be larger than 0 but was: " + maNr); }
    this.maNr = maNr;
    this.setTitel(titel);
    this.setNachname(nachname);
    this.setVorname(vorname);
  }

  public int getMaNr() {
    return this.maNr;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) throws IllegalArgumentException {
    if (vorname == null || vorname.isEmpty()) { throw new IllegalArgumentException(); }
    this.vorname = vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + maNr;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) { return true; }
    if (obj == null) return false;
    if ( !(obj instanceof Mitarbeiter)) return false;
    Mitarbeiter other = (Mitarbeiter) obj;
    if (maNr != other.maNr) return false;
    return true;
  }
}
