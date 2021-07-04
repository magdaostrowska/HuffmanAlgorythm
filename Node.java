class Node {

    char letter;
    int number;

    Node leftChild;
    Node rightChild;

    public Node(char letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.number = rightChild.number + leftChild.number;
    }

    public void createPrefix(String prefixCode) {

        if (leftChild == null && rightChild == null){
            System.out.println(letter + " " + prefixCode);
        }
        if (leftChild != null){
            leftChild.createPrefix(prefixCode + '0');
        }
        if (rightChild != null){
            rightChild.createPrefix(prefixCode + '1');
        }
    }
}
