class Square {
    private char symbol;

    public Square() {
        this.symbol = Symbol.EMPTY;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == Symbol.EMPTY;
    }
}//grsgsg