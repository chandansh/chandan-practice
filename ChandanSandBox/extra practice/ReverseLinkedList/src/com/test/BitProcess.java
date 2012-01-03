package com.test;

public class BitProcess {

	/**
	 * @param args
	 */
	public static final Byte FLAG_ATTEMPTED = 0x01;
	public static final Byte FLAG_MARKED = 0x02;

	public static void main(String[] args) {
		byte flag = 0x00;
		System.out.println(flag);
		flag = (byte) (flag | FLAG_MARKED & flag | FLAG_ATTEMPTED);
		System.out.println("after marked :" + (flag & FLAG_MARKED));
		//flag = (byte) (flag & ~FLAG_MARKED);
		//System.out.println("after unmarked :" + (flag & FLAG_MARKED));
		//flag = (byte) (flag | FLAG_ATTEMPTED);
		System.out.println("after attempted :" + (flag & FLAG_ATTEMPTED));
//		flag = (byte) (flag & ~FLAG_ATTEMPTED);
//		System.out.println("after unattempted :" + (flag & FLAG_ATTEMPTED));

	}

}
