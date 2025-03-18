import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid board;
        User player1, player2, currentPlayer;

        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            board = new Grid();
            boolean vsComputer;

            while (true) {
                System.out.print("Play against the computer? (Y/N): ");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("y") || input.equals("yes")) {
                    vsComputer = true;
                    break;
                } else if (input.equals("n") || input.equals("no")) {
                    vsComputer = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'Yes' for computer, 'N' or 'No' for two players.");
                }
            }

            System.out.print("Player 1, enter your name: ");
            String name1 = scanner.nextLine().trim();

            String name2;
            if (vsComputer) {
                name2 = "Computer";
            } else {
                System.out.print("Player 2, enter your name: ");
                name2 = scanner.nextLine().trim();
                if (name1.equalsIgnoreCase(name2)) {
                    System.out.println("Error: Players cannot have the same name.");
                    continue;
                }
            }

            player1 = new Human(name1, 'X');
            player2 = vsComputer ? new Computer(name2, 'O') : new Human(name2, 'O');
            currentPlayer = player1;

            while (true) {
                board.display();
                System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
                String move = currentPlayer.getMove(board);

                try {
                    if (!board.placeSymbol(move, currentPlayer.getSymbol())) {
                        System.out.println("Invalid move. Try again.");
                        continue;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.display();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            System.out.print("Press Y to play again press any key to stop): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                break;
            }
        }
        scanner.close();
    }
}
