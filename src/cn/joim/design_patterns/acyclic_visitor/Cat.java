package cn.joim.design_patterns.acyclic_visitor;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return getClass().getName() + " : " + getName();
    }
}
