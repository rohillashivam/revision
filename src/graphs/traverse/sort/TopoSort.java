package graphs.traverse.sort;

import java.util.List;
import java.util.Stack;

import graphs.vertex.Vertex;

public class TopoSort {

	private Stack<Vertex> vertexStack = new Stack<>();

	public void sort(Vertex vertex) {
		if(vertex == null)
			return;
		vertex.setVisited(true);

		List<Vertex> vertexList = vertex.getNeighbour();
		if (vertexList != null && !vertexList.isEmpty()) {
			for (Vertex vertexObj : vertexList) {
				if (!vertexObj.isVisited()) {
					sort(vertexObj);
				}
			}
		}
		vertexStack.push(vertex);
	}

	public Stack<Vertex> getStack() {
		return this.vertexStack;
	}

}
