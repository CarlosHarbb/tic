import java.util.*;
class Human extends User {
   final private Scanner scanner = new Scanner(System.in);

    public Human(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public String getMove(Board board) {
        System.out.print("Enter your move (e.g., A1, B2): ");
        return scanner.nextLine().trim().toUpperCase();
    }
}
