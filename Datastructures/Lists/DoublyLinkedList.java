

public class DoublyLinkedList <T> implements Iterable <T> {

    private int size = 0;
    private Pos <T> head = null;
    private Pos <T> tail = null;

    private class Pos<T> {
        T value;
        Pos <T> pred, succ;
        public Pos(T value, Pos <T> pred, Pos <T> succ) {
            this.value = value;
            this.pred = pred;
            this.succ = succ;
        }
        @Override public String toString() {
            return value.toString();
        }
    }

    public void clear(){
        Pos <T> p = head;
        while(p != null){
            Pos <T> q = p.succ;
            p.pred = p.succ = null;
            p.value = null;
            p = q;
        }
        head = tail = p = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // add elem to the end of list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // add elem to the start of the list, O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Pos<T> (elem, null, null);
        } else {
            head.pred = new Pos<T>(elem, null, head);
            head = head.pred;
        }
        size++;
    }

    public void addLast(T elem){
        if (isEmpty()){
            head = tail = new Pos<T> (elem, null, null);
        } else {
            tail.succ = new Pos<T> (elem, tail, null);
            tail = tail.succ;
        }
        size++;
    }

    // return value of the first elem, O(1)
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return head.value;
    }

    // return value of the last elem, O(1)
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return tail.value;
    }

    // remove first elem, O(1)
    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list");

        T data = head.value;
        head = head.succ;
        --size;

        if(isEmpty()) tail = null;
        else head.pred = null;

        return data;
    }

    // remove last elem, O(1)
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty list");

        T data = tail.value;
        tail = tail.pred;
        --size;

        if(isEmpty()) head = null;
        else tail.succ = null;

        return data;
    }

    // remove elementfrom list at any position, O(1)
    private T remove(Pos<T> p){

        if(p.pred == null) return removeFirst();
        if(p.succ == null) return removeLast();

        // reset pointers
        // ------>[p.pred]<--->[p]<--->[p.succ]
        // => --->[p.pred]<----------->[p.succ]
        p.succ.pred = p.pred;
        p.pred.succ = p.succ;

        T data = p.value;

        p.value = null;
        p.succ = p.pred = null;

        --size;

        return data;
    }

    // remove elem at position, O(n)
    public T removeAt(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Pos<T> p;

        // search for the element
        for(i=0, p=head; i != index; i++){
            p = p.succ;
        }

        return remove(p);
    }

    // remove elem of certain value, O(n)
    public boolean remove(Object obj) {

        Pos <T> p = head;

        // support searching for null
        if (obj == null) {
            for(p = head; p != null; p = p.succ) {
                if (p.value == null) {
                    remove(p);
                    return true;
                }
            }
        // search for non null value
        } else {
            for (p = head; p != null ; p = p.succ) {
                if (obj.equals(p.value)) {
                    remove(p);
                    return true;
                }
            }
        }
        return false;
    }

    // find pos of given elem, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Pos<T> p = head;

        // seaching for null
        if(obj == null){
            for(p=head; p != null; p = p.succ, index++){
                if (p.value == null)
                    return index;
            }
        } else {
            for(p=head; p!=null; p = p.succ, index++){
                if(obj.equals(p.value))
                    return index;
            }
        }
        return -1;
    }

    public boolean containt(Object obj){
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator <T> iterator() {
        return new java.util.Iterator <T> () {
            private Pos <T> p = head;
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
        DoublyLinkedList l = new DoublyLinkedList();
        System.out.println(l);
        l.add(5);
        System.out.println(l);
        l.add("abc");
        System.out.println(l);
        for(int i=0; i<5; i++){
            l.add(i*i);
        }
        System.out.println(l);
        l.remove(4);
        System.out.println(l);
    }


// end of class
}


