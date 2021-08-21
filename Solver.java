public class Solver {

    private int[][] board = new int[3][3];

    public Solver() {
        
    }

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                    System.out.print(""+ this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                    this.board[i][j] = 0;
            }
        }
    }
}
