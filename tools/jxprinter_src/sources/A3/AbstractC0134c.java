package A3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: A3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0134c implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37a;
    private Object nextValue;

    public abstract void b();

    public final void c(Object obj) {
        this.nextValue = obj;
        this.f37a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.f37a;
        if (i5 == 0) {
            this.f37a = 3;
            b();
            return this.f37a == 1;
        }
        if (i5 == 1) {
            return true;
        }
        if (i5 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.f37a;
        if (i5 == 1) {
            this.f37a = 0;
            return this.nextValue;
        }
        if (i5 != 2) {
            this.f37a = 3;
            b();
            if (this.f37a == 1) {
                this.f37a = 0;
                return this.nextValue;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
