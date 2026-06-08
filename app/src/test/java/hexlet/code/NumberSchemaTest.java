package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    void testWithoutRequired() {
        NumberSchema schema = new NumberSchema();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
    }

    @Test
    void testRequired() {
        NumberSchema schema = new NumberSchema().required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }

    @Test
    void testPositive() {
        NumberSchema schema = new NumberSchema().positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-10));
    }

    @Test
    void testRange() {
        NumberSchema schema = new NumberSchema().range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void testRequiredAndPositive() {
        NumberSchema schema = new NumberSchema().required().positive();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(0));
    }
}
