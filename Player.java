
abstract class User {
    protected String name;
    protected char symbol;

    public User(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract String getMove(Board board);
}