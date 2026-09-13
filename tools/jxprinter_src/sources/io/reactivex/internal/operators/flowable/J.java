package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends AtomicInteger implements t5.d {
    private static final long serialVersionUID = 6770240836423125754L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4296a;
    public final K b;
    public final AtomicLong c = new AtomicLong();
    public L0.j d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4297f;

    public J(t5.c cVar, K k6) {
        this.f4296a = cVar;
        this.b = k6;
        this.d = k6.f4312g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t5.d
    public final void cancel() {
        J[] jArr;
        if (this.c.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            AtomicReference atomicReference = this.b.e;
            while (true) {
                J[] jArr2 = (J[]) atomicReference.get();
                int length = jArr2.length;
                if (length == 0) {
                    return;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    } else if (jArr2[i5] == this) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 < 0) {
                    return;
                }
                if (length == 1) {
                    jArr = K.f4309l;
                } else {
                    J[] jArr3 = new J[length - 1];
                    System.arraycopy(jArr2, 0, jArr3, 0, i5);
                    System.arraycopy(jArr2, i5 + 1, jArr3, i5, (length - i5) - 1);
                    jArr = jArr3;
                }
                while (!atomicReference.compareAndSet(jArr2, jArr)) {
                    if (atomicReference.get() != jArr2) {
                    }
                }
                return;
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.b(this.c, j6);
            this.b.g(this);
        }
    }
}
