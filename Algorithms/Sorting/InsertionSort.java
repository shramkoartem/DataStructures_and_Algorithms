public class InsertionSort{

    /*
    1. take out element i
    2. shift all the elements > i before i to the right
    3. insert i to the new position in the sorted part of the array
     */

    public static void printArray(int[] array){
        System.out.print("[ ");
        for(int elem : array){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    // bc = O(n)
    // wc = O(n2)
    public static void insertionSort(int[] array){
        int curr;
        int j;

        for(int i=1; i<array.length; i++){
            curr = array[i];
            j = i-1;

            System.out.print("i = " + i + " : ");
            printArray(array);
            System.out.println(" -- curr = " + curr);

            while(j>=0 && curr < array[j]){
                array[j+1] = array[j];
                System.out.print(" -- j = " + j + " : ");
                printArray(array);
                j--;

            }
            array[j+1] = curr;

        }
    }

    public static void main(String[] args){
        int[] A = {5,6,2, 4, 7, 3, 8, 0};

        insertionSort(A);
    }
}