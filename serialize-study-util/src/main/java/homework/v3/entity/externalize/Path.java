package homework.v3.entity.externalize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.*;

@JsonPropertyOrder({"code", "value"})
public class Path  implements Externalizable {
    
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getValue());
        out.writeObject(this.getCode());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setValue((String)in.readObject());
        this.setCode((String)in.readObject());
    }
}
