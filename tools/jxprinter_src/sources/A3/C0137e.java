package A3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: A3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0137e extends p072m4.t implements ListIterator {
    public final /* synthetic */ AbstractC0139g d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0137e(AbstractC0139g abstractC0139g, int i5) {
        super(abstractC0139g);
        this.d = abstractC0139g;
        C0136d c0136d = AbstractC0139g.Companion;
        int iB = abstractC0139g.b();
        c0136d.getClass();
        C0136d.c(i5, iB);
        this.b = i5;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i5 = this.b - 1;
        this.b = i5;
        return this.d.get(i5);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
