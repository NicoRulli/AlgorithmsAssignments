package edu.elon.nrulli;

import java.util.Arrays;
import java.util.Collections;

/**
 * CSC 331 Programming Assignment 2
 * Method 2
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
public class Method2 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by first sorting the array and then selecting the last K elements.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) { 
		int[] results = new int[k];
		
		Arrays.sort(arr);	//Assuming this is constant time in my calculation for time complexity
		
		int length = arr.length - 1;
		
		for(int i = 0; i < results.length; i++) {
			results[i] = arr[length - i];
		
		}
		return results;
	}
}







