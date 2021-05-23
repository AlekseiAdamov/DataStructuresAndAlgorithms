package lesson2;

import java.text.DecimalFormat;
import java.util.Random;

public class TestSorting {
    private static final int NUM_OF_ELEMENTS = 100_000;

    public static void main(String[] args) {
        ArrayImpl<Integer> dataSortBubble = new ArrayImpl<>(NUM_OF_ELEMENTS);
        Random rand = new Random();
        for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
            dataSortBubble.add(rand.nextInt(NUM_OF_ELEMENTS));
        }
        ArrayImpl<Integer> dataSortSelect = dataSortBubble.copy();
        ArrayImpl<Integer> dataSortInsert = dataSortBubble.copy();

        long dataSortBubbleStart = System.nanoTime();
        dataSortBubble.sortBubble();
        long dataSortBubbleEnd = System.nanoTime();
        long bubbleSortTime = dataSortBubbleEnd - dataSortBubbleStart;

        long dataSortSelectStart = System.nanoTime();
        dataSortSelect.sortSelect();
        long dataSortSelectEnd = System.nanoTime();
        long sortBySelectionTime = dataSortSelectEnd - dataSortSelectStart;

        long dataSortInsertStart = System.nanoTime();
        dataSortInsert.sortInsert();
        long dataSortInsertEnd = System.nanoTime();
        long sortByInsertionTime = dataSortInsertEnd - dataSortInsertStart;

        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        System.out.printf("RESULTS of sorting array of %s elements of type Integer:\n",
                decimalFormat.format(NUM_OF_ELEMENTS));

        System.out.printf("Bubble sort:\t\t%s ns.\n", decimalFormat.format(bubbleSortTime));

        System.out.printf("Sort by selection:\t%s ns.\t%s times faster than bubble sort.\n",
                decimalFormat.format(sortBySelectionTime),
                decimalFormat.format(bubbleSortTime / sortBySelectionTime));

        System.out.printf("Sort by insertion:\t%s ns.\t%s times faster than bubble sort.\n",
                decimalFormat.format(sortByInsertionTime),
                decimalFormat.format(bubbleSortTime / sortByInsertionTime));
    }
}
