package laiofferClass3;

public class ReverseLinkedList {
	public ListNode reverseLinkedList(ListNode head){
		ListNode prev = null;
		while (head != null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
		
	}
	
	public ListNode reverseLinkedListI(ListNode head){
		// be careful about the base case,
		// need to make sure the later head.next.next != null
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = reverseLinkedListI(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}
