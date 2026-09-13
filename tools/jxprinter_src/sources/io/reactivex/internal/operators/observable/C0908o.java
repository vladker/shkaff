package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0908o implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5243a;
    public final int b;
    public final Callable c;
    public Collection d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5244f;

    public C0908o(io.reactivex.I i5, int i6, Callable callable) {
        this.f5243a = i5;
        this.b = i6;
        this.c = callable;
    }

    public final boolean a() {
        try {
            Object objCall = this.c.call();
            p039g3.A.b(objCall, "Empty buffer supplied");
            this.d = (Collection) objCall;
            return true;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.d = null;
            p011b3.c cVar = this.f5244f;
            io.reactivex.I i5 = this.f5243a;
            if (cVar == null) {
                i5.onSubscribe(p033f3.e.f3970a);
                i5.onError(th);
                return false;
            }
            cVar.dispose();
            i5.onError(th);
            return false;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5244f.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5244f.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        Collection collection = this.d;
        if (collection != null) {
            this.d = null;
            boolean zIsEmpty = collection.isEmpty();
            io.reactivex.I i5 = this.f5243a;
            if (!zIsEmpty) {
                i5.onNext(collection);
            }
            i5.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.d = null;
        this.f5243a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        Collection collection = this.d;
        if (collection != null) {
            collection.add(obj);
            int i5 = this.e + 1;
            this.e = i5;
            if (i5 >= this.b) {
                this.f5243a.onNext(collection);
                this.e = 0;
                a();
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5244f, cVar)) {
            this.f5244f = cVar;
            this.f5243a.onSubscribe(this);
        }
    }
}
