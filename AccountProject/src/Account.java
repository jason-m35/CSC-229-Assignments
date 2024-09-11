public abstract class Account {
    private double balance;
    public Account() {
        this.balance = 0;
    }
    public Account(double _balance){
        this.balance = _balance;
    }
    public Account(Account act){
        this.balance = act.balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double _balance){
        this.balance = _balance;
    }
    public abstract boolean deposit(double _amount);
    public abstract boolean withdraw(double _amount);
}
