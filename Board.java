class Grid {
    private Square[][] grid;

    public Grid() { //creates a grid of dimensions 3x3
        grid = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Square();
            }
        }
    }

    public void display() { //displays the grid (cols and rows)
        System.out.println("  1 2 3");
        char[] rows = {'A', 'B', 'C'};
        for (int i = 0; i < 3; i++) {
            System.out.print(rows[i] + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public boolean placeSymbol(String move, char symbol) { //allows user to place a symbol
        int[] coords = getCoordinates(move);
        if (coords == null || !grid[coords[0]][coords[1]].isEmpty()) {
            return false;
        }
        grid[coords[0]][coords[1]].setSymbol(symbol);
        return true;
    }

    public boolean checkWin(char symbol) { //checks every case if a user wins
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0].getSymbol() == symbol && grid[i][1].getSymbol() == symbol && grid[i][2].getSymbol() == symbol) ||
                    (grid[0][i].getSymbol() == symbol && grid[1][i].getSymbol() == symbol && grid[2][i].getSymbol() == symbol)) {
                return true;
            }
        }
        return (grid[0][0].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][2].getSymbol() == symbol) ||
                (grid[0][2].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][0].getSymbol() == symbol);
    }

    /*public boolean checkWin(char symbol) { //different implementation for the same method
            return (grid[0][0].getSymbol() == symbol && grid[0][1].getSymbol() == symbol && grid[0][2].getSymbol() == symbol) || // checks row 1
                    (grid[1][0].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[1][2].getSymbol() == symbol) || // checks row 2
                    (grid[2][0].getSymbol() == symbol && grid[2][1].getSymbol() == symbol && grid[2][2].getSymbol() == symbol) || // checks row 3
                    (grid[0][0].getSymbol() == symbol && grid[1][0].getSymbol() == symbol && grid[2][0].getSymbol() == symbol) || // checks Column 1
                    (grid[0][1].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][1].getSymbol() == symbol) || // checks Column 2
                    (grid[0][2].getSymbol() == symbol && grid[1][2].getSymbol() == symbol && grid[2][2].getSymbol() == symbol) || // checks Column 3
                    (grid[0][0].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][2].getSymbol() == symbol) || // checks Diagonal \
                    (grid[0][2].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][0].getSymbol() == symbol);   // checks Diagonal /
        }
*/

    public boolean isFull() {// checks every row in the grid and every cell in a row if it is full if 1 of them is empty return false
        for (Square[] row : grid) {
            for (Square cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] getCoordinates(String move) {
        if (move.length() != 2) {
            throw new IllegalArgumentException("Invalid coordinate. Use format A1, B2, etc.");
        }

        int row = move.charAt(1) - '1'; // Convert '1'-'3' to 0-2
        int col = Character.toUpperCase(move.charAt(0)) - 'A'; // Convert 'A'-'C' to 0-2

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Invalid coordinate. Use format A1, B2, etc."); // Ensure within bounds
        }

        return new int[]{row, col}; // Return row and column correctly
    }
}
