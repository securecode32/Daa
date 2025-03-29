//mergesort
import java.util.Scanner;

class MergeSortDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, a[];
        System.out.println("Enter the size of array:");
        n = s.nextInt();
        a = new int[n];
        System.out.println("Enter elements of array one by one space separated:");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        System.out.println("Array before sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }	
        MergePass(a, 0, a.length - 1);
        System.out.println("\nArray after sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void MergePass(int ar[], int lb, int ub) {
        int mid;
        if (ub != lb) {
            mid = (lb + ub) / 2;
            MergePass(ar, lb, mid);
            MergePass(ar, mid + 1, ub);
            MergeSort(ar, lb, mid, ub);
        }
    }

   public static void MergeSort(int a[], int l, int m, int u) {
    int i, j, k;
    int temp[] = new int[u - l + 1]; 

    i = l;
    j = m + 1;
    k = 0; 

    while ((i <= m) && (j <= u)) {
        if (a[i] < a[j])
            temp[k++] = a[i++];
        else
            temp[k++] = a[j++];
    }

    while (i <= m)
        temp[k++] = a[i++];
    while (j <= u)
        temp[k++] = a[j++];

    
    for (i = l, k = 0; i <= u; i++, k++)
        a[i] = temp[k];
}

}