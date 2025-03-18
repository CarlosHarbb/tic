import java.util.*;
class Computer extends User {
    public Computer(String name, char symbol) {  //contructor for class
        super(name, symbol);
    }


    public String getMove(Grid board) {   //method get move overrided from parent
        Random rand = new Random();
        char[] rows = {'A', 'B', 'C'};
        List<String> availableMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                availableMoves.add("" + rows[i] + (j + 1));
            }
        }
        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }
}





