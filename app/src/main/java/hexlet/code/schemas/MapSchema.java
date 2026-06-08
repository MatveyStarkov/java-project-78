package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer size;

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        this.size = mapSize;
        return this;
    }

    @Override
    public boolean isValid(Map<?, ?> value) {
        if (!super.isValid(value)) {
            return false;
        }

        if (value == null) {
            return true;
        }

        if (size != null && value.size() != size) {
            return false;
        }

        return true;
    }
}
