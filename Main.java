import java.util.Scanner;

public class Main {
    // Main method to start the game
    public static void main(String[] args) {
        // Create a Minesweeper game with specific dimensions and number of mines
        Minesweeper game = new Minesweeper(10, 10, 10);
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!game.getGameOver()) {
            game.displayBoard();
            // Get player input for row, col, and action (reveal or flag)
            // For now, just simulate a move (to be replaced with real player input logic)
            System.out.print("Enter your move (row col action [reveal/flag]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            String action = scanner.next();

            game.playerMove(0, 0, "reveal");

            // Check for win or loss conditions
            if (game.checkWin()) {
                System.out.println("Congratulations! You've won the game.");
                break;
            }
            if (game.checkLoss(0, 0)) {
                System.out.println("Game Over! You hit a mine.");
                game.setGameOver(true);
            }
        }
        scanner.close();
    }
}