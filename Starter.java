public class Starter {
    public static void main(String[] args) {
        TwoThreeTree Tree = new TwoThreeTree();
        Tree.insert(8);
        Tree.insert(16);
        Tree.insert(24);
        Tree.insert(32);
        Tree.insert(40);


        System.out.println("In-Order traversal: "+ Tree.displayInOrder());

        System.out.println("Max value: "+ Tree.getMax());


        System.out.println("Search for value 16: "+ Tree.search(16));

    }
}
