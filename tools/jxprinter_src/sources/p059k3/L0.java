package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p027e3.o;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L0 extends AtomicInteger implements c {
    private static final long serialVersionUID = -5556924161382950569L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5522a;
    public final o b;
    public final M0[] c;
    public final Object[] d;

    public L0(int i5, o oVar, InterfaceC0988v interfaceC0988v) {
        super(i5);
        this.f5522a = interfaceC0988v;
        this.b = oVar;
        M0[] m0Arr = new M0[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            m0Arr[i6] = new M0(this, i6);
        }
        this.c = m0Arr;
        this.d = new Object[i5];
    }

    public final void a(int i5) {
        M0[] m0Arr = this.c;
        int length = m0Arr.length;
        for (int i6 = 0; i6 < i5; i6++) {
            M0 m6 = m0Arr[i6];
            m6.getClass();
            d.a(m6);
        }
        while (true) {
            i5++;
            if (i5 >= length) {
                return;
            }
            M0 m7 = m0Arr[i5];
            m7.getClass();
            d.a(m7);
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (getAndSet(0) > 0) {
            for (M0 m6 : this.c) {
                m6.getClass();
                d.a(m6);
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() <= 0;
    }
}
