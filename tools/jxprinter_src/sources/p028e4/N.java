package p028e4;

import O3.l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.E;
import p007a4.AbstractRunnableC0294o0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class N {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(N.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private O[] f3937a;

    public final void a(int i5) {
        while (i5 > 0) {
            O[] oArr = this.f3937a;
            E.c(oArr);
            int i6 = (i5 - 1) / 2;
            O o6 = oArr[i6];
            E.c(o6);
            O o7 = oArr[i5];
            E.c(o7);
            if (((Comparable) o6).compareTo(o7) <= 0) {
                return;
            }
            b(i5, i6);
            i5 = i6;
        }
    }

    public final void addImpl(O o6) {
        o6.setHeap(this);
        O[] oArr = this.f3937a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (oArr == null) {
            oArr = new O[4];
            this.f3937a = oArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= oArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(oArr, atomicIntegerFieldUpdater.get(this) * 2);
            E.e(objArrCopyOf, "copyOf(...)");
            oArr = (O[]) objArrCopyOf;
            this.f3937a = oArr;
        }
        int i5 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i5 + 1);
        oArr[i5] = o6;
        ((AbstractRunnableC0294o0) o6).f955a = i5;
        a(i5);
    }

    public final void addLast(O o6) {
        synchronized (this) {
            addImpl(o6);
        }
    }

    public final boolean addLastIf(O o6, l lVar) {
        boolean z6;
        synchronized (this) {
            if (((Boolean) lVar.invoke(firstImpl())).booleanValue()) {
                addImpl(o6);
                z6 = true;
            } else {
                z6 = false;
            }
        }
        return z6;
    }

    public final void b(int i5, int i6) {
        O[] oArr = this.f3937a;
        E.c(oArr);
        O o6 = oArr[i6];
        E.c(o6);
        O o7 = oArr[i5];
        E.c(o7);
        oArr[i5] = o6;
        oArr[i6] = o7;
        ((AbstractRunnableC0294o0) o6).f955a = i5;
        ((AbstractRunnableC0294o0) o7).f955a = i6;
    }

    public final O find(l lVar) {
        O o6;
        synchronized (this) {
            try {
                int i5 = b.get(this);
                int i6 = 0;
                while (true) {
                    o6 = null;
                    if (i6 >= i5) {
                        break;
                    }
                    O[] oArr = this.f3937a;
                    o6 = oArr != null ? oArr[i6] : null;
                    E.c(o6);
                    if (((Boolean) lVar.invoke(o6)).booleanValue()) {
                        break;
                    }
                    i6++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o6;
    }

    public final O firstImpl() {
        O[] oArr = this.f3937a;
        if (oArr != null) {
            return oArr[0];
        }
        return null;
    }

    public final O peek() {
        O oFirstImpl;
        synchronized (this) {
            oFirstImpl = firstImpl();
        }
        return oFirstImpl;
    }

    public final boolean remove(O o6) {
        boolean z6;
        synchronized (this) {
            if (o6.getHeap() == null) {
                z6 = false;
            } else {
                removeAtImpl(((AbstractRunnableC0294o0) o6).f955a);
                z6 = true;
            }
        }
        return z6;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0047  */
    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    /* JADX WARN: Code duplicated, block: B:21:0x007b A[LOOP:0: B:9:0x003c->B:21:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0080 A[EDGE_INSN: B:24:0x0080->B:22:0x0080 BREAK  A[LOOP:0: B:9:0x003c->B:21:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[EDGE_INSN: B:25:0x0080->B:22:0x0080 BREAK  A[LOOP:0: B:9:0x003c->B:21:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:? A[SYNTHETIC] */
    public final O removeAtImpl(int i5) {
        int i6;
        int i7;
        O[] oArr;
        int i8;
        O o6;
        O o7;
        O o8;
        O o9;
        O[] oArr2 = this.f3937a;
        E.c(oArr2);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        atomicIntegerFieldUpdater.set(this, atomicIntegerFieldUpdater.get(this) - 1);
        if (i5 < atomicIntegerFieldUpdater.get(this)) {
            b(i5, atomicIntegerFieldUpdater.get(this));
            int i9 = (i5 - 1) / 2;
            if (i5 > 0) {
                O o10 = oArr2[i5];
                E.c(o10);
                O o11 = oArr2[i9];
                E.c(o11);
                if (((Comparable) o10).compareTo(o11) < 0) {
                    b(i5, i9);
                    a(i9);
                } else {
                    while (true) {
                        i6 = i5 * 2;
                        i7 = i6 + 1;
                        if (i7 >= atomicIntegerFieldUpdater.get(this)) {
                            break;
                        }
                        oArr = this.f3937a;
                        E.c(oArr);
                        i8 = i6 + 2;
                        if (i8 < atomicIntegerFieldUpdater.get(this)) {
                            o8 = oArr[i8];
                            E.c(o8);
                            o9 = oArr[i7];
                            E.c(o9);
                            if (((Comparable) o8).compareTo(o9) >= 0) {
                                i8 = i7;
                            }
                        } else {
                            i8 = i7;
                        }
                        o6 = oArr[i5];
                        E.c(o6);
                        o7 = oArr[i8];
                        E.c(o7);
                        if (((Comparable) o6).compareTo(o7) <= 0) {
                            break;
                        }
                        b(i5, i8);
                        i5 = i8;
                    }
                }
            } else {
                while (true) {
                    i6 = i5 * 2;
                    i7 = i6 + 1;
                    if (i7 >= atomicIntegerFieldUpdater.get(this)) {
                        break;
                        break;
                    }
                    oArr = this.f3937a;
                    E.c(oArr);
                    i8 = i6 + 2;
                    if (i8 < atomicIntegerFieldUpdater.get(this)) {
                        o8 = oArr[i8];
                        E.c(o8);
                        o9 = oArr[i7];
                        E.c(o9);
                        if (((Comparable) o8).compareTo(o9) >= 0) {
                            i8 = i7;
                        }
                    } else {
                        i8 = i7;
                    }
                    o6 = oArr[i5];
                    E.c(o6);
                    o7 = oArr[i8];
                    E.c(o7);
                    if (((Comparable) o6).compareTo(o7) <= 0) {
                        break;
                        break;
                    }
                    b(i5, i8);
                    i5 = i8;
                }
            }
        }
        O o12 = oArr2[atomicIntegerFieldUpdater.get(this)];
        E.c(o12);
        o12.setHeap(null);
        ((AbstractRunnableC0294o0) o12).f955a = -1;
        oArr2[atomicIntegerFieldUpdater.get(this)] = null;
        return o12;
    }

    public final O removeFirstIf(l lVar) {
        synchronized (this) {
            O oFirstImpl = firstImpl();
            if (oFirstImpl == null) {
                return null;
            }
            return ((Boolean) lVar.invoke(oFirstImpl)).booleanValue() ? removeAtImpl(0) : null;
        }
    }

    public final O removeFirstOrNull() {
        O oRemoveAtImpl;
        synchronized (this) {
            oRemoveAtImpl = b.get(this) > 0 ? removeAtImpl(0) : null;
        }
        return oRemoveAtImpl;
    }
}
