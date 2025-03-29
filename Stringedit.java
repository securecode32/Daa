import java.util.Scanner;
    public class StringEditDemo {
            public static void main(String args[])
            {
                Scanner in=new Scanner(System.in);
                System.out.println("Enter string1: ");
                String s1=in.nextLine();
                System.out.println("Enter string2: ");
                String s2=in.nextLine();
                int dist=minEditDist(s1,s2);
                System.out.println(dist);
            }
            public static int minEditDist(String s1,String s2)
            {
                int m=s1.length();
                int n=s2.length();
                int dptable[][]=new int[m+1][n+1];
                for(int i=0;i<=m;i++)
                    dptable[i][0]=i;
                for(int j=0;j<=n;j++)
                    dptable[0][j]=j;
                for(int i=1;i<=m;i++)
                    for(int j=1;j<=n;j++)
                        if(s1.charAt(i-1)==s2.charAt(j-1))
                            dptable[i][j]=dptable[i-1][j-1];
                        else
                            dptable[i][j]=Math.min(dptable[i][j-1],Math.min(dptable[i-1][j],dptable[i-1][j-1])+1);
                return dptable[m][n];
            }
    }
string edit