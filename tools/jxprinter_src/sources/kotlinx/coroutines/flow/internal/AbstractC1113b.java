package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import p018c4.EnumC0368b;
import p023d4.n2;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1113b {
    private L _subscriptionCount;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5706a;
    public int b;
    private AbstractC1115d[] slots;

    public final AbstractC1115d allocateSlot() {
        AbstractC1115d abstractC1115dCreateSlot;
        L l6;
        synchronized (this) {
            try {
                AbstractC1115d[] abstractC1115dArrCreateSlotArray = this.slots;
                if (abstractC1115dArrCreateSlotArray == null) {
                    abstractC1115dArrCreateSlotArray = createSlotArray(2);
                    this.slots = abstractC1115dArrCreateSlotArray;
                } else if (this.f5706a >= abstractC1115dArrCreateSlotArray.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractC1115dArrCreateSlotArray, abstractC1115dArrCreateSlotArray.length * 2);
                    kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
                    this.slots = (AbstractC1115d[]) objArrCopyOf;
                    abstractC1115dArrCreateSlotArray = (AbstractC1115d[]) objArrCopyOf;
                }
                int i5 = this.b;
                do {
                    abstractC1115dCreateSlot = abstractC1115dArrCreateSlotArray[i5];
                    if (abstractC1115dCreateSlot == null) {
                        abstractC1115dCreateSlot = createSlot();
                        abstractC1115dArrCreateSlotArray[i5] = abstractC1115dCreateSlot;
                    }
                    i5++;
                    if (i5 >= abstractC1115dArrCreateSlotArray.length) {
                        i5 = 0;
                    }
                    kotlin.jvm.internal.E.d(abstractC1115dCreateSlot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!abstractC1115dCreateSlot.a(this));
                this.b = i5;
                this.f5706a++;
                l6 = this._subscriptionCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l6 != null) {
            l6.q(1);
        }
        return abstractC1115dCreateSlot;
    }

    public abstract AbstractC1115d createSlot();

    public abstract AbstractC1115d[] createSlotArray(int i5);

    public final void forEachSlotLocked(O3.l lVar) {
        AbstractC1115d[] abstractC1115dArr;
        if (this.f5706a == 0 || (abstractC1115dArr = this.slots) == null) {
            return;
        }
        for (AbstractC1115d abstractC1115d : abstractC1115dArr) {
            if (abstractC1115d != null) {
                lVar.invoke(abstractC1115d);
            }
        }
    }

    public final void freeSlot(AbstractC1115d abstractC1115d) {
        L l6;
        int i5;
        E3.g<Q>[] gVarArrFreeLocked;
        synchronized (this) {
            try {
                int i6 = this.f5706a - 1;
                this.f5706a = i6;
                l6 = this._subscriptionCount;
                if (i6 == 0) {
                    this.b = 0;
                }
                kotlin.jvm.internal.E.d(abstractC1115d, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                gVarArrFreeLocked = abstractC1115d.freeLocked(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (E3.g<Q> gVar : gVarArrFreeLocked) {
            if (gVar != null) {
                gVar.resumeWith(p147z3.u.m1361constructorimpl(Q.INSTANCE));
            }
        }
        if (l6 != null) {
            l6.q(-1);
        }
    }

    public final AbstractC1115d[] getSlots() {
        return this.slots;
    }

    public final n2 getSubscriptionCount() {
        L l6;
        synchronized (this) {
            l6 = this._subscriptionCount;
            if (l6 == null) {
                int i5 = this.f5706a;
                l6 = new L(1, Integer.MAX_VALUE, EnumC0368b.b);
                l6.b(Integer.valueOf(i5));
                this._subscriptionCount = l6;
            }
        }
        return l6;
    }
}
