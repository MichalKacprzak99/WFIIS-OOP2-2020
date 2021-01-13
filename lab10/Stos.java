
class StackElement<T> {
    private final T value;
    private final StackElement<T> under;

    public StackElement(T data, StackElement<T> under) {
        this.value = data;
        this.under = under;
    }

    public T getValue() {
        return value;
    }

    public StackElement<T> getUnder() {
        return under;
    }
}

public class Stos<T> {
    private StackElement<T> onTop = null;

    public void push(T value) {
        this.onTop = new StackElement<>(value, this.onTop);
    }

    public void pop() {
        this.onTop = this.onTop.getUnder();
    }

    @Override
    public String toString() {
        StringBuilder stackRepresentation = new StringBuilder();
        StackElement<T> element = onTop;
        while (element.getUnder() != null){
            String stackElementRepresentation = "{" + element.getValue() + "} ";
            stackRepresentation.append(stackElementRepresentation);
            element = element.getUnder();
        }
        String stackElementRepresentation = "{" + element.getValue() + "}";
        stackRepresentation.append(stackElementRepresentation);
        return stackRepresentation.toString();

    }
}