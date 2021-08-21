import java.util.*;

public class Solver {

    private int[][] board = new int[9][9];
    private int[][] clue = new int[9][9];

    public Solver(int[][] clue) {
        this.clue = clue;
    }

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (j == 3 || j == 6) {
                    System.out.print("| "+ this.board[i][j] + " ");
                }
                else{
                    System.out.print(""+ this.board[i][j] + " ");
                }
            }
            if (i == 2 || i == 5) {
                System.out.println();
                System.out.print("---------------------");
            }
            System.out.println();
        }
    }

    public void fillBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                    this.board[i][j] = this.clue[i][j];
            }
        }
    }

    public boolean checkPuzzle() {
        for (int i = 0; i < this.board.length; i++) {
            if (!checkRow(i)) {
                return false;
            }
        }
        for (int i = 0; i < this.board[0].length; i++) {
            if (!checkCol(i)) {
                return false;
            }
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (!checkSquare(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(int row) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < this.board[row].length; i++) {
            if (this.board[row][i] == 0) {
                continue;
            }

            Integer c = hmap.get(this.board[row][i]);

            if (c == null) {
                hmap.put(this.board[row][i], 1);
            }
            else {
                return false;
            }
        }

        return true;
    }

    public boolean checkCol(int col) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i][col] == 0) {
                continue;
            }

            Integer c = hmap.get(this.board[i][col]);

            if (c == null) {
                hmap.put(this.board[i][col], 1);
            }
            else {
                return false;
            }
        }

        return true;
    }

    public boolean checkSquare(int row, int col) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        int squareRow = row / 3 * 3;
        int squareCol = col / 3 * 3;

        for (int i = squareRow; i < squareRow+3; i++) {
            for (int j = squareCol; j < squareCol+3; j++) {
                if (this.board[i][j] == 0) {
                    continue;
                }
    
                Integer c = hmap.get(this.board[i][j]);
    
                if (c == null) {
                    hmap.put(this.board[i][j], 1);
                }
                else {
                    return false;
                }
            }
        }


        return true;
    }

}
