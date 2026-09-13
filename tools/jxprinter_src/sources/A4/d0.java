package A4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class d0 {
    public static final d0 INSTANCE = new d0();
    private static final c0 LOCK = new c0(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f68a;
    private static final AtomicReference<c0>[] hashBuckets;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f68a = iHighestOneBit;
        AtomicReference<c0>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i5 = 0; i5 < iHighestOneBit; i5++) {
            atomicReferenceArr[i5] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    public static final void recycle(c0 segment) {
        kotlin.jvm.internal.E.f(segment, "segment");
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared) {
            return;
        }
        INSTANCE.getClass();
        AtomicReference<c0> atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (((long) f68a) - 1))];
        c0 c0Var = LOCK;
        c0 andSet = atomicReference.getAndSet(c0Var);
        if (andSet == c0Var) {
            return;
        }
        int i5 = andSet != null ? andSet.limit : 0;
        if (i5 >= 65536) {
            atomicReference.set(andSet);
            return;
        }
        segment.next = andSet;
        segment.pos = 0;
        segment.limit = i5 + 8192;
        atomicReference.set(segment);
    }

    public static final c0 take() {
        INSTANCE.getClass();
        AtomicReference<c0> atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (((long) f68a) - 1))];
        c0 c0Var = LOCK;
        c0 andSet = atomicReference.getAndSet(c0Var);
        if (andSet == c0Var) {
            return new c0();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new c0();
        }
        atomicReference.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }
}
