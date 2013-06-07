package at.gv.brz.training.krachbum.input;

import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import at.gv.brz.training.krachbum.bom.IZeitverwaltung;
import at.gv.brz.training.krachbum.bom.ZeitverwaltungService;

public class WSAufruf {

  /**
   * @param args
   * @throws ParseException
   * @throws DatatypeConfigurationException
   */
  public static void main(String[] args) throws DatatypeConfigurationException {
    ZeitverwaltungService service = new ZeitverwaltungService();
    IZeitverwaltung zeitverwaltung = service.getZeitverwaltungPort();

    int mitarbeiterNr = 3;

    int stunde = 9;
    int minute = 0;
    XMLGregorianCalendar xmlVon = DatatypeFactory.newInstance().newXMLGregorianCalendar(2013, 1, 1, stunde, minute, 0, 0, 0);
    XMLGregorianCalendar xmlBis = DatatypeFactory.newInstance().newXMLGregorianCalendar(2013, 1, 1, stunde + 4, minute + 20, 0, 0, 0);

    Boolean gebucht = zeitverwaltung.bucheZeit(mitarbeiterNr, xmlVon, xmlBis, "Java-Kurs");
    if (gebucht.toString().length() < 5) {
      System.out.println("Wurde erfolgreich gebucht");
    } else {
      System.out.println("you are doomed!");
    }
  }

}
