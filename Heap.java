public class Heap {
    Tree[] treeTab;
    int counter = 0;

    public Heap() {
        treeTab = new Tree[64];
    }

    public void down(int upIndex) {
        Tree tree;

        int leftChildIndex = 2 * upIndex + 1;
        int rightChildIndex = 2 * upIndex + 2;
        int childPrefixCode;

        if (counter <= leftChildIndex) {
            return;
        } else if (counter <= rightChildIndex) {
            childPrefixCode = leftChildIndex;
        } else {

            if (treeTab[leftChildIndex].root.number <= treeTab[rightChildIndex].root.number) {
                childPrefixCode = leftChildIndex;
            } else {
                childPrefixCode = rightChildIndex;
            }
        }

        if (treeTab[upIndex].root.number > treeTab[childPrefixCode].root.number) {
            tree = treeTab[upIndex];
            treeTab[upIndex] = treeTab[childPrefixCode];
            treeTab[childPrefixCode] = tree;
            down(childPrefixCode);
        }
    }

    public void up(int downIndex){

        Tree tree;

        if (treeTab[(downIndex-1)/2].root.number > treeTab[downIndex].root.number) {
            tree = treeTab[downIndex];
            treeTab[downIndex] = treeTab[(downIndex-1)/2];
            treeTab[(downIndex-1)/2] = tree;
            up((downIndex-1)/2);
        }
    }

    public void heapConstruct() {

        for (int i = counter/2; i >= 0; i--) {
            down(i);
        }
    }

    public Tree delMin() {
        Tree min = treeTab[0];
        treeTab[0] = treeTab[counter - 1];
        counter--;

        down(0);
        return min;
    }
}
