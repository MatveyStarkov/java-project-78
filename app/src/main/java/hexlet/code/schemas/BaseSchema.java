package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean required;

    public boolean isValid(T value) {
        if (value == null) {
            return !required;
        }
        return true;
    }
}
