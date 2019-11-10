package dataStructureExample;

public class Array {

	private int[] items;
	private int count;
	
	Array(int length)
	{
		items = new int[length]; 
	}

	public void insert(int item)
	{

		if(items.length == count)
		{
			//System.out.println("Extending array");
			int[] newItems = new int[count * 2];
			for(int i=0;i<count;i++)
				newItems[i] = items[i];
			items = newItems;
		}

		items[count]= item;
		count++;
	}

	public int max()
	{
		int maxItem = -1;
		
		for(int i=0; i< count; i++)
		{
			if(items[i]> maxItem)
				maxItem = items[i];
			
		}
		return maxItem;
	}

	public void reverseHalf()
	{
		int temp, end = count -1;
		for(int start=0; start < end; start++, end--)
		{
			temp = items[start];
			items[start] = items[end];
			items[end] = temp;
		}
		
		System.out.println("Reverse array: " );
		print();
	}
	
	/*public void reverse()
	{
		int[] reverseItems = new int[count];
		int j = 0;
		for(int i=count-1; i>= 0; i--)
			reverseItems[j++] = items[i];
		
		System.out.println("Reverse array: " );
		for(int i=0; i< count; i++)
			System.out.println(reverseItems[i]);
	}*/

	
	public void insertAt(int item, int index)
	{
		int[] tempArr = new int[count *2];
		int j = 0;
		
		if(index < 0 || index >= count)
			throw new IllegalArgumentException();
		
		for(int i=0; j< count; i++)
		{
			if(i == index)
				tempArr[i] = item;
			else
				tempArr[i] = items[j++];
		}
		items = tempArr;
		count++;
		
		System.out.print("After adding in array: ");
		for(int i=0;i<count;i++)
			System.out.println(items[i]);
	}
	
	public void intersect(int[] anotherArray, int anotherLength)
	{
		int temp, anotherCount=0; 
		int[] commonArray = new int[count];
		for(int i=0; i< count; i++)
		{
			temp = items[i];
			for(int j=0; j<anotherLength ; j++)
			{
				if(anotherArray[j] == temp)
					commonArray[anotherCount++] = temp;
			}
			
		}
		System.out.println("Common Items are: ");
		for(int i=0;i<anotherCount;i++)
			System.out.println(commonArray[i]);
	}
	
	public void print()
	{
		System.out.print("Elements in array: ");
		for(int i=0;i<count;i++)
			System.out.println(items[i]);
	}
}
