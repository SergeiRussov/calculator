package mainPackage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import javax.xml.bind.*;

public class SerializationMethods {

    /*Java Serialization*/
    File file = new File("saves.bin");

    public void toWriteObject(Calculations calc) throws IOException {
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);

        so.writeObject(calc);
        so.flush();
        so.close();
    }

    public Calculations toReadObject() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        Calculations calc = (Calculations) si.readObject();
        si.close();
        return calc;
    }

    /*Serialization with XML*/
    String PACKAGE = Calculations.class.getPackage().getName();
    File fileXML = new File("saves.xml");

    public void toWriteObjectXML(Calculations calc) throws JAXBException{

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Marshaller m = jc.createMarshaller();
        m.marshal(calc, fileXML);

    }

    public Calculations toReadObjectXML() throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);

        Unmarshaller um = jc.createUnmarshaller();

        Calculations newCalc = (Calculations) um.unmarshal(fileXML);

        return newCalc;
    }

    /*Serialization with JSON*/

    public void toWriteObjectJSON(Calculations calc) throws IOException {
        try (Writer writer = new FileWriter("saves.json")) {
            Gson gson = new GsonBuilder().create();

            gson.toJson(calc, writer);
            writer.flush();
        }
    }

    public Calculations toReadObjectJSON() throws IOException {
        try (Reader reader = new FileReader("saves.json")) {
            Gson gson = new Gson();

            Calculations newCalc = gson.fromJson(reader, Calculations.class);
            return newCalc;
        }
    }
}
