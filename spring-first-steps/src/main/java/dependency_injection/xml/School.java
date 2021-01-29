package dependency_injection.xml;

import java.util.List;

public class School {

    private int number;
    private String name = "Гоcударственная общеобразовательная школа";
    private List<Pupil> pupils;

    public School(int number, List<Pupil> pupils) {
        this.number = number;
        this.pupils = pupils;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }
}
