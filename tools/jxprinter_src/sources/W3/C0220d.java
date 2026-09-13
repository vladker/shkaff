package W3;

import A3.C0133b0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: W3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0220d implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f812a = 2;
    public final Iterator b;
    public int c;

    public C0220d(C0230n c0230n) {
        this.b = c0230n.sequence.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f812a) {
            case 0:
                break;
            case 1:
                return this.b.hasNext();
            default:
                return this.c > 0 && this.b.hasNext();
        }
        while (true) {
            int i5 = this.c;
            it = this.b;
            if (i5 > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f812a) {
            case 0:
                break;
            case 1:
                int i5 = this.c;
                this.c = i5 + 1;
                if (i5 < 0) {
                    A3.I.throwIndexOverflow();
                }
                return new C0133b0(i5, this.b.next());
            default:
                int i6 = this.c;
                if (i6 == 0) {
                    throw new NoSuchElementException();
                }
                this.c = i6 - 1;
                return this.b.next();
        }
        while (true) {
            int i7 = this.c;
            it = this.b;
            if (i7 > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f812a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0220d(N n6) {
        this.c = n6.f810a;
        this.b = n6.sequence.iterator();
    }

    public C0220d(C0221e c0221e) {
        this.b = c0221e.sequence.iterator();
        this.c = c0221e.f813a;
    }
}
