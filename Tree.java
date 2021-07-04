class Tree {

    Node root;

    public Tree(char letter, int number) {
        root = new Node(letter, number);
    }

    public Tree(Tree tree1, Tree tree2) {
        Node root1 = tree1.root;
        Node root2 = tree2.root;
        root = new Node(root1, root2);
    }

    public void createPrefix() {
        if (root != null) {
            root.createPrefix("");
        }
    }
}
