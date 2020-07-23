package graphs.vertex;

import java.util.LinkedList;
import java.util.List;

public final class Vertex<T> {

	private T data;
	private boolean visited;
	private List<Vertex> neighbour;
	private boolean isBeingVisited;
	
	public Vertex(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public boolean isVisited() {
		return visited;
	}
	public List<Vertex> getNeighbour() {
		return neighbour;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void addEdge(Vertex vertex) {
		if(neighbour == null) {
			neighbour = new LinkedList<Vertex>();
		}
		
		for (Vertex vertexObj : neighbour) {
			if(vertexObj.equals(vertex))
				return;
		}
		neighbour.add(vertex);		
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((neighbour == null) ? 0 : neighbour.hashCode());
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (neighbour == null) {
			if (other.neighbour != null)
				return false;
		} else if (!neighbour.equals(other.neighbour))
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

	public boolean isBeingVisited() {
		return isBeingVisited;
	}

	public void setBeingVisited(boolean isBeingVisited) {
		this.isBeingVisited = isBeingVisited;
	}
	
}
