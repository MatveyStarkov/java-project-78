package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean positive;
    private Integer min;
    private Integer max;

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int minNum, int maxNum) {
        this.min = minNum;
        this.max = maxNum;
        return this;
    }

    @Override
    public boolean isValid(Integer value) {
        if (!super.isValid(value)) {
            return false;
        }

        if (value == null) {
            return true;
        }

        if (positive && value <= 0) {
            return false;
        }

        if (min != null && max != null && (value < min || value > max)) {
            return false;
        }

        return true;
    }
}
