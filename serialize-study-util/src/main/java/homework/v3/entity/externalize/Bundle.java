package homework.v3.entity.externalize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.*;
import java.util.List;

@JsonPropertyOrder({"paths", "values"})
public class Bundle implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private List<Path> paths;
    private List<String> values;

    public List<Path> getPaths() {
        return paths;
    }
    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getPaths());
        out.writeObject(this.getValues());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPaths((List<Path>)in.readObject());
        this.setValues((List<String>)in.readObject());
    }
}
