
/**
 * CSC 331 Programming Assignment 2
 * Method 1
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
package edu.elon.nrulli;

public class Method1 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by looping through the array k times, each time picking the largest.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		int minVal = 0;
		
		for(int i = 0; i < k; i++) {
			int max = 0;
			int max2 = 0;
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
					max2 = j;
				}
			}
			results[i] = max;
			arr[max2] = minVal;
		}
		return results;
	}
} // Method1
