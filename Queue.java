/*
 * Caleb Hall
 * 10/10/2022
 * https://github.com/kevin-wayne/algs4/blob/master/src/main/java/edu/princeton/cs/algs4/Queue.java
 * https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/DLList.java
 * 
 * +iterator(): Iterator<E> - creates iterator to move through list
 * +Queue(): void - constructor that creates empty queue
 * +enqueue(E): void - adds new node the the end of the queue with info from parameter
 * +dequeue(): E - removes node from start of queue and returns its info
 * +isEmpty(): boolean - returns true if no items in list, false otherwise
 * +size(): int - returns number of elements in list
 * +toString(): String - returns string containing the info from all elements
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E>
{
	private int size;
	private Node head;
	private Node tail;
	
	private class Node
	{
        private E item;
        private Node next;
    }
	
	public Iterator<E> iterator()  
	{
        return new LinkedIterator(head);
    }
	
	private class LinkedIterator implements Iterator<E> 
	{
        private Node current;

        public LinkedIterator(Node first) {
            current = first;
        }

        public boolean hasNext()  
        { 
        	return current != null;
        }

        public E next() 
        {
            if (!hasNext()) 
            	throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }
    }
	
	public Queue()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(E item)
	{
		Node newNode = new Node();
		newNode.item = item;
		if (head == null)
		{
			head = newNode;
		} else
		{
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}
	
	public E dequeue()
	{
		if (isEmpty())
		{
			return null;
		}
        E item = head.item;
        head = head.next;
        size--;
        if (isEmpty())
        {
        	tail = null;
        }
        return item;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		Node cur = head;
		String s = new String();
		while (cur != null)
		{
			s += cur.item + " ";
			cur = cur.next;
		}
		return s;
	}
}