
package at.gv.brz.trainig.krachbum.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MatheImplService", targetNamespace = "http://server.krachbum.trainig.brz.gv.at/", wsdlLocation = "http://localhost:8080/WS/Mathe?wsdl")
public class MatheImplService
    extends Service
{

    private final static URL MATHEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MATHEIMPLSERVICE_EXCEPTION;
    private final static QName MATHEIMPLSERVICE_QNAME = new QName("http://server.krachbum.trainig.brz.gv.at/", "MatheImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WS/Mathe?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MATHEIMPLSERVICE_WSDL_LOCATION = url;
        MATHEIMPLSERVICE_EXCEPTION = e;
    }

    public MatheImplService() {
        super(__getWsdlLocation(), MATHEIMPLSERVICE_QNAME);
    }

    public MatheImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MATHEIMPLSERVICE_QNAME, features);
    }

    public MatheImplService(URL wsdlLocation) {
        super(wsdlLocation, MATHEIMPLSERVICE_QNAME);
    }

    public MatheImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MATHEIMPLSERVICE_QNAME, features);
    }

    public MatheImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MatheImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Mathe
     */
    @WebEndpoint(name = "MatheImplPort")
    public Mathe getMatheImplPort() {
        return super.getPort(new QName("http://server.krachbum.trainig.brz.gv.at/", "MatheImplPort"), Mathe.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Mathe
     */
    @WebEndpoint(name = "MatheImplPort")
    public Mathe getMatheImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.krachbum.trainig.brz.gv.at/", "MatheImplPort"), Mathe.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MATHEIMPLSERVICE_EXCEPTION!= null) {
            throw MATHEIMPLSERVICE_EXCEPTION;
        }
        return MATHEIMPLSERVICE_WSDL_LOCATION;
    }

}
