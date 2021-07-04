package GUI;

class Tree {

    Node1 root;

    public Tree(char letter, int number) {
        root = new Node1(letter, number);
    }

    public Tree(Tree tree1, Tree tree2) {
        Node1 root1 = tree1.root;
        Node1 root2 = tree2.root;
        root = new Node1(root1, root2);
    }

    public void createPrefix() {
        if (root != null) {
            root.createPrefix("");
        }
    }
}