package MainPackage;

import javax.xml.bind.*;
import java.io.File;

public class XMLMethods  {

    static final String PACKAGE = Calculations.class.getPackage().getName();
    File file = new File("saves.xml");

    public void toWriteObjectXML(Calculations calc) throws JAXBException{

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Marshaller m = jc.createMarshaller();
        m.marshal(calc, file);

    }

    public Calculations toReadObjectXML() throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Unmarshaller um = jc.createUnmarshaller();

        Calculations newCalc = (Calculations) um.unmarshal(file);

        return newCalc;
    }
}
