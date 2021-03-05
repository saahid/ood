package ood.design.splitwise;

import java.util.List;

public class SplitwiseService {

    public void addExpense(ExpenseType type, ExpenseDetails details, List<Split> splits) {
        Expense expense = null;
        switch(type) {
            case EQUAL:
                expense = new EqualSplitExpense(details, splits);
                break;
            case FIXED:
                expense = new FixedSplitExpense(details, splits);
                break;
            case PERCENTAGE:
                expense = new PercentageSplitExpense(details, splits);
                break;
            default:
                return;
        }
        this.processExpense(expense);
    }

    public void processExpense(Expense expense) {
        ExpenseDetails details = expense.getExpenseDetails();
        List<Split> splits = expense.getSplits();
        for (Split split : splits) {
            double amt = split.getAmt();
            AccountManager.updateBalanceSheet(details.getCreditor().getId(), split.getDebtor().getId(), amt);
        }
    }
}
