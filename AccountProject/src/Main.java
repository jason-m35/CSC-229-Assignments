public class Main {
    public static void main(String[] args) {
        DepitAccount dpt1 = new DepitAccount();
        DepitAccount dpt2 = new DepitAccount(25);

        dpt1.deposit(100);
        dpt1.withdraw(25);
        System.out.println(dpt1.toString());

        dpt2.deposit(100);
        dpt2.withdraw(25);
        System.out.println(dpt2.toString());


        // CreditAccount testing
        CreditAccount credit = new CreditAccount(500);
        credit.deposit(200);
        credit.withdraw(180);
        System.out.println("CreditAccount Balance: " + credit.getBalance());
        System.out.println("CreditAccount Limit: " + credit.getCreditLimit());

        //LoanAccount Testing
        LoanAccount loan = new LoanAccount(1000, 5);
        loan.applyInterest();
        loan.makePayment(200);
        System.out.println("Loan balance after payment: " + loan.toString());
    }
    }