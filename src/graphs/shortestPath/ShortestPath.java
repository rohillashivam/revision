package graphs.shortestPath;

import java.util.List;

import graphs.vertex.VertexWithWeightDistance;

public interface ShortestPath {

	public void findShortestPath(List<VertexWithWeightDistance> graph, VertexWithWeightDistance startVertex);
	
	
}
