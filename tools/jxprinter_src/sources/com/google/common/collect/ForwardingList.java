package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public void add(int i5, @ParametricNullness E e) {
        delegate().add(i5, e);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i5, Collection<? extends E> collection) {
        return delegate().addAll(i5, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.List
    @ParametricNullness
    public E get(int i5) {
        return delegate().get(i5);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove(int i5) {
        return delegate().remove(i5);
    }

    @Override // java.util.List
    @ParametricNullness
    @CanIgnoreReturnValue
    public E set(int i5, @ParametricNullness E e) {
        return delegate().set(i5, e);
    }

    public boolean standardAdd(@ParametricNullness E e) {
        add(size(), e);
        return true;
    }

    public boolean standardAddAll(int i5, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i5, iterable);
    }

    @Beta
    public boolean standardEquals(Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Beta
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    public int standardIndexOf(Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i5, int i6) {
        return Lists.subListImpl(this, i5, i6);
    }

    @Override // java.util.List
    public List<E> subList(int i5, int i6) {
        return delegate().subList(i5, i6);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i5) {
        return delegate().listIterator(i5);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i5) {
        return Lists.listIteratorImpl(this, i5);
    }
}
