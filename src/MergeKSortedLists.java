/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
				ListNodeComparator);
		for (int i = 0; i < lists.size(); i++) {
			heap.add(lists.get(i));
		}// 如果k为3的话，for loop做3次， 把3个ListNode放到heap中去

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();// 从heap中poll出之前放入的3个最开头的ListNode
			tail.next = head;// tail后连head
			tail = head;// 每次取heap 中最小的元素放到结果中，再读取该元素的下一个元素放到heap 中
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}

	// comparator
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}
	};
}
