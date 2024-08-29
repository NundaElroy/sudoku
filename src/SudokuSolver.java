/**
 * This class provides a solution to a Sudoku puzzle using a backtracking algorithm.
 * The Sudoku grid is assumed to be a 9x9 grid where empty cells are represented by 0.
 */
public class SudokuSolver {

    /**
     * The size of the Sudoku grid (9x9).
     */
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        //uncomment for trial run
    }
//         Integer board [][] = {
//                {5, 3, 0, 0, 7, 0, 0, 0, 0},
//                {6, 0, 0, 1, 9, 5, 0, 0, 0},
//                {0, 9, 8, 0, 0, 0, 0, 6, 0},
//                {8, 0, 0, 0, 6, 0, 0, 0, 3},
//                {4, 0, 0, 8, 0, 3, 0, 0, 1},
//                {7, 0, 0, 0, 2, 0, 0, 0, 6},
//                {0, 6, 0, 0, 0, 0, 2, 8, 0},
//                {0, 0, 0, 4, 1, 9, 0, 0, 5},
//                {0, 0, 0, 0, 8, 0, 0, 7, 9}
//        };
//
//        Gameboard.printBoard(board);
//        System.out.println("Solving Sudoku puzzle...");
//        if (solveSoduku(board)) {
//            System.out.println("Sudoku puzzle solved successfully:");
//            Gameboard.printBoard(board);
//        } else {
//            System.out.println("No solution found for the given Sudoku puzzle.");
//        }
//
//    }

    /**
     * Solves the given Sudoku puzzle using a backtracking algorithm.
     *
     * @param board a 2D array representing the Sudoku grid. Empty cells should be filled with 0.
     * @return true if the Sudoku puzzle is solved successfully, false otherwise.
     */
    public static boolean solveSoduku(Integer [][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    // Try all possible values for this cell
                    for (int value = 1; value <= GRID_SIZE; value++) {
                        if (checkValidity(value, column, row, board)) {
                            board[row][column] = value;

                            // Recursively attempt to solve the rest of the board
                            if (solveSoduku(board)) {
                                return true;
                            } else {
                                // Undo the current cell (backtracking)
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false; // No valid value found, trigger backtracking
                }
            }
        }
        return true; // Puzzle solved
    }

    /**
     * Checks if a given value exists in the specified row of the Sudoku grid.
     *
     * @param value the value to check for.
     * @param row the row index to check.
     * @param board the Sudoku grid.
     * @return true if the value exists in the row, false otherwise.
     */
    private static boolean checkIfValueExitsInRow(int value, int row, Integer [][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given value exists in the specified column of the Sudoku grid.
     *
     * @param value the value to check for.
     * @param column the column index to check.
     * @param board the Sudoku grid.
     * @return true if the value exists in the column, false otherwise.
     */
    private static boolean checkIfValueExitsInColumn(int value, int column, Integer[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given value exists in the 3x3 sub-grid containing the specified cell.
     *
     * @param value the value to check for.
     * @param column the column index of the cell.
     * @param row the row index of the cell.
     * @param board the Sudoku grid.
     * @return true if the value exists in the 3x3 sub-grid, false otherwise.
     */
    private static boolean checkIfValueExitsInGrid(int value, int column, int row, Integer[][] board) {
        int gridRowStart = row - row % 3;
        int gridColumnStart = column - column % 3;

        for (int i = gridRowStart; i < gridRowStart + 3; i++) {
            for (int j = gridColumnStart; j < gridColumnStart + 3; j++) {
                if (board[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if placing a value in the specified cell is valid according to Sudoku rules.
     *
     * @param value the value to check.
     * @param column the column index of the cell.
     * @param row the row index of the cell.
     * @param board the Sudoku grid.
     * @return  if the value is valid for the specified cell it returns false
     */
    private static boolean checkValidity(int value, int column, int row, Integer[][] board) {
        return !checkIfValueExitsInRow(value, row, board) &&
                !checkIfValueExitsInColumn(value, column, board) &&
                !checkIfValueExitsInGrid(value, column, row, board);
    }
}
