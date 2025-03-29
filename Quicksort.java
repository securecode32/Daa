//quick sort
import java.util.Scanner;

class QuickSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, a[];
        System.out.println("Enter the size of array:");
        n = s.nextInt();
        a = new int[n];
        System.out.println("Enter elements of array one by one space seperated:");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        System.out.println("Array before sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        quickSort(a, 0, a.length - 1);

        System.out.println("\nArray after sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void quickSort(int[] ar, int lb, int ub) {
        if (lb < ub) {
            int left = lb;
            int right = ub;
            int pivot = ar[lb];

            // Partitioning logic
            while (left < right) {
                while (ar[right] > pivot && left < right) {
                    right--;
                }
                while (ar[left] <= pivot && left < right) {
                    left++;
                }
                if (left < right) {
                    // Swap elements at left and right
                    int temp = ar[left];
                    ar[left] = ar[right];
                    ar[right] = temp;
                }
            }
            ar[lb] = ar[left];
            ar[left] = pivot;
            quickSort(ar, lb, left - 1);
            quickSort(ar, left + 1, ub);
        }
    }
}
quick sort