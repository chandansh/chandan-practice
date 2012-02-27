package com.test;

public class StringReverse {
	public static void main(String args[]) {
		String str = "Ram is a good boy. he is also smart.";
		str = strRev(str);
		System.out.println(str);
	}

	// TODO write algorithms for this
	// algorithm is :
	// step 1 : Get the character array from string
	// step 2 : reverse the character array 
	// step 3 : start from the array where ever you find ' ' space character
	// reverse the array elements from last ' ' character
	private static String strRev(String str) {
		char[] chars = str.toCharArray();
		reverse(chars);
		int start = 0;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ' || i == chars.length - 1) {
				int size = i - start - 1;
				if (start > 0)
					size += 1;
				// System.out.println("size :" + size);
				// System.out.println("start :" + start);
				if (size % 2 == 0)
					end = size / 2;
				else
					end = size / 2 + 1;
				end = start + end;
				int pivot = start + size;
				if (i == chars.length - 1) {
					end = pivot;
					start += 1;
				}
				// System.out.println("pivot :" + pivot);
				// System.out.println("last :" + last);
				for (int j = start; j < end; j++) {
					char temp = chars[j];
					chars[j] = chars[pivot];
					chars[pivot] = temp;
					pivot--;
				}
				start = i;
			}
		}
		return new String(chars);
	}

	private static void reverse(char[] chars) {
		int size = chars.length - 1;
		int end = 0;

		if (size % 2 == 0)
			end = size / 2;
		else
			end = size / 2 + 1;

		int pivot = size;
		for (int i = 0; i < end; i++) {
			char temp = chars[i];
			chars[i] = chars[pivot];
			chars[pivot] = temp;
			pivot--;
		}
	}

	private static String strRev1(char[] chars) {
		// char[] chars = str.toCharArray();
		char[] rev = new char[chars.length];
		int pivot = chars.length;
		int pivot1 = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ' ' || i == 0) {
				pivot1 = arrayCopy(chars, rev, i, pivot, pivot1);
				pivot = i;
			}
		}
		// chars = rev;
		return new String(rev);
	}

	private static int arrayCopy(char[] chars, char[] rev, int i, int pivot,
			int pivot1) {
		if (pivot == chars.length) {
			i++;
		}
		if (i == 0) {
			rev[pivot1] = ' ';
			pivot1++;
		}
		while (i < pivot) {
			rev[pivot1] = chars[i];
			i++;
			pivot1++;
		}
		return pivot1;

	}
}
