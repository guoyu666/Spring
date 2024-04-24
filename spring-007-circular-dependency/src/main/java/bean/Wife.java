package bean;

public class Wife {
    private String name;
    private Husband husband;

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
