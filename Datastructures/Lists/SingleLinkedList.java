import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable <T> {

    private int size = 0;

    private Pos<T> head = null;

    private class Pos<T> {

        T value;
        Pos<T> succ;

        public Pos(T value, Pos<T> succ) {
            this.value = value;
            this.succ = succ;
        }
        @Override public String toString() {
            return value.toString();
        }
    }

        public boolean EOL (Pos<T> p){
        return p.succ == null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public SingleLinkedList<T> front(){
        return this;
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
        size = 0;
    }

    // O(1)
    public void addFirst(T elem){
        Pos<T> p = new Pos(elem, null);
        if(isEmpty()){
            head = p;
        } else {
            p.succ = head.succ;
            head.succ = p;
        }
    }

    // O(n)
    public void addLast(T elem){
        if(isEmpty()){addFirst(elem);}

        Pos<T> p = new Pos(elem, null);
        Pos<T> q = new Pos(null, null);
        while (!EOL(p)){
            q = q.succ;
        }
        q.succ = p;
    }



    @Override public java.util.Iterator <T> iterator() {
        return new java.util.Iterator <T> () {
            private Pos<T> p = head;
            @Override public boolean hasNext() {
                return p != null;
            }
            @Override public T next() {
                T value = p.value;
                p = p.succ;
                return value;
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Pos<T> p = head;
        while(p != null) {
            sb.append(p.value + ", ");
            p = p.succ;
        }
        sb.append(" ]");
        return sb.toString();
    }


    public static void main(String[] args){
        SingleLinkedList l = new SingleLinkedList();
        System.out.println(l);

    }



}
