package graphs.traverse;

import java.util.Arrays;
import java.util.List;

import graphs.operation.GraphTraversal;
import graphs.operation.impl.BFSTraversal;
import graphs.operation.impl.DFSTraversal;
import graphs.vertex.Vertex;

public class GraphBFS {

	public static void main(String[] args) {
		Vertex<Integer> vertex1 = new Vertex<Integer>(1);
		Vertex<Integer> vertex2 = new Vertex<Integer>(2);
		Vertex<Integer> vertex3 = new Vertex<Integer>(3);
		Vertex<Integer> vertex4 = new Vertex<Integer>(4);
		Vertex<Integer> vertex5 = new Vertex<Integer>(5);
		
		vertex1.addEdge(vertex2);
		vertex1.addEdge(vertex4);
		vertex1.addEdge(vertex3);
		vertex2.addEdge(vertex1);
		vertex5.addEdge(vertex2);
		vertex5.addEdge(vertex3);
		vertex4.addEdge(vertex3);
		
		List<Vertex> vertexList = Arrays.asList(vertex1,vertex2, vertex3, vertex4, vertex5);
		
		GraphTraversal<Vertex> graphTraversal = new BFSTraversal();
		graphTraversal.traverse(vertexList);
		
		System.out.println();
		resetGraph(vertexList);
		GraphTraversal<Vertex> graphTraversalNew = new DFSTraversal();
		graphTraversalNew.traverse(vertexList); 
		System.out.println();
		resetGraph(vertexList);
		graphTraversalNew.traverseRecusrively(vertexList);
	}

	private static void resetGraph(List<Vertex> vertexList) {
		vertexList.stream().forEach(vertex -> vertex.setVisited(false));
	}

}
