package mainPackage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import javax.xml.bind.*;

public class SerializationMethods {

    /*Java Serialization*/

    public void toWriteObject(Calculations calc, File file) throws IOException {
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);

        so.writeObject(calc);
        so.flush();
        so.close();
    }

    public Calculations toReadObject(File file) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        Calculations calc = (Calculations) si.readObject();
        si.close();
        return calc;
    }

    /*Serialization with XML*/
    String PACKAGE = Calculations.class.getPackage().getName();

    public void toWriteObjectXML(Calculations calc, File file) throws JAXBException{

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Marshaller m = jc.createMarshaller();
        m.marshal(calc, file);

    }

    public Calculations toReadObjectXML(File file) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Unmarshaller um = jc.createUnmarshaller();

        Calculations newCalc = (Calculations) um.unmarshal(file);

        return newCalc;
    }

    /*Serialization with JSON*/

    public void toWriteObjectJSON(Calculations calc, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new Gson();

            gson.toJson(calc, writer);
            writer.flush();
        }
    }

    public Calculations toReadObjectJSON(File file) throws IOException {
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();

            Calculations newCalc = gson.fromJson(reader, Calculations.class);
            return newCalc;
        }
    }
}
