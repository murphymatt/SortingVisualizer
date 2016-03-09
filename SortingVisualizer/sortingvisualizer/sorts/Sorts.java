package sorts;

import java.util.Arrays;

public class Sorts {

	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int cur = 0; cur < arr.length - 1; cur++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[cur].compareTo(arr[i]) < 0) {
					T tmp = arr[cur];
					arr[cur] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	} // void selectionSort(T[] arr)

	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int cur = arr.length; cur > 0; cur--) {
			T val = arr[cur];
			int i = cur - 1;
			while (i > 0 && val.compareTo(arr[i]) < 0) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = val;
		}
	} // void insertionSort(T[] arr)

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int j = 0;
		T temp;
		boolean swapped = true;
		while (swapped) {
			j++;
			swapped = false;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
		}
	} // void bubbleSort(T[] arr)
	
	public static <T extends Comparable<T>> T[] mergeSort(T[] arr) {
		// base case
		if (arr.length <= 1) {
			return arr;
		} else {
			return merge(mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2 - 1)),
					mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length)));
		}
	} // T[] mergeSort(T[] arr)
	
	public static <T extends Comparable<T>> T[] merge(T[] arr1, T[] arr2) {
		int index1 = 0, index2 = 0, mergeIndex = 0;
		Object[] merged = new Object[arr1.length + arr2.length];
		while (index1 < arr1.length && index2 < arr2.length) {
			if (arr1[index1].compareTo(arr2[index2]) < 0) {
				// add element from first array
				merged[mergeIndex++] = arr1[index1++];
			} else {
				// add element from second array
				merged[mergeIndex++] = arr2[index2++];
			}	
		}
		if (index1 == arr1.length) {
			while (index2 < arr2.length) {
				merged[mergeIndex++] = arr2[index2++];
			}
		} else {
			while (index1 < arr1.length) {
				merged[mergeIndex++] = arr1[index1++];
			}
		}
		return (T[]) merged;
	} // T[] merge(T[] arr1, T[] arr2)
	
	public static void main(String[] args) {
		Integer[] arr = { 0, 5, 2, 6, 7, 8, 1, 53, 35 };
		Integer[] sorted = mergeSort(arr);
		for (int i = 0; i < sorted.length; i++) {
			System.out.format("%d ", sorted[i]);
		}
	}
}
