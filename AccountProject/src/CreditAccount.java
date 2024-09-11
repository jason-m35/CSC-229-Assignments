public class CreditAccount extends Account {
    private double creditLimit;

    // Default constructor with a preset credit limit
    public CreditAccount() {
        super();  // Calls the constructor of Account (sets balance to 0)
        this.creditLimit = 500;  // Default credit limit of 500
    }

    // Constructor that allows setting the credit limit
    public CreditAccount(double creditLimit) {
        super();  // Calls the Account constructor
        this.creditLimit = creditLimit;  // Sets the credit limit
    }

    // Getter for credit limit
    public double getCreditLimit() {
        return creditLimit;  // Returns the current credit limit
    }

    // Setter for credit limit
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;  // Sets the new credit limit
    }

    // Method to deposit money
    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;  // Amount must be positive
        }
        setBalance(getBalance() + amount);  // Add deposit to balance
        return true;  // Deposit successful
    }

    // Method to withdraw money
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount.");
            return false;  // Amount must be positive
        }
        if (getBalance() - amount < -creditLimit) {
            System.out.println("Withdrawal exceeds credit limit.");
            return false;  // Can't withdraw more than the credit limit allows
        }
        setBalance(getBalance() - amount);  // Subtract withdrawal from balance
        return true;  // Withdrawal successful
    }

    // toString method to show the balance and credit limit
    @Override
    public String toString() {
        return "Current balance: " + getBalance() + ", Credit limit: " + creditLimit;
    }
}
