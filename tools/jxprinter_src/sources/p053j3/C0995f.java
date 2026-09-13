package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;

/* JADX INFO: renamed from: j3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0995f extends AbstractC0676c implements InterfaceC0679f {
    public static final C0994e[] e = new C0994e[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0994e[] f5431f = new C0994e[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0676c f5432a;
    public final AtomicReference b = new AtomicReference(e);
    public final AtomicBoolean c = new AtomicBoolean();
    public Throwable d;

    public C0995f(AbstractC0676c abstractC0676c) {
        this.f5432a = abstractC0676c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        C0994e c0994e = new C0994e(this, interfaceC0679f);
        interfaceC0679f.onSubscribe(c0994e);
        while (true) {
            AtomicReference atomicReference = this.b;
            C0994e[] c0994eArr = (C0994e[]) atomicReference.get();
            if (c0994eArr == f5431f) {
                Throwable th = this.d;
                if (th != null) {
                    interfaceC0679f.onError(th);
                    return;
                } else {
                    interfaceC0679f.onComplete();
                    return;
                }
            }
            int length = c0994eArr.length;
            C0994e[] c0994eArr2 = new C0994e[length + 1];
            System.arraycopy(c0994eArr, 0, c0994eArr2, 0, length);
            c0994eArr2[length] = c0994e;
            do {
                if (atomicReference.compareAndSet(c0994eArr, c0994eArr2)) {
                    if (c0994e.get()) {
                        e(c0994e);
                    }
                    if (this.c.compareAndSet(false, true)) {
                        this.f5432a.subscribe(this);
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == c0994eArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(C0994e c0994e) {
        C0994e[] c0994eArr;
        while (true) {
            AtomicReference atomicReference = this.b;
            C0994e[] c0994eArr2 = (C0994e[]) atomicReference.get();
            int length = c0994eArr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c0994eArr2[i5] == c0994e) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c0994eArr = e;
            } else {
                C0994e[] c0994eArr3 = new C0994e[length - 1];
                System.arraycopy(c0994eArr2, 0, c0994eArr3, 0, i5);
                System.arraycopy(c0994eArr2, i5 + 1, c0994eArr3, i5, (length - i5) - 1);
                c0994eArr = c0994eArr3;
            }
            while (!atomicReference.compareAndSet(c0994eArr2, c0994eArr)) {
                if (atomicReference.get() != c0994eArr2) {
                }
            }
            return;
        }
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        for (C0994e c0994e : (C0994e[]) this.b.getAndSet(f5431f)) {
            if (!c0994e.get()) {
                c0994e.f5430a.onComplete();
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.d = th;
        for (C0994e c0994e : (C0994e[]) this.b.getAndSet(f5431f)) {
            if (!c0994e.get()) {
                c0994e.f5430a.onError(th);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
    }
}
