public class SelectionSort{

    // utility
    public static void swap(int[] array, int n, int m){
        int tmp = array[n];
        array[n] = array[m];
        array[m] = tmp;
    }

    public static void printArray(int[] array){
        System.out.print("[ ");
        for(int elem : array){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    // avg = O(n2)
    // wc  = O(n2)
    public static void selectionSort(int[] array){
        int min;
        int minindex;

        for(int i=0; i<array.length-1; i++){
            min = array[i];
            minindex = i;

            for(int j = i+1; j<array.length;j++){
                if(array[j] < min){
                    min = array[j];
                    minindex = j;
                }
            }
            swap(array, i, minindex);
        }
    }

    public static void main(String[] args){
        int[] A = {5, 2, 6, 3, 2, 4, 7, 0};
        printArray(A);
        selectionSort(A);
        printArray(A);
    }
}