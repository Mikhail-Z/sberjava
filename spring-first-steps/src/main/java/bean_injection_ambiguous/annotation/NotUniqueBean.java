package bean_injection_ambiguous.annotation;

import org.springframework.stereotype.Component;

@Component
public class NotUniqueBean {

    private String name;

    public NotUniqueBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
