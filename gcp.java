//gcp
import java.sql.SQLOutput;
import java.util.*;
public class GraphColoring {
    static int n,m;
    static int graph[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no.of vertices: ");
        n=sc.nextInt();
        System.out.println("Enter no.of colours: ");
        m=sc.nextInt();
        System.out.println("Enter adjacency matrix: ");
        graph=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();
        solveGCP();
    }
    public static void solveGCP()
    {
        if(!solutionGCP(0)) {
            System.out.println("No solution exists");
            return;
        }
        printSolution();
    }
    public static boolean solutionGCP(int v)
    {
        if(v==n) return true;
        for(int c=1;c<=m;c++)
        {
            if(isSafe(v,c)) {
                color[v] = c;
                if (solutionGCP(v + 1)) return true;
                color[v] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int v,int c)
    {
        for(int i=0;i<n;i++)
        {
            if(i!=v)
                if(graph[v][i]==1 && color[i]==c)
                    return false;
        }
        return true;
    }
    public static void printSolution()
    {
        System.out.println("The solution is: ");
        for(int i=0;i<n;i++)
            System.out.print("Vertex"+i+" has color "+color[i]);
        System.out.println("Minimum no.of colors required to colour graph is: "+Arrays.stream(color).max().getAsInt());
    }
}