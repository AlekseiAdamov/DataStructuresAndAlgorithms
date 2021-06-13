package ru.alekseiadamov.lesson7.core;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String firstLabel, String secondLabel, String... otherLabels);

    int getSize();

    void display();

    /**
     *  Depth-first search.
     *
     * @param startLabel Start vertex label.
     */
    void dfs(String startLabel);

    /**
     *  Breadth-first search.
     *
     * @param startLabel Start vertex label.
     */
    void bfs(String startLabel);
}
