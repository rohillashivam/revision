package graphs.traverse.sort.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graphs.traverse.sort.TopoSort;
import graphs.vertex.Vertex;

public class TopoSortTest {

	public static void main(String[] args) {
		TopoSort topoSort = new TopoSort();
		
		List<Vertex> graph = buildGraph();
		executeSorting(topoSort, graph);
		displaySortedGraph(topoSort.getStack());
		System.out.println("---------------------------");
		graph = buildGraphNew();
		executeSorting(topoSort, graph);
		displaySortedGraph(topoSort.getStack());
	}

	private static List<Vertex> buildGraphNew() {
		List<Vertex> graphNew = new ArrayList<>();
		createVerticesNew(graphNew);
		addEdgesInGraphNew(graphNew);
		return graphNew;
	}

	private static void addEdgesInGraphNew(List<Vertex> graphNew) {
		graphNew.get(0).addEdge(graphNew.get(1));
		graphNew.get(1).addEdge(graphNew.get(2));
		graphNew.get(2).addEdge(graphNew.get(3));
		graphNew.get(3).addEdge(graphNew.get(4));
		graphNew.get(4).addEdge(graphNew.get(5));
		graphNew.get(2).addEdge(graphNew.get(5));
		graphNew.get(5).addEdge(graphNew.get(4));
		graphNew.get(4).addEdge(graphNew.get(2));
	}

	private static void createVerticesNew(List<Vertex> graphNew) {
		graphNew.add(new Vertex("a"));
		graphNew.add(new Vertex("b"));
		graphNew.add(new Vertex("c"));
		graphNew.add(new Vertex("d"));
		graphNew.add(new Vertex("e"));
		graphNew.add(new Vertex("f"));
		//graphNew.add(new Vertex("x"));
		//graphNew.add(new Vertex("y"));
		//graphNew.add(new Vertex("z"));
	}

	private static void displaySortedGraph(Stack<Vertex> stack) {
		if(stack == null)
			return;
		
		while(!stack.isEmpty()) {
			Vertex vertex = stack.pop();
			System.out.println("vertex -- "+vertex.getData());
		}
		System.out.println();
	}

	private static void executeSorting(TopoSort topoSort, List<Vertex> graph) {
		//for (Vertex vertex : graph) {
		for(int i=graph.size() -1; i>=0 ; i--) {
			Vertex vertex = graph.get(i);
			if(!vertex.isVisited())
				topoSort.sort(vertex);
		}
	}

	private static List<Vertex> buildGraph() {
		List<Vertex> graph = new ArrayList<>();
		addVertices(graph);
		addEdgesInGraph(graph);
		return graph;
	}

	private static void addVertices(List<Vertex> graph) {
		graph.add(new Vertex<>(0));
		graph.add(new Vertex<>(1));
		graph.add(new Vertex<>(2));
		graph.add(new Vertex<>(3));
		graph.add(new Vertex<>(4));
		graph.add(new Vertex<>(5));
	}

	private static void addEdgesInGraph(List<Vertex> graph) {
		graph.get(2).addEdge(graph.get(3));
		graph.get(3).addEdge(graph.get(1));
		graph.get(4).addEdge(graph.get(0));
		graph.get(4).addEdge(graph.get(1));
		graph.get(5).addEdge(graph.get(0));
		graph.get(5).addEdge(graph.get(2));
	}

}
