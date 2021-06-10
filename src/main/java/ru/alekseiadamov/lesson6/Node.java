package ru.alekseiadamov.lesson6;

public class Node<T extends Comparable<? super T>> {

    private final T value;

    private Node<T> leftChild;
    private Node<T> rightChild;
    private int level;


    public Node(T value) {
        this.value = value;
        this.level = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            leftChild.setLevel(level + 1);
        }
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            rightChild.setLevel(level + 1);
        }
    }

    public boolean isLeftChild(T value) {
        return value.compareTo(getValue()) < 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
        return leftChild != null ^ rightChild != null;
    }
}
