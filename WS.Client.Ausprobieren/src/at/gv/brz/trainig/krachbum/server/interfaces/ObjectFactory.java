
package at.gv.brz.trainig.krachbum.server.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.gv.brz.trainig.krachbum.server.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddiereResponse_QNAME = new QName("http://interfaces.server.krachbum.trainig.brz.gv.at/", "addiereResponse");
    private final static QName _Addiere_QNAME = new QName("http://interfaces.server.krachbum.trainig.brz.gv.at/", "addiere");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.gv.brz.trainig.krachbum.server.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Addiere }
     * 
     */
    public Addiere createAddiere() {
        return new Addiere();
    }

    /**
     * Create an instance of {@link AddiereResponse }
     * 
     */
    public AddiereResponse createAddiereResponse() {
        return new AddiereResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddiereResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.server.krachbum.trainig.brz.gv.at/", name = "addiereResponse")
    public JAXBElement<AddiereResponse> createAddiereResponse(AddiereResponse value) {
        return new JAXBElement<AddiereResponse>(_AddiereResponse_QNAME, AddiereResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addiere }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.server.krachbum.trainig.brz.gv.at/", name = "addiere")
    public JAXBElement<Addiere> createAddiere(Addiere value) {
        return new JAXBElement<Addiere>(_Addiere_QNAME, Addiere.class, null, value);
    }

}
