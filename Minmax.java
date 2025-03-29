//MinMax
import java.util.Scanner;
public class MaxMinDC {
    static class Result {
        int max, min;
        public Result(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    public static void main(String[] args) {
        int n;
        System.out.println("Enter number of elements: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        Result r = findMaxMin(arr, 0, arr.length - 1);
        System.out.println("Max: " + r.max + ", Min: " + r.min);
        sc.close();
    }

    public static Result findMaxMin(int a[], int start, int end) {
        if (start == end) {
            return new Result(a[start], a[start]);
        }
        else if (end - start == 1) {
            if (a[start] < a[end])
                return new Result(a[start], a[end]); 
            else
                return new Result(a[end], a[start]);
        }
        else {
            int mid = (start + end) / 2;
            Result lr = findMaxMin(a, start, mid);
            Result rr = findMaxMin(a, mid + 1, end);
            
            int min = Math.min(lr.min, rr.min);
            int max = Math.max(lr.max, rr.max);
            
            return new Result(min, max);
        }
    }
}