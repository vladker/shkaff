package p083o3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p043h3.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6445i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f6446j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f6447a;
    public final int b;
    public long c;
    public final int d;
    public AtomicReferenceArray e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f6449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f6450h;

    public d(int i5) {
        AtomicLong atomicLong = new AtomicLong();
        this.f6447a = atomicLong;
        this.f6450h = new AtomicLong();
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i5) - 1));
        int i6 = iNumberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iNumberOfLeadingZeros + 1);
        this.e = atomicReferenceArray;
        this.d = i6;
        this.b = Math.min(iNumberOfLeadingZeros / 4, f6445i);
        this.f6449g = atomicReferenceArray;
        this.f6448f = i6;
        this.c = iNumberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
    }

    @Override // p043h3.j
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f6447a.get() == this.f6450h.get();
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.f6447a;
        long j6 = atomicLong.get();
        int i5 = this.d;
        int i6 = ((int) j6) & i5;
        if (j6 < this.c) {
            atomicReferenceArray.lazySet(i6, obj);
            atomicLong.lazySet(j6 + 1);
            return true;
        }
        long j7 = ((long) this.b) + j6;
        if (atomicReferenceArray.get(((int) j7) & i5) == null) {
            this.c = j7 - 1;
            atomicReferenceArray.lazySet(i6, obj);
            atomicLong.lazySet(j6 + 1);
            return true;
        }
        long j8 = j6 + 1;
        if (atomicReferenceArray.get(((int) j8) & i5) == null) {
            atomicReferenceArray.lazySet(i6, obj);
            atomicLong.lazySet(j8);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j6 + ((long) i5)) - 1;
        atomicReferenceArray2.lazySet(i6, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i6, f6446j);
        atomicLong.lazySet(j8);
        return true;
    }

    public final Object peek() {
        AtomicReferenceArray atomicReferenceArray = this.f6449g;
        int i5 = (int) this.f6450h.get();
        int i6 = this.f6448f;
        int i7 = i5 & i6;
        Object obj = atomicReferenceArray.get(i7);
        if (obj != f6446j) {
            return obj;
        }
        int i8 = i6 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i8);
        atomicReferenceArray.lazySet(i8, null);
        this.f6449g = atomicReferenceArray2;
        return atomicReferenceArray2.get(i7);
    }

    @Override // p043h3.i, p043h3.j
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f6449g;
        AtomicLong atomicLong = this.f6450h;
        long j6 = atomicLong.get();
        int i5 = this.f6448f;
        int i6 = ((int) j6) & i5;
        Object obj = atomicReferenceArray.get(i6);
        boolean z6 = obj == f6446j;
        if (obj != null && !z6) {
            atomicReferenceArray.lazySet(i6, null);
            atomicLong.lazySet(j6 + 1);
            return obj;
        }
        if (!z6) {
            return null;
        }
        int i7 = i5 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i7);
        atomicReferenceArray.lazySet(i7, null);
        this.f6449g = atomicReferenceArray2;
        Object obj2 = atomicReferenceArray2.get(i6);
        if (obj2 != null) {
            atomicReferenceArray2.lazySet(i6, null);
            atomicLong.lazySet(j6 + 1);
        }
        return obj2;
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.f6447a;
        long j6 = atomicLong.get();
        long j7 = 2 + j6;
        int i5 = this.d;
        if (atomicReferenceArray.get(((int) j7) & i5) == null) {
            int i6 = ((int) j6) & i5;
            atomicReferenceArray.lazySet(i6 + 1, obj2);
            atomicReferenceArray.lazySet(i6, obj);
            atomicLong.lazySet(j7);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        int i7 = ((int) j6) & i5;
        atomicReferenceArray2.lazySet(i7 + 1, obj2);
        atomicReferenceArray2.lazySet(i7, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i7, f6446j);
        atomicLong.lazySet(j7);
        return true;
    }
}
