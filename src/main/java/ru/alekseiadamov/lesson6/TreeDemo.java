package ru.alekseiadamov.lesson6;

public class TreeDemo {
    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>(10);
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(62);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        System.out.println("Traverse in order:");
        tree.traverse(Tree.TraverseMode.IN_ORDER);

        System.out.println("Traverse pre-order:");
        tree.traverse(Tree.TraverseMode.PRE_ORDER);

        System.out.println("Traverse post-order:");
        tree.traverse(Tree.TraverseMode.POST_ORDER);

        tree.display();
//        tree.remove(55);
//        tree.remove(42);
//        tree.remove(40);
//        tree.display();
//        tree.remove(43);
//        tree.display();

        System.out.printf("Tree is balanced: %b\n", tree.isBalanced());
        System.out.printf("Tree height is %d.\n", tree.getHeight());
    }
}
