import java.io.*;
import java.time.*;
import java.util.*;

public class SelectionSort
{
    void sort(ArrayList<Integer> list)
    {
        int n = list.size();
        for (int i = 0; i < n -1; i++)
        {
            // minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (list.get(j) < list.get(min_idx))
                    min_idx = j;

            // swap the elements
            Collections.swap(list, i, min_idx);
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
        SelectionSort ob = new SelectionSort();
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

        // calculating time for Selection sort
        Instant start = Instant.now();
        ob.sort(mylist);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed +" milliseconds");
        System.out.println("Selection sorted array");
        ob.printArray(mylist);
    }
}
