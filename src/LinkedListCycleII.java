/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. Follow up: Can you solve it without using extra space?
 * 
 * slow 和 fast 同时出发，fast 比 slow 快一倍；当 slow 和 fast 相遇时，启动另一个 slow2 以与 slow
 * 相同的速度从头出发，当 slow2 与 slow 相遇，则是环口。slow 和 fast 同时出发，fast 比 slow 快一倍；当 slow 和
 * fast 相遇时，启动另一个 slow2 以与 slow 相同的速度从头出发，当 slow2 与 slow 相遇，则是环口。
 * 
 * 
 * @author cassie9082
 * 
 *         Time O(N), Space O(1)
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
		if (head == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow2;
			}
		}
		return null;
	}
}

/*
 * 证明：设 
 * x：出发点到环口的距离 
 * a：环口到 slow 和 fast 相遇点的距离 
 * r：环长 
 * 当 slow 和 fast 相遇时， slow 走了 x + a，fast 走了 2x + 2a，
 * 也就是说在环内 slow 走了 a，fast 走了 x + 2a，
 * 可知 a mod r = (x + 2a) mod
 * r (x + a) mod r = 0 
 * x = kr - a 
 * 上式表明当 slow 从 a 出发，此时 slow2 从头出发，
 * 当 slow2 走完 x 到达环口时，slow 也真好到达环口，即它们在环口相遇。
 */
