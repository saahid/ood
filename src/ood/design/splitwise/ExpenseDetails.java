package ood.design.splitwise;

import java.util.Objects;

public class ExpenseDetails {
    private User creditor;
    private String desc;
    private double totalExpense;

    public ExpenseDetails(User creditor, String desc, double totalExpense) {
        this.creditor = Objects.requireNonNull(creditor);
        this.desc = Objects.requireNonNull(desc);
        this.totalExpense = totalExpense;
    }

    public User getCreditor() {
        return creditor;
    }

    public String getDesc() {
        return desc;
    }

    public double getTotalExpense() {
        return totalExpense;
    }
}
