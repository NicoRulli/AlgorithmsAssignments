package edu.elon.nrulli;

import java.util.Arrays;
import java.util.Random;

/**
 * CSC 331 Programming Assignment 2
 * Method 3
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
public class Method3 {
	// For finding a random pivot in the partition method.
	private Random randGen = new Random();

	/**
	 * This method finds the k largest elements in an integer array
	 * by calling the selection method to find the location of the
	 * (n-k)th element, copying the k largest elements into an array,
	 * (i.e., the elements to the right of the pivot)
	 * and then calling insertion sort on this array to put them in order
	 * from largest to smallest.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		int length = arr.length;
		
		int x = selection(arr, 0, length - 1, length - k); //(array, 0, n, n - k)
		
		for(int i = 0; i < k; i++) {
			results[i] = arr[length - i - 1];
		}
		insertionSortReverse(results);
		
		return results;
	}

	/**
	 * Return kth smallest element of array A between left..right
	 * @param A: input array of ints
	 * @param left: index of the left-most element to be considered
	 * @param right: index of the right-most element to be considered
	 * @param k: the order of the element to find
	 * @return the value of the kth smallest element in A between left and right
	 */
	public int selection(int[] A, int left, int right, int k) {

		if(left == right) {
			return A[left];
		}
		int pivot = partition(A, left, right);

		if(k == pivot) {
			return A[k];
		}
		else if(k < pivot) {
			return selection(A, left, pivot - 1, k);
		}
		else {
			return selection(A, pivot + 1, right, k);
		}
	}

	/**
	 * Partition the elements of an array A between left and right
	 * so that, for some pivot element, all the elements to its left
	 * are less and all the elements to its right are greater.
	 * Recommendation: pick the index of the pivot element randomly.
	 * 
	 * @param A: input array of ints
	 * @param left: index of the left-most element to be considered
	 * @param right: index of the right-most element to be considered
	 * @return final index of the pivot element
	 */
	public int partition(int[] A, int left, int right) {

		int rand = randGen.nextInt(right - left) + left;

		swap(A,rand,right);
		int pivot = A[right];
		int L = left;
		int R = right;

		while(L < R) {
			while(A[L] < pivot && L < right) {
				L++;
			}
			while(A[R] >= pivot && R > left) {
				R--;
			}
			if(L < R) {
				swap(A, L, R);
			}
		}
		swap(A, L, right);

		return L;
	}

	/**
	 * Helper method to swap two elements in an array.
	 * @param A: array
	 * @param a: first index
	 * @param b: second index
	 */
	public  void swap(int[] A, int a, int b) {
		int tempVal = A[a];
		A[a] = A[b];
		A[b] = tempVal;

	}	

	/**
	 * Sort the elements in the array A using insertion sort.
	 * Elements will be sorted in reverse order, so that the
	 * largest is first and the smallest is last.
	 * @param A: input array of ints.
	 */
	public void insertionSortReverse(int[] A) {
		int n = A.length;
		for (int j = 1; j < n; j++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] < key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}

} // Method3
