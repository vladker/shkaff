package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        public TransformedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e) {
            getListIterator().add(TransformedList.this.transform(e));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e) {
            getListIterator().set(TransformedList.this.transform(e));
        }
    }

    public TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
    }

    public static <E> TransformedList<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        TransformedList<E> transformedList = new TransformedList<>(list, transformer);
        if (list.size() > 0) {
            Object[] array = list.toArray();
            list.clear();
            for (Object obj : array) {
                transformedList.decorated().add(transformer.transform(obj));
            }
        }
        return transformedList;
    }

    public static <E> TransformedList<E> transformingList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return new TransformedList<>(list, transformer);
    }

    @Override // java.util.List
    public void add(int i5, E e) {
        getList().add(i5, transform(e));
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        return getList().addAll(i5, transform((Collection) collection));
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i5) {
        return getList().get(i5);
    }

    public List<E> getList() {
        return (List) decorated();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i5) {
        return getList().remove(i5);
    }

    @Override // java.util.List
    public E set(int i5, E e) {
        return getList().set(i5, transform(e));
    }

    @Override // java.util.List
    public List<E> subList(int i5, int i6) {
        return new TransformedList(getList().subList(i5, i6), this.transformer);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i5) {
        return new TransformedListIterator(getList().listIterator(i5));
    }
}
