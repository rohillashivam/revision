package linked.node;

public class DoublyLinkedNode {

	private int value;
	private DoublyLinkedNode next;
	private DoublyLinkedNode prev;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public DoublyLinkedNode getNext() {
		return next;
	}
	public void setNext(DoublyLinkedNode next) {
		this.next = next;
	}
	public DoublyLinkedNode getPrev() {
		return prev;
	}
	public void setPrev(DoublyLinkedNode prev) {
		this.prev = prev;
	}
	
}
