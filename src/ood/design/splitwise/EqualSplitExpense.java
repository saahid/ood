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
       for (Split split : splits) {
           if (!(split instanceof EqualSplit)) {
               final String message = String.format("Illegal split object: %s", split);
               throw new IllegalSplitException(message);
           }
       }
    }
}
