import java.util.List;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author cassie9082
 * 
 */
public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if(head == null){
			return null;
		}
		
		ListNode leftDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy, right = leftDummy;
		while(head != null){
			if(head.val < x){
				left.next = head;
				left = head;
			}else{
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		right.next = null;
		left.next = rightDummy.next;
		return leftDummy.next;
	}
	
	public static void main(String[] args){
        PartitionList pl = new PartitionList();
		ListNode n1 = pl.new ListNode(2);
		ListNode n2 = pl.new ListNode(3);
        ListNode n3 = pl.new ListNode(4);
        ListNode n4 = pl.new ListNode(3);
        ListNode n5 = pl.new ListNode(4);
        ListNode n6 = pl.new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n1 = pl.partition(n1, 4);
        printList(n1);
	}
	
	public static void printList(ListNode node){
		if(node != null){
//			System.out.println(node.val + " ");
			while(node!= null){
				System.out.println(node.val + " ");
				node = node.next;
			}
			System.out.println();
		}
	}
}
