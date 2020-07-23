package graphs.operation;

import java.util.List;

public interface GraphTraversal<Vertex> {

	public void traverse(List<Vertex> vertex);
	
	public default void traverseRecusrively(List<Vertex> vertexList) {
		return;
	}
}
