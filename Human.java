import java.util.*;
class Human extends User {
    private Scanner scanner = new Scanner(System.in); // scanner to get the input from user

    public Human(String name, char symbol) {         //contructor for class
        super(name, symbol);
    }

    public String getMove(Grid board) {          //method get move overrided from parent
        System.out.print("Enter your move (e.g., A1, B2): ");
        return scanner.nextLine().trim().toUpperCase();
    }
}
