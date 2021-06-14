package ru.alekseiadamov.lesson7;

import ru.alekseiadamov.lesson7.core.Graph;

import java.util.*;

/**
 * Implementation of the {@link Graph} interface.
 */
public class GraphImpl implements Graph {
    private final List<Vertex> vertices;
    private final boolean[][] adjacencyMatrix;

    /**
     * Class constructor.
     *
     * @param maxVertexNum Maximum number of vertices.
     */
    public GraphImpl(int maxVertexNum) {
        this.vertices = new ArrayList<>();
        adjacencyMatrix = new boolean[maxVertexNum][maxVertexNum];
    }

    /**
     * @param label Vertex label.
     * @return The index of the vertex with the specified label.
     */
    private int indexOf(String label) {
        for (int i = 0, verticesSize = vertices.size(); i < verticesSize; i++) {
            Vertex vertex = vertices.get(i);
            if (vertex.getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    /**
     * Adds edges between the first and the second, and the first and the other specified vertices.
     *
     * @param firstLabel First vertex label.
     * @param secondLabel Second vertex label.
     * @param otherLabels Other vertices labels.
     * @return True if all the edges are added, otherwise false.
     */
    @Override
    public boolean addEdge(String firstLabel, String secondLabel, String... otherLabels) {
        boolean result = addEdge(firstLabel, secondLabel);
        for (String label : otherLabels) {
            result &= addEdge(firstLabel, label);
        }
        return result;
    }

    /**
     * Adds an edge between specified vertices.
     *
     * @param firstLabel First vertex label.
     * @param secondLabel Second vertex label.
     * @return True if the edge is added, otherwise false.
     */
    private boolean addEdge(String firstLabel, String secondLabel) {
        final int firstIndex = indexOf(firstLabel);
        final int secondIndex = indexOf(secondLabel);
        if (firstIndex == -1 || secondIndex == -1) {
            return false;
        }
        adjacencyMatrix[firstIndex][secondIndex] = true;
        adjacencyMatrix[secondIndex][firstIndex] = true;
        return true;
    }

    /**
     * @return Number of vertices in the graph.
     */
    @Override
    public int getSize() {
        return vertices.size();
    }

    /**
     * Prints the content of the graph.
     */
    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertices.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjacencyMatrix[j][i]) {
                    System.out.print(" -> " + vertices.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the graph vertices in a depth-first manner.
     *
     * @param startLabel Start vertex label.
     */
    @Override
    public void dfs(String startLabel) {
        final int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        final Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertices.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getUnvisitedNeighbourVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    /**
     * Resets all the graph's vertices 'visited' flag.
     */
    private void resetVertexState() {
        for (Vertex vertex : vertices) {
            vertex.setVisited(false);
        }
    }

    /**
     * @param currentVertex Current vertex.
     * @return Current vertex's unvisited neighbour.
     */
    private Vertex getUnvisitedNeighbourVertex(Vertex currentVertex) {
        final int currentIndex = vertices.indexOf(currentVertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjacencyMatrix[currentIndex][i] && !vertices.get(i).isVisited()) {
                return vertices.get(i);
            }
        }
        return null;
    }

    /**
     * Visits the current vertex in the {@link #dfs(String)} algorithm.
     *
     * @param stack Vertex stack.
     * @param vertex Current vertex.
     */
    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
    }

    /**
     * Visits the current vertex in the {@link #bfs(String)} and {@link #bfs(String, String)} algorithm.
     *
     * @param queue Vertex queue.
     * @param vertex Current vertex.
     */
    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        queue.add(vertex);
        vertex.setVisited(true);
    }

    /**
     * Prints the graph vertices in a breadth-first manner.
     *
     * @param startLabel Start vertex label.
     */
    @Override
    public void bfs(String startLabel) {
        final int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        final Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertices.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getUnvisitedNeighbourVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
    }

    /**
     * Finds and prints the shortest way from the start vertex to the end vertex.
     *
     * @param startLabel Start vertex label.
     * @param endLabel End vertex label.
     */
    public void bfs(String startLabel, String endLabel) {
        final int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        final Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertices.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            Vertex predecessor = queue.peek();
            vertex = getUnvisitedNeighbourVertex(predecessor);
            if (vertex != null) {
                vertex.setPredecessor(predecessor);
                if (vertex.getLabel().equals(endLabel)) {
                    resetVertexState();

                    printShortestPath(startLabel, vertex);
                    return;
                }
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
        System.out.printf("There is no way between %s and %s.\n", startLabel, endLabel);
    }

    /**
     * Prints the shortest way from the start vertex to the end vertex.
     *
     * @param startLabel Start vertex label.
     * @param endVertex Found end vertex.
     */
    private void printShortestPath(String startLabel, Vertex endVertex) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(endVertex);
        Vertex pathPredecessor = endVertex.getPredecessor();
        while (pathPredecessor != null) {
            stack.push(pathPredecessor);
            pathPredecessor = pathPredecessor.getPredecessor();
        }
        System.out.printf("The shortest way from %s to %s is %d steps:\n", startLabel, endVertex.getLabel(), stack.size() - 1);
        System.out.print(stack.pop());
        while (!stack.isEmpty()) {
            System.out.print(" -> " + stack.pop());
        }
        System.out.println();
    }
}
