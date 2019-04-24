package cn.joim.design_patterns.acyclic_visitor;

public class Juan {

    private Cat mPetCat;

    public Juan(Cat mPetCat) {
        this.mPetCat = mPetCat;
    }

    public void handleVisit(IVisitor visit) {
        if (visit instanceof OneVisitor) {
            ((OneVisitor) visit).visit(mPetCat);
        }
    }
}
