/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return
 * 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author cassie9082
 * 
 */
public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		if (m > n) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for (int i = 1; i < m; i++) {
			head = head.next;// 把head移到m的前一位
		}
		ListNode mNode = head.next;// 在m处的一个指针，不移动，为方便之后反转后连到尾部
		ListNode nNode = head.next;// 随reverse移动
		ListNode post = mNode.next;//post指针是为了接着反转后m对应的node

		// 这边reverse移动多少通过m，n位置判断，所以用for loop
		for (int i = m; i < n; i++) {
			ListNode temp = post.next;
			post.next = nNode;
			nNode = post;
			post = temp;
		}
		mNode.next = post;
		head.next = nNode;

		return dummy.next;
	}
}
