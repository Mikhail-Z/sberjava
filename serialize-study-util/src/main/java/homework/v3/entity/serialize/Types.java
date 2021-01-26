package homework.v3.entity.serialize;

import java.io.Serializable;

public enum Types implements Serializable {
    
    STRING("STRING"),
    BOOLEAN("BOOLEAN"),
    LONG("LONG");
    
    private final String value;
    
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
}
