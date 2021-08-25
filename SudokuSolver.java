public class SudokuSolver {
    
    public static void main(String args[]) {

        Solver sol = new Solver();
        sol.parse(args[0]);
        sol.printBoard();
        sol.solve(sol.getBoard());
        sol.printBoard();
    }

}

