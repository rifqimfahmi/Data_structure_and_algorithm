import java.util.*;

public class GraphSimulation {

    private static class Graph {

        private int size;
        private LinkedList<Integer>[] nodes;

        Graph(int size) {
            this.size = size;
            nodes = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int dest) {
            nodes[source].add(dest);
        }

        LinkedList<Integer> getNode(int source) {
            return nodes[source];
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);


//        for (int i = 0; i < 4; i++) {
//
//        }
        boolean[] dfsTrack = new boolean[4];
        dfs(2, graph, dfsTrack);
        System.out.println();

        boolean[] bfsTrack = new boolean[4];
        bfs(2, graph, bfsTrack);
     }

    private static void bfs(int n, Graph graph, boolean[] isVisited) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!isVisited[node]) {
                isVisited[node] = true;
                System.out.print(node + " ");
                LinkedList<Integer> adj = graph.getNode(node);
                q.addAll(adj);
            }
        }

    }

    private static void dfs(int node, Graph graph, boolean[] isVisited) {
        if (isVisited[node]) return;
        System.out.print(node + " ");
        isVisited[node] = true;
        LinkedList<Integer> adj = graph.getNode(node);
        for (Integer integer : adj) {
            dfs(integer, graph, isVisited);
        }
    }
}
