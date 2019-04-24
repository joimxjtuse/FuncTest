package cn.joim.design_patterns.acyclic_visitor;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("mo-mo");
        Dog dog = new Dog("gou-gou");
        Joim joim = new Joim(dog);
        Juan juan = new Juan(cat);


        joim.handleVisit(new AllVisitor() {

            @Override
            public void visit(Cat cat) {

            }

            @Override
            public void visit(Dog dog) {


                System.out.println(dog.getDetail());
            }
        });

        juan.handleVisit(new OneVisitor() {
            @Override
            public void visit(Cat cat) {
                System.out.println(cat.getDetail());
            }
        });

    }
}
