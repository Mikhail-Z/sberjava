package dependency_injection.xml;

import java.util.UUID;

public class Pupil {
    private String name;
    private int age;

    private UUID uuid = UUID.randomUUID();

    public Pupil(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UUID getUuid() {
        return uuid;
    }
}
