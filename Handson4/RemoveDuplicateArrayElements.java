class RemoveDuplicateArrayElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5};
        int currentElement = arr[0];
        int j=1;
        for( int i=1; i < arr.length; i++ ){
            if(currentElement != arr[i]){
                arr[j]= arr[i];
                currentElement = arr[i];
                j= j+1;
            }
        }
        System.out.print(" output : ");
        for(int i=0; i<j ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
// input array = {1, 2, 2, 3, 4, 4, 4, 5, 5}
//output : 1 2 3 4 5

// input array = {2, 2, 2,2}
//output : 2
