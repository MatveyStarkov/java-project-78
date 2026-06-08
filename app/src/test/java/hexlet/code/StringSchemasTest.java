package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    @Test
    void testWithoutRequired() {
        var schema = new StringSchema();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("matthew"));
    }

    @Test
    void testRequired() {
        var schema = new StringSchema().required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("matthew"));
    }

    @Test
    void testMinLength() {
        var schema = new StringSchema().minLength(5);

        assertTrue(schema.isValid("matthew"));
        assertTrue(schema.isValid("Starkov"));
        assertFalse(schema.isValid("matt"));
    }

    @Test
    void testContains() {
        var schema = new StringSchema().contains("matt");

        assertTrue(schema.isValid("matthew"));
        assertTrue(schema.isValid("matthewStarkov"));
        assertFalse(schema.isValid("Starkov"));
    }

    @Test
    void testMinLengthOverride() {
        var schema = new StringSchema().minLength(10).minLength(4);

        assertTrue(schema.isValid("matt"));
    }

    @Test
    void testContainsOverride() {
        var schema = new StringSchema().contains("mat").contains("hew");

        assertTrue(schema.isValid("matthew"));
        assertFalse(schema.isValid("matvey"));
    }
}
