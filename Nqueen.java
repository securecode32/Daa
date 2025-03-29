import java.util.Scanner;
public class Nqueens{
    private static int solutionCount = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Queens: ");
        int n = sc.nextInt();
        int board[][] = new int[n][n];
        if(n==1){
            System.out.println("Q1");
        }else if(n==2 || n==3){
            System.out.println("No Solution exists");
        }else{
            solveNQueens(board,n,0);
        }
    }
    public static void solveNQueens(int[][] board,int n,int row){
        if(row >= n){
            printSolution(board,n);
            return;
        }
        for(int col = 0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                solveNQueens(board, n, row+1);
                board[row][col] = 0;
            }
        }
    }
    public static boolean isSafe(int board[][],int row,int col,int n){
        for(int i = 0;i <= row;i++){
            if(board[i][col]==1){
                return false;
            }
        }
        // for(int i = 0;i <= col;i++){
        //     if(board[row][i]==1){
        //         return false;
        //     }
        // }
        for(int i = row,j = col;i >= 0 && j >= 0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i = row,j = col;i >= 0 && j < n;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static void printSolution(int board[][],int n) {
        int c = 1;
        System.out.println("Solution: "+ (solutionCount++));
        System.out.println("===========");
        for(int i = 0;i < n;i++){
            for(int j= 0;j < n;j++){
                if(board[i][j] == 1){
                    System.out.print("Q"+(c++)+" ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}