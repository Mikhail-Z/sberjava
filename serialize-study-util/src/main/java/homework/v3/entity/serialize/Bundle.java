package homework.v3.entity.serialize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

class A {

}

@JsonPropertyOrder({"paths", "values"})
public class Bundle implements Serializable {
    
    public static final long SerialVersionUID = 1L;

    private A a;

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
}
