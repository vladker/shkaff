package p028e4;

import O3.p;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: e4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0647a {
    private static final H CLOSED = new H("CLOSED");

    public static final <N extends AbstractC0648b> N close(N n6) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AbstractC0648b.f3939a;
            n6.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = AbstractC0648b.f3939a;
            Object obj = atomicReferenceFieldUpdater2.get(n6);
            H h6 = CLOSED;
            if (obj == h6) {
                break;
            }
            AbstractC0648b abstractC0648b = (AbstractC0648b) obj;
            if (abstractC0648b == null) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(n6, null, h6)) {
                    if (atomicReferenceFieldUpdater2.get(n6) != null) {
                    }
                }
                break loop0;
            }
            n6 = (N) abstractC0648b;
        }
        return n6;
    }

    public static final <S extends E> Object findSegmentInternal(S s6, long j6, p pVar) {
        while (true) {
            if (s6.id >= j6 && !s6.b()) {
                return F.m1030constructorimpl(s6);
            }
            Object obj = AbstractC0648b.f3939a.get(s6);
            H h6 = CLOSED;
            if (obj == h6) {
                return F.m1030constructorimpl(h6);
            }
            E e = (E) ((AbstractC0648b) obj);
            if (e == null) {
                e = (E) pVar.invoke(Long.valueOf(s6.id + 1), s6);
                if (s6.trySetNext(e)) {
                    if (s6.b()) {
                        s6.c();
                    }
                }
            }
            s6 = (S) e;
        }
    }
}
