public class LoanAccount extends Account {
    private double loanBalance;
    private double interestRate;

    // Constructor
    public LoanAccount(double loanBalance, double interestRate) {
        super();  // Calls the Account constructor
        this.loanBalance = loanBalance;  // Initialize the loan balance
        this.interestRate = interestRate;  // Initialize the interest rate
    }

    // Method to apply interest to the loan
    public void applyInterest() {
        double interest = loanBalance * (interestRate / 100);  // Calculate interest
        loanBalance += interest;  // Add interest to loan balance
    }

    // Method to make a payment on the loan
    public boolean makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return false;  // Payment must be greater than 0
        }
        if (loanBalance <= 0) {
            System.out.println("Loan is already paid off.");
            return false;  // Can't make payments if the loan is paid off
        }
        loanBalance -= amount;  // Subtract payment from loan balance
        return true;  // Payment successful
    }

    // Override the deposit method (not applicable for loan accounts)
    @Override
    public boolean deposit(double amount) {
        System.out.println("Cannot deposit into a loan account.");
        return false;  // Deposits are not allowed in loan accounts
    }

    // Override the withdraw method (not applicable for loan accounts)
    @Override
    public boolean withdraw(double amount) {
        System.out.println("Cannot withdraw from a loan account.");
        return false;  // Withdrawals are not allowed in loan accounts
    }

    // toString method to display loan details
    @Override
    public String toString() {
        return "Loan balance: " + loanBalance + ", Interest rate: " + interestRate;
    }
}
