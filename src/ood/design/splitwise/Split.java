package ood.design.splitwise;

import java.util.Objects;

public abstract class Split {
    private final User debtor;
    protected double amt;

    public Split(User debtor) {
        this.debtor = Objects.requireNonNull(debtor);
    }

    public Split(User debtor, double amt) {
       this.debtor = Objects.requireNonNull(debtor);
       this.amt  = amt;
    }

    public User getDebtor() {
        return debtor;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
