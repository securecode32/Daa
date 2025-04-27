import java.util.Scanner;
public class LongPSeq
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String S=sc.nextLine();
        System.out.println("Longest Common Subsequence : "+LCS(S));
    }
    public  static int LCS( String S)
    {
        int n=S.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) {
        dp[i][i]=1;
        }
        for(int len=2;len<=n;len++)
        {
            for(int i=0;i<=n-len;i++)
            {
                int j=i+len-1;
                if(S.charAt(i)==S.charAt(j))
                dp[i][j]=dp[i+1][j-1]+2;
                else
                dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
        
    }
}