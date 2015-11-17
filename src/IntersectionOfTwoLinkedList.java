/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author cassie9082
 *
 */
public class IntersectionOfTwoLinkedList {
	//calculate the length of the list
	//move the head of the longer list by(lenA - lenB) steps
	//Then compare node of the two lists
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lenA = 0, lenB = 0;
        while(pointerA != null){
            pointerA = pointerA.next;
            lenA++;
        }
        
        while(pointerB != null){
            pointerB = pointerB.next;
            lenB++;
        }
        
        pointerA = headA;
        pointerB = headB;
        for(int i = 0; i < Math.abs(lenA - lenB); i++){
            if(lenA > lenB){
                pointerA = pointerA.next;
            }else{
                pointerB = pointerB.next;
            }
        }
        
        while(pointerA != pointerB){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }
}
