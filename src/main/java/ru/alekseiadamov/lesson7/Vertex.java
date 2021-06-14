package ru.alekseiadamov.lesson7;

public class Vertex {
    private final String label;
    private boolean visited;
    private Vertex predecessor;

    public Vertex(String label) {
        this.label = label;
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }
}
