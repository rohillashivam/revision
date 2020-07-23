package linked.problems.ibit;

public class MergeLists {

	public static void main(String[] args) {
		Integer arr[] = {12 , 22 , 27 , 29 , 38 , 41 , 45 , 75 , 75 , 87 , 99 , 109 , 113 , 142 , 177 , 188 , 191 , 204 , 205 , 228 , 271 , 284 , 286 , 291 , 300 , 308 , 310 , 326 , 327 , 337 , 352 , 364 , 372 , 382 , 384 , 389 , 405 , 427 , 465 , 483 , 496 , 505 , 508 , 508 , 515 , 519 , 524 , 532 , 536 , 555 , 561 , 588 , 588 , 626 , 635 , 662 , 671 , 671 , 674 , 692 , 696 , 698 , 706 , 717 , 732 , 741 , 744 , 753 , 759 , 779 , 786 , 792 , 804 , 811 , 819 , 821 , 835 , 848 , 860 , 860 , 864 , 864 , 868 , 872 , 874 , 880 , 909 , 913 , 915 , 929 , 929 , 958 , 990};
		Integer arr1[] = {7 , 12 , 46 , 66 , 84 , 86 , 93 , 116 , 131 , 132 , 179 , 222 , 230 , 238 , 246 , 253 , 254 , 256 , 290 , 301 , 357 , 372 , 375 , 391 , 395 , 396 , 402 , 424 , 439 , 494 , 508 , 535 , 554 , 592 , 593 , 612 , 629 , 711 , 719 , 721 , 731 , 738 , 746 , 758 , 768 , 769 , 780 , 782 , 831 , 835 , 837 , 873 , 874 , 882 , 907 , 936 , 960 , 970 , 982 , 987 , 990};
		ListNode headA = buildList(arr);
		ListNode headB = buildList(arr1);
		ListNode headData = mergeLists(headA, headB);
		System.out.println(sizeOfList(headData));
		System.out.println("A");
	}

	private static int sizeOfList(ListNode headData) {
		int count=0;
		ListNode node = headData;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	private static ListNode mergeLists(ListNode headA, ListNode headB) {
		ListNode headNew = null;
		ListNode nodeNew = headNew;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null && nodeB != null) {
            /*if(nodeA == null && nodeB != null) {
                nodeNew.next = new ListNode(nodeB.val);
                nodeB = nodeB.next;
                nodeNew = nodeNew.next;
                continue;
            }
            if(nodeB == null && nodeA != null) {
            	nodeNew.next = new ListNode(nodeA.val);
                nodeA = nodeA.next;
                nodeNew = nodeNew.next;
                continue;
            }*/
            
            if(nodeA.val < nodeB.val) {
                if(headNew == null) {
                	nodeNew = new ListNode(nodeA.val);
                	headNew = nodeNew;
                } else {
                	nodeNew.next = new ListNode(nodeA.val);
                	nodeNew = nodeNew.next;
                }
                nodeA = nodeA.next;
            } else {
                if(headNew == null) {
                	nodeNew = new ListNode(nodeB.val);
                    headNew = nodeNew;
                } else {
                	nodeNew.next = new ListNode(nodeB.val);
                	nodeNew = nodeNew.next;
                }
                nodeB = nodeB.next;
            }
            
        }
        if(nodeA == null) {
        	nodeNew.next = nodeB;
        } else {
        	nodeNew.next = nodeA;
        }
        return headNew;
	}

	private static ListNode buildList(Integer[] arr) {
		ListNode head = null;
		for (int i=arr.length-1; i>=0; i--) {
			ListNode node = new ListNode(arr[i]);
			if(head == null) 
				head = node;
			else {
				node.next = head;
				head = node;
			}
		}
		return head;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
