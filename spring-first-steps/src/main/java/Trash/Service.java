package Trash;

public class Service {
    private Repository repo;
    private String name;

    /*public Trash.Service(Trash.Repository repo, String name) {
        this.repo = repo;
        this.name = name;
    }*/

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Repository getRepo() {
        return repo;
    }

    public String getName() {
        return name;
    }

    public void helloWorld() {
        System.out.println("hello, world!");
    }
}
