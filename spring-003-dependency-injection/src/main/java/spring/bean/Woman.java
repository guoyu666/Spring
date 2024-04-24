package spring.bean;

public class Woman {
    private String name;

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
