package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    private Integer minLength;
    private String contains;

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String str) {
        this.contains = str;
        return this;
    }

    @Override
    public boolean isValid(String value) {
        if (!super.isValid(value)) {
            return false;
        }

        if (value == null || value.isEmpty()) {
            return !required;
        }

        if (minLength != null && value.length() < minLength) {
            return false;
        }

        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;
    }
}
