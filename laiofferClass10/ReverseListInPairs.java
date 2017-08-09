package laiofferClass10;

import laiofferClass3.ListNode;

public class ReverseListInPairs {
	//Method 1: recursion
	public ListNode reverseInPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = head.next;
		head.next = reverseInPairs(head.next.next);
		newHead.next = head;
		return newHead;
	}
	
	// method 2: iterative.
	public ListNode reverseInPairsI(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null){
			ListNode next = cur.next.next;
			cur.next.next = cur.next.next.next;
			next.next = cur.next;
			cur.next = next;
			cur = cur.next.next;
		}
		return dummy.next;
	}

}
