package homework.v3;

import classwork.entity.serialize.Fallback;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

public class BinarySerialization {
    public static <T extends Serializable> void writeSerializable(T obj, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
                oos.writeObject(obj);
            }
        }
    }

    public static <T extends Externalizable> void writeExternalizable(T obj, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
                oos.writeObject(obj);
            }
        }
    }

    public static <T extends Serializable> T readSerializable(String filename, Class<T> clazz) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)){
            try (ObjectInputStream oos = new ObjectInputStream(fos)){
                return (T)oos.readObject();
            }
        }
    }

    public static <T extends Externalizable> T readExternalizable(String filename, Class<T> clazz) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)){
            try (ObjectInputStream oos = new ObjectInputStream(fos)){
                return (T)oos.readObject();
            }
        }
    }
}
