
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
	
	//LinkedList PRINT method
	public static void LinkedListPrint(ListNode head){
		ListNode point = head;
		while(point != null){
			System.out.print(point.val + ", ");
			point = point.next;
		}
	}
}

class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
}