import java.util.*;


abstract class User {
    protected String name; //name of user
    protected char symbol; // each user has a symbol in this program its X for player 1 and O for computer/player 2

    public User(String name, char symbol) {  //contructor for class
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract String getMove(Grid board);
}
