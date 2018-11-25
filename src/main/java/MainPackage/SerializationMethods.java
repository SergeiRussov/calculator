package MainPackage;

import java.io.*;

public class SerializationMethods {

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

}
