package graphs.cycle;

import java.util.List;

import graphs.vertex.Vertex;

public class CycleDetection {

	public boolean detectCycle(List<Vertex> graph) {
		boolean hasCycle = false;
		if(graph == null || graph.isEmpty())
			return hasCycle;
		
		for (Vertex vertex : graph) {
			if(vertex.isVisited())
				continue;
			hasCycle = hasCycle || detectCycleUsingDFS(vertex);
		}
		return hasCycle;
	}

	private boolean detectCycleUsingDFS(Vertex vertex) {
		if(vertex == null)
			return false;
		
		vertex.setVisited(true);
		vertex.setBeingVisited(true);
		
		List<Vertex> neighbour = vertex.getNeighbour();
		boolean hasCycle = false;
		if(neighbour == null || neighbour.isEmpty())
			return hasCycle;
		for (Vertex vertexObj : neighbour) {
			if(vertexObj == null)
				continue;
			if(vertexObj.isBeingVisited()) {
				return true;
			}
			if(vertexObj.isVisited())
				continue;
			
			hasCycle = hasCycle || detectCycleUsingDFS(vertexObj) ;
		}
		vertex.setBeingVisited(false);
		return hasCycle;
	}
}
