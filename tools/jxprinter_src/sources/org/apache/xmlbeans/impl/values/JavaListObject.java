package org.apache.xmlbeans.impl.values;

import java.util.AbstractList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaListObject<T> extends AbstractList<T> {
    private final BiConsumer<Integer, T> adder;
    private final Function<Integer, T> getter;
    private final Consumer<Integer> remover;
    private final BiConsumer<Integer, T> setter;
    private final Supplier<Integer> sizer;

    public JavaListObject(Function<Integer, T> function, BiConsumer<Integer, T> biConsumer, BiConsumer<Integer, T> biConsumer2, Consumer<Integer> consumer, Supplier<Integer> supplier) {
        this.getter = function;
        this.setter = biConsumer;
        this.adder = biConsumer2;
        this.remover = consumer;
        this.sizer = supplier;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, T t6) {
        BiConsumer<Integer, T> biConsumer = this.adder;
        if (biConsumer == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no add method available");
        }
        biConsumer.accept(Integer.valueOf(i5), t6);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i5) {
        Function<Integer, T> function = this.getter;
        if (function != null) {
            return function.apply(Integer.valueOf(i5));
        }
        throw new IllegalStateException("XmlBean generated using partial methods - no getter method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i5) {
        if (this.remover == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no remove method available");
        }
        T t6 = get(i5);
        this.remover.accept(Integer.valueOf(i5));
        return t6;
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i5, T t6) {
        if (this.setter == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no setter method available");
        }
        T t7 = get(i5);
        this.setter.accept(Integer.valueOf(i5), t6);
        return t7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        Supplier<Integer> supplier = this.sizer;
        if (supplier != null) {
            return supplier.get().intValue();
        }
        throw new IllegalStateException("XmlBean generated using partial methods - no size-of method available");
    }
}
