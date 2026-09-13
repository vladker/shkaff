package p028e4;

import O3.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.apache.commons.io.FileUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3946a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;
    public static final s Companion = new s();
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3945f = AtomicLongFieldUpdater.newUpdater(u.class, "_state$volatile");
    public static final H REMOVE_FROZEN = new H("REMOVE_FROZEN");

    public u(int i5, boolean z6) {
        this.f3946a = i5;
        this.b = z6;
        int i6 = i5 - 1;
        this.c = i6;
        this.d = new AtomicReferenceArray(i5);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i5 & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final boolean a() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        do {
            atomicLongFieldUpdater = f3945f;
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((FileUtils.ONE_EB & j6) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, 2305843009213693952L | j6));
        return true;
    }

    public final int addLast(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3945f;
            long j6 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j6) != 0) {
                Companion.getClass();
                return (2305843009213693952L & j6) != 0 ? 2 : 1;
            }
            int i5 = (int) (1073741823 & j6);
            int i6 = (int) ((1152921503533105152L & j6) >> 30);
            int i7 = this.c;
            if (((i6 + 2) & i7) == (i5 & i7)) {
                return 1;
            }
            boolean z6 = this.b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (z6 || atomicReferenceArray.get(i6 & i7) == null) {
                Companion.getClass();
                if (f3945f.compareAndSet(this, j6, ((-1152921503533105153L) & j6) | (((long) ((i6 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i6 & i7, obj);
                    u next = this;
                    while ((atomicLongFieldUpdater.get(next) & FileUtils.ONE_EB) != 0) {
                        next = next.next();
                        AtomicReferenceArray atomicReferenceArray2 = next.d;
                        int i8 = next.c & i6;
                        Object obj2 = atomicReferenceArray2.get(i8);
                        if ((obj2 instanceof t) && ((t) obj2).index == i6) {
                            atomicReferenceArray2.set(i8, obj);
                        } else {
                            next = null;
                        }
                        if (next == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i9 = this.f3946a;
                if (i9 < 1024 || ((i6 - i5) & 1073741823) > (i9 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final <R> List<R> map(l lVar) {
        ArrayList arrayList = new ArrayList(this.f3946a);
        long j6 = f3945f.get(this);
        int i5 = (int) (1073741823 & j6);
        int i6 = (int) ((j6 & 1152921503533105152L) >> 30);
        while (true) {
            int i7 = this.c;
            if ((i5 & i7) == (i6 & i7)) {
                return arrayList;
            }
            Object obj = this.d.get(i7 & i5);
            if (obj != null && !(obj instanceof t)) {
                arrayList.add(lVar.invoke(obj));
            }
            i5++;
        }
    }

    public final u next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        u uVar;
        while (true) {
            atomicLongFieldUpdater = f3945f;
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & FileUtils.ONE_EB) != 0) {
                uVar = this;
                break;
            }
            long j7 = FileUtils.ONE_EB | j6;
            uVar = this;
            if (atomicLongFieldUpdater.compareAndSet(uVar, j6, j7)) {
                j6 = j7;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            u uVar2 = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar2 != null) {
                return uVar2;
            }
            u uVar3 = new u(uVar.f3946a * 2, uVar.b);
            int i5 = (int) (1073741823 & j6);
            int i6 = (int) ((1152921503533105152L & j6) >> 30);
            while (true) {
                int i7 = uVar.c;
                int i8 = i5 & i7;
                if (i8 == (i7 & i6)) {
                    break;
                }
                Object tVar = uVar.d.get(i8);
                if (tVar == null) {
                    tVar = new t(i5);
                }
                uVar3.d.set(uVar3.c & i5, tVar);
                i5++;
            }
            Companion.getClass();
            atomicLongFieldUpdater.set(uVar3, (-1152921504606846977L) & j6);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, uVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object removeFirstOrNull() {
        u next = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3945f;
            long j6 = atomicLongFieldUpdater.get(next);
            if ((j6 & FileUtils.ONE_EB) != 0) {
                return REMOVE_FROZEN;
            }
            int i5 = (int) (j6 & 1073741823);
            int i6 = next.c;
            int i7 = i5 & i6;
            if ((((int) ((1152921503533105152L & j6) >> 30)) & i6) != i7) {
                AtomicReferenceArray atomicReferenceArray = next.d;
                Object obj = atomicReferenceArray.get(i7);
                boolean z6 = next.b;
                if (obj == null) {
                    if (z6) {
                    }
                } else if (!(obj instanceof t)) {
                    Companion.getClass();
                    long j7 = (i5 + 1) & 1073741823;
                    if (f3945f.compareAndSet(next, j6, (j6 & (-1073741824)) | j7)) {
                        atomicReferenceArray.set(i7, null);
                        return obj;
                    }
                    next = this;
                    if (z6) {
                        while (true) {
                            long j8 = atomicLongFieldUpdater.get(next);
                            int i8 = (int) (j8 & 1073741823);
                            if ((j8 & FileUtils.ONE_EB) != 0) {
                                next = next.next();
                            } else {
                                Companion.getClass();
                                u uVar = next;
                                if (f3945f.compareAndSet(uVar, j8, (j8 & (-1073741824)) | j7)) {
                                    uVar.d.set(i8 & uVar.c, null);
                                    next = null;
                                } else {
                                    next = uVar;
                                }
                            }
                            if (next == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
