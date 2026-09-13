package W3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: W3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0223g implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f814a;
    public final Iterator b;
    public int c;
    public Object d;
    public final /* synthetic */ InterfaceC0233q e;

    public C0223g(C0226j c0226j) {
        this.f814a = 1;
        this.e = c0226j;
        this.b = c0226j.sequence.iterator();
        this.c = -1;
    }

    public void b() {
        Object next;
        C0226j c0226j = (C0226j) this.e;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) c0226j.predicate.invoke(next)).booleanValue() != c0226j.f815a);
        this.d = next;
        this.c = 1;
    }

    public void c() {
        Iterator it = this.b;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) ((O) this.e).predicate.invoke(next)).booleanValue()) {
                this.c = 1;
                this.d = next;
                return;
            }
        }
        this.c = 0;
    }

    public void d() {
        Object next;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) ((C0224h) this.e).predicate.invoke(next)).booleanValue());
        this.d = next;
        this.c = 1;
    }

    public boolean e() {
        Iterator it;
        C0227k c0227k = (C0227k) this.e;
        Iterator it2 = (Iterator) this.d;
        if (it2 != null && it2.hasNext()) {
            this.c = 1;
            return true;
        }
        do {
            Iterator it3 = this.b;
            if (!it3.hasNext()) {
                this.c = 2;
                this.d = null;
                return false;
            }
            it = (Iterator) c0227k.iterator.invoke(c0227k.transformer.invoke(it3.next()));
        } while (!it.hasNext());
        this.d = it;
        this.c = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f814a) {
            case 0:
                if (this.c == -1) {
                    d();
                }
                return this.c == 1 || this.b.hasNext();
            case 1:
                if (this.c == -1) {
                    b();
                }
                return this.c == 1;
            case 2:
                int i5 = this.c;
                if (i5 == 1) {
                    return true;
                }
                if (i5 == 2) {
                    return false;
                }
                return e();
            default:
                if (this.c == -1) {
                    c();
                }
                return this.c == 1;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f814a) {
            case 0:
                if (this.c == -1) {
                    d();
                }
                if (this.c != 1) {
                    return this.b.next();
                }
                Object obj = this.d;
                this.d = null;
                this.c = 0;
                return obj;
            case 1:
                if (this.c == -1) {
                    b();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.d;
                this.d = null;
                this.c = -1;
                return obj2;
            case 2:
                int i5 = this.c;
                if (i5 == 2) {
                    throw new NoSuchElementException();
                }
                if (i5 == 0 && !e()) {
                    throw new NoSuchElementException();
                }
                this.c = 0;
                Iterator it = (Iterator) this.d;
                kotlin.jvm.internal.E.c(it);
                return it.next();
            default:
                if (this.c == -1) {
                    c();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj3 = this.d;
                this.d = null;
                this.c = -1;
                return obj3;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f814a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0223g(C0227k c0227k) {
        this.f814a = 2;
        this.e = c0227k;
        this.b = c0227k.sequence.iterator();
    }

    public C0223g(O o6) {
        this.f814a = 3;
        this.e = o6;
        this.b = o6.sequence.iterator();
        this.c = -1;
    }

    public C0223g(C0224h c0224h) {
        this.f814a = 0;
        this.e = c0224h;
        this.b = c0224h.sequence.iterator();
        this.c = -1;
    }
}
