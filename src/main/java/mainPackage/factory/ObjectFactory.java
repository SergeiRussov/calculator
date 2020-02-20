package mainPackage.factory;

import mainPackage.entity.CalculationEntity;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName QNAME = new QName(
            XMLConstants.NULL_NS_URI, "data"
    );

    @XmlElementDecl(name = "mainPackage.Calculations")
    public JAXBElement<CalculationEntity> createData(CalculationEntity value) {
        return new JAXBElement<CalculationEntity>(
                QNAME, CalculationEntity.class, null, value
        );
    }
}
