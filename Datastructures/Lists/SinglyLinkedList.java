package com.shramkoartem.datastructures.lists;


public class SinglyLinkedList<T> {

    // [head: T value]--->[Pos 1: <T>]--->[Pos 2: <T>]--->...

    private Pos<T> head;

    // Private class representing list element
    private class Pos<T> {
        T value;
        Pos<T> succ;
        public Pos(T value) {
            this.value = value;
        }
        @Override public String toString() {
            return value.toString();
        }
    }

    public boolean EOL (Pos<T> p){
        return p.succ == null;
    }

    // Finding size of the list, O(n)
    public int size() {
        int size = 0;
        Pos<T> p = this.head;
        while(p != null){
            size++;
            p = p.succ;
        }
        return size;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public Pos<T> front(){
        return this.head;
    }

    // delete all elements of a list, O(n)
    public void clear(){
        Pos<T> p = head;
        while (p != null) {
            Pos<T> q = p.succ;
            p.value = null;
            p.succ = null;
            p = q;
        }
    }


    // Adding elem at the end of the list, O(n)
    public void addLast(T elem){

        // Create new node
        Pos<T> new_pos = new Pos(elem);
        new_pos.succ = null;

        // If list is empty
        if(this.head == null){
            this.head = new_pos;
        } else {
            Pos<T> last = this.head;

            while (last.succ != null) {
                last = last.succ;
            }
            last.succ = new_pos;
        }
        //return this;
    }

    // Adding elem at position, O(n)
    public void addAt(int pos, T elem){

        if(pos > this.size()) throw new RuntimeException("Position out of bounds.");

        Pos<T> new_pos = new Pos(elem);
        new_pos.succ = null;

        if(this.head == null){
            this.head = new_pos;
        } else {
            Pos<T> last = this.head;
            int i = 0;
            while(i+1 != pos){
                last = last.succ;
                i++;
            }
            new_pos.succ = last.succ;
            last.succ = new_pos;
        }
    }

    // Remove element by its value, O(n)
    public void remove(T elem){
        Pos<T> last = this.head;
        if(last == null){
            throw new RuntimeException("Empty list.");
        } else if (last.value == elem){
            this.head = this.head.succ;
        } else {
            while(last.succ.value != elem){
                last = last.succ;
            }
            if(last == null) throw new RuntimeException("Element is not in a list.");

            last.succ = last.succ.succ;
        }
    }



    // printing list, O(n)
    public void printList(){
        Pos<T> p = this.head;

        System.out.print("Singly Linked List: [");

        String sep;
        while(p != null){
            if(p.succ == null){
                sep = "";
            } else {
                sep = ", ";
            }
            System.out.print(p.value + sep);
            p = p.succ;
        }
        System.out.println("]");
    }


    public static void main(String[] args){
        SinglyLinkedList l = new SinglyLinkedList();

        l.printList();
        System.out.println("Size: " + l.size());


        for (int i = 1; i<6; i++){
            l.addLast( i*i);
        }
        l.printList();
        System.out.println("Size: " + l.size());


        l.addAt(2,100);
        l.printList();
        System.out.println("Size: " + l.size());

        l.remove(9);
        l.printList();

    }

}
