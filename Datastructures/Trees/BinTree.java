
public class BinTree {

    Node root;

    class Node {
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
            left = right = null;
        }
    }

    /* Constructors */
    public BinTree(int value){
        root = new Node(value);
    }

    public BinTree(){
        root = null;
    }

    /* recursive method for insertion */
    private Node addRecursive(Node current, int value){

        /* if current node is null, then it is a leaf,
            i.e. position is vacant and a new node
            can be inserted
         */
        if (current == null) {
            return new Node(value);
        }

        /*  if value is smaller than the value of current node,
            then we go to the left node, if greater -> right
         */
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    /* public method to start recursive adding from root  */
    public void add(int value){
        root = addRecursive(root, value);
    }

    /* check if value is in the tree */
    private boolean containsValueRecursive(Node current, int value){
        if(current == null){
            return false;
        } else if(value == current.value) {
            return true;
        } else {
            if (value < current.value){
                return containsValueRecursive(current.left, value);
            } else {
                return containsValueRecursive(current.right, value);
            }
        }
    }

    /* starting search from the root */
    public boolean containsValue(int value){
        return containsValueRecursive(root, value);
    }

    /* smallest value in the tree */
    private int minValueRecursive(Node node){
        if (node.left == null){
            return node.value;
        } else {
            return minValueRecursive(node.left);
        }
    }


    /* deleting node with value */

    private Node deleteRecursive(Node current, int value){
        /* Termination */
        if (current == null){
            return null;

        /* Current node is to be deleted */
        } else if (value == current.value) {
            /* if does not have children */
            if (current.left == null && current.right == null){
                return null;

            /* if has one child */
            } else if (current.right == null){
                return current.left;
            } else if (current.left == null){
                return current.right;

            /* if has children - reorder the tree
            * find smallest value and place it at the
            * position of the node that is to be deleted */
            } else {
                int min = minValueRecursive(current);
                current.value = min;
                current.right = deleteRecursive(current.right, min);
                return current;
            }


        /* Continue search based on value */
        } else if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        } else {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    /* Traversals */
    /* Deep-first search, in order */
    public void deepFirstInOrder(Node node){
        if (node != null){
            deepFirstInOrder(node.left);
            System.out.print(node.value + " ");
            deepFirstInOrder(node.right);
        }
    }

    /* Deep-first search, pre-order */
    public void deepFirstPreOrder(Node node){
        if (node != null){
            System.out.print(node.value + " ");
            deepFirstPreOrder(node.left);
            deepFirstPreOrder(node.right);
        }
    }

    /* Deep-first search, post-order */
    public void deepFirstPostOrder(Node node){
        if (node != null){
            deepFirstPostOrder(node.left);
            deepFirstPostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void deepFirstTraverse(String method){
        System.out.print("[ ");
        if (method == "pre"){
            deepFirstPreOrder(root);
            System.out.println("]");

        } else if(method == "in"){
            deepFirstInOrder(root);
            System.out.println("]");

        } else if(method == "post"){
            deepFirstPostOrder(root);
            System.out.println("]");

        } else {
            throw new RuntimeException("Allowed methods: pre, in, post.");
        }
    }



    public static void main(String[] args){
        BinTree bt = new BinTree();
        bt.add(5);
        bt.add(3);
        bt.add(2);
        bt.add(7);
        bt.add(9);
        bt.add(1);

        System.out.println(bt.containsValue(3));

        bt.delete(3);
        System.out.println(bt.containsValue(3));


        bt.deepFirstTraverse("in");
        bt.deepFirstTraverse("pre");
        bt.deepFirstTraverse("post");

    }



}
