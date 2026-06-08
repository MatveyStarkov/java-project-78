package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    void testWithoutRequired() {
        MapSchema schema = new MapSchema();

        assertTrue(schema.isValid(null));
    }

    @Test
    void testRequired() {
        MapSchema schema = new MapSchema().required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<String, String>();
        data.put("key1", "value1");

        assertTrue(schema.isValid(data));
    }

    @Test
    void testSizeof() {
        MapSchema schema = new MapSchema().required().sizeof(2);

        Map<String, String> data = new HashMap<String, String>();
        data.put("key1", "value1");

        assertFalse(schema.isValid(data));

        data.put("key2", "value2");

        assertTrue(schema.isValid(data));
    }
}
