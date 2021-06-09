package ru.alekseiadamov.lesson6;

import java.util.ArrayList;
import java.util.Random;

public class TreeBalanceCheckDemo {
    private static final Random RANDOM = new Random();
    private static final int NUM_OF_TREES = 20;
    private static final int MAX_HEIGHT = 6;

    public static void main(String[] args) {

        for (int height = 2; height <= MAX_HEIGHT; height++) {
            double avgPercentage = getAvgPercentageForHeight(height);
            System.out.printf("Average percentage of balanced trees for the maximum height of %d is %.2f.\n", height, avgPercentage);
        }

//        Result:
//        Average percentage of balanced trees for the maximum height of 2 is 100,00.
//        Average percentage of balanced trees for the maximum height of 3 is 96,19.
//        Average percentage of balanced trees for the maximum height of 4 is 71,04.
//        Average percentage of balanced trees for the maximum height of 5 is 19,36.
//        Average percentage of balanced trees for the maximum height of 6 is 0,49.

    }

    private static double getAvgPercentageForHeight(int height) {
        ArrayList<Double> percentages = new ArrayList<>();

        for (int tryCount = 0; tryCount < 10000; tryCount++) {
            ArrayList<TreeImpl<Integer>> trees = generateTrees(height);

            int numOfBalancedTrees = trees.stream().mapToInt(e -> (e.isBalanced() ? 1 : 0)).sum();

            double percentage = (double) numOfBalancedTrees / NUM_OF_TREES * 100;
            percentages.add(percentage);
        }
        return percentages.stream().mapToDouble(e -> e).average().orElse(0);
    }

    private static ArrayList<TreeImpl<Integer>> generateTrees(int maxHeight) {
        ArrayList<TreeImpl<Integer>> trees = new ArrayList<>();
        for (int i = 0; i < NUM_OF_TREES; i++) {
            trees.add(getTree(maxHeight));
        }
        return trees;
    }

    private static TreeImpl<Integer> getTree(int maxHeight) {
        TreeImpl<Integer> tree = new TreeImpl<>(maxHeight);

        double maxNumOfNodes = Math.pow(2, MAX_HEIGHT) - 1;
        int low = -100;
        int high = 100;
        for (int j = 0; j < maxNumOfNodes; j++) {
            int newNumber = RANDOM.nextInt(high - low) + low;
            tree.add(newNumber);
        }
        return tree;
    }
}
