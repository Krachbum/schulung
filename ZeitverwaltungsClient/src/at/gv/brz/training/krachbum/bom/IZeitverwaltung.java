
package at.gv.brz.training.krachbum.bom;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import at.gv.brz.training.krachbum.bom.ws.Mitarbeiter;
import at.gv.brz.training.krachbum.bom.ws.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IZeitverwaltung", targetNamespace = "http://ws.bom.krachbum.training.brz.gv.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IZeitverwaltung {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bucheZeit", targetNamespace = "http://ws.bom.krachbum.training.brz.gv.at/", className = "at.gv.brz.training.krachbum.bom.ws.BucheZeit")
    @ResponseWrapper(localName = "bucheZeitResponse", targetNamespace = "http://ws.bom.krachbum.training.brz.gv.at/", className = "at.gv.brz.training.krachbum.bom.ws.BucheZeitResponse")
    @Action(input = "http://ws.bom.krachbum.training.brz.gv.at/IZeitverwaltung/bucheZeitRequest", output = "http://ws.bom.krachbum.training.brz.gv.at/IZeitverwaltung/bucheZeitResponse")
    public boolean bucheZeit(
        @WebParam(name = "arg0", targetNamespace = "")
        Mitarbeiter arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        XMLGregorianCalendar arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        XMLGregorianCalendar arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

}
