package mainPackage.service;

import com.google.gson.Gson;
import mainPackage.entity.CalculationEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class SerializationService {

    /*Java Serialization*/

    public void toWriteObject(CalculationEntity calc, File file) throws IOException {
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);

        so.writeObject(calc);
        so.flush();
        so.close();
    }

    public CalculationEntity toReadObject(File file) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        CalculationEntity calc = (CalculationEntity) si.readObject();
        si.close();
        return calc;
    }

    /*Serialization with XML*/
    String PACKAGE = CalculationEntity.class.getPackage().getName();

    public void toWriteObjectXML(CalculationEntity calc, File file) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Marshaller m = jc.createMarshaller();
        m.marshal(calc, file);

    }

    public CalculationEntity toReadObjectXML(File file) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Unmarshaller um = jc.createUnmarshaller();

        CalculationEntity newCalc = (CalculationEntity) um.unmarshal(file);

        return newCalc;
    }

    /*Serialization with JSON*/

    public void toWriteObjectJSON(CalculationEntity calc, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new Gson();

            gson.toJson(calc, writer);
            writer.flush();
        }
    }

    public CalculationEntity toReadObjectJSON(File file) throws IOException {
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();

            CalculationEntity newCalc = gson.fromJson(reader, CalculationEntity.class);
            return newCalc;
        }
    }
}
