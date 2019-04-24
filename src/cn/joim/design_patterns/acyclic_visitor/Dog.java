package cn.joim.design_patterns.acyclic_visitor;

public class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return getClass().getName() + " : " + getName();
    }
}
