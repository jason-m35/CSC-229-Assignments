import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Boolean expression (e.g., A + B * C): ");
        String expression = scanner.nextLine();
        
        System.out.println("\nTruth Table for: " + expression);
        TruthTableGenerator.generateTruthTable(expression);
    }
}
