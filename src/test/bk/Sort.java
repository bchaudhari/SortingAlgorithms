package test.bk;

public class Sort {
	public static void main(String[] args) {
		int[] inputArr = { 1, 9, 56, 3, 29, 94, 0, 3};
		System.out.print("Input: \t");
		Sort sort = new Sort();
		sort.printArray(inputArr);
//		sort.selectionSort(inputArr);
//		sort.bubbleSort(inputArr);
//		sort.insertionSort(inputArr);
//		sort.mergeSort(inputArr);
		sort.quickSort(inputArr, 0, inputArr.length - 1);
		System.out.print("Output: ");
		sort.printArray(inputArr);
	}

	// O(n2)
	public void selectionSort(int[] arr){
		System.out.println("Performing Selection Sort");
		int temp;
		int length = arr.length;
		for(int i = 0; i < (length - 1); i++){
			int iMin = i;
			for(int j = i+1; j < length; j++){
				if(arr[j] < arr[iMin]){
					iMin = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[iMin];
			arr[iMin] = temp;
		}
	}

	// O(n2)
	public void bubbleSort(int[] arr){
		System.out.println("Performing Bubble Sort");
		int length = arr.length;
		int temp;
		boolean swap = false;
		for(int i = 0; i < length; i++){
			for(int j = 1; j < (length-i); j++){
				if(arr[j-1] > arr[j]){
					swap = true;
					//swap
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
			if(!swap){
				break;
			}
		}
	}

	// Best case O(n)
	// Worst case O(n2)
	// Average O(n2)
	public void insertionSort(int[] arr){
		System.out.println("Performing Insertion Sort");
		int length = arr.length;
		int value, hole;
		for(int i = 1; i < length; i++){
			value = arr[i];
			hole = i;
			while(hole > 0 && arr[hole - 1] > value){
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
	}
	
	// O(nlog n)
	public void mergeSort(int[] arr){
		int n = arr.length;
		
		if (n < 2) return;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0, j = 0; i < n; i++){
			if(i < mid){
				left[i] = arr[i];
			} else {
				right[j] = arr[i];
				j++;
			}
		}
		
		mergeSort(left);
		mergeSort(right);
		
		mergeArrays(left, right, arr);	
	}

	// Merge two arrays leftArray and rightArray into one array - arr
	public void mergeArrays(int[] leftArray, int[] rightArray, int[] arr){
		int nL = leftArray.length;
		int nR = rightArray.length;
		int n = arr.length;
		int i, j, k;
		i = j = k = 0;

		while(i < nL && j < nR){
			if(leftArray[i] < rightArray[j]){
				arr[k] = leftArray[i];
				k++;
				i++;
			} else {
				arr[k] = rightArray[j];
				k++;
				j++;
			}
		}

		while(i < nL){
			arr[k] = leftArray[i];
			k++;
			i++;
		}

		while(j < nR){
			arr[k] = rightArray[j];
			k++;
			j++;
		}
	}
	
	// print array content on console
	public void printArray(int[] arr){
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	public void quickSort(int[] arr, int start, int end){
		if(start < end){
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex - 1);
			quickSort(arr, pIndex + 1, end);
		}
	}
	
	public int partition(int[] arr, int start, int end){
		int pivot = arr[end];
		int pIndex = start;
		int temp;
		for(int i = start; i < end; i++){
			if(arr[i] <= pivot){
				//swap
				temp = arr[pIndex];
				arr[pIndex] = arr[i];
				arr[i] = temp;
				pIndex++;
			}
		}
		
		// swap
		temp = arr[end];
		arr[end] = arr[pIndex];
		arr[pIndex] = temp;
		return pIndex;
	}
}
