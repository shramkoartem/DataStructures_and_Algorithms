
// methods with generic types
// public void <T> T[] newArray(Class<T> type, int length) { ... }

import java.lang.*;
import java.util.*;

public class DynamicArray<T> implements Iterable <T> {
    // Array<T> - support generics of type T (input)

    private T [] arr;               // internal stack array
    private int len = 0;            // length user sees
    private int capacity = 0;       // actual capacity

    // Constructors
    public DynamicArray() { this(16); }    // default size of 16

    public DynamicArray(int capacity) {            // parametrized, of size n
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];   // initialize new array and cast it to type T
    }

    // Getters
    public int size() { return len; }       // return size of array
    public boolean isEmpty() { return size() == 0; }

    // Get and Set for values at index
    public T get(int index) { return arr[index]; }
    public void set(int index, T elem) { arr[index] = elem; }

    // Delete all elements in the array
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    // Add an element to the array at the end
    public void add(T elem) {
        // if new size > capacity --> double the size of the array
        if (len+1 >= capacity) {
            if (capacity == 0) { capacity = 1; }
            else { capacity *= 2; }
            T[] new_arr = (T[]) new Object[capacity];
            for (int i=0; i<len; i++){
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    // remove the element at given index
    public T removeAt(int rm_index) {
        /* Construct a new array of size len-1;
         * Copy elements from old array to new
         *      except for the element at index
         *      to be removed
         */

        if (rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];   // data removed at index rm_index
        T[] new_arr = (T[]) new Object[len-1];  // new array of size len-1
        for (int i=0, j=0; i<len; i++, j++) {
            if (i == rm_index) j--;     // at the index of object to be removed we skip assignment
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj) {
        /*
          Searches array for the elem to be removed.
          When found, passes the position to removeAt method.
         */
        for (int i=0; i<len; i++) {
            if (arr[i].equals(obj)){
                removeAt(i);
                return true;
            }

        } return false;
    }

    public int indexOf(Object obj) {
        for (int i=0; i<len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        } return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator <T> () {
            int index = 0;
            public boolean hasNext() { return index < len; }
            public T next() { return arr[index++]; }
        };
    }

    @Override public String toString() {
        if (len==0) return "[]";
        else {
            StringBuilder sb = new StringBuilder( len ).append("[");
            for (int i=0; i<len-1; i++) {
                sb.append(arr[i] + ", ");
            }
            return sb.append(arr[len-1] + "]").toString();
        }
    }

    public static void main (String[] args){
        DynamicArray a = new DynamicArray(10);

        for (int i=0; i<10; i++ ){
            a.add(i+5);
        };

        System.out.println(a);
    }


}