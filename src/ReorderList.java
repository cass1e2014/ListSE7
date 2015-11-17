/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author cassie9082
 * 
 */
public class ReorderList {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 1. find middle 2. reverse 3. merge
	 * 
	 * @param head
	 */
	public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
       
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firsthalf = head;
        ListNode secondhalf = slow.next;
        slow.next = null;
        secondhalf = reverse(secondhalf);
        
        while(secondhalf != null){
            ListNode tmp1 = firsthalf.next;
            ListNode tmp2 = secondhalf.next;
            
            firsthalf.next = secondhalf;
            secondhalf.next = tmp1;
            
            firsthalf = tmp1;
            secondhalf = tmp2;
        }
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode newHead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        curr.next = null;
        return newHead;
    }
}
