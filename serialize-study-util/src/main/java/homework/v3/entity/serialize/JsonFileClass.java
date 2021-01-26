package homework.v3.entity.serialize;

import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({"version", "parameters"})
public class JsonFileClass implements Serializable{
    
    public static final long SerialVersionUID = 1L;
    
    private String version;
    public List<JsonParameters> parameters;
    
    @Override
    public String toString() {
        return this.version + "\n" + this.parameters;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    @JsonGetter("version")
    public String getVersion() {
        return this.version;
    }
    @JsonGetter("parameters")
    public void setParameters(List<JsonParameters> parameters) {
        this.parameters = parameters;
    }
    public List<JsonParameters> setParameters() {
        return this.parameters;
    }
}
