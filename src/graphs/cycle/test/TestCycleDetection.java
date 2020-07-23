package graphs.cycle.test;

import java.util.ArrayList;
import java.util.List;

import graphs.cycle.CycleDetection;
import graphs.vertex.Vertex;

public class TestCycleDetection {

	public static void main(String[] args) {
		List<Vertex> graph = createVertices();
		addEdges(graph);
		CycleDetection detectCycle = new CycleDetection();
		boolean isCyclePresent = detectCycle.detectCycle(graph);
		System.out.println("is cycle :: "+isCyclePresent);
		System.out.println("==============================");
		graph.clear();
		graph = createVertices();
		addEdgesWithoutCycle(graph);
		isCyclePresent = detectCycle.detectCycle(graph);
		System.out.println("is cycle :: "+isCyclePresent);
	}

	private static void addEdgesWithoutCycle(List<Vertex> graph) {
		graph.get(0).addEdge(graph.get(1));
		graph.get(1).addEdge(graph.get(2));
		graph.get(2).addEdge(graph.get(3));
		graph.get(3).addEdge(graph.get(5));
		graph.get(5).addEdge(graph.get(4));
	}

	private static void addEdges(List<Vertex> graph) {
		graph.get(0).addEdge(graph.get(1));
		graph.get(1).addEdge(graph.get(2));
		graph.get(2).addEdge(graph.get(0));
		graph.get(1).addEdge(graph.get(3));
		graph.get(3).addEdge(graph.get(4));
		graph.get(3).addEdge(graph.get(5));
	}

	private static List<Vertex> createVertices() {
		List<Vertex> graph = new ArrayList<>();
		
		graph.add(new Vertex(1));
		graph.add(new Vertex(2));
		graph.add(new Vertex(5));
		graph.add(new Vertex(4));
		graph.add(new Vertex(9));
		graph.add(new Vertex(8));
		return graph;
	}
}
