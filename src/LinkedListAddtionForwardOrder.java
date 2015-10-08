
public class LinkedListAddtionForwardOrder {

	public int carry = 0;
	public ListNode newHead = null;
	public ListNode add(ListNode h1, ListNode h2){
		int h1Len = getLength(h1);
		int h2Len = getLength(h2);
		if(h1Len > h2Len){
			int diff = h1Len - h2Len;
			while(diff > 0){
				ListNode n = new ListNode(0);
				n.next = h2;
				h2 = n;
				diff --;
			}
		}
		
		if(h1Len < h2Len){
			int diff = h2Len - h1Len;
			while(diff > 0){
				ListNode n = new ListNode(0);
				n.next = h1;
				h1 = n;
				diff --;
			}
		}
		
		return addBackRecursion(h1, h2);
	}
	
	public ListNode addBackRecursion(ListNode h1, ListNode h2){
		if(h1 == null && h2 == null){
			return null;
		}
		
		addBackRecursion(h1.next, h2.next);
		int a = h1.val + h2.val + carry;
		carry = a / 10;
		a = a % 10;
		ListNode n = new ListNode(a);
		if(newHead == null){
			newHead = n;
		}else{
			n.next = newHead;
			newHead = n;
		}
		
		return newHead;
	}
	
	public int getLength(ListNode head){
		int length = 0;
		while(head != null){
			head = head.next;
			length ++;
		}
		return length;
	}
	
	
	public static void main(String[] args) {
		LinkedListAddtionForwardOrder l = new LinkedListAddtionForwardOrder();
		ListNode h1 = new ListNode(1);
		h1.next= new ListNode(0);
		h1.next.next = new ListNode(0);
		h1.next.next.next = new ListNode(7);
		System.out.print("First Number : ");
		l.display(h1);
		ListNode h2 = new ListNode(9);
		h2.next= new ListNode(3);
		System.out.print("\n Second Number : ");
		l.display(h2);
		ListNode x = l.add(h1, h2);		
		System.out.print("\n Addition : ");
		l.display(x);

	}
	
	public void display(ListNode head){
		ListNode currNode = head;
		while(currNode != null){
			System.out.print("-->" + currNode.val);
			currNode = currNode.next;
		}
	}

}
