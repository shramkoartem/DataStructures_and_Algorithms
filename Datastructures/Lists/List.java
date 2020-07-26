import java.lang.*;

interface Elem {
    String toString();
}

interface ElemTest {
    boolean check(Elem l);
}

class Pos {
    Elem value;
    Pos pred, succ;
}

public class List extends Pos {

    private List l = new List();

    public Pos front() {
        return this;
    }

    public boolean eol(Pos p) {
        return p.succ == null;
    }

    public boolean isEmpty() {
        return this.succ == null && this.value == null && this.pred == null;
    }

    public List insert(Pos p, Elem e){
        /*** Insert an element after position p.
         * Two cases:
         * a) elem is added in the middle of list
         *      - create new element of list q, reset pointers
         *        of elements at positions p and p+1 on q, set
         *        pointers of q
         * b) elem is added in the end of list

         ***/

        Pos q = new Pos();
        q.value = e;
        if(!(eol(p) || isEmpty())){
            q.pred = p;
            q.pred = p.succ;
            p.succ.pred = q;
            p.succ = q;
        }
        else {
            q.pred = p;
            q.succ = null;
            p.succ = q;
            p.pred = q;
        }
        return this;
    }
/*
    public List concat(List l2){
        Pos p, q;
        if (this.isEmpty()) return l2;
        else if (l2.isEmpty()) return this;
        else {
            p = this.pred;
            q = l2.next(l2.front());
            p.succ = q;
            q.pred = p;
            this.pred = l2.pred;
            l2.reset();
            return this;
        }
    }
*/
    public Pos find(ElemTest test) {
        Pos p = this;
        while (!eol(p))
        {
            p = p.succ;
            if (test.check(p.value)) return p;
        }
        return null;
    }

    public List delete(Pos p){
        Pos q = p.pred; // elem before p
        q.succ = p.succ;
        p.succ.pred = q;
        return this;
    }

    public static void main(String[] args){
        List l1 = new List();
        Pos p = l1.front();
        l1.insert(p, 26);
    }
}