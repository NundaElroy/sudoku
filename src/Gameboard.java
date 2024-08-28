/**
 * Represents a Sudoku game board with methods to print and manage the board.
 *
 * @Author: Group I
 */
public class Gameboard {
    private String [][] board = new String[9][9];
    private Integer [][] boardLayout = new Integer[9][9];
    private static final String ANSI_GREEN = "\u001B[32m"; // Green color for console output
    private static final String ANSI_RESET = "\u001B[0m";  // Reset color

    public static void main(String[] args) {
        Gameboard gb = new Gameboard();
        //this is the layout of the board pick the postion to fill out the board
        gb.fillBoardLayout();
        printBoard(gb.boardLayout);
        //this is the board that will be filled out
        System.out.println("");
        System.out.println("");
        System.out.println("");
        printBoard(gb.board);
    }

    /**
     * Prints the game board to the console.
     * <p>
     * The board is a 2D array that can contain any type of elements. Each element is printed
     * within a cell of a fixed width. A border is printed around the entire board for clarity.
     * </p>
     *
     * @param board The 2D array representing the board to be printed. It can contain elements of any type.
     * @param <T>   The type of elements in the board. This method is generic and can handle any type.
     */
    public static <T> void printBoard(T[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int cellWidth = 4; // Adjust cell width as needed

        int counterForOuterLoop = 0;

        // Print top border
        printBorder(counterForOuterLoop,cols, cellWidth);
        int counter = 0;

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                counter++;
                if (board[i][j] == null) {
                    System.out.print(String.format("%" + cellWidth + "s", " "));
                } else {
                    System.out.print(String.format("%" + cellWidth + "s", board[i][j]));
                }
                if (counter % 3 == 0) {
                    System.out.print(ANSI_GREEN + "|" + ANSI_RESET);
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
            counterForOuterLoop++;
            // Print row separator
            printBorder(counterForOuterLoop,cols, cellWidth);
        }
    }

    /**
     * Prints the border of the game board with optional color based on the row.
     *
     * @param counter   Determines when to apply color to the border.
     * @param cols      Number of columns in the board.
     * @param cellWidth Width of each cell in the border.
     */
    private static void printBorder(int counter, int cols, int cellWidth) {
        String borderChar = (counter % 3 == 0) ? ANSI_GREEN + "+" + ANSI_RESET : "+";
        String dashChar = (counter % 3 == 0) ? ANSI_GREEN + "-" + ANSI_RESET : "-";

        for (int i = 0; i < cols; i++) {
            System.out.print(borderChar);
            for (int j = 0; j < cellWidth; j++) {
                System.out.print(dashChar);
            }
        }
        System.out.println(borderChar);
    }



    /**
     * This method will fill out the board layout
     * This helps the player to keep track of the cells that is being filled out
     */
    public void fillBoardLayout(){
        int counter = 1;
        for (int i = 0; i < boardLayout.length; i++) {
            for (int j = 0; j < boardLayout[i].length; j++) {
                boardLayout[i][j] = counter;
                counter++;
            }
        }

    }

    public String[][] getBoard() {
        return board;
    }

    public Integer[][] getBoardLayout() {
        return boardLayout;
    }
}
