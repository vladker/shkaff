package p100r3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends AtomicInteger implements List, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7970a = new ArrayList();

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        ArrayList arrayList = this.f7970a;
        boolean zAdd = arrayList.add(obj);
        lazySet(arrayList.size());
        return zAdd;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        ArrayList arrayList = this.f7970a;
        boolean zAddAll = arrayList.addAll(collection);
        lazySet(arrayList.size());
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f7970a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f7970a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f7970a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        boolean z6 = obj instanceof p;
        ArrayList arrayList = this.f7970a;
        return z6 ? arrayList.equals(((p) obj).f7970a) : arrayList.equals(obj);
    }

    @Override // java.util.List
    public final Object get(int i5) {
        return this.f7970a.get(i5);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f7970a.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f7970a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f7970a.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f7970a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.f7970a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        ArrayList arrayList = this.f7970a;
        boolean zRemove = arrayList.remove(obj);
        lazySet(arrayList.size());
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        ArrayList arrayList = this.f7970a;
        boolean zRemoveAll = arrayList.removeAll(collection);
        lazySet(arrayList.size());
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        ArrayList arrayList = this.f7970a;
        boolean zRetainAll = arrayList.retainAll(collection);
        lazySet(arrayList.size());
        return zRetainAll;
    }

    @Override // java.util.List
    public final Object set(int i5, Object obj) {
        return this.f7970a.set(i5, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return get();
    }

    @Override // java.util.List
    public final List subList(int i5, int i6) {
        return this.f7970a.subList(i5, i6);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.f7970a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.f7970a.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i5) {
        return this.f7970a.listIterator(i5);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f7970a.toArray(objArr);
    }

    @Override // java.util.List
    public final void add(int i5, Object obj) {
        ArrayList arrayList = this.f7970a;
        arrayList.add(i5, obj);
        lazySet(arrayList.size());
    }

    @Override // java.util.List
    public final boolean addAll(int i5, Collection collection) {
        ArrayList arrayList = this.f7970a;
        boolean zAddAll = arrayList.addAll(i5, collection);
        lazySet(arrayList.size());
        return zAddAll;
    }

    @Override // java.util.List
    public final Object remove(int i5) {
        ArrayList arrayList = this.f7970a;
        Object objRemove = arrayList.remove(i5);
        lazySet(arrayList.size());
        return objRemove;
    }
}
