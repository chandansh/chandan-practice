package bean.json.examples;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONserializer {
	private final ObjectMapper mapper = new ObjectMapper();

	public String serialize(final Student student) {
		final StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, student);
			return writer.toString();
		} catch (final IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			try {
				writer.close();
			} catch (final IOException ex) { /* Nothing to do here */
			}
		}
	}

	public Student deserialize(final String str, Class clz) {
		final StringReader reader = new StringReader(str);
		try {
			return mapper.readValue(reader, clz);
		} catch (final IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			reader.close();
		}
	}
}