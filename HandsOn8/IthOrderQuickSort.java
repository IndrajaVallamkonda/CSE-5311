import java.util.Arrays;

public class IthOrderQuickSort{

    int partition(int[] arr, int low, int high)
	{
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

    int quickSort(int[] arr, int low, int high, int ithOrder)
	{
		if (low < high) {
			int pi = partition(arr, low, high);
			
			 if (pi == ithOrder) {
			     return arr[pi];
			 }
		    else if (pi < ithOrder) {
		        return quickSort(arr, pi + 1, high, ithOrder);
		    } else{
		       return quickSort(arr, low, pi - 1, ithOrder);
		    }
		}
		 return -1;
	}
	
	public static void main(String[] args)
	{
		int[] arr = { 88, 5, 65, 45, 12, 98, 23, 76, 55, 66};
		int[] arr1 = arr;
		IthOrderQuickSort iqs = new IthOrderQuickSort();
		int ithOrder= 2;
		int ithOrderValue = iqs.quickSort(arr, 0, arr.length-1, ithOrder -1 );
		if (ithOrderValue == -1) {
		    System.out.println("Invalid index or array size.");
        } else {
            System.out.println("The " + ithOrder + "th order statistic: " + ithOrderValue);
        }
        // Validation
        Arrays.sort(arr1);
        if(arr1[ithOrder-1] == ithOrderValue){
            System.out.println("Validated, ithOrder matched with sorted array" );
        }
        else{
            System.out.println("InValid number");
        }
        
	}
}

// The 2th order statistic: 12
// Validated, ithOrder matched with sorted array
