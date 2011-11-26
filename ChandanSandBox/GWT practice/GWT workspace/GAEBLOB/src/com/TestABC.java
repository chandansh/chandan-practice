package com;
import com.test.blob.ReadBlob;


public class TestABC {
private int a;
	public int getA() {
	return a;
}
public void setA(int a) {
	this.a = a;
}
	public TestABC() {
		super();
		ReadBlob r=new ReadBlob();
	}

}
