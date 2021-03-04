package ood.design.splitwise;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static final Map<String, Map<String, Double>> balanceSheet;

    static {
        balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    private AccountManager() {
    }

    public static void updateBalanceSheet(String lender, String borrower, double amt) {
        Map<String, Double> lenderSheet = balanceSheet.get(lender);

        if (lenderSheet.containsKey(borrower)) {
            double debt = lenderSheet.getOrDefault(borrower, 0.0);
            lenderSheet.put(borrower, amt + debt);
        } else {
            lenderSheet.put(borrower, amt);
        }

        Map<String, Double> borrowerSheet = balanceSheet.get(borrower);
        if (borrowerSheet.containsKey(lender)) {
            double credit = borrowerSheet.getOrDefault(lender, 0.0);
            borrowerSheet.put(lender, credit - amt);
        } else {
            borrowerSheet.put(borrower, -amt);
        }
    }

    public static void printBalanceSummary() {
        System.out.println(balanceSheet);
    }

    public static void addUser(final String userId) {
        if (!balanceSheet.containsKey(userId)) {
            balanceSheet.put(userId, new HashMap<String, Double>());
        }
    }

    public static boolean containsUser(final String userId) {
         return balanceSheet.containsKey(userId);
    }
}
