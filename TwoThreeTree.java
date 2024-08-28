public class TwoThreeTree {
    private Node root;

    public TwoThreeTree(){
        root = null;
    }

//    Node class representing a 2-3 node
    private static class Node{
        int [] keys;
        Node[] children;
        int size;

        Node(int key){
            keys = new int[3];
            children = new Node[4];
            keys[0] = key;
            size = 1;
        }
        boolean isLeaf(){
            return children[0] == null;
        }
    }

//    Inserts a value into the 2-3 tree
    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }else{
            Node newRoot = insert(root,value);
            if(newRoot != null){
                root = newRoot;
            }
        }
    }

    private Node insert(Node node, int value){
        if(node.isLeaf()){
            insertIntoNode(node,value);
            if(node.size == 3){
                return split(node);
            }
        }else{
            int childIndex = getChildIndex(value);
            Node newChild = insert(node.children[childIndex], value);
            if(newChild != null){
                node.children[node.size + 1] = node.children[node.size];
                node.children[childIndex] = newChild;
                insertIntoNode(node, newChild.keys[0]);
                if(node.size == 3){
                    return split(node);
                }
            }
        }
        return null;
    }

    private void insertIntoNode(Node node, int value){
        int i = node.size - 1;
        while(i>= 0 && value < node.keys[i]){
            node.keys[i + 1] = node.keys[i];
            i--;
        }
        node.keys[i + 1] = value;
        node.size++;
    }

//    Splits the node that way the illegal 4 node can be put into its proper place in the tree
    private Node split(Node node){
        Node newNode = new Node(node.keys[2]);
        newNode.children[0] = node.children[2];
        newNode.children[1] = node.children[3];
        node.size = 1;
        return newNode;
    }


//    Searches for a value in the 2-3 tree
    public boolean search(int value){
        return search(root, value);
    }
    private boolean search(Node node, int value){
        if(node == null){
            return false;
        }
        for(int i = 0; i < node.size; i++){
            if(value == node.keys[i]){
                return true;
            } else if (value < node.keys[i]) {
                return search(node.children[i],value);
            }
        }
        return search(node.children[node.size],value);
    }

//    Gets the max value from the 2-3 tree
    public int getMax(){
        Node current = root;
        while (current.children[0] != null){
            current = current.children[current.size];
        }
        return current.keys[current.size - 1];
    }

//    Function that does an in-order traversal of the 2-3 tree
    public String displayInOrder(){
        StringBuilder result = new StringBuilder();
        displayInOrder(root,result);
        return result.toString();
    }

    private void displayInOrder(Node node, StringBuilder result){
        if(node != null){
            for(int i = 0; i< node.size; i++){
                displayInOrder(node.children[i], result);
                result.append(node.keys[i]).append(" ");
            }
            displayInOrder(node.children[node.size], result);
        }
    }
    private int getChildIndex(int value) {
        return value;
    }
}
