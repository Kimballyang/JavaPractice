package laiofferClass3;
import java.util.*;

public class PartitionList {
	public ListNode partition(ListNode head, int target){
		if (head == null || head.next == null){
			return head;
		}
		ListNode small= new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode curSmall =small;
		ListNode curLarge = large;
		while (head !=null){
			if (head.value <target){
				curSmall.next = head;
				curSmall = curSmall.next;
			}else {
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		//connect the two partition
		curSmall.next = large.next;
		//un-link the last node in large partition
		curLarge.next =null;
		return small.next;
	}
	

}
