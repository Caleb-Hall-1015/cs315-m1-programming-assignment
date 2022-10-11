/*
 * Caleb Hall
 * 10/10/2022
 * https://github.com/kevin-wayne/algs4/blob/master/src/main/java/edu/princeton/cs/algs4/Stack.java
 * https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/DLList.java
 * 
 * Stack(): void - constructor to make empty queue
 * isEmpty(): boolean - returns true if stack is empty, false if not
 * size(): int - returns number of elements in the stack
 * push(E): void - adds new node to top of the stack with info from the parameter
 * pop(): E - gives info from top element, and removes it from the stack
 * peek(): E - returns info of top element
 * toString(): String - returns string containing info of all elements, starting from the top element 
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> 
{
    private Node top;
    private int size;

    private class Node 
    {
        private E item;
        private Node next;
    }
    
    public Iterator<E> iterator() 
    {
        return new LinkedIterator(top);
    }
    
    private class LinkedIterator implements Iterator<E> 
    {
        private Node current;

        public LinkedIterator(Node first) 
        {
            current = first;
        }

        public boolean hasNext() 
        {
            return current != null;
        }

        public E next() 
        {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    public Stack() 
    {
        top = null;
        size = 0;
    }

    public boolean isEmpty() 
    {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void push(E item) 
    {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E pop() 
    {
    	if (top == null)
    	{
    		return null;
    	}
        E item = top.item;
        top = top.next;
        size--;
        return item;
    }


    public E peek() 
    {
    	if (top == null)
    	{
    		return null;
    	}
        return top.item;
    }
    
    public String toString()
	{
		Node cur = top;
		String s = new String();
		while (cur != null)
		{
			s += cur.item + " ";
			cur = cur.next;
		}
		return s;
	}
}