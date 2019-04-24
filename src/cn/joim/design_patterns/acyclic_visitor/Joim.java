package cn.joim.design_patterns.acyclic_visitor;

public class Joim {

    private Dog mPetDog;

    public Joim(Dog mPetDog) {
        this.mPetDog = mPetDog;
    }

    public void handleVisit(IVisitor visit) {
        if (visit instanceof TwoVisitor) {
            ((TwoVisitor) visit).visit(mPetDog);
        }
    }
}
