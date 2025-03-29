//LongestCommonSubseqvence
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter string1: ");
        String s1=in.nextLine();
        System.out.println("Enter string2: ");
        String s2=in.nextLine();
        int lcss=calcLCSS(s1,s2);
        System.out.println("Length of Longest Common Subsequence: "+lcss);
    }
    public static int calcLCSS(String s1,String s2)
    {
        int[][] dptable=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++)
            for(int j=1;j<=s2.length();j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dptable[i][j]=1+dptable[i-1][j-1];
                else
                    dptable[i][j]=Math.max(dptable[i][j-1],dptable[i-1][j]);
        return dptable[s1.length()][s2.length()];
    }
}
LCS