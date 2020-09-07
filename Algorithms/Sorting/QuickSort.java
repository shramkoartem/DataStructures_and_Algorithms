
public class QuickSort{

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static int findx(int[] arr, int i, int j){
        /*
        Returns index of a not minimal index in subarray (i, j), if exists, else -1
         */

        int k = i+1;

        while( k<=j && arr[k] == arr[k-1]) k++;
        if(k>j) return -1;
        else if(arr[k-1] < arr[k]) return k;
        else return k-1;
    }

    private static int partition(int[] arr, int i, int j, int x){
        /*
        Partitions subarray (i,j) given key value x and returns
        index of elems > x
         */

        // dynamic pointers for swapping elements between partitions
        int l = i;
        int r = j;

        while(l<r){
            while(arr[l] <  x) l++;
            while(arr[r] >= x) r--;
            if(l<r) swap(arr, l, r);
        }
        System.out.print("l = " + l + " : ");
        printArray(arr);
        return l;
    }

    public static void quickSort(int[] arr, int i, int j){
        int k, xindex;
        if(i<j){
            xindex = findx(arr, i, j);
            if(xindex != -1){
                k = partition(arr, i, j, arr[xindex]);  // Divide
                quickSort(arr, i, k -1);             // Conquer (left side)
                quickSort(arr, k, j);                  // Conquer (right side)
            }
        }
    }

    public static void printArray(int[] arr){
        System.out.print("[ ");
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){

        int[] A = {3, 1, 8, 5, 0, 9, 7, 2, 6, 4};

        printArray(A);
        quickSort(A, 0, A.length-1);
        printArray(A);
    }
}