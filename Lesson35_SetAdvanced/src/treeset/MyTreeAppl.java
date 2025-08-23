package treeset;

public class MyTreeAppl {
    public static void main(String[] args) {
        MyTree tree = new MyTree();

        tree.add(10);
        tree.add(15);
        tree.add(2);
        tree.add(19);
        tree.add(25);
        tree.add(39);
        tree.add(1);
        tree.add(4);
        tree.add(11);
        tree.add(16);
        tree.add(20);
        tree.add(7);
        tree.add(0);
        tree.add(17);
        tree.add(55);
        tree.add(6);

//        tree.traverse();
//        System.out.println(tree.contains(4));
//        System.out.println(tree.contains(3));

        tree.traverse();

        int start = 10;
        int end = 14;

        System.out.println("subSet test:");
        System.out.println("Tree:");
        tree.traverse();
        MyTree newTree = tree.subSet(start,end);
        System.out.println("NewTree:");
        newTree.traverse();
        System.out.println("Again tree:");
        tree.traverse();

        System.out.println();
        System.out.println("Check trim tree: \nTree");
        tree.traverse();
        System.out.println("Trim tree:");
        tree.trimMyTree(start,end);
        tree.traverse();

       // System.out.println("Count calls trimRecursive " + tree.count);
    }
}
