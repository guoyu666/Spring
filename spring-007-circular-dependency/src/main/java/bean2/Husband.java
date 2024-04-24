package bean2;

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

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }
}
