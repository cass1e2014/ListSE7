/**
 * Sort a linked list using insertion sort.
 * @author cassie9082
 *
 */
public class InsertionSortList {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = head;
		
		while(curr != null && curr.next != null){
			if(curr.val > curr.next.val){
				ListNode valueToStore = curr.next;//把比之前小的数存到valueToStore
				ListNode pre = dummy;
				//find position to insert
				while(pre.next.val < valueToStore.val){
					pre = pre.next; //这种情况下不需要insert
				}
				ListNode temp = pre.next;
				pre.next = valueToStore;
				curr.next = valueToStore.next;
				valueToStore.next = temp;
			}else{
				curr = curr.next; //if nodes are in order
			}
		}
		return dummy.next;
	}
	
	
}
