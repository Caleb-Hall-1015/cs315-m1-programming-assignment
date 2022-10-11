/*
 * Caleb Hall
 * 10/10/2022
 * https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/List.java
 * 
 * interface implemented by DoubleLinkedList
 */

public interface List<E> 
{
	public E getAt(int loc);

	public E deleteAt(int loc);

	public void addToHead(E item);

	public void addToTail(E item);

	public void addAt(int loc, E item);

	public void printFwd();

	public void printRev();

	public boolean isEmpty();
	
}