package bean.json.examples;

public class SerializerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student("neeraj", "bangalore", 26);
		JSONserializer serializer = new JSONserializer();
		String serializedStudent = serializer.serialize(s);
		System.out.println("deserialized obj :: " + s);

		System.out.println("serialStudent :: " + serializedStudent);
		Student deserializedStudent = serializer.deserialize(serializedStudent, Student.class);
		System.out.println("deserialized Student :: " + deserializedStudent);
		
	}

}
