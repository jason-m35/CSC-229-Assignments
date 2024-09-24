
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        Node current = head;
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current != null) {
            current.data = data;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node current = head;
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current != null) {
            return current.data;
        }
        return "";
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.print(current.data.equals("") ? count : current.data);
            if (count % 3 == 0) {
                System.out.println();  // New row
            } else {
                System.out.print(" | ");
            }
            current = current.next;
            count++;
        }
        System.out.println();
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        String[] values = new String[9];
        Node current = head;
        int index = 0;
    
        while (current != null) {
            values[index++] = current.data;
            current = current.next;
        }
    
        // Check rows, columns, and diagonals for a win
        if (checkLine(values[0], values[1], values[2]) ||  
            checkLine(values[3], values[4], values[5]) ||  
            checkLine(values[6], values[7], values[8]) ||  
            checkLine(values[0], values[3], values[6]) ||  
            checkLine(values[1], values[4], values[7]) ||  
            checkLine(values[2], values[5], values[8]) ||  
            checkLine(values[0], values[4], values[8]) ||  
            checkLine(values[2], values[4], values[6])) { 
            return true;
        }
    
        return false;
    }

        private boolean checkLine(String s1, String s2, String s3) {
            return (!s1.equals("") && s1.equals(s2) && s2.equals(s3));
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        Node current = head;
        while (current != null) {
            if (current.data.equals("")) {
                return false;
            }
            current = current.next;
        }
    

        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        Node current = head;
        while (current != null) {
            current.data = "";
            current = current.next;
        }
    }
}
