class Square {
    private char symbol; //symbol present in the square

    public Square() { //contructor for class
        this.symbol = '-'; //set the symbol in the square to null
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == '-'; //
    }
}
