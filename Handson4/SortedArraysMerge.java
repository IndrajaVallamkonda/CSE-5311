import java.util.Scanner;
import java.util.Arrays;
public class SortedArraysMerge {
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

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of Sorted Arrays:");
    System.out.print("K = ");
    int K = scanner.nextInt();
    System.out.println("Enter the size of each array:");
    System.out.print("N = ");
    int N = scanner.nextInt();
    scanner.nextLine();
    int oneD[] = new int [K*N];
    for(int i=0; i<K;i++){
        System.out.println(" Enter sorted elements for array" + (i+1));
        for(int j=0; j<N;j++){
            oneD[(i*N) + j]=scanner.nextInt();
        }
    }

    SortedArraysMerge ms = new SortedArraysMerge();
    ms.sort(oneD);
    System.out.println("Sorted array: " + Arrays.toString(oneD));
  }
}


//output 1
// Enter the number of Sorted Arrays:
// K = 3
// Enter the size of each array:
// N = 4
//  Enter sorted elements for array1
// 1
// 3
// 5
// 7
//  Enter sorted elements for array2
// 2
// 4
// 6
// 8
//  Enter sorted elements for array3
// 0
// 9
// 10
// 11
// Sorted array: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

//output 2
// Enter the number of Sorted Arrays:
// K = 3
// Enter the size of each array:
// N = 3
//  Enter sorted elements for array1
// 1
// 3
// 7
//  Enter sorted elements for array2
// 2
// 4
// 8
//  Enter sorted elements for array3
// 9
// 10
// 11
// Sorted array: [1, 2, 3, 4, 7, 8, 9, 10, 11]
