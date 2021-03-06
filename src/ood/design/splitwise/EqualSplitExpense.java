package ood.design.splitwise;

import java.util.List;
import java.util.Objects;

public class EqualSplitExpense extends Expense {

    public EqualSplitExpense(ExpenseDetails expenseDetails, List<Split> splits) {
        super(expenseDetails);
        this.splits = Objects.requireNonNull(splits);
        this.validate();
    }

    @Override
    protected void validate() {
        if (splits.size() == 0)
            throw new IllegalSplitException("Number of splits is 0");

        for (Split split : splits) {
            if (!(split instanceof EqualSplit)) {
                final String message = String.format("Illegal split object: %s", split);
                throw new IllegalSplitException(message);
            }
        }
        ExpenseDetails details = this.getExpenseDetails();
        List<Split> splits = this.getSplits();
        User creditor = details.getCreditor();
        final double totalExpense = details.getTotalExpense();
        final int noOfSplits = 1 + splits.size();
        double splitAmt = totalExpense / noOfSplits;
        for (Split split : splits) {
            split.setAmt(splitAmt);
        }
    }
}
