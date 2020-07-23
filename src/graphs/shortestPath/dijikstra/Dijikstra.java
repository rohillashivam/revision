package graphs.shortestPath.dijikstra;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import graphs.shortestPath.ShortestPath;
import graphs.vertex.VertexWithWeightDistance;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Dijikstra implements ShortestPath {

	@Override
	public void findShortestPath(List<VertexWithWeightDistance> graph, VertexWithWeightDistance startVertex) {
		if (!validateGraphAndStart(graph, startVertex))
			return;

		startVertex.setDistance(0);
		findShortestPath(startVertex);
		for (VertexWithWeightDistance vertexWithWeightDistance : graph) {
			if (!vertexWithWeightDistance.isVisited())
				findShortestPath(vertexWithWeightDistance);
		}
		System.out.println("Completed");
	}

	private void findShortestPath(VertexWithWeightDistance startVertex) {
		Queue<VertexWithWeightDistance> queue = new PriorityQueue<>((_vertex1, _vertex2) -> {
			return _vertex1.getDistance().compareTo(_vertex2.getDistance());
		});

		// PredecessorDistanceVertex startPDV = new
		// PredecessorDistanceVertex(startVertex);
		queue.add(startVertex);
		while (!queue.isEmpty()) {
			VertexWithWeightDistance vertex = queue.remove();
			if (vertex.isVisited())
				continue;
			Map<VertexWithWeightDistance, Integer> nodeDistanceMap = vertex.getEdgeWeight();
			for (Map.Entry<VertexWithWeightDistance, Integer> entry : nodeDistanceMap.entrySet()) {
				VertexWithWeightDistance nextVertex = entry.getKey();
				setMinDistancePredecessor(vertex, nodeDistanceMap, nextVertex, entry.getValue());
				queue.add(nextVertex);
			}
			vertex.setVisited(true);
		}
	}

	private void setMinDistancePredecessor(VertexWithWeightDistance vertex,
			Map<VertexWithWeightDistance, Integer> nodeDistanceMap, VertexWithWeightDistance nextVertex,
			Integer distance) {
		if ((Integer.MAX_VALUE == nextVertex.getDistance().intValue())
				|| (nextVertex.getDistance() > distance + vertex.getDistance())) {
			nextVertex.setDistance(distance + vertex.getDistance());
			nextVertex.setPredecessorNode(vertex);
		} else {
			// do nothing
		}
	}

	private boolean validateGraphAndStart(List<VertexWithWeightDistance> graph, VertexWithWeightDistance startVertex) {
		return graph != null && !graph.isEmpty() && startVertex != null && graph.contains(startVertex);
	}

}
