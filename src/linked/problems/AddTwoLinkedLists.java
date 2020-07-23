package linked.problems;

public class AddTwoLinkedLists {

	public static void main(String[] args) {
		/*ListNode node = new ListNode(9);
		node.next = new ListNode(9);
		node.next.next = new ListNode(1);
		*/
		ListNode node = new ListNode(1);
		//ListNode node2 = new ListNode(1);
		ListNode node2 = new ListNode(9);
		node2.next = new ListNode(9);
		node2.next.next = new ListNode(9);
		ListNode sumNode = addTwoNumbers(node, node2);
		while(sumNode != null) {
			System.out.print(sumNode.val);
			sumNode = sumNode.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		ListNode head = null, currNode = null;
		int carry = 0;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				int val = list2.val + carry;
				carry = val / 10;
				ListNode node = new ListNode(val % 10);
				if (head == null) {
					head = node;
					currNode = head;
				} else {
					currNode.next = node;
					currNode = node;
				}
				list2 = list2.next;
			} else if (list2 == null) {
				int val = list1.val + carry;
				carry = val / 10;
				ListNode node = new ListNode(val % 10);
				if (head == null) {
					head = node;
					currNode = head;
				} else {
					currNode.next = node;
					currNode = node;
				}
				list1 = list1.next;
			} else {
				int val = list1.val + list2.val + carry;
				carry = val / 10;
				ListNode node = new ListNode(val % 10);
				if (head == null) {
					head = node;
					currNode = head;
				} else {
					currNode.next = node;
					currNode = node;
				}
				list2 = list2.next;
				list1 = list1.next;
			}

		}

		if(carry != 0 ) {
			ListNode node = new ListNode(carry);
			currNode.next = node;
			currNode = node;
		}
			
		return head;
	}

}

class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
}
