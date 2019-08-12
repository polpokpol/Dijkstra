class Main{
    public static void main(String[] args) {
        
        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");

        vertex0.addNeighbor(new Edge(1, vertex0, vertex1));
        vertex0.addNeighbor(new Edge(3, vertex0, vertex2));
        vertex1.addNeighbor(new Edge(1, vertex1, vertex2));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePaths(vertex0);

        System.out.println(dijkstra.getShortestPathTo(vertex2));
    }
}