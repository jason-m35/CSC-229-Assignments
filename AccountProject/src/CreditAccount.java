public class CreditAccount extends Account {
    private double creditLimit;

    
    public CreditAccount() {
        super();
        this.creditLimit = 500;
    }

   
    public CreditAccount(double creditLimit) {
        super(); 
        this.creditLimit = creditLimit;  
    }

    
    public double getCreditLimit() {
        return creditLimit;  
    }

    
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit; 
    }


    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;  
        }
        setBalance(getBalance() + amount);  
        return true;
    }

    
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount.");
            return false; 
        }
        if (getBalance() - amount < -creditLimit) {
            System.out.println("Withdrawal exceeds credit limit.");
            return false;
        }
        setBalance(getBalance() - amount);  
        return true;
    }

    
    @Override
    public String toString() {
        return "Current balance: " + getBalance() + ", Credit limit: " + creditLimit;
    }
}
