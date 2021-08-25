import java.util.*;

public class Solver {

    private int[][] board = new int[9][9];

    public Solver() {
    }

    public void printBoard() {
        String output = "\n";
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (j == 3 || j == 6) {
                    if (this.board[i][j] == 0) {
                        output += "|   ";
                    } else {
                        output += "| "+ this.board[i][j] + " ";
                    }
                }
                else{
                    if (this.board[i][j] == 0) {
                        output += "  ";
                    } else {
                        output += this.board[i][j] + " ";
                    }
                }
            }
            if (i == 2 || i == 5) {
                output += "\n---------------------";
            }
            output += "\n";
        }

        System.out.print(output + "\n");
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
                if (!checkBox(i, j) || this.board[i][j] == 0) {
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

    public boolean checkBox(int row, int col) {
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

    public boolean checkCell(int row, int col) {
        return this.checkRow(row) && this.checkCol(col) && this.checkBox(row, col);
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void parse(String s) {
        if (s.length() != 81) {
            System.out.println("Invalid grid");
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = Integer.parseInt(s.substring(0,1));
                s = s.substring(1, s.length());
            }
        }
    }
    
    public int[][] solve(int[][] board) {

        for (int row = 0; row < board.length; row++) { // Loop through rows
            for (int col = 0; col < board[row].length; col++) { // Loop through cols
                if (board[row][col] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        board[row][col] = i;
                        if (this.checkCell(row, col)) {
                            board = this.solve(board);
                            if (this.checkPuzzle()) {
                                return board;
                            }
                        }
                        if (i == 9) {
                            board[row][col] = 0;
                            return board;
                        }
                    }
                }
            }
        }

        return board;

    }

}
