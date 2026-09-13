package p050j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a implements List, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f5377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient Object f5378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public transient Class f5379l;

    public b() {
        this.f5377j = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        return this.f5377j.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        return this.f5377j.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f5377j.clear();
    }

    public final Object clone() {
        return new b(new ArrayList(this.f5377j));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5377j.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f5377j.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return this.f5377j.equals(obj);
    }

    @Override // java.util.List
    public final Object get(int i5) {
        return this.f5377j.get(i5);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f5377j.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f5377j.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f5377j.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f5377j.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f5377j.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.f5377j.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f5377j.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f5377j.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.f5377j.retainAll(collection);
    }

    @Override // java.util.List
    public final Object set(int i5, Object obj) {
        ArrayList arrayList = this.f5377j;
        if (i5 == -1) {
            arrayList.add(obj);
            return null;
        }
        if (arrayList.size() > i5) {
            return arrayList.set(i5, obj);
        }
        for (int size = arrayList.size(); size < i5; size++) {
            arrayList.add(null);
        }
        arrayList.add(obj);
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f5377j.size();
    }

    @Override // java.util.List
    public final List subList(int i5, int i6) {
        return this.f5377j.subList(i5, i6);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.f5377j.toArray();
    }

    @Override // java.util.List
    public final void add(int i5, Object obj) {
        this.f5377j.add(i5, obj);
    }

    @Override // java.util.List
    public final boolean addAll(int i5, Collection collection) {
        return this.f5377j.addAll(i5, collection);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i5) {
        return this.f5377j.listIterator(i5);
    }

    @Override // java.util.List
    public final Object remove(int i5) {
        return this.f5377j.remove(i5);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f5377j.toArray(objArr);
    }

    public b(int i5) {
        this.f5377j = new ArrayList(i5);
    }

    public b(ArrayList arrayList) {
        this.f5377j = arrayList;
    }
}
