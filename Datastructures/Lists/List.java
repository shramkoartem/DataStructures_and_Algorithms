

interface Elem {
    String toString();
}

interface ElemTest {
    boolean check(Elem l)
}

class Pos {
    Elem value;
    Pos pred, succ;
}

public class List extends Pos {

    List l = new List();

    public Pos front() {
        return this;
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
        if(!(eol(p) || isempty())){
            q.pred = p;
            q.pred = p.succ;
            p.succ.pred = q;
            p.succ = q;
        }
        else {
            q.pred = p;
            q.succ = null;
            p.succ = q;
            pred = q;
        }
        return this;
    }

    public List concat(List l2){
        Pos p, q;
        if (this.isempty()) return l2;
        else if (l2.isempty()) return this;
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

    public Pos find(ElemTest test) {
        Pos p = this;
        while (!eol(p))
        {
            p = next(p);
            if (test.check(p.value)) return p
        }
        return null;
    }

    public List delete(Pos p){
        Pos q = p.pred; // elem before p
        q.succ = p.succ;
        p.succ.pred = q;
        return this;
    }
}