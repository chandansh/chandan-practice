package com.test;

import java.util.ArrayList;
import java.util.List;
//change the whole rows and cols by 1 where 1 occurred in the array.
public class GridOnes {

	public static void main(String args[]) {
		int[][] arr = { { 1, 2, 3, 5, 6, 3, 9, 4 }, { 5, 6, 5, 8, 7, 2, 2, 1 },
				{ 2, 7, 6, 3, 7, 1, 2, 3 }, { 2, 9, 6, 3, 7, 4, 2, 3 },
				{ 2, 3, 7, 3, 7, 4, 2, 3 }, { 2, 1, 6, 3, 7, 9, 2, 3 },
				{ 2, 3, 6, 3, 7, 5, 6, 3 }, { 2, 9, 6, 3, 7, 2, 2, 3 },
				{ 2, 3, 7, 3, 7, 4, 2, 3 }, { 2, 1, 6, 3, 7, 9, 2, 3 },
				{ 2, 3, 7, 3, 7, 4, 2, 3 }, { 2, 1, 6, 3, 7, 9, 2, 3 } };

		// System.out.println(arr.length);
		// System.out.println(arr[0].length);
		System.out.println("Array before change.");
		showArr(arr);
		changeOne(arr);
		System.out.println("Array After change.");
		showArr(arr);

	}

	private static void changeOne(int[][] arr) {
		// find the index of the cell no which has one
		List<Integer> rv = new ArrayList<Integer>();

		final int ROWS = arr.length;
		final int COLS = arr[0].length;

		for (int i = 0; i < ROWS; i++) {

			for (int j = 0; j < COLS; j++) {
				if (arr[i][j] == 1) {
					rv.add(ROWS * i + j);
				}
			}
		}
		// System.out.println(rv);
		for (int val : rv) {
			int rowNo = val / ROWS;
			int colNo = val % ROWS;
			// System.out.println("row :" + rowNo + " col :" + colNo);
			createOne(arr, rowNo, colNo);
		}
	}

	private static void createOne(int[][] arr, int rowNo, int colNo) {

		final int ROWS = arr.length;
		final int COLS = arr[0].length;

		for (int i = 0; i < ROWS; i++) {
			arr[i][colNo] = 1;
		}
		for (int j = 0; j < COLS; j++) {
			arr[rowNo][j] = 1;
		}
	}

	private static void showArr(int[][] arr) {
		final int ROWS = arr.length;
		final int COLS = arr[0].length;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
