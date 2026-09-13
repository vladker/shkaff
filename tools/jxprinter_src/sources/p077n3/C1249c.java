package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;

/* JADX INFO: renamed from: n3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1249c extends O implements S {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1248b[] f6288f = new C1248b[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1248b[] f6289g = new C1248b[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f6290a;
    public final AtomicInteger b = new AtomicInteger();
    public final AtomicReference c = new AtomicReference(f6288f);
    public Object d;
    public Throwable e;

    public C1249c(O o6) {
        this.f6290a = o6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(C1248b c1248b) {
        C1248b[] c1248bArr;
        while (true) {
            AtomicReference atomicReference = this.c;
            C1248b[] c1248bArr2 = (C1248b[]) atomicReference.get();
            int length = c1248bArr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c1248bArr2[i5] == c1248b) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c1248bArr = f6288f;
            } else {
                C1248b[] c1248bArr3 = new C1248b[length - 1];
                System.arraycopy(c1248bArr2, 0, c1248bArr3, 0, i5);
                System.arraycopy(c1248bArr2, i5 + 1, c1248bArr3, i5, (length - i5) - 1);
                c1248bArr = c1248bArr3;
            }
            while (!atomicReference.compareAndSet(c1248bArr2, c1248bArr)) {
                if (atomicReference.get() != c1248bArr2) {
                }
            }
            return;
        }
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.e = th;
        for (C1248b c1248b : (C1248b[]) this.c.getAndSet(f6289g)) {
            if (!c1248b.get()) {
                c1248b.f6286a.onError(th);
            }
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.d = obj;
        for (C1248b c1248b : (C1248b[]) this.c.getAndSet(f6289g)) {
            if (!c1248b.get()) {
                c1248b.f6286a.onSuccess(obj);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        C1248b c1248b = new C1248b(s6, this);
        s6.onSubscribe(c1248b);
        while (true) {
            AtomicReference atomicReference = this.c;
            C1248b[] c1248bArr = (C1248b[]) atomicReference.get();
            if (c1248bArr == f6289g) {
                Throwable th = this.e;
                if (th != null) {
                    s6.onError(th);
                    return;
                } else {
                    s6.onSuccess(this.d);
                    return;
                }
            }
            int length = c1248bArr.length;
            C1248b[] c1248bArr2 = new C1248b[length + 1];
            System.arraycopy(c1248bArr, 0, c1248bArr2, 0, length);
            c1248bArr2[length] = c1248b;
            do {
                if (atomicReference.compareAndSet(c1248bArr, c1248bArr2)) {
                    if (c1248b.get()) {
                        f(c1248b);
                    }
                    if (this.b.getAndIncrement() == 0) {
                        this.f6290a.subscribe(this);
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == c1248bArr);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
    }
}
