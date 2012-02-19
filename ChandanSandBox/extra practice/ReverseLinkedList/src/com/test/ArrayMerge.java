package com.test;

import java.util.Arrays;

public class ArrayMerge {
	public static void main(String s[]) {
		int[] arr1 = { -11, -10, -5, -3, 10, 11, 0, 0, 0, 0 };
		int[] arr2 = { -20, 5, 6, 19, 20, 21, 33, 34, 35, 46 };

		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int k = i - j - 1;
		// System.out.println(k);
		// binary search return the index if find if not find then it returns the insertion point of that number in negative
		// ex: 18 is not find in arr2 then binary search return -4 because 18 can be fit into index 3 of arr2 and default 
		// insertion point is -1 then -1-3=-4
		System.out.println("Searched At " + Arrays.binarySearch(arr2, 18));

		while (i >= 0 && j >= 0) {
			if (k >= 0 && arr2[j] <= arr1[k]) {
				arr1[i] = arr1[k];
				i--;
				k--;
				// System.out.println("i:" + i + "k:" + k);
			} else {
				arr1[i] = arr2[j];
				i--;
				j--;
				// System.out.println("i:" + i + "j:" + j);
			}
			// System.out.println("k:" + k);
		}

		System.out.println("i:" + i);
		System.out.println("j:" + j);
		System.out.println("k:" + k);
		// System.out.println("2nd array");
		for (int val : arr1) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}
