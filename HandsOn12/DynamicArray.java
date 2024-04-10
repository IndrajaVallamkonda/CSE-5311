
public class DynamicArray {

	private int arr[];
	private int count;

	public DynamicArray(int length) { arr = new int[length]; }
	public void printArray()
	{
		for (int i = 0; i < count; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void insert(int element)
	{
		if (arr.length == count) {
			int newArr[] = new int[2 * count];
			for (int i = 0; i < count; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[count++] = element;
	}
	
	public void delete(int element)
	{ boolean elementFound = false;
	    for(int i=0; i< count ; i++){
	        if(element == arr[i] ){
	            elementFound = true;
	            count--;
	        }
	        if(elementFound)
	        {arr[i]= arr[i+1]; }
	    }
	}	
	
	public void delete()
	{ 
	    if(count > 0){
	        arr[count-1]= 0;
	        count--;
	    }
	}
	public static void main(String[] args)
	{
		DynamicArray numbers = new DynamicArray(5);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);
		numbers.printArray();
		System.out.println();
		numbers.insert(60);
		numbers.insert(70);
		numbers.insert(80);
		numbers.printArray();
		System.out.println();
		numbers.delete(50);
		numbers.delete();
		numbers.printArray();
	
    }
}

// Output:-
// 10 20 30 40 50 
// 10 20 30 40 50 60 70 80 
// 10 20 30 40 60 70 
