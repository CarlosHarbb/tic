class Board {
   final private Square[][] grid;

    public Board() {
        grid = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Square();
            }
        }
    }

    public void display() {
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

    public boolean placeSymbol(String move, char symbol) {
        int[] coords = getCoordinates(move);
        if (!grid[coords[0]][coords[1]].isEmpty()) {
            return false;
        }
        grid[coords[0]][coords[1]].setSymbol(symbol);
        return true;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0].getSymbol() == symbol && grid[i][1].getSymbol() == symbol && grid[i][2].getSymbol() == symbol) ||
                    (grid[0][i].getSymbol() == symbol && grid[1][i].getSymbol() == symbol && grid[2][i].getSymbol() == symbol)) {
                return true;
            }
        }
        return (grid[0][0].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][2].getSymbol() == symbol) ||
                (grid[0][2].getSymbol() == symbol && grid[1][1].getSymbol() == symbol && grid[2][0].getSymbol() == symbol);
    }

    public boolean isFull() {
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
        int row = move.charAt(0) - 'A';
        int col = move.charAt(1) - '1';
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Invalid coordinate. Use format A1, B2, etc.");
        }
        return new int[]{row, col};
    }
}//sfeg