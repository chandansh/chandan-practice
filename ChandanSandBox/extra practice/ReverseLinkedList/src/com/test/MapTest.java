package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class SetTest{
	
}

class SetTest1 extends SetTest{
	
}
public class MapTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//HashSet<E>
		try {
			//Map map= new TreeMap();
			Map map= new HashMap();
			map.put("chandan", "raju");
			map.put(1, 2);
			map.put(25L, 3);
			map.put(2.5, "Raja");
			System.out.println(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Set set=new HashSet();
		Set set=new TreeSet();
//		set.add(1);
//		set.add("hello");
//		set.add(2.5);
//		set.add(23L);
		
		set.add(null);
		set.add(new SetTest());
		
		System.out.println("set content: "+set);
	}

}
