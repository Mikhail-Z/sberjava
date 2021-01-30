package bean_injection_ambiguous.xml;

public class NotUniqueBean {

    private String name;

    public NotUniqueBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
