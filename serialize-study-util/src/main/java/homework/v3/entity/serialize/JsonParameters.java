package homework.v3.entity.serialize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({"name", "description", "isList", "roles", "bundles", "type"})
public class JsonParameters implements Serializable {
    
    public static final long SerialVersionUID = 1L;
    
    private String name;
    private String description = "";
    private boolean isList;
    private List<String> roles;
    private Types type;
    private List<Bundle> bundles;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsList() {
        return isList;
    }

    public void setList(boolean isList) {
        this.isList = isList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public List<Bundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }

    @Override
    public String toString() {

        String s = "";
        for (String s1: roles){
            s += s1;
        }

        return  name + "\n" +
                description + "\n" +
                isList + "\n" +
                type + "\n" +
                bundles + "\n" +
                s;
    }
}
