package org.apache.commons.collections4.list;

import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3677737457567429713L;
    private final Factory<? extends E> factory;
    private final Transformer<Integer, ? extends E> transformer;

    public LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        Objects.requireNonNull(factory);
        this.factory = factory;
        this.transformer = null;
    }

    private E element(int i5) {
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return factory.create();
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return transformer.transform(Integer.valueOf(i5));
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i5) {
        int size = decorated().size();
        if (i5 < size) {
            E e = decorated().get(i5);
            if (e != null) {
                return e;
            }
            E eElement = element(i5);
            decorated().set(i5, eElement);
            return eElement;
        }
        while (size < i5) {
            decorated().add(null);
            size++;
        }
        E eElement2 = element(i5);
        decorated().add(eElement2);
        return eElement2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i5, int i6) {
        List<E> listSubList = decorated().subList(i5, i6);
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return new LazyList(listSubList, factory);
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return new LazyList(listSubList, transformer);
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        return new LazyList<>(list, transformer);
    }

    public LazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        super(list);
        this.factory = null;
        Objects.requireNonNull(transformer);
        this.transformer = transformer;
    }
}
