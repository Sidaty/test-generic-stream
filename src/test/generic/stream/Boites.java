/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.generic.stream;

import static java.lang.Double.compare;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 *
 * @author sidaty
 * @param <E>
 */
public class Boites<E extends Number> {

    private final List<E> elements = new ArrayList();
    private final Supplier<E> supplier;
    private final BinaryOperator<E> accumulator;

    public static Boites<Integer> ofInt() {
        return new Boites<>(() -> 0, (a, b) -> a + b);
    }

    public static Boites<Long> ofLong() {
        return new Boites<>(() -> 0l, (a, b) -> a + b);
    }

    public static Boites<Float> ofFloat() {
        return new Boites<>(() -> 0f, (a, b) -> a + b);
    }

    public static Boites<Double> ofDouble() {
        return new Boites<>(() -> 0d, (a, b) -> a + b);
    }

    private Boites(Supplier<E> supplier, BinaryOperator<E> accumulator) {
        this.supplier = supplier;
        this.accumulator = accumulator;
    }

    public Boites add(E element) {
        elements.add(element);
        return this;
    }

    public Optional<E> get(int index) {
        return isEmpty() || index < 0 || index > size() - 1 ? Optional.empty() : Optional.of(elements.get(index));
    }

    public E sum() {
        E sum = supplier.get();
        for (E elt : elements) {
            sum = accumulator.apply(sum, elt);
        }
        return sum;
    }

    public Optional<E> max() {
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(sortedCopy().get(elements.size() - 1));
    }

    public Optional<E> min() {
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(sortedCopy().get(0));
    }

    public Optional<Double> average() {
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(sum().doubleValue() / size());
    }

    private List<E> sortedCopy() {
        List<E> copy = new ArrayList<>(elements);
        copy.sort((a, b) -> compare(a.doubleValue(), b.doubleValue()));
        return copy;
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void show(String title) {
        System.out.println("---------------------------------------");
        System.out.println(title);
        System.out.println("element 0 : " + get(0));
        System.out.println("Sum : " + sum());
        System.out.println("Max : " + max());
        System.out.println("Max/2 if > 100000 : " + max().map(max -> max.doubleValue() > 200 ? max.doubleValue() / 2 : null));
        System.out.println("Min : " + min());
        System.out.println("Min if < 5 : " + min().filter(min -> min.doubleValue() < 5));
        System.out.println("element 0 : " + get(0));
        System.out.println("---------------------------------------");
    }
}
