public class LoanAccount extends Account {
    private double loanBalance;
    private double interestRate;

   
    public LoanAccount(double loanBalance, double interestRate) {
        super();  
        this.loanBalance = loanBalance;  
        this.interestRate = interestRate;  
    }

    
    public void applyInterest() {
        double interest = loanBalance * (interestRate / 100);  
        loanBalance += interest;  
    }

    
    public boolean makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return false; 
        }
        if (loanBalance <= 0) {
            System.out.println("Loan is already paid off.");
            return false;  
        }
        loanBalance -= amount;  
        return true;  
    }

    
    @Override
    public boolean deposit(double amount) {
        System.out.println("Cannot deposit into a loan account.");
        return false;
    }

    
    @Override
    public boolean withdraw(double amount) {
        System.out.println("Cannot withdraw from a loan account.");
        return false; 
    }


    @Override
    public String toString() {
        return "Loan balance: " + loanBalance + ", Interest rate: " + interestRate;
    }
}
