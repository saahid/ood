package ood.design.splitwise;

import java.util.List;
import java.util.Objects;

public class FixedSplitExpense extends Expense {

    public FixedSplitExpense(ExpenseDetails expenseDetails, List<Split> splits) {
        super(expenseDetails);
        this.splits = Objects.requireNonNull(splits);
        this.validate();
    }

    @Override
    protected void validate() {
        if (splits.size() == 0)
            throw new IllegalSplitException("Number of splits is 0");

        for (Split split : splits) {
            if (!(split instanceof FixedAmountSplit)) {
                final String message = String.format("Illegal split object: %s", split);
                throw new IllegalSplitException(message);
            }
        }
        // Validate the total sum of splits
    }
}
