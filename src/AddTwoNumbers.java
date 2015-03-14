/*
 * Add Two Numbers (4/29)
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		}
		ListNode dummy = new ListNode(0);//建一个dummy和指针
		ListNode tail = dummy;
		
		int carry = 0;
		while(l1 != null && l2 != null){
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;//加十进一
			sum = sum % 10;
			tail.next = new ListNode(sum);//sum成为一个新node接在dummy之后，tail指着
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null){
			int sum = l1.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			tail.next = new ListNode(sum);
			tail = tail.next;
			l1 = l1.next;
		}
		
		while(l2 != null){
			int sum = l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			tail.next = new ListNode(sum);
			tail = tail.next;
			l2 = l2.next;
		}
		
		//当l1和l2都过完，还有进位没有处理的时候
		while(carry != 0){
			tail.next = new ListNode(carry);
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);	
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;
		l6.next = null;
		
		ListNode result = addTwoNumbers(l1, l4);
		ListNode.LinkedListPrint(result);
	}

}
