package com.shramkoartem.datastructures.queue;

public class Queue<T> {
    /***
     * [head: value]-->[Node 1: value]--> ... -->[tail: value]--> null
     *
     * First in first out
     * Implemented based on a Singly Linked List logic
     *
     * Enqueue O(1)
     * Dequeue O(1)
     * Peek O(1)
     * Contains O(n)
     * Remove O(n)
     * isEmpty O(1)
     */

    Node<T> head;
    Node<T> tail;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T elem) {
            this.value = elem;
        }
        @Override public String toString(){
            return this.value.toString();
        }
    }

    // O(1)
    public boolean isEmpty(){
        return head == null && tail == null;
    }

    // Returns size of the Queue, O(n)
    public int size(){
        Node<T> traverser = head;
        int size = 0;
        while(traverser != null){
            size++;
            traverser = traverser.next;
        }
        return size;
    }

    // offer (add) an element at the end of the queue, O(1)
    public void enqueue(T elem){

        Node<T> new_node = new Node(elem);
        new_node.next = null;

        if(isEmpty()){
            this.head = new_node;
            this.tail = new_node;
        } else {
            this.tail.next = new_node;
            this.tail = new_node;
        }
    }

    // pull (pop) first element in the Queue, O(1)
    public void dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        } else {
            head = head.next;
        }
    }

    // Check if element is contained in a Queue, O(n)
    public boolean containts(T elem){
        Node<T> traverser = head;

        while(traverser != null){
            if(traverser.value == elem){
                return true;
            }
            traverser = traverser.next;
        }
        return false;
    }

    // Remove element by value, O(n)
    public void remove(T elem) {
        Node<T> traverser = head;

        while (traverser.next.value != elem && traverser != null) {
            traverser = traverser.next;
        }
        if (traverser == null) {
            throw new RuntimeException("Element is not in the Queue.");
        } else {
            traverser.next = traverser.next.next;
        }
    }

    // Show the first (next to be out) element in a Queue, O(1)
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        } else {
            return head.value;
        }
    }

    // Print all elements of the Queue, O(n)
    public void print(){

        Node<T> traverser = head;

        System.out.print("[");
        while(traverser != null){
            System.out.print(traverser.value + " ");
            traverser = traverser.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        Queue q = new Queue();

        q.print();
        q.enqueue(5);
        q.print();
        for (int i=1; i<6; i++){
            q.enqueue(10*i);
        }
        System.out.println("Queue size: " + q.size());
        q.print();
        q.dequeue();
        q.print();
        q.enqueue("abc");
        q.print();
        System.out.println("Peeking: " + q.peek());
        System.out.println("Contains 30: " + q.containts(30));
        System.out.println("Contains 'Hello': " + q.containts("Hello"));
        q.remove(20);
        q.print();

    }

}