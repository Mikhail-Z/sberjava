package homework.v3.entity.externalize;

import java.io.*;

public enum Types implements Externalizable {
    
    STRING("STRING"),
    BOOLEAN("BOOLEAN"),
    LONG("LONG");
    
    //private final String value;
    private String value;

    Types(String string) {
        this.value = string;
    }
    
    public static Types fromValue(String value) {
        if (value != null) {
            for (Types type : values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }
        }
        return getDefault();
    }
    
    public String toValue() {
        return value;
    }
    
    public static Types getDefault() {
        return STRING;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(toValue());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = (String)in.readObject();
    }
}
