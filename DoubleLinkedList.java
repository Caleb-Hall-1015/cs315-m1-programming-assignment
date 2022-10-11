/*
 * Caleb Hall
 * 10/10/2022
 * https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/DLList.java
 * 
 * +DoubleLinkedList(): void - constructor
 * +getAt(int): E - gets info from node at index of input
 * +deleteAt(int): E - gets info from node at index of input and deletes that node
 * +addToHead(E): void - adds new node as head of list with info from parameter
 * +addToTail(E): void - adds a new node to the tail
 * +addAt(int, E): void - adds node with info from parameter at the index passed in
 * +printFwd(): void - prints info in forward order starting at head
 * +printRev(): void - prints info from all elements starting at tail and continuing backwards through list
 * +isEmpty(): boolean - returns true if list is empty, false otherwise
 */

public class DoubleLinkedList<E> implements List<E>
{
	private Node head;
	private Node tail;
	
	private class Node 
	{
		E info;
		Node next;
		Node prev;
	}
	
	public DoubleLinkedList()
	{
		head = null;
		tail = null;
	}
	
	public E getAt(int loc)
	{
		Node cur = head;
		
		for (int i = 0; i < loc; i++) {
			if (cur.next == null) 
				return null;
			cur = cur.next;
		}
		return cur.info;
	}

	public E deleteAt(int loc)
	{
		Node cur = head;
		
		for (int i = 0; i < loc; i++) 
		{
			if (cur == null)
				return null;
			cur = cur.next;
		}
		
		E item = cur.info;
		
		if (cur == head && cur == tail) 
		{ 
			head = null;
			tail = null;
		} else if (cur == head) 
		{ 
			head = head.next;
			head.prev = null;
		} else if (cur == tail) 
		{ 
			tail = tail.prev;
			tail.next = null;
		} else 
		{
			Node prevNode = cur.prev;
			Node nextNode = cur.next;				
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}				

		return item;
	}

	public void addToHead(E item)
	{
		Node newNode = new Node();
		newNode.info = item;
		newNode.prev = null;
		
		if (head == null)
		{
			newNode.next = null;
			head = newNode;
			tail = newNode;
		} else
		{
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	public void addToTail(E item)
	{
		Node newNode = new Node();
		newNode.info = item;
		newNode.next = null;
		
		if (tail == null)
		{
			head = newNode;
			tail = newNode;
			newNode.prev = null;
		} else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		
	}

	public void addAt(int loc, E item)
	{
		if (loc <= 0 || head == null) 
		{
			addToHead(item);
			return;
		}

		Node cur = head;
		for (int i=0; i < (loc-1); i++) 
		{
			if (cur.next == null) 
				break;
			cur = cur.next;
		}

		if (cur == tail) 
		{
			addToTail(item);
		} else 
		{
			Node newNode = new Node();
			newNode.info = item;
			newNode.next = cur.next;
			newNode.prev = cur;
			
			newNode.prev.next = newNode;
			newNode.next.prev = newNode;
		}
	}

	public void printFwd()
	{
		Node cur = head;
		while (cur != null) 
		{
			System.out.print(cur.info + " ");
			cur = cur.next;
		}
	}

	public void printRev()
	{
		Node cur = tail;
		while (cur != null) 
		{
			System.out.print(cur.info + " ");
			cur = cur.prev;
		}
	}

	public boolean isEmpty()
	{
		if (head == null)
		{
			return true;
		}
		return false;
	}
}