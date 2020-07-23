package graphs.shortestPath.dijikstra.test;

import java.util.ArrayList;
import java.util.List;

import graphs.shortestPath.dijikstra.Dijikstra;
import graphs.vertex.VertexWithWeightDistance;

public class DijikstraTest {

	public static void main(String[] args) {
		List<VertexWithWeightDistance> graph = new ArrayList<>();
		addVertices(graph);
		addEdges(graph);
		Dijikstra dijikstra = new Dijikstra();
		dijikstra.findShortestPath(graph, graph.get(0));
	}

	private static void addEdges(List<VertexWithWeightDistance> graph) {
		/*
		graph.get(0).addEdge(graph.get(1), 5);
		graph.get(0).addEdge(graph.get(4), 9);
		graph.get(0).addEdge(graph.get(7), 8);
		graph.get(1).addEdge(graph.get(7), 4);
		graph.get(1).addEdge(graph.get(3), 15);
		graph.get(1).addEdge(graph.get(2), 12);
		graph.get(7).addEdge(graph.get(7), 4);
		*/
		graph.get(0).addEdge(graph.get(1), 10);
		graph.get(0).addEdge(graph.get(2), 15);
		graph.get(1).addEdge(graph.get(3), 12);
		graph.get(1).addEdge(graph.get(5), 15);
		graph.get(2).addEdge(graph.get(4), 10);
		graph.get(3).addEdge(graph.get(5), 1);
		graph.get(3).addEdge(graph.get(4), 2);
		graph.get(4).addEdge(graph.get(3), 5);
	}

	private static void addVertices(List<VertexWithWeightDistance> graph) {
		graph.add(new VertexWithWeightDistance("A"));
		graph.add(new VertexWithWeightDistance("B"));
		graph.add(new VertexWithWeightDistance("C"));
		graph.add(new VertexWithWeightDistance("D"));
		graph.add(new VertexWithWeightDistance("E"));
		graph.add(new VertexWithWeightDistance("F"));
		//graph.add(new VertexWithWeightDistance("G"));
		//graph.add(new VertexWithWeightDistance("H"));
	}

}
