package graphs.operation.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import graphs.operation.GraphTraversal;
import graphs.vertex.Vertex;

public class BFSTraversal implements GraphTraversal<Vertex> {

	@Override
	public void traverse(List<Vertex> vertexList) {
		if(vertexList == null || vertexList.isEmpty())
			return;

		Queue<Vertex> queueVertex = new LinkedList<>();

		for (Vertex vertex : vertexList) {
			queueVertex.add(vertex);
			while(!queueVertex.isEmpty()) {
				Vertex vertexObj = queueVertex.remove();
				if(vertexObj == null || vertexObj.isVisited())
					continue;
				System.out.print(vertexObj.getData()+" ");
				vertexObj.setVisited(true);
				List<Vertex> neighbourList = vertexObj.getNeighbour();
				if(neighbourList == null || neighbourList.isEmpty())
					continue;
				neighbourList.stream().filter(_vertex -> Objects.nonNull(_vertex) && !_vertex.isVisited()).forEach(queueVertex::add);
			}
		}
	}

}
