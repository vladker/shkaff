package W3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: W3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0228l implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f816a;
    public int b;
    public Object c;
    public final /* synthetic */ InterfaceC0233q d;

    public C0228l(P p6) {
        this.f816a = 2;
        this.d = p6;
        this.c = p6.sequence.iterator();
    }

    public void b() {
        Object objInvoke;
        C0229m c0229m = (C0229m) this.d;
        if (this.b == -2) {
            objInvoke = c0229m.getInitialValue.invoke();
        } else {
            O3.l lVar = c0229m.getNextValue;
            Object obj = this.c;
            kotlin.jvm.internal.E.c(obj);
            objInvoke = lVar.invoke(obj);
        }
        this.c = objInvoke;
        this.b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f816a) {
            case 0:
                if (this.b < 0) {
                    b();
                }
                return this.b == 1;
            case 1:
                M m6 = (M) this.d;
                Iterator it = (Iterator) this.c;
                while (this.b < m6.f809a && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                return this.b < m6.b && it.hasNext();
            default:
                return ((Iterator) this.c).hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f816a) {
            case 0:
                if (this.b < 0) {
                    b();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.c;
                kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return obj;
            case 1:
                M m6 = (M) this.d;
                Iterator it = (Iterator) this.c;
                while (this.b < m6.f809a && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                int i5 = this.b;
                if (i5 >= m6.b) {
                    throw new NoSuchElementException();
                }
                this.b = i5 + 1;
                return it.next();
            default:
                O3.p pVar = ((P) this.d).transformer;
                int i6 = this.b;
                this.b = i6 + 1;
                if (i6 < 0) {
                    A3.I.throwIndexOverflow();
                }
                return pVar.invoke(Integer.valueOf(i6), ((Iterator) this.c).next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f816a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0228l(M m6) {
        this.f816a = 1;
        this.d = m6;
        this.c = m6.sequence.iterator();
    }

    public C0228l(C0229m c0229m) {
        this.f816a = 0;
        this.d = c0229m;
        this.b = -2;
    }
}
