package ru.alekseiadamov.lesson7;

import ru.alekseiadamov.lesson7.util.City;

public class GraphDemo {

    public static void main(String[] args) {
        findShortestPath();
    }

    private static void findShortestPath() {
        GraphImpl graph = new GraphImpl(10);

        graph.addVertex(City.MOSCOW);
        graph.addVertex(City.TULA);
        graph.addVertex(City.RYAZAN);
        graph.addVertex(City.KALUGA);
        graph.addVertex(City.LIPETSK);
        graph.addVertex(City.TAMBOV);
        graph.addVertex(City.ORYOL);
        graph.addVertex(City.SARATOV);
        graph.addVertex(City.KURSK);
        graph.addVertex(City.VORONEZH);

        graph.addEdge(City.MOSCOW, City.TULA, City.RYAZAN, City.KALUGA);
        graph.addEdge(City.TULA, City.MOSCOW, City.LIPETSK);
        graph.addEdge(City.RYAZAN, City.MOSCOW, City.TAMBOV);
        graph.addEdge(City.KALUGA, City.MOSCOW, City.ORYOL);
        graph.addEdge(City.LIPETSK, City.TULA, City.VORONEZH);
        graph.addEdge(City.TAMBOV, City.RYAZAN, City.SARATOV);
        graph.addEdge(City.ORYOL, City.KALUGA, City.KURSK);
        graph.addEdge(City.SARATOV, City.TAMBOV, City.VORONEZH);
        graph.addEdge(City.ORYOL, City.KURSK, City.VORONEZH);
        graph.addEdge(City.VORONEZH, City.LIPETSK, City.SARATOV, City.KURSK);

        graph.bfs(City.MOSCOW, City.VORONEZH);
        graph.bfs(City.MOSCOW, City.KRASNODAR);

//        Results:
//        The shortest way from Moscow to Voronezh is 3 steps:
//        Vertex{label='Moscow'} -> Vertex{label='Tula'} -> Vertex{label='Lipetsk'} -> Vertex{label='Voronezh'}
//        There is no way between Moscow and Krasnodar.
    }
}
