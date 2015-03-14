/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 0 || k == 1) {
			return head;
		}
		// 算出LinkedList的长度
		int length = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		int multi = length / k;
		if (multi == 0) {
			return head;
		}
		// 2个for loop。第一个控制的是有多少段需要reverse。第二个for loop控制每一段里面段reverse
		ListNode preTail = null;
		ListNode preNode = null;
		ListNode curHead = null;
		ListNode curTail = null;
		ListNode nextNode = null;
		cur = head;
		for (int j = 0; j < multi; j++) {
			preNode = null;
			// reverse
			for (int i = 0; i < k; i++) {
				if (cur != null) {
					nextNode = cur.next;// nextNode就相当于temp在ReverseLinkedList.java那题
					cur.next = preNode;
					preNode = cur;
				}
				// 给每一段段第一个node和最后一个node指针，方便反转段时候连起来
				if (i == 0) {
					curTail = cur;
				}
				if (i == (k - 1)) {
					curHead = cur;
				}
				cur = nextNode;
			}
			// 整个list的头，因为preTail还是null
			if (preTail == null) {
				head = curHead;
			} else {
				preTail.next = curHead; // 需要把反转后的头接上之前的尾，不用管反转后的尾，下次会被考虑
				preTail = curTail;
			}
		}
		// 当需要反转当全部反转完后，把最后当尾巴连上还剩下的node
		curTail.next = cur;
		return head;
	}
}
