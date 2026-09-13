package A3;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements ListIterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46a = 0;
    public final ListIterator b;
    public final /* synthetic */ Object c;

    public q0(s0 s0Var, int i5) {
        this.c = s0Var;
        this.b = s0Var.delegate.listIterator(P.e(i5, s0Var));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f46a) {
            case 0:
                ListIterator listIterator = this.b;
                listIterator.add(obj);
                listIterator.previous();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f46a) {
            case 0:
                break;
        }
        return this.b.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f46a) {
            case 0:
                break;
        }
        return this.b.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f46a) {
            case 0:
                break;
        }
        return this.b.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        int iPreviousIndex;
        int lastIndex;
        switch (this.f46a) {
            case 0:
                r0 r0Var = (r0) this.c;
                iPreviousIndex = this.b.previousIndex();
                lastIndex = I.getLastIndex(r0Var);
                break;
            default:
                s0 s0Var = (s0) this.c;
                iPreviousIndex = this.b.previousIndex();
                lastIndex = I.getLastIndex(s0Var);
                break;
        }
        return lastIndex - iPreviousIndex;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f46a) {
            case 0:
                break;
        }
        return this.b.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int iNextIndex;
        int lastIndex;
        switch (this.f46a) {
            case 0:
                r0 r0Var = (r0) this.c;
                iNextIndex = this.b.nextIndex();
                lastIndex = I.getLastIndex(r0Var);
                break;
            default:
                s0 s0Var = (s0) this.c;
                iNextIndex = this.b.nextIndex();
                lastIndex = I.getLastIndex(s0Var);
                break;
        }
        return lastIndex - iNextIndex;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f46a) {
            case 0:
                this.b.remove();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f46a) {
            case 0:
                this.b.set(obj);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public q0(r0 r0Var, int i5) {
        this.c = r0Var;
        this.b = r0Var.delegate.listIterator(P.e(i5, r0Var));
    }
}
