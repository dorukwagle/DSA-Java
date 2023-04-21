package structures.Graphs;

public class App {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("bc");
        graph.addNode("bcd");
        graph.addEdge("A", "bc");
        graph.addEdge("A", "bcd");
        graph.removeEdge("A", "bcd");
        graph.removeNode("A");
        graph.addEdge("bc", "bcd");
        graph.print();
    }
}
