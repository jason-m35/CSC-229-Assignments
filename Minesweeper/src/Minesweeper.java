import java.util.Random;

public class Minesweeper {

    // Data members
    private char[][] board;   // The game board where cells will be displayed
    private boolean[][] mines; // Array to track the locations of mines
    private boolean[][] revealed; // Array to track which cells have been revealed
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board
    private int numMines; // Number of mines in the game
    private boolean gameOver; // Boolean to check if the game is over

    // Constructor to initialize the board with the specified dimensions and number of mines
    public Minesweeper(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.board = new char[rows][cols];
        this.mines = new boolean[rows][cols];
        this.revealed = new boolean[rows][cols];
        this.gameOver = false;

        // Call methods to initialize the board and place mines
        initializeBoard();
        placeMines();
        calculateNumbers();
    }
    public boolean getGameOver(){
        return this.gameOver;
    }
    public void setGameOver(boolean status)
    {
        this.gameOver = status;

    }
    // Method to initialize the game board with empty values
    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
                revealed[i][j] = false;
            }
        }
    }

    // Method to randomly place mines on the board
    private void placeMines() {
    Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int randRow = rand.nextInt(rows);
            int randCol = rand.nextInt(cols);
            if (!mines[randRow][randCol]) {
                mines[randRow][randCol] = true;
                minesPlaced++;
            }
        }
    }

    // Method to calculate numbers on the board for non-mine cells
    private void calculateNumbers() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!mines[i][j]) {
                    int mineCount = countAdjacentMines(i, j);
                    board[i][j] = (char) (mineCount + '0');
                }
            }
        }


    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mines[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Method to display the current state of the board
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    // Method to handle a player's move (reveal a cell or place a flag)
    public void playerMove(int row, int col, String action) {
        if (action.equals("reveal")) {
            revealCell(row, col);
        } else if (action.equals("flag")) {
            flagCell(row, col);
        }
    }

    // Method to check if the player has won the game
    public boolean checkWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!mines[i][j] && !revealed[i][j]) {
                    return false; // There are still non-mine cells to reveal
                }
            }
        }
        return true;
    }

    // Method to check if the player has lost the game
    public boolean checkLoss(int row, int col) {
        return mines[row][col];

    }

    // Method to reveal a cell (and adjacent cells if necessary)
    private void revealCell(int row, int col) {
        if (revealed[row][col]) {
            return;
        }
        revealed[row][col] = true;

        if (mines[row][col]) {
            setGameOver(true);
        } else if (board[row][col] == '0') {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        revealCell(newRow, newCol);
                    }
                }
            }
        }
    }

    // Method to flag a cell as containing a mine
    private void flagCell(int row, int col) {
        if (!revealed[row][col]) {
            board[row][col] = 'F';
        }
    }

    // Method to unflag a cell
    private void unflagCell(int row, int col) {
        if (!revealed[row][col] && board[row][col] == 'F') {
            board[row][col] = '-';
        }
    }
}
