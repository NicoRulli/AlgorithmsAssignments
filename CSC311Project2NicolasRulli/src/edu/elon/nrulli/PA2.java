/**
 * CSC 331 Programming Assignment 2
 * This is the driver class that will create instances of
 * the 3 method classes to test them.
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */

package edu.elon.nrulli;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PA2 {

	public static void main(String[] args) {
		Method1 method1 = new Method1();
		Method2 method2 = new Method2();
		Method3 method3 = new Method3();

		// -----------------------------------------------------
		// Functionality Tests
		// Test each method on the provided test data, which consists of
		// 100 integers (one per line). Use k = 10. Include the output from
		// each method in your readme file.
		System.out.println("Functionality Tests...");


		// A. Read test data from file into array


		File myTxt = new File("pa2_input.txt");
		Scanner ints = null;
		int[] initialTextArray = new int[100];

		try {
			ints = new Scanner(myTxt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		int test = 0;
		while(ints.hasNextLine()) {
			String num = ints.nextLine();
			initialTextArray[count] = Integer.parseInt(num);
			count++;
		}



		//Creates Temporary Testing Array 
		int[] method1Array = initialTextArray.clone();
		int[] method2Array = initialTextArray.clone();
		int[] method3Array = initialTextArray.clone();


		int[] testArray = method1.findTopK(method1Array, 10);


		System.out.println("Method 1: findTopK: ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + ", ");
		}

		System.out.println();
		int[] arr2 = method2.findTopK(method2Array, 10);
		System.out.println("Method 2 findTopK: ");

		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ", " );

		}

//				int partition = method3.partition(method3Array, 0, editableArray.length - 1);
//				System.out.println();
//		
//				int selectiontest = method3.selection(method3Array, 0, 10, 3);

		System.out.println();
		int[] finArr = method3.findTopK(method3Array, 10);

		System.out.println("Method 3: findTopK ");
		for(int i = 0; i < 10; i++) {
			System.out.print(finArr[i] + ", ");
		}

		// Run tests to time each method on random data

		//		 A. For each experiment, create an array of 10,000 random integers
		//		 !! Make sure to clone the array for testing each method so the original isn't changed !!
		//		 Use System.nanoTime() to get the runtime for each method.
		//		 E.g., 

		// B. Test each method with the same test data. 
		// (!! Make sure to clone the array for testing each method so the original isn't changed !!)

		// -----------------------------------------------------
		// Timing Tests
		// Use a random number generator to generate 10,000 elements and run 
		// the three different algorithms to find the 500 largest elements. 
		// Take the average over 10 experiments for each algorithm and compare the results.
		System.out.println();
		System.out.println("Timing Tests...");

		int K = 500;
		
		int numExperiments = 10;
		long start = 0;
		long end = 0;
		
		long timeResults1 = 0;
		long timeResults2 = 0;
		long timeResults3 = 0;
		
		Random randGen = new Random();
		
		for(int i = 0; i < numExperiments; i++) {
			int[] bigboy = new int[10000];
			
			for(int j = 0; j < bigboy.length; j++) {
				bigboy[j] = randGen.nextInt();
			}
			
			int[] test1 = bigboy.clone();
			int[] test2 = bigboy.clone();
			int[] test3 = bigboy.clone();
			
			int[] output1 = new int[K];
			int[] output2 = new int[K];
			int[] output3 = new int[K];
			
			start = System.nanoTime();
			output1 = method1.findTopK(test1, K);
			end = System.nanoTime();
			timeResults1 += end - start;
			
			start = System.nanoTime();
			output2 = method2.findTopK(test2, K);
			end = System.nanoTime();
			timeResults2 += end - start;
			
			start = System.nanoTime();
			output3 = method3.findTopK(test3, K);
			end = System.nanoTime();
			timeResults3 += end - start;

		}
		
		long av1 = 0;
		long av2 = 0;
		long av3 = 0;
		
		av1 = timeResults1 / 10;
		av2 = timeResults2 / 10;
		av3 = timeResults3 / 10;
		
		System.out.println("Method 1 Time Result Average: " + av1);
		System.out.println("Method 2 Time Result Average: " + av2);
		System.out.println("Method 3 Time Result Average: " + av3);

	} // end main
}













