import mypack.MyClass;




public class Test {

	public static void main(String[] args) {
		
		ClassLoader loader=Test.class.getClassLoader();
		try {
			Class<? extends MyClass> clz=(Class<? extends MyClass>)loader.loadClass("mypack.MyClass");
			MyClass m=clz.newInstance();
			System.out.print(m.sum(12, 15));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class<? extends MyClass> clz=(Class<? extends MyClass>)Class.forName("mypack.MyClass");
			MyClass m=clz.newInstance();
			System.out.println(m.sum(20, 75));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
