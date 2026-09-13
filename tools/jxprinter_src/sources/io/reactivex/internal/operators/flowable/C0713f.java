package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.observable.C0858e;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0713f implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4613a;
    public Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0713f(Object obj, int i5) {
        this.f4613a = i5;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean zC;
        switch (this.f4613a) {
            case 0:
                Object obj = ((C0719g) this.c).b;
                this.b = obj;
                zC = p100r3.n.c(obj);
                break;
            default:
                Object obj2 = ((C0858e) this.c).b;
                this.b = obj2;
                zC = p100r3.n.c(obj2);
                break;
        }
        return !zC;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4613a) {
            case 0:
                try {
                    if (this.b == null) {
                        this.b = ((C0719g) this.c).b;
                    }
                    if (p100r3.n.c(this.b)) {
                        throw new NoSuchElementException();
                    }
                    Object obj = this.b;
                    if (obj instanceof p100r3.l) {
                        throw p100r3.g.d(((p100r3.l) obj).f7966a);
                    }
                    this.b = null;
                    return obj;
                } catch (Throwable th) {
                    this.b = null;
                    throw th;
                }
            default:
                try {
                    if (this.b == null) {
                        this.b = ((C0858e) this.c).b;
                    }
                    if (p100r3.n.c(this.b)) {
                        throw new NoSuchElementException();
                    }
                    Object obj2 = this.b;
                    if (obj2 instanceof p100r3.l) {
                        throw p100r3.g.d(((p100r3.l) obj2).f7966a);
                    }
                    this.b = null;
                    return obj2;
                } catch (Throwable th2) {
                    this.b = null;
                    throw th2;
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4613a) {
            case 0:
                throw new UnsupportedOperationException("Read only iterator");
            default:
                throw new UnsupportedOperationException("Read only iterator");
        }
    }
}
