public class BubbleSort{

    public static void printArray(int[] array){
        System.out.print("[ ");
        for(int elem : array){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    // wc = O(n2)
    public static void bubbleSort(int[] array){
        for (int i = array.length; i>0; i--){
            for(int j=0; j<i-1; j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
            System.out.print(i + " : ");
            printArray(array);
        }
    }

    public static void main(String[] args){
        int[] A = {2, 5,1, 8, 3, 7, 9, 0};
        printArray(A);

        bubbleSort(A);
    }
}