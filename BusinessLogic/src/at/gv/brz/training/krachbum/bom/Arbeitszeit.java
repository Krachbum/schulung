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
    if (von.after(bis)) { throw new IllegalArgumentException("Von Datum liegt nach dem Bis Datum"); }
    this.von = von;
    this.bis = bis;

  }

}
