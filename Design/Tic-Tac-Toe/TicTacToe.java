import java.util.Scanner;

public class TicTacToe{
    final int[][] board;
    final int[] rowSum;
    final int[] colSum;
    int diagSum;
    int revDiagSum;
    int n;
    public TicTacToe(int n)
    {
        this.n=n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        diagSum = 0;
        revDiagSum = 0;
    }

    //order 1
    public int moveOrder_1(int player, int row, int col) throws IllegalArgumentException
    {
        if(row<0 || col<0 || row>=n || col>=n)
        {
            throw new IllegalArgumentException("Not a valid cell");
        }
        else if(player != 0 && player !=1)
        {
            throw new IllegalArgumentException("Not a valid player");
        }
        else if(board[row][col]!=0)
        {
            throw new IllegalArgumentException("Not a valid value");
        }
        else{
            player = player == 0 ? -1 : 1;
            rowSum[row] += player;
            colSum[col] += player;
            if(row == col){
                diagSum += player;
            }
            if(row + col == n-1){
                revDiagSum += player;
            }
            if(Math.abs(rowSum[row]) == Math.abs(n) || Math.abs(colSum[col]) == Math.abs(n)
            || Math.abs(diagSum) == Math.abs(n) || Math.abs(revDiagSum) == Math.abs(n))
            {
                return player;
            }
        }
        return 0;
    }

    //this one is in O(n). 
    public int moveOrder_N(int player, int row, int col) throws IllegalArgumentException
    {
        if(row<0 || col<0 || row>=n || col>=n)
        {
            throw new IllegalArgumentException("Not a valid cell");
        }
        else if(player != 0 && player !=1)
        {
            throw new IllegalArgumentException("Not a valid player");
        }
        else if(board[row][col]!=0)
        {
            throw new IllegalArgumentException("Not a valid value");
        }
        else{
            player = player == 0 ? -1 : 1;
            board[row][col] = player;
            boolean rowWin = true, colWin = true, diagWin = true, revDiagWin = true;
            for(int i=0;i<n;i++)
            {
                if(board[i][col] != player){
                    rowWin = false;
                }
                if(board[row][i] != player){
                    colWin = false;
                }
                if(board[i][i]!=player){
                    diagWin = false;
                }
                if(board[i][n-i-1]!=player){
                    revDiagWin = false;
                }
            }
            if(rowWin || colWin || diagWin || revDiagWin){
                if(player == -1) System.out.println("player 0 wins");
                else System.out.println("player 1 wins");
                return player;
            }
            return 0;
        }
    }
    public static void main(String agrs[])
    {
        int n = 3;
        TicTacToe game = new TicTacToe(n);
        int player = 0;
        int row, col;
        Scanner sc = new Scanner(System.in);
        int  c = 0;
        while(true)
        {
            System.out.println("Enter row, col for player " + player);

            row = sc.nextInt();
            col = sc.nextInt();
            
            int res = game.moveOrder_1(player, row, col );
            if(res == 1)
            {
                System.out.println("player 1 wins");
                break;
            }
            if(res == -1)
            {
                System.out.println("player 0 wins");
                break;
            }
            if(res == 0)
            {
                c++;
            }
            if( c== n*n){
                System.out.println("Game draw");
                break;
            }
            player = player == 0? 1: 0;
        }
    }
}