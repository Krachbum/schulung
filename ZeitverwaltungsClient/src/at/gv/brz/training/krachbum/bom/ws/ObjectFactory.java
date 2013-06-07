
package at.gv.brz.training.krachbum.bom.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.gv.brz.training.krachbum.bom.ws package. 
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

    private final static QName _BucheZeit_QNAME = new QName("http://ws.bom.krachbum.training.brz.gv.at/", "bucheZeit");
    private final static QName _BucheZeitResponse_QNAME = new QName("http://ws.bom.krachbum.training.brz.gv.at/", "bucheZeitResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.gv.brz.training.krachbum.bom.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BucheZeitResponse }
     * 
     */
    public BucheZeitResponse createBucheZeitResponse() {
        return new BucheZeitResponse();
    }

    /**
     * Create an instance of {@link BucheZeit }
     * 
     */
    public BucheZeit createBucheZeit() {
        return new BucheZeit();
    }

    /**
     * Create an instance of {@link Mitarbeiter }
     * 
     */
    public Mitarbeiter createMitarbeiter() {
        return new Mitarbeiter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BucheZeit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bom.krachbum.training.brz.gv.at/", name = "bucheZeit")
    public JAXBElement<BucheZeit> createBucheZeit(BucheZeit value) {
        return new JAXBElement<BucheZeit>(_BucheZeit_QNAME, BucheZeit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BucheZeitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bom.krachbum.training.brz.gv.at/", name = "bucheZeitResponse")
    public JAXBElement<BucheZeitResponse> createBucheZeitResponse(BucheZeitResponse value) {
        return new JAXBElement<BucheZeitResponse>(_BucheZeitResponse_QNAME, BucheZeitResponse.class, null, value);
    }

}
