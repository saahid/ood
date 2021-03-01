package ood.design.splitwise;

import java.util.List;
import java.util.Objects;

public abstract class Expense {
    private ExpenseDetails expenseDetails;
    protected List<Split> splits;

    public Expense(ExpenseDetails expenseDetails) {
        this.expenseDetails = Objects.requireNonNull(expenseDetails);
    }

    public ExpenseDetails getExpenseDetails() {
        return expenseDetails;
    }

    public List<Split> getSplits() {
        return splits;
    }

    protected abstract void validate();
// public abstract void setSplits();
}
