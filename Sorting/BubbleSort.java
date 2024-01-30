import java.io.*;
import java.time.*;
import java.util.*;

public class BubbleSort {

	void sort(ArrayList<Integer> list)
    {
        int i, j, temp;
        int n = list.size();
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    Collections.swap(list, j, j+1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
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
        BubbleSort ob = new BubbleSort();
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

        // calculating time for Bubble sort
        Instant start = Instant.now();
        ob.sort(mylist);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed +" milliseconds");
        System.out.println("Bubble Sorted array");
        ob.printArray(mylist);
    }
}
