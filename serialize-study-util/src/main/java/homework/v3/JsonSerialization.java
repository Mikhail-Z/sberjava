package homework.v3;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class JsonSerialization {
    public static <T extends Serializable> void write(T obj, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), obj);
    }

    public static <T extends Serializable> T read(String filename, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), clazz);
    }
}
