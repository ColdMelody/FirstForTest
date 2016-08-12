package effectivejava;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Bill on 2016/7/12.
 */
public class CustomStack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private CustomStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    private void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        CustomStack<String> stack = new CustomStack<>();
        Arrays.asList("cao rui and diao cheng kun shi ruo zha".split(" ")).forEach(stack::push);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
