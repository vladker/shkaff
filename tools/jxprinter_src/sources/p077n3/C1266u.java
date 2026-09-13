package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p011b3.c;
import p039g3.A;

/* JADX INFO: renamed from: n3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1266u implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6309a;
    public final b b;
    public final Object[] c;
    public final S d;
    public final AtomicInteger e;

    public C1266u(int i5, b bVar, Object[] objArr, S s6, AtomicInteger atomicInteger) {
        this.f6309a = i5;
        this.b = bVar;
        this.c = objArr;
        this.d = s6;
        this.e = atomicInteger;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        AtomicInteger atomicInteger;
        int i5;
        do {
            atomicInteger = this.e;
            i5 = atomicInteger.get();
            if (i5 >= 2) {
                a.onError(th);
                return;
            }
        } while (!atomicInteger.compareAndSet(i5, 2));
        this.b.dispose();
        this.d.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        this.b.add(cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        int i5 = this.f6309a;
        Object[] objArr = this.c;
        objArr[i5] = obj;
        if (this.e.incrementAndGet() == 2) {
            this.d.onSuccess(Boolean.valueOf(A.a(objArr[0], objArr[1])));
        }
    }
}
