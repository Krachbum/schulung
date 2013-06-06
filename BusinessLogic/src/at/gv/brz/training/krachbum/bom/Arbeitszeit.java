package at.gv.brz.training.krachbum.bom;

import java.io.Serializable;
import java.util.Date;

public class Arbeitszeit implements Serializable {

  private static final long serialVersionUID = 536285737330498636L;
  private Date von;
  private Date bis;

  public Date getVon() {
    return von;
  }

  public void setVon(Date von) {
    this.von = von;
  }

  public Date getBis() {
    return bis;
  }

  public void setBis(Date bis) {
    this.bis = bis;
  }

  public Arbeitszeit(Date von, Date bis) {
    if (von == null || bis == null) { throw new IllegalArgumentException(); }
    if ( !bis.after(von)) { throw new IllegalArgumentException("Von Datum liegt nach dem Bis Datum"); }
    this.von = von;
    this.bis = bis;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + bis.hashCode();
    result = prime * result + von.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Arbeitszeit other = (Arbeitszeit) obj;
    if ( !bis.equals(other.bis)) return false;
    if ( !von.equals(other.von)) return false;
    return true;
  }

}
