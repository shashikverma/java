package dataStructureExample;

import java.util.NoSuchElementException;

public class LinkedList {

	private class Node 
	{
		private int value;
		private Node next;
		
		Node(int item)
		{
			this.value = item;
		}
	}		

	private Node first;
	private Node last;
	private int size;
	
	private boolean isEmpty()
	{
		return first ==  null;
	}
		
	public void addFirst(int item)
	{
		Node node = new Node(item);
		
		if(isEmpty())
			first = last = node;
		node.next = first;
		first = node;
		size++;
	}

	public void removeFirst()
	{

		Node temp= first;
		
		if(isEmpty())
		{
			System.out.println("List is empty");
			throw new NoSuchElementException();
		}
		else if(temp.next == null)
		{
			first = last = null;
			System.out.println("List is empty after removal");
		}
		else
		{
			first = first.next;
			temp.next = null;
		}
		size--;
	}

	
	public void addLast(int item)
	{
		Node node = new Node(item);
		
		if(isEmpty())
			first = last = node;
		else
		{
			node.next = null;
			last.next = node;
			last = node;
		}
		size++;
	}

	public void removeLast()
	{

		Node temp= last, prev = first;
		
		if(isEmpty())
		{
			System.out.println("List is empty");
			throw new NoSuchElementException();
		}
		
		else if(prev.next == null)
		{
			first = last = null;
			System.out.println("List is empty after removal");
		}
		else
		{
			while(prev.next.next != null)
				prev = prev.next;
			prev.next = null;
			last = prev;
		}
		size--;
	}

	
/*	public void indexOf(int item)
	{
		int index = -1;
		boolean found =  false;
		Node temp = first;
		
		if(temp == null)
			System.out.println("Linked list is empty");
			
		while(temp != null)
		{
			if(temp.value != item)
			{
				index++;
				temp = temp.next;
			}
			else
			{
				index++;
				found = true;
				break;
			}
		}
		
		if(found == true)
			System.out.println("Element present at :" + index);
		else
			System.out.println("Element not present in linked list");
			
	}
*/
	
	public int indexOf(int item)
	{
		int index = 0;
		Node current = first;
		while(current != null)
		{
			if(current.value == item)
				return index;
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(int item)
	{
		return indexOf(item) != -1;
	}
	
/*	public void size()
	{
		int size = 0;
		Node temp = first;
		while(temp != null)
		{
			size++;
			temp = temp.next;
		}
		
		System.out.println("Size of linked list is :" + size);
	} */
	
	public int size()
	{
		return size;
	}
	
	public int[] toArray()
	{
		int[] array = new int[size];
		Node current = first;
		int index = 0;
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}
	
	public void reverseList()
	{
		Node lastReverse = first;
		Node firstReverse, temp;
		//Node temp ;
		
		first = first.next;
		lastReverse.next = null;
		temp = first;
		firstReverse = lastReverse;
		
		while(first != null)
		{
			first = first.next;
			temp.next = firstReverse;
			firstReverse = temp;
			temp = first;
		}
		first = firstReverse;
		last = lastReverse;
		
		
	}
	
	public Node getKthElement(int k)
	{
		Node current = first, prev = null;
		
		//if(k > size)
		//	return -1;
		
		if(isEmpty())
			throw new IllegalStateException();
		
		for(int i=0; i<k -1;i++)
		{
			current = current.next;
			if(current == null)
				throw new IllegalArgumentException();
		}
		prev = first;
		
		while(current != last)
		{
			current = current.next;
			prev = prev.next;
		}
		return prev;
		
		//System.out.println("Kth Element from last is: " + prev.value);
	}
	
	public void getMiddleNode()
	{
		Node slowPtr = first, fastPtr = first;
		
		while(fastPtr != last && fastPtr.next != last)
		{
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		if(fastPtr == last)
			System.out.println("Middle Element is: " + slowPtr.value);
		else
			System.out.println("Middle Element is: " + slowPtr.value + "," + slowPtr.next.value);;
	}
	
	
	public boolean hasLoop()
	{
		Node slowPtr  = first.next, fastPtr = first.next.next;
		
		Node temp = getKthElement(3);
		last.next = temp;
		
		while(slowPtr != fastPtr)
		{
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		if(slowPtr == fastPtr)
			return true;
		else
			return false;
	}
	
	public void print()
	{
		Node temp = first;
		System.out.print("Linked list is :" );
		if(isEmpty())
			System.out.println("null");
		else if (first == last && first != null)
			System.out.println(first.value);
		else
			while(temp != null)
			{
				System.out.println(temp.value);
				temp = temp.next;
			}
					
	}
}
