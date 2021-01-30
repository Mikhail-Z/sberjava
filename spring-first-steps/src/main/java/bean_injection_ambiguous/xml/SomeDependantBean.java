package bean_injection_ambiguous.xml;

public class SomeDependantBean {

    private NotUniqueBean notUniqueBean;

    public SomeDependantBean(NotUniqueBean notUniqueBean) {
        this.notUniqueBean = notUniqueBean;
    }

    public NotUniqueBean getNotUniqueBean() {
        return notUniqueBean;
    }
}
