package ood.design.splitwise;

public class PercentageSplit extends Split {
    double percentage;
    public PercentageSplit(User debtor, double percentage) {
        super(debtor);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
