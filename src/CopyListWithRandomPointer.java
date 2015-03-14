/**
 * Copy List with Random Pointer (4/29) A linked list is given such that each
 * node contains an additional random pointer which could point to any node in
 * the list or null. Return a deep copy of the list.
 * http://blog.csdn.net/fightforyourdream/article/details/16879561
 * http://www.cnblogs.com/lautsie/p/3259724.html
 */

public class CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	/**
	 * 1. 插入拷贝节点 2. 复制random指针 3. 分解至两个独立列表
	 * http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}

	public void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.next = head.next;
			newNode.random = head.random;
			head.next = newNode;
			head = head.next.next;
		}
	}

	public void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}

	public RandomListNode splitList(RandomListNode head) {
		RandomListNode newHead = head.next;
		while (head != null) {
			RandomListNode temp = head.next;
			head.next = temp.next;
			head = head.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}
		return newHead;
	}
}
