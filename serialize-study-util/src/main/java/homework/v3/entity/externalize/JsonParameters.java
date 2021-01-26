package homework.v3.entity.externalize;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.*;
import java.util.List;

@JsonPropertyOrder({"name", "description", "isList", "roles", "bundles", "type"})
public class JsonParameters implements Externalizable {
    
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

    public void setIsList(boolean isList) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getBundles());
        out.writeObject(this.getName());
        out.writeObject(this.getType());
        out.writeObject(this.getDescription());
        out.writeObject(this.getRoles());
        out.writeObject(this.getIsList());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       this.setBundles((List<Bundle>)in.readObject());
       this.setName((String)in.readObject());
       this.setType((Types)in.readObject());
       this.setDescription((String)in.readObject());
       this.setRoles((List<String>)in.readObject());
       this.setIsList((boolean)in.readObject());
    }
}
