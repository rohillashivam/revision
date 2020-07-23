package graphs.vertex;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class VertexWithWeightDistance<T> {

	private boolean isVisited;
	
	private T data;
	
	private Map<VertexWithWeightDistance, Integer> edgeWeight;
	
	private VertexWithWeightDistance predecessorNode;
	
	private Integer distance;
	
	public VertexWithWeightDistance(T data) {
		this.data = data;
		edgeWeight = new HashMap<>();
		distance = Integer.MAX_VALUE;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public T getData() {
		return data;
	}

	public Map<VertexWithWeightDistance, Integer> getEdgeWeight() {
		return edgeWeight;
	}

	public VertexWithWeightDistance getPredecessorNode() {
		return predecessorNode;
	}

	public void setPredecessorNode(VertexWithWeightDistance predecessorNode) {
		this.predecessorNode = predecessorNode;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public synchronized void addEdge(VertexWithWeightDistance vertexWithWeightDistance, Integer distance) {
		this.edgeWeight.put(vertexWithWeightDistance, distance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((edgeWeight == null) ? 0 : edgeWeight.hashCode());
		result = prime * result + (isVisited ? 1231 : 1237);
		result = prime * result + ((predecessorNode == null) ? 0 : predecessorNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexWithWeightDistance other = (VertexWithWeightDistance) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (edgeWeight == null) {
			if (other.edgeWeight != null)
				return false;
		} else if (!edgeWeight.equals(other.edgeWeight))
			return false;
		if (isVisited != other.isVisited)
			return false;
		return true;
	}
	
	
	
}
