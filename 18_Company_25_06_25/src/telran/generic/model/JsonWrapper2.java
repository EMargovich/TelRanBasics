package telran.generic.model;

public class JsonWrapper2<T> {
    private T value;

    public JsonWrapper2(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{'key':" + value + "}";
    }
}
