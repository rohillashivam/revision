package linked.node;

public class LinkedNode {
	private int value;
	private LinkedNode down;
	private LinkedNode next;
	
	public LinkedNode(int value, LinkedNode next) {
		super();
		this.value = value;
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LinkedNode getNext() {
		return next;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	public LinkedNode getDown() {
		return down;
	}
	public void setDown(LinkedNode down) {
		this.down = down;
	}
	
}
