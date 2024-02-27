import java.util.*;

public class RandomizedQuickSort{
  void random(int arr[],int low,int high)
  {
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
  }

  int partition(int[] arr, int low, int high)
	{
	  random(arr,low,high);
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

  void sort(int[] arr, int low, int high)
	{
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	void sort(int[] arr)
	{
		sort(arr, 0, arr.length -1);
	}

	public static void main(String[] args)
	{
		int[] arr = { 88, 5, 65, 45, 12, 98, 23};
		RandomizedQuickSort rqs = new RandomizedQuickSort();
		rqs.sort(arr);
		System.out.println("Sorted array:" + Arrays.toString(arr));
	}
}
