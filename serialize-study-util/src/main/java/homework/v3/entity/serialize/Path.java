package homework.v3.entity.serialize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"code", "value"})
public class Path  implements Serializable {
    
    public static final long SerialVersionUID = 1L;
    
    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
