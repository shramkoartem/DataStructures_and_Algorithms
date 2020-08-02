package com.shramkoartem.stack;

public class Stack <T> {
    // LIFO: last in first out

    private Node<T> head = null;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value){
            this.value = value;
        }

        @Override public String toString(){return this.value.toString();}
    }

    // Adds new element to the top, O(1)
    public void push(T elem){

        Node<T> new_node = new Node(elem);
        new_node.next = null;

        if(this.head == null){
            this.head = new_node;
        } else {
            new_node.next = this.head;
            this.head = new_node;
        }
    }

    // Removes top element, O(1)
    public void pop(){
        if(this.head == null){
            throw new RuntimeException("Stack is empty");
        } else {
            this.head = this.head.next;
        }
    }

    // Prints all elements in the stack, O(n)
    public void printStack(){
        Node<T> traverser = this.head;

        System.out.print("Stack: [");
        while (traverser != null){
            System.out.print(traverser.value + " ");
            traverser = traverser.next;
        }
        System.out.println("]");
    }

    // Prints amount of elements in a stack, O(n)
    public int size(){
        Node<T> traverser = this.head;
        int n = 0;
        while (traverser != null){
            n++;
            traverser = traverser.next;
        }
        return n;
    }

    // Check if stack is empty, O(1)
    public boolean isEmpty(){
        return this.head == null;
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        System.out.println("Stack is empty: " + stack.isEmpty());
        stack.printStack();
        stack.push(5);
        stack.printStack();
        for(int i=1; i<6;i++){
            stack.push(i*i);
        }
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.printStack();
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
    }
}