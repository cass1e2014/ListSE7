/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. Follow up: Can you solve it without using extra space?
 * 
 * @author cassie9082
 * 
 */
public class LinkedListCycleII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast == slow){
			return findNode(slow, head);
		}
		return null;
	}
	
	//数学规律。相遇的起始点其中一点一定是head
	public ListNode findNode(ListNode node, ListNode head){
		ListNode out = head;
		while(out != node){
			out = out.next;
			node = node.next;
		}
		return out;
	}
}
