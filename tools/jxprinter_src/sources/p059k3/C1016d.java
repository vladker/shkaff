package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;

/* JADX INFO: renamed from: k3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1016d extends AbstractC0985s implements InterfaceC0988v {
    public static final C1014c[] e = new C1014c[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1014c[] f5542f = new C1014c[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f5543a;
    public final AtomicReference b = new AtomicReference(e);
    public Object c;
    public Throwable d;

    public C1016d(AbstractC0985s abstractC0985s) {
        this.f5543a = new AtomicReference(abstractC0985s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        C1014c c1014c = new C1014c(interfaceC0988v, this);
        interfaceC0988v.onSubscribe(c1014c);
        while (true) {
            AtomicReference atomicReference = this.b;
            C1014c[] c1014cArr = (C1014c[]) atomicReference.get();
            if (c1014cArr == f5542f) {
                if (c1014c.e()) {
                    return;
                }
                Throwable th = this.d;
                if (th != null) {
                    interfaceC0988v.onError(th);
                    return;
                }
                Object obj = this.c;
                if (obj != null) {
                    interfaceC0988v.onSuccess(obj);
                    return;
                } else {
                    interfaceC0988v.onComplete();
                    return;
                }
            }
            int length = c1014cArr.length;
            C1014c[] c1014cArr2 = new C1014c[length + 1];
            System.arraycopy(c1014cArr, 0, c1014cArr2, 0, length);
            c1014cArr2[length] = c1014c;
            do {
                if (atomicReference.compareAndSet(c1014cArr, c1014cArr2)) {
                    if (c1014c.e()) {
                        d(c1014c);
                        return;
                    }
                    y yVar = (y) this.f5543a.getAndSet(null);
                    if (yVar != null) {
                        ((AbstractC0985s) yVar).subscribe(this);
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == c1014cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(C1014c c1014c) {
        C1014c[] c1014cArr;
        while (true) {
            AtomicReference atomicReference = this.b;
            C1014c[] c1014cArr2 = (C1014c[]) atomicReference.get();
            int length = c1014cArr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c1014cArr2[i5] == c1014c) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c1014cArr = e;
            } else {
                C1014c[] c1014cArr3 = new C1014c[length - 1];
                System.arraycopy(c1014cArr2, 0, c1014cArr3, 0, i5);
                System.arraycopy(c1014cArr2, i5 + 1, c1014cArr3, i5, (length - i5) - 1);
                c1014cArr = c1014cArr3;
            }
            while (!atomicReference.compareAndSet(c1014cArr2, c1014cArr)) {
                if (atomicReference.get() != c1014cArr2) {
                }
            }
            return;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        for (C1014c c1014c : (C1014c[]) this.b.getAndSet(f5542f)) {
            if (!c1014c.e()) {
                c1014c.f5540a.onComplete();
            }
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.d = th;
        for (C1014c c1014c : (C1014c[]) this.b.getAndSet(f5542f)) {
            if (!c1014c.e()) {
                c1014c.f5540a.onError(th);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.c = obj;
        for (C1014c c1014c : (C1014c[]) this.b.getAndSet(f5542f)) {
            if (!c1014c.e()) {
                c1014c.f5540a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
    }
}
