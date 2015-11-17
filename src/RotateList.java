/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. For example: Given 1->2->3->4->5->NULL and k = 2, return
 * 4->5->1->2->3->NULL.
 */
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}


	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }
        
        ListNode prev = head;
        ListNode curr = head;
        
        int len = 0;
        while(head != null){
            head = head.next;
            len ++;
        }
        k = k % len;
        head = curr;//head重新指回开头
        
        while(curr.next != head || k > 0){
            if(k > 0){
                k --;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
            if(curr.next == null){
                curr.next = head;
            }
        }
        ListNode dummy = prev.next;
        prev.next = null;
        return dummy;
    }
}
