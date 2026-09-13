package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import io.reactivex.internal.operators.observable.C0863f;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0731i implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4664a;
    public Object b;
    public boolean c = true;
    public boolean d = true;
    public Throwable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p011b3.c f4666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4667h;

    public /* synthetic */ C0731i(Object obj, p011b3.c cVar, int i5) {
        this.f4664a = i5;
        this.f4667h = obj;
        this.f4666g = cVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4664a) {
            case 0:
                Throwable th = this.e;
                if (th != null) {
                    throw p100r3.g.d(th);
                }
                if (!this.c) {
                    return false;
                }
                boolean z6 = true;
                if (this.d) {
                    C0737j c0737j = (C0737j) this.f4666g;
                    try {
                        if (!this.f4665f) {
                            this.f4665f = true;
                            c0737j.c.set(1);
                            AbstractC0979l.fromPublisher((AbstractC0979l) this.f4667h).materialize().subscribe((InterfaceC0984q) c0737j);
                        }
                        io.reactivex.A aTakeNext = c0737j.takeNext();
                        if (!aTakeNext.a()) {
                            this.c = false;
                            Object obj = aTakeNext.f4169a;
                            if (obj != null) {
                                z6 = false;
                            }
                            if (z6) {
                                return false;
                            }
                            if (!(obj instanceof p100r3.l)) {
                                throw new IllegalStateException("Should not reach here");
                            }
                            Throwable error = aTakeNext.getError();
                            this.e = error;
                            throw p100r3.g.d(error);
                        }
                        this.d = false;
                        this.b = aTakeNext.getValue();
                    } catch (InterruptedException e) {
                        c0737j.dispose();
                        this.e = e;
                        throw p100r3.g.d(e);
                    }
                }
                return true;
            default:
                Throwable th2 = this.e;
                if (th2 != null) {
                    throw p100r3.g.d(th2);
                }
                if (!this.c) {
                    return false;
                }
                if (this.d) {
                    C0863f c0863f = (C0863f) this.f4666g;
                    if (!this.f4665f) {
                        this.f4665f = true;
                        c0863f.c.set(1);
                        new io.reactivex.internal.operators.observable.Z((io.reactivex.B) this.f4667h, 5).subscribe(c0863f);
                    }
                    try {
                        io.reactivex.A aTakeNext2 = c0863f.takeNext();
                        if (!aTakeNext2.a()) {
                            this.c = false;
                            if (aTakeNext2.f4169a == null) {
                                return false;
                            }
                            Throwable error2 = aTakeNext2.getError();
                            this.e = error2;
                            throw p100r3.g.d(error2);
                        }
                        this.d = false;
                        this.b = aTakeNext2.getValue();
                    } catch (InterruptedException e6) {
                        c0863f.dispose();
                        this.e = e6;
                        throw p100r3.g.d(e6);
                    }
                }
                return true;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4664a) {
            case 0:
                Throwable th = this.e;
                if (th != null) {
                    throw p100r3.g.d(th);
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                this.d = true;
                return this.b;
            default:
                Throwable th2 = this.e;
                if (th2 != null) {
                    throw p100r3.g.d(th2);
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                this.d = true;
                return this.b;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4664a) {
            case 0:
                throw new UnsupportedOperationException("Read only iterator");
            default:
                throw new UnsupportedOperationException("Read only iterator");
        }
    }
}
