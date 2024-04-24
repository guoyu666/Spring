package bean;

public class Husband {
    private String name;
    private Wife wife;

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
