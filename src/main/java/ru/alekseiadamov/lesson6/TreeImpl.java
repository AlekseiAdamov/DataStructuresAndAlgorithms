package ru.alekseiadamov.lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    public TreeImpl(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    private int size;
    private Node<E> root;
    private final int maxHeight;


    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null) {
            return false;
        }

        Node<E> previous = nodeAndParent.parent;
        if (previous == null) {
            root = node;
            size++;
            return true;
        }
        if (previous.getLevel() < maxHeight - 1) {
            if (previous.isLeftChild(value)) {
                previous.setLeftChild(node);
            } else {
                previous.setRightChild(node);
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, previous);
            }

            previous = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, previous);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.current;
        Node<E> parentNode = nodeAndParent.parent;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parentNode);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOnlyOneChild(removedNode, parentNode);
        } else {
            removeNodeWithAllChildren(removedNode, parentNode);
        }

        size--;
        return true;
    }

    private void removeNodeWithAllChildren(Node<E> removedNode, Node<E> parentNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
            if (successor != null) {
                successor.setLevel(0);
            }
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(successor);
        } else {
            parentNode.setRightChild(successor);
        }

        if (successor != null) {
            successor.setLeftChild(removedNode.getLeftChild());
            if (successor.getRightChild() != null) {
                successor.getRightChild().setLevel(successor.getLevel() + 1);
            }
        }
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;

    }

    private void removeNodeWithOnlyOneChild(Node<E> removedNode, Node<E> parentNode) {
        Node<E> childNode = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(childNode);
        } else {
            parentNode.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> removedNode, Node<E> parentNode) {
        if (removedNode == root) {
            root = null;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode: " + mode);
        }
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<E> node) {
        return (node == null)
                || (isBalanced(node.getLeftChild())
                && isBalanced(node.getRightChild())
                && Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1);
    }

    private int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public int getHeight() {
        return height(root);
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        printNode(current);
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        printNode(current);
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        printNode(current);
    }

    private void printNode(Node<E> node) {
        System.out.println(node.getValue() + " (" + node.getLevel() + "), is balanced: " + isBalanced(node));
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}