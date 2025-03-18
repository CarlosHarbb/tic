Tic Tac Toe Java Program
This is a simple console-based Tic Tac Toe game implemented in Java. It allows two players to play against each other or a single player to play against the computer.
How to run:
1. Compile the program using `javac Main.java`
2. Run the program using `java Main`

## Game Rules
- The game is played on a 3x3 grid. (given in exam)
- Player 1 always plays as 'X'. (to not make the user choose)
- Player 2 (or the computer) plays as 'O'. (to not make the user choose)
- Players take turns placing their symbol in an unoccupied square. (exam)
- The objective is to form a horizontal, vertical, or diagonal line of three identical symbols. (how to win)
- The game ends when a player wins or all squares are filled. (resulting in a draw)

## Instructions for Use
1. When prompted, choose whether to play against the computer by entering 'Y' or 'yes' for single-player mode, or 'N' or 'no' for two-player mode.
2. Enter Player 1's name.
3. If playing against another human, enter Player 2's name. (Names cant be the same)
4. The game will display the board and prompt the current player for their move.
5. Enter your move using grid coordinates (e.g., 'A1', 'B3').
6. The game will validate the move and update the board.
7. The game continues until a player wins or the board is full.
8. After the game ends, you will be asked if you want to play again. Enter 'Y' to restart or any key to exit.

## Error Handling
- If an invalid move is entered (e.g., out-of-range coordinates or an already occupied square), the game will prompt you to try again.
- If both players enter the same name, the game will restart.
- If an invalid response is given when asked to play against the computer, the program will prompt again until a valid answer is provided.

