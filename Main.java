package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File(".\\input.txt");
        Scanner scanner = null;

        String[] tab;
        int number;
        char letter;

        Heap heap = new Heap();

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find the file");
        }

        String regex = "\\s";

        assert scanner != null;
        String line = scanner.nextLine();
        while (scanner.hasNextLine()) {

            tab = scanner.nextLine().split(regex);
            letter = tab[0].charAt(0);
            number = Integer.parseInt(tab[1]);

            heap.treeTab[heap.counter] = new Tree(letter,number); // counter = 0 na początku
            heap.counter++;
            heap.up(heap.counter-1);
        }

        heap.heapConstruct();

        while (heap.counter > 1){
            Tree tree = new Tree(heap.delMin(), heap.delMin());
            heap.treeTab[heap.counter] = tree;
            heap.counter++;
            heap.up(heap.counter-1);
        }

        heap.treeTab[0].createPrefix();
    }
}