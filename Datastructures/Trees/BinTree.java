
public class BinTree<T> {

    Node<T> root;

    class Node<T> {
        T value;
        Node<T> left, right;

        public Node(T value){
            this.value = value;
            left = right = null;
        }
    }

    /* Constructors */
    public BinTree(T value){
        root = new Node(value);
    }

    public BinTree(){
        root = null;
    }






}