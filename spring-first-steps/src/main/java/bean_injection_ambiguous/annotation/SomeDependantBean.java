package bean_injection_ambiguous.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SomeDependantBean {

    @Autowired
    @Qualifier("notUniqueBean1")
    private NotUniqueBean notUniqueBean;

    public SomeDependantBean(@Autowired NotUniqueBean notUniqueBean) {
        this.notUniqueBean = notUniqueBean;
    }

    public NotUniqueBean getNotUniqueBean() {
        return notUniqueBean;
    }
}
