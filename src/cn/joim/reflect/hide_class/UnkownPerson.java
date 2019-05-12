package cn.joim.reflect.hide_class;

class UnkownPerson {

    private String name;

    private int age;

    public UnkownPerson() {
    }

    UnkownPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}
