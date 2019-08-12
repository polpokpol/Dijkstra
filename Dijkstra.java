import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra{

    public void computePaths(Vertex sourceVertex){

        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(); // the purpose of this is just to catch
        priorityQueue.add(sourceVertex);

        while(!priorityQueue.isEmpty()){

            Vertex actualVertex = priorityQueue.poll();

            for (Edge edge : actualVertex.getAdjacenciesList()) { // if no edges then it will stop
                
                Vertex v = edge.getTargetVertex();

                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if(newDistance < v.getDistance()){ // vertex's default distance is infinity
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }


    public List<Vertex> getShortestPathTo(Vertex targeVertex){
      
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for (Vertex vertex = targeVertex; vertex != null; vertex=vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }

}