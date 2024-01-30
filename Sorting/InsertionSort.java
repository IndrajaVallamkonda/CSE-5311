import java.io.*;
import java.time.*;
import java.util.*;

public class InsertionSort {

	void sort(ArrayList<Integer> list)
	{
		int n = list.size();
		for (int i = 1; i < n; i++) {
			int key = list.get(i) ; //arr[i];
			int j = i - 1;

      // move elements that are greater than key to one position ahead of their current position
			while (j >= 0 && list.get(j) > key) {
				list.set(j + 1,  list.get(j));
				j = j - 1;
			}
			list.set(j+1,key);
		}
	}

	void printArray(ArrayList list)
    {
        for (int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+" ");
    }

	public static void main(String args[])
    {
        Random rand = new Random();
        ArrayList<Integer>  mylist = new ArrayList<Integer>();
        InsertionSort ob = new InsertionSort();
        int pick;
        int listSize;

        Scanner myInput = new Scanner( System.in );
        System.out.print( "Enter list size: " );
        listSize = myInput.nextInt(); // taking list size from console

        // adding elements to list
        for (int i=0; i<listSize; i++)
        {
        pick = rand.nextInt(listSize);
        mylist.add(pick);
        }
        // calculating time for Insertion sort
        Instant start = Instant.now();
        ob.sort(mylist);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed +" milliseconds");
        System.out.println("Insertion sorted array");
        ob.printArray(mylist);
    }
}
