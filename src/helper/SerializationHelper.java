package helper;

import java.io.*;

/**
 * Created by Jan Kakol on 2015-06-10.
 */
public class SerializationHelper {

    public static void serialize(Object o, String fileName) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        outputStream.writeObject(o);
        outputStream.close();
    }

    public static Object deSerialize(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        Object o1 = inputStream.readObject();
        inputStream.close();
        return o1;
    }
}
