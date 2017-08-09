package laiofferClass27;
import java.util.*;

public class FirstNonRepeating {
	//each node is a double linked list node
	// and it contains one distinct character
	static class Node{
		Node prev;
		Node next;
		Character ch;
		
		Node(Character ch){
			this.ch = ch;
		}
	}
	//record the head and tail of the list all the time
	//only the characters appearing just once will be 
	// in the double linked list.
	private Node head;
	private Node tail;
	//for any character, it could be in three state:
	// 1. Not existed yet, it will not be singled Map
	// or repeated Set
	// 2. only exists once, it will be in singled Map
	// and there will be a corresponding node in the list.
	// 3. exist more than once, it will be in the repeated Set.
	// and it will be removed from the list;
	private HashMap<Character, Node> singled;
	private HashSet<Character> repeated;
	
	public FirstNonRepeating(){
		//an example of using sentinel node to eliminate some corner cases
		tail = new Node(null);
		tail.next = tail.prev = tail;
		head = tail;
		singled = new HashMap<Charcater, Node>();
		repeated = new HashSet<Character>();
	}
	public void read(char ch){
		// if the character already exists more than once,
		// we just ignore
		if (repeated.contains(ch)){
			return;
		}
		Node node = singled.get(ch);
		if(node == null){
			//if the characher appears for the first time
			// it should be added to the list and added to 
			// the nonRepeated
			node = new Node(ch);
			append(node);
		} else{
			// if the character is already in the nonRepeated
			//Map, we should remove it from the Map and list,
			// and put it into the repeated Set
			remove(node);
		}
	}
	private void append(Node node){
		singled.put(node.ch,  node);
		tail.next = node;
		node.prev = tail;
		node.next = head;
		tail = tail.next;
	}
	private void remove(Node node){
		//use sentinel node so that some of the 
		// corner cases will be eliminated
		node.prev.next = node.next;
		node.next.prev = node.prev;
		if(node == tail){
			tail = node.prev;
		}
		node.prev = node.next = null;
		repeated.add(node.ch);
		singled.remove(node.ch);
	}
	public Character firstNodeRepeating(){
		//when head == tail, it means there is only
		// the sentinel node in the list
		if (head == tail){
			return null;
		}
		return head.next.ch;
	}
}
