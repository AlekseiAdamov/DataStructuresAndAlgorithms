package ru.alekseiadamov.lesson5;

public class RecursiveKnapsackDemo {
    static Item[] items;

    public static void main(String[] args) {
        int numberOfItems = 5;

        items = new Item[numberOfItems];
        items[0] = new Item("book", 1, 600);
        items[1] = new Item("binoculars", 2, 5000);
        items[2] = new Item("first aid kit", 4, 1500);
        items[3] = new Item("notebook", 2, 40000);
        items[4] = new Item("cauldron", 1, 500);

        int maxWeight = 5;

        System.out.printf("Maximum cost of items with maximum total weight %d kg is %d.\n", maxWeight, maxCost(maxWeight, numberOfItems));

        // Result:
        // Maximum cost of items with maximum total weight 5 kg is 45600.
    }

    private static int maxCost(int maxWeight, int numberOfItems) {
        // Nothing to add or there is no place left.
        if (numberOfItems == 0 || maxWeight == 0) {
            return 0;
        }

        // If the item's weight is more than fits the knapsack, skip the current item and move to the next item.
        int currentIndex = numberOfItems - 1;
        Item currentItem = items[currentIndex];

        @SuppressWarnings("UnnecessaryLocalVariable")
        int itemsLeft = currentIndex; // To explicitly indicate the meaning of the 2nd argument of maxCost().

        if (currentItem.getWeight() > maxWeight) {
            return maxCost(maxWeight, itemsLeft);
        }

        int weightAvailable = maxWeight - currentItem.getWeight();

        int cost1 = currentItem.getCost() + maxCost(weightAvailable, itemsLeft);
        int cost2 = maxCost(maxWeight, itemsLeft);

        return Math.max(cost1, cost2);
    }
}

class Item {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final String name; // To distinguish items.
    private final int weight;
    private final int cost;

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
