package p129w3;

import io.reactivex.I;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public static final a[] c = new a[0];
    public static final a[] d = new a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8817a = new AtomicReference(d);
    public Throwable b;

    public static <T> b create() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.B
    public final void b(I i5) {
        a aVar = new a(i5, this);
        i5.onSubscribe(aVar);
        while (true) {
            AtomicReference atomicReference = this.f8817a;
            a[] aVarArr = (a[]) atomicReference.get();
            if (aVarArr == c) {
                Throwable th = this.b;
                if (th != null) {
                    i5.onError(th);
                    return;
                } else {
                    i5.onComplete();
                    return;
                }
            }
            int length = aVarArr.length;
            a[] aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
            do {
                if (atomicReference.compareAndSet(aVarArr, aVarArr2)) {
                    if (aVar.get()) {
                        e(aVar);
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == aVarArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(a aVar) {
        a[] aVarArr;
        while (true) {
            AtomicReference atomicReference = this.f8817a;
            a[] aVarArr2 = (a[]) atomicReference.get();
            if (aVarArr2 == c || aVarArr2 == (aVarArr = d)) {
                return;
            }
            int length = aVarArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (aVarArr2[i5] == aVar) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length != 1) {
                aVarArr = new a[length - 1];
                System.arraycopy(aVarArr2, 0, aVarArr, 0, i5);
                System.arraycopy(aVarArr2, i5 + 1, aVarArr, i5, (length - i5) - 1);
            }
            while (!atomicReference.compareAndSet(aVarArr2, aVarArr)) {
                if (atomicReference.get() != aVarArr2) {
                }
            }
            return;
        }
    }

    @Override // p129w3.d
    public Throwable getThrowable() {
        if (this.f8817a.get() == c) {
            return this.b;
        }
        return null;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        AtomicReference atomicReference = this.f8817a;
        Object obj = atomicReference.get();
        Object obj2 = c;
        if (obj == obj2) {
            return;
        }
        a[] aVarArr = (a[]) atomicReference.getAndSet(obj2);
        for (a aVar : aVarArr) {
            if (!aVar.get()) {
                aVar.f8816a.onComplete();
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onError(Throwable th) {
        A.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference atomicReference = this.f8817a;
        Object obj = atomicReference.get();
        Object obj2 = c;
        if (obj == obj2) {
            a.onError(th);
            return;
        }
        this.b = th;
        a[] aVarArr = (a[]) atomicReference.getAndSet(obj2);
        for (a aVar : aVarArr) {
            if (aVar.get()) {
                a.onError(th);
            } else {
                aVar.f8816a.onError(th);
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onNext(Object obj) {
        A.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a aVar : (a[]) this.f8817a.get()) {
            if (!aVar.get()) {
                aVar.f8816a.onNext(obj);
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (this.f8817a.get() == c) {
            cVar.dispose();
        }
    }
}
