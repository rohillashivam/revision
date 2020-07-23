package linked.problems;

public class DeleteDuplicates {

	public static void main(String[] args) {
		//LinkedNode node = new LinkedNode(1, new LinkedNode(1, new LinkedNode(1, new LinkedNode(2, null))));
		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(2);
		//ListNode node = new ListNode(1);
		DeleteDuplicates dd = new DeleteDuplicates();
		node = dd.deleteDuplicates(node);
		dd.printList(node);
	}
	
	private void printList(ListNode node) {
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public ListNode deleteDuplicates(ListNode list) {
		if(list == null)
            return list;
        ListNode prev = null, prepPrev=null;
        ListNode temp = list;
        while(temp != null) {
            if(temp.next != null && temp.val == temp.next.val) {
                while(temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                if(prev == null) {
                    System.out.println("lust :: "+list.val);
                    list = temp;
                    System.out.println("lust is null :: "+list == null);
                } else {
                    prev.next = temp;
                }
            } else {
            	prev = temp;
                temp = temp.next;
            }
                
        }
        
        return list;
    }
}
