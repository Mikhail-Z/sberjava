package task01_05.my_bean;

public class MyBean {
    private final String name;

    public MyBean(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(
                String.format("Hello from %s of type %s",
                        this.name,
                        this.getClass().getName()));
    }
}
