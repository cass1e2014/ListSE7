
/**
 * Given a linked list, determine if it has a cycle in it. Follow up: Can you
 * solve it without using extra space?
 * slow和fast两个指针，slow走一步，fast走两步，如果slow和fast相遇则有环
 * 
 * Time O(N), Space O(1)
 * 
 * @author cassie9082
 * 
 */
public class LinkedListCycle {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
