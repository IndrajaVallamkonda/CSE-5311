import java.util.Arrays;

public class mergeSort {

	void merge(int arr[], int left, int middle, int right)
	{
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		for (int i = 0; i < n1; i++)
			leftArray[i] = arr[left + i];
		for (int i = 0; i < n2; i++)
			rightArray[i] = arr[middle + i + 1];

    int i,j,k;
		for ( i=0, j=0, k=left ; i < n1 && j < n2 ; k++) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			}
			else {
				arr[k] = rightArray[j];
				j++;
			}
		}
		// copy remaining elements
		for(int a= i; a<n1 ; a++, k++){
			arr[k] = leftArray[a];
		}
		for(int a= j; a<n2 ; a++, k++){
			arr[k] = rightArray[a];
		}
	}

	void sort(int arr[], int left, int right)
	{
		if (left < right) {
			int middle = left + (right - left) / 2;
			sort(arr, left, middle);
			sort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	void sort(int arr[])
	{
		sort(arr, 0, arr.length - 1);
	}

	public static void main(String args[])
	{
		int array[] = { 5,2,4,7,1,3,2,6};
		System.out.println("Given array: " +Arrays.toString(array));
		mergeSort ms = new mergeSort();
		ms.sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
