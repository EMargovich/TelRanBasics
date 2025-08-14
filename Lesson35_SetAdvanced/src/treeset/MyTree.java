package treeset;

public class MyTree {
    //Inner private class. It is not use in another classes
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public MyTree subSet(int from, int to) {
        MyTree newTree = new MyTree();
        root = subSetRecursive(root,newTree, from, to);
        return newTree;
    }

    private Node subSetRecursive(Node root, MyTree newTree, int from, int to) {
        if(root == null)
            return null;
        if(root.value < from)
            root = subSetRecursive(root.right, newTree, from, to);
        if(root.value >= from && root.value < to) {
            newTree.add(root.value);
            subSetRecursive(root.right, newTree, from, to);
            subSetRecursive(root.left, newTree, from, to);
        }
        if(root.value >= to) {
            root = subSetRecursive(root.left, newTree, from, to);
        }
        return root;
    }

    public void trimMyTree(int start, int end) {
        root = trimMyTreeRecursive(root, start, end);
    }

    private Node trimMyTreeRecursive(Node root, int start, int end) {
        if(root == null)
            return null;

        root.left = trimMyTreeRecursive(root.left,start,end);
        root.right = trimMyTreeRecursive(root.right,start,end);

        if(root.value < start || root.value >= end) {
            root = removeRecursive(root, root.value);
        }
        return root;
    }


    public void add(int value) {
        root = addRecursive(root,value);
    }

    private Node addRecursive(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (value < root.value)
            root.left = addRecursive(root.left, value);
        else if (value > root.value)
            root.right = addRecursive(root.right, value);
        return root;
    }

    public void traverse() {
        traversRecursive(root);
        System.out.println();
    }

    private void traversRecursive(Node root) {
        if(root != null) {
            traversRecursive(root.left);
            System.out.print(root.value + " ");
            traversRecursive(root.right);
        }
    }

    public boolean contains(int value) {
        return searchRecursive(root, value) != null;
    }

    private Node searchRecursive(Node root, int value) {
        if(root == null || root.value == value)
            return root;
        if(value < root.value)
            return searchRecursive(root.left, value);
        return searchRecursive(root.right, value);
    }

    private int findSmall(Node node) {
        return  node.left == null ? node.value : findSmall(node.left);
    }

    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node root, int value) {
        if (root == null)
            return null;
        //If element was found
        if(root.value == value) {
            //If are not children
            if(root.left == null && root.right == null) {
                return null;
            }
            //If is one child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //If two children
            int small = findSmall(root.right);
            root.value = small;
            root.right = removeRecursive(root.right, small);
        } else if (value < root.value)
            root.left = removeRecursive(root.left, value);
          else root.right = removeRecursive(root.right, value);
        return root;
    }
}