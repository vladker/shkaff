package B3;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements ListIterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f92a;
    public int b;
    public int c;
    private final e list;

    public d(e list, int i5) {
        E.f(list, "list");
        this.list = list;
        this.f92a = i5;
        this.b = -1;
        this.c = ((AbstractList) list).modCount;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        b();
        e eVar = this.list;
        int i5 = this.f92a;
        this.f92a = i5 + 1;
        eVar.add(i5, obj);
        this.b = -1;
        this.c = ((AbstractList) this.list).modCount;
    }

    public final void b() {
        if (((AbstractList) this.list).modCount != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f92a < this.list.f93a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f92a > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        b();
        int i5 = this.f92a;
        e eVar = this.list;
        if (i5 >= eVar.f93a) {
            throw new NoSuchElementException();
        }
        this.f92a = i5 + 1;
        this.b = i5;
        return eVar.backing[this.b];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f92a;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        b();
        int i5 = this.f92a;
        if (i5 <= 0) {
            throw new NoSuchElementException();
        }
        int i6 = i5 - 1;
        this.f92a = i6;
        this.b = i6;
        return this.list.backing[this.b];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f92a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        b();
        int i5 = this.b;
        if (i5 == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
        this.list.c(i5);
        this.f92a = this.b;
        this.b = -1;
        this.c = ((AbstractList) this.list).modCount;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        b();
        int i5 = this.b;
        if (i5 == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
        this.list.set(i5, obj);
    }
}
