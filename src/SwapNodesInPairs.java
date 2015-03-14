
/**
 * Given a linked list, swap every two adjacent nodes and return its head. For
 * example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your
 * algorithm should use only CONSTANT SPACE. You may not modify the values in
 * the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		ListNode n1 = head; 
		ListNode n2 = head.next;
		
		//这边如果条件写n2.next.next != null，后面的pair没法swap
		while(n2 != null && n2.next != null){
			ListNode temp = n2.next.next;
			n2.next.next = n1.next;
			n1.next = n2.next;
			n2.next = temp;
			n1 = n2;
			n2 = n1.next;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		SwapNodesInPairs list = new SwapNodesInPairs();
		ListNode n1 = list.new ListNode(1);
		ListNode n2 = list.new ListNode(2);
		ListNode n3 = list.new ListNode(3);
		ListNode n4 = list.new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1 = list.swapPairs(n1);
		printList(n1);
	}

	public static void printList(ListNode x) {
		if (x != null) {
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
	}
}
