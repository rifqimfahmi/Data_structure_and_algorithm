import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GraphSimulationTest {

    private final int GRAPH1_SIZE = 4;
    GraphSimulation.Graph graph = new GraphSimulation.Graph(GRAPH1_SIZE);

    private PrintStream out;

    @BeforeEach
    void before() {
        out = mock(PrintStream.class);
        System.setOut(out);
        init_graph_1_edges();
    }

    private void init_graph_1_edges() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
    }

    @Test
    @DisplayName("Test BFS implementation on graph")
    void bfs() {
        boolean[] bfsTrack = new boolean[4];
        GraphSimulation.bfs(2, graph, bfsTrack);

        verify(out, times(4)).print(anyInt());
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).print(2);
        inOrder.verify(out).print(0);
        inOrder.verify(out).print(3);
        inOrder.verify(out).print(1);
    }

    @Test
    @DisplayName("Test DFS implementation on graph")
    void dfs() {
        boolean[] dfsTrack = new boolean[4];
        GraphSimulation.dfs(2, graph, dfsTrack);

        verify(out, times(4)).print(anyInt());
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).print(2);
        inOrder.verify(out).print(0);
        inOrder.verify(out).print(1);
        inOrder.verify(out).print(3);
    }
}