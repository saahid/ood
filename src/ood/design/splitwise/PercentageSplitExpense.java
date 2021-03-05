package ood.design.splitwise;

import java.util.List;
import java.util.Objects;

public class PercentageSplitExpense extends Expense {

    public PercentageSplitExpense(ExpenseDetails expenseDetails, List<Split> splits) {
        super(expenseDetails);
        this.splits = Objects.requireNonNull(splits);
        this.validate();
    }

    @Override
    protected void validate() {
        if (splits.size() == 0)
            throw new IllegalSplitException("Number of splits is 0");

        for (Split split : splits) {
            if (!(split instanceof PercentageSplit)) {
                final String message = String.format("Illegal split object: %s", split);
                throw new IllegalSplitException(message);
            }
        }
        ExpenseDetails details = this.getExpenseDetails();
        List<Split> splits = this.getSplits();
        final double totalExpense = details.getTotalExpense();
        for (Split split : splits) {
            PercentageSplit percentageSplit = (PercentageSplit) split;
            double splitAmt = percentageSplit.getPercentage() * totalExpense / 100;
            split.setAmt(splitAmt);
        }
    }
}
