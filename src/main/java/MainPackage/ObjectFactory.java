package MainPackage;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName QNAME = new QName(
            XMLConstants.NULL_NS_URI, "data"
    );

    @XmlElementDecl(name = "MainPackage.Calculations")
    public JAXBElement <Calculations> createData (Calculations value){
        return new JAXBElement<Calculations>(
                QNAME, Calculations.class, null, value
        );
    }

}
