package org.aswinayyappadas;

public class CheckingAccountCustomer extends Customer{
    private final String accountNumber;
    public CheckingAccountCustomer() {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.customerId = this.getCustomerId();
        CustomerDetailsInserter.insertNewCustomer(this.getCustomerId(), this.getName(), this.getPhone(), this.getAddress(), this.getEmail(), this.getPassword());
        String accountType = "Checking";
        AccountDetailsInserter.insertNewAccount(this.getAccountNumber(), this.getCustomerId(), 0.0, accountType);
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        // Use BalanceRetriever to retrieve the balance from the database
        return BalanceRetriever.retrieveBalance(accountNumber);
    }

    public void deposit(double amount) {
        // Update the balance and record the transaction
        double currentBalance = getBalance();
        currentBalance += amount;
        TransactionRecorder.recordTransaction(this.getAccountNumber(), amount, "Deposit", currentBalance);
    }

    public void withdraw(double amount) {
        // Update the balance and record the transaction
        double currentBalance = getBalance();
        if (amount <= currentBalance) {
            currentBalance -= amount;
            TransactionRecorder.recordTransaction(this.getAccountNumber(), amount, "Withdraw", currentBalance);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
