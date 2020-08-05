


public class ArrayBasedList<T>{

    int size;
    ListElem[] space;
    Pointer free = new Pointer(0);

    public class Pointer{
        public int pos;
        public static final int nil = -1;
        public Pointer(int p) { pos = p; }
    }

    public class ListElem {

        int value;
        Pointer succ = new Pointer(Pointer.nil);
    }

    public ArrayBasedList(int size){
        this.size = size;
        ListElem[] space = (ListElem[]) new Object[size];

        for(int i=0; i < size; i++){
            if(i < size-1){
                space[i].succ.pos = i+1;
            } else {
                space[i].succ.pos = Pointer.nil;
            }
        }
    }

    public void alloc(Pointer p){

        if(space[free.pos].succ.pos == Pointer.nil ){
            throw new RuntimeException("List is full.");
        } else {
            p.pos = space[free.pos].succ.pos;
            space[free.pos].succ.pos = space[p.pos].succ.pos;
            space[p.pos].succ.pos = Pointer.nil;
        }
    }

    public void dispose(Pointer p){
        if(p.pos == Pointer.nil){
            throw new RuntimeException("Position not defined.");
        } else {
            space[p.pos].succ.pos = space[free.pos].succ.pos;
            space[free.pos].succ.pos = p.pos;
        }
    }

    public void printList(){
        Pointer traverser = new Pointer(0);

        while(traverser.pos != Pointer.nil){
            int elem = space[traverser.pos].value;
            System.out.print(elem + ' ');
            traverser.pos = space[traverser.pos].succ.pos;
        }
    }

    public static void main(String[] args){
        ArrayBasedList l = new ArrayBasedList(10);
        l.printList();
    }


}