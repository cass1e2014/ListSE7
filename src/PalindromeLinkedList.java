/*
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {	
	public static boolean isPalindrome(ListNode head){
		if(head == null) return true;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("slow pointer is at " + slow.val);
		
		fast = slow.next;
		ListNode newHead = null;
		while(fast != null){
			ListNode tmp = fast.next;
			fast.next = newHead;
			newHead = fast;
			fast = tmp;
		}
		slow.next = newHead;
		
		while(slow.next != null){
			slow = slow.next;
			System.out.println("head val = " + head.val + ", slow val = " + slow.val);
			if(head.val != slow.val) return false;
			head = head.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node7 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node7;
		node7.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		System.out.println(isPalindrome(node1));
	}

}

