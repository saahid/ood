package ood.design.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        User first = new User("first", "first");
        User second = new User("second", "second");
        User third = new User("third", "third");
        AccountManager.addUser("first");
        AccountManager.addUser("second");
        AccountManager.addUser("third");
        SplitwiseService service = new SplitwiseService();

        // EqualSplit expense
        ExpenseDetails firstExpense = new ExpenseDetails(first, "first pays to second and third", 300);
        Split firstPaysSecond = new EqualSplit(second);
        Split firstPaysthird = new EqualSplit(third);
        List<Split> firstSplits = new ArrayList<>();
        firstSplits.add(firstPaysSecond);
        firstSplits.add(firstPaysthird);
        service.addExpense(ExpenseType.EQUAL, firstExpense, firstSplits);
        AccountManager.printBalanceSummary();

        // EqualSplit Expense
        ExpenseDetails secondExpense = new ExpenseDetails(second, "second pays to first and third", 450);
        Split secondPaysFirst = new EqualSplit(first);
        Split secondPaysThird = new EqualSplit(third);
        List<Split> secondSplit = new ArrayList<>();
        secondSplit.add(secondPaysFirst);
        secondSplit.add(secondPaysThird);
        service.addExpense(ExpenseType.EQUAL, secondExpense, secondSplit);
        AccountManager.printBalanceSummary();

        // Percentage Expense
        ExpenseDetails thirdPaysDetails = new ExpenseDetails(third, "third pays to first and second", 100);
        Split thirdPaysFirst = new PercentageSplit(first, 60);
        Split thirdPaysSecond = new PercentageSplit(second, 40);
        List<Split> thirdSplit = new ArrayList<>();
        thirdSplit.add(thirdPaysFirst);
        thirdSplit.add(thirdPaysSecond);
        service.addExpense(ExpenseType.PERCENTAGE, thirdPaysDetails, thirdSplit);
        AccountManager.printBalanceSummary();

        // Fixed Expense
        ExpenseDetails thirdSettlesFirstAndSecond = new ExpenseDetails(third, "third settles first and second", 100);
        Split thirdPaysFixedFirst = new FixedAmountSplit(first, 40);
        Split thirdPaysFixedSecond = new FixedAmountSplit(second, 110);
        List<Split> thirdFixedSplit = new ArrayList<>();
        thirdFixedSplit.add(thirdPaysFixedFirst);
        thirdFixedSplit.add(thirdPaysFixedSecond);
        service.addExpense(ExpenseType.FIXED, thirdSettlesFirstAndSecond, thirdFixedSplit);
        AccountManager.printBalanceSummary();
    }
}
