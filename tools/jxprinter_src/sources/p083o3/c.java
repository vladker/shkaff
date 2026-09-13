package p083o3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p043h3.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AtomicReferenceArray implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f6443f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6444a;
    public final AtomicLong b;
    public long c;
    public final AtomicLong d;
    public final int e;

    public c(int i5) {
        super(1 << (32 - Integer.numberOfLeadingZeros(i5 - 1)));
        this.f6444a = length() - 1;
        this.b = new AtomicLong();
        this.d = new AtomicLong();
        this.e = Math.min(i5 / 4, f6443f.intValue());
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
        return this.b.get() == this.d.get();
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicLong atomicLong = this.b;
        long j6 = atomicLong.get();
        int i5 = this.f6444a;
        int i6 = ((int) j6) & i5;
        if (j6 >= this.c) {
            long j7 = ((long) this.e) + j6;
            if (get(i5 & ((int) j7)) == null) {
                this.c = j7;
            } else if (get(i6) != null) {
                return false;
            }
        }
        lazySet(i6, obj);
        atomicLong.lazySet(j6 + 1);
        return true;
    }

    @Override // p043h3.i, p043h3.j
    public Object poll() {
        AtomicLong atomicLong = this.d;
        long j6 = atomicLong.get();
        int i5 = ((int) j6) & this.f6444a;
        Object obj = get(i5);
        if (obj == null) {
            return null;
        }
        atomicLong.lazySet(j6 + 1);
        lazySet(i5, null);
        return obj;
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        return offer(obj) && offer(obj2);
    }
}
