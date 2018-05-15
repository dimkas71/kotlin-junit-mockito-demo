package ua.compservice;

import static ua.compservice.Filter.*;

public class Prettl {

    private final String name;
    private final String description;

    public Prettl(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prettl prettl = (Prettl) o;

        if (!name.equals(prettl.name)) return false;
        return description.equals(prettl.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Prettl{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String... args) {
        Utils.log("Hello from Kotlin");
        Demo demo = new Demo("simple name");
        System.out.println(demo);

    }
}
