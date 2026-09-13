package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    public AbstractListDecorator() {
    }

    @Override // java.util.List
    public void add(int i5, E e) {
        decorated().add(i5, e);
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        return decorated().addAll(i5, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i5) {
        return decorated().get(i5);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return decorated().listIterator();
    }

    @Override // java.util.List
    public E remove(int i5) {
        return decorated().remove(i5);
    }

    @Override // java.util.List
    public E set(int i5, E e) {
        return decorated().set(i5, e);
    }

    @Override // java.util.List
    public List<E> subList(int i5, int i6) {
        return decorated().subList(i5, i6);
    }

    public AbstractListDecorator(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i5) {
        return decorated().listIterator(i5);
    }
}
