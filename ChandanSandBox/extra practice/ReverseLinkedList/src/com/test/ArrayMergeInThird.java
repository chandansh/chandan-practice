package com.test;

import java.lang.ref.WeakReference;

//algorithm : in third array start with last position and which is 
//greater in both array's last position add it to the last position of third array 
public class ArrayMergeInThird {
	public static void main(String s[]) {
		int[] arr1 = { -11, -10, -5, -3, 5, 6, 10, 11, 12, 15 };
		int[] arr2 = { -20, 5, 6, 19 };

		int[] arr3 = new int[arr1.length + arr2.length];

		int i = arr3.length - 1;
		int j = arr2.length - 1;
		int k = arr1.length - 1;
		// System.out.println(k);

		WeakReference<Integer> a=new WeakReference<Integer>(null);
		while (i >= 0 && j >= 0) {
			if (k >= 0 && arr2[j] <= arr1[k]) {
				arr3[i] = arr1[k];
				i--;
				k--;
				// System.out.println("i:" + i + "k:" + k);
			} else {
				arr3[i] = arr2[j];
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
		for (int val : arr3) {
			System.out.print(val + " ");
		}
		System.out.println();

	}
}
