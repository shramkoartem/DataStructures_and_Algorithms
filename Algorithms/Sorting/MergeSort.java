
public class MergeSort{

    // avg time = O( n log(n) )

    // Merges two sub arrays of arr[]
    // First sub array of size [l..m]
    // Second sub array of size [m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;   // size of left sub array
        int n2 = r - m;       // size of right sub array

        int[] L = new int[n1];
        int[] R = new int[n2];


        // Copyting data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // Merge temporary sub arrays

        // Initial indexes of sub arrays
        int i = 0;
        int j = 0;

        // Initial index of merged array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elems in L and R if any left
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        printArray(L);
        printArray(R);
    }

    // Main function for merge sort
    public static void sort(int[] arr, int l, int r){
        if(l<r){
            int m = (l + r)/2;

            // Sort two halves (recursive)
            sort(arr, l, m);
            sort(arr, m+1, r);

            // Merge two sorted halves
            merge(arr, l, m, r);

            printArray(arr);
        }
    }

    // Utility to display array
    public static void printArray(int[] arr){
        System.out.print("[ ");
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] A = { 6, 2, 3, 0, 7, 9,5, 1, 8,4};

        printArray(A);

        sort(A, 0, A.length-1);

    }

}
