package graphs.operation.impl;

import java.util.List;
import java.util.Stack;

import graphs.operation.GraphTraversal;
import graphs.vertex.Vertex;

public class DFSTraversal implements GraphTraversal<Vertex> {

	@Override
	public void traverse(List<Vertex> vertexList) {
		if (vertexList == null || vertexList.isEmpty())
			return;

		Stack<Vertex> vertexStack = new Stack<>();
		for (Vertex vertex : vertexList) {
			if(!vertex.isVisited())
				vertexStack.push(vertex);
			while (!vertexStack.isEmpty()) {
				Vertex vertextData = vertexStack.pop();
				List<Vertex> neighbourList = vertextData.getNeighbour();
				vertextData.setVisited(true);

				if (neighbourList != null && !neighbourList.isEmpty()) {
					for (Vertex vertexObj : neighbourList) {
						if (vertexObj == null)
							continue;
						if (!vertexObj.isVisited())
							vertexStack.push(vertexObj);
					}
				}
				System.out.print(vertextData.getData() + " ");
			}
		}

	}

	@Override
	public void traverseRecusrively(List<Vertex> vertexList) {
		if(vertexList == null || vertexList.isEmpty())
			return;
		
		for (Vertex vertex : vertexList) {
			if(!vertex.isVisited())
				traverseRecusrively(vertex);
		}
		
	}

	private void traverseRecusrively(Vertex vertex) {
		if (vertex == null)
			return;

		if (vertex.isVisited())
			return;
		List<Vertex> neighbourList = vertex.getNeighbour();
		vertex.setVisited(true);

		if (neighbourList != null && !neighbourList.isEmpty()) {
			for (Vertex vertexObj : neighbourList) {
				if (vertexObj == null)
					continue;
				traverseRecusrively(vertexObj);
			}
		}
		System.out.print(vertex.getData() + " ");
	}
}
