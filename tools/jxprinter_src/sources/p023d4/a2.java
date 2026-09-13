package p023d4;

import A3.I;
import E3.g;
import E3.q;
import F3.h;
import F3.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.flow.internal.AbstractC1113b;
import kotlinx.coroutines.flow.internal.AbstractC1114c;
import kotlinx.coroutines.flow.internal.AbstractC1115d;
import kotlinx.coroutines.flow.internal.B;
import p007a4.AbstractC0293o;
import p007a4.C0289m;
import p007a4.InterfaceC0280h0;
import p018c4.EnumC0368b;
import p028e4.H;
import p147z3.C1937q;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a2 extends AbstractC1113b implements U1, InterfaceC0582e, B {
    private Object[] buffer;
    public final int c;
    public final int d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3852h;
    private final EnumC0368b onBufferOverflow;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements InterfaceC0280h0 {
        public final g<Q> cont;
        public final a2 flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public a(a2 a2Var, long j6, Object obj, g<? super Q> gVar) {
            this.flow = a2Var;
            this.index = j6;
            this.value = obj;
            this.cont = gVar;
        }

        @Override // p007a4.InterfaceC0280h0
        public final void dispose() {
            a2.c(this.flow, this);
        }
    }

    public a2(int i5, int i6, EnumC0368b enumC0368b) {
        this.c = i5;
        this.d = i6;
        this.onBufferOverflow = enumC0368b;
    }

    public static final void c(a2 a2Var, a aVar) {
        synchronized (a2Var) {
            if (aVar.index < a2Var.j()) {
                return;
            }
            Object[] objArr = a2Var.buffer;
            E.c(objArr);
            if (c2.a(objArr, aVar.index) != aVar) {
                return;
            }
            c2.b(objArr, aVar.index, c2.NO_VALUE);
            a2Var.e();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        if (((p023d4.t2) r9).onSubscription(r0) == r1) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object f(p023d4.a2 r8, p023d4.InterfaceC0615p r9, E3.g r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.a2.f(d4.a2, d4.p, E3.g):java.lang.Object");
    }

    @Override // p023d4.U1
    public final boolean b(Object obj) {
        int i5;
        boolean z6;
        g<Q>[] gVarArrI = AbstractC1114c.EMPTY_RESUMES;
        synchronized (this) {
            if (m(obj)) {
                gVarArrI = i(gVarArrI);
                z6 = true;
            } else {
                z6 = false;
            }
        }
        for (g<Q> gVar : gVarArrI) {
            if (gVar != null) {
                gVar.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
            }
        }
        return z6;
    }

    @Override // p023d4.U1, p023d4.Z1, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<?> gVar) {
        return f(this, interfaceC0615p, gVar);
    }

    public final Object d(d2 d2Var, b2 b2Var) {
        C0289m c0289m = new C0289m(h.intercepted(b2Var), 1);
        c0289m.initCancellability();
        synchronized (this) {
            try {
                if (n(d2Var) < 0) {
                    d2Var.cont = c0289m;
                } else {
                    c0289m.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(b2Var);
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    public final void e() {
        if (this.d != 0 || this.f3852h > 1) {
            Object[] objArr = this.buffer;
            E.c(objArr);
            while (this.f3852h > 0 && c2.a(objArr, (j() + ((long) (this.f3851g + this.f3852h))) - 1) == c2.NO_VALUE) {
                this.f3852h--;
                c2.b(objArr, j() + ((long) (this.f3851g + this.f3852h)), null);
            }
        }
    }

    @Override // p023d4.U1, p023d4.InterfaceC0615p
    public Object emit(Object obj, g<? super Q> gVar) throws Throwable {
        Throwable th;
        g[] gVarArrI;
        a aVar;
        if (b(obj)) {
            return Q.INSTANCE;
        }
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        g[] gVarArrI2 = AbstractC1114c.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (m(obj)) {
                    try {
                        c0289m.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
                        gVarArrI = i(gVarArrI2);
                        aVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        aVar = new a(this, j() + ((long) (this.f3851g + this.f3852h)), obj, c0289m);
                        h(aVar);
                        this.f3852h++;
                        if (this.d == 0) {
                            gVarArrI2 = i(gVarArrI2);
                        }
                        gVarArrI = gVarArrI2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (aVar != null) {
                    AbstractC0293o.disposeOnCancellation(c0289m, aVar);
                }
                for (g gVar2 : gVarArrI) {
                    if (gVar2 != null) {
                        gVar2.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
                    }
                }
                Object result = c0289m.getResult();
                if (result == i.getCOROUTINE_SUSPENDED()) {
                    G3.h.probeCoroutineSuspended(gVar);
                }
                if (result != i.getCOROUTINE_SUSPENDED()) {
                    result = Q.INSTANCE;
                }
                return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.B
    public InterfaceC0612o fuse(q qVar, int i5, EnumC0368b enumC0368b) {
        return c2.fuseSharedFlow(this, qVar, i5, enumC0368b);
    }

    public final void g() {
        AbstractC1115d[] abstractC1115dArr;
        Object[] objArr = this.buffer;
        E.c(objArr);
        c2.b(objArr, j(), null);
        this.f3851g--;
        long j6 = j() + 1;
        if (this.e < j6) {
            this.e = j6;
        }
        if (this.f3850f < j6) {
            if (this.f5706a != 0 && (abstractC1115dArr = ((AbstractC1113b) this).slots) != null) {
                for (AbstractC1115d abstractC1115d : abstractC1115dArr) {
                    if (abstractC1115d != null) {
                        d2 d2Var = (d2) abstractC1115d;
                        long j7 = d2Var.index;
                        if (j7 >= 0 && j7 < j6) {
                            d2Var.index = j6;
                        }
                    }
                }
            }
            this.f3850f = j6;
        }
    }

    @Override // p023d4.U1, p023d4.Z1
    public List<Object> getReplayCache() {
        synchronized (this) {
            int iJ = (int) ((j() + ((long) this.f3851g)) - this.e);
            if (iJ == 0) {
                return I.emptyList();
            }
            ArrayList arrayList = new ArrayList(iJ);
            Object[] objArr = this.buffer;
            E.c(objArr);
            for (int i5 = 0; i5 < iJ; i5++) {
                arrayList.add(c2.a(objArr, this.e + ((long) i5)));
            }
            return arrayList;
        }
    }

    public final void h(Object obj) {
        int i5 = this.f3851g + this.f3852h;
        Object[] objArrL = this.buffer;
        if (objArrL == null) {
            objArrL = l(0, 2, null);
        } else if (i5 >= objArrL.length) {
            objArrL = l(i5, objArrL.length * 2, objArrL);
        }
        c2.b(objArrL, j() + ((long) i5), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [E3.g[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final g[] i(g[] gVarArr) {
        AbstractC1115d[] abstractC1115dArr;
        d2 d2Var;
        g<? super Q> gVar;
        int length = gVarArr.length;
        if (this.f5706a != 0 && (abstractC1115dArr = ((AbstractC1113b) this).slots) != null) {
            int length2 = abstractC1115dArr.length;
            int i5 = 0;
            while (i5 < length2) {
                AbstractC1115d abstractC1115d = abstractC1115dArr[i5];
                if (abstractC1115d == null || (gVar = (d2Var = (d2) abstractC1115d).cont) == null || n(d2Var) < 0) {
                    gVarArr = gVarArr;
                } else {
                    if (length >= gVarArr.length) {
                        gVarArr = gVarArr;
                        gVarArr = gVarArr;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) gVarArr, Math.max(2, gVarArr.length * 2));
                        E.e(objArrCopyOf, "copyOf(...)");
                        gVarArr = objArrCopyOf;
                    }
                    gVarArr = gVarArr;
                    gVarArr = gVarArr;
                    ((g[]) gVarArr)[length] = gVar;
                    d2Var.cont = null;
                    length++;
                }
                i5++;
                gVarArr = gVarArr;
            }
            gVarArr = gVarArr;
        }
        return (g[]) gVarArr;
    }

    public final long j() {
        return Math.min(this.f3850f, this.e);
    }

    public final Object k() {
        Object[] objArr = this.buffer;
        E.c(objArr);
        return c2.a(objArr, (this.e + ((long) ((int) ((j() + ((long) this.f3851g)) - this.e)))) - 1);
    }

    public final Object[] l(int i5, int i6, Object[] objArr) {
        if (i6 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i6];
        this.buffer = objArr2;
        if (objArr != null) {
            long j6 = j();
            for (int i7 = 0; i7 < i5; i7++) {
                long j7 = ((long) i7) + j6;
                c2.b(objArr2, j7, objArr[((int) j7) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    public final boolean m(Object obj) {
        int i5;
        long j6;
        long j7;
        int i6 = this.f5706a;
        int i7 = this.c;
        if (i6 != 0) {
            int i8 = this.f3851g;
            int i9 = this.d;
            if (i8 < i9 || this.f3850f > this.e) {
                h(obj);
                i5 = this.f3851g + 1;
                this.f3851g = i5;
                if (i5 > i9) {
                    g();
                }
                j6 = j() + ((long) this.f3851g);
                j7 = this.e;
                if (((int) (j6 - j7)) > i7) {
                    p(1 + j7, this.f3850f, j() + ((long) this.f3851g), j() + ((long) this.f3851g) + ((long) this.f3852h));
                }
            } else {
                int iOrdinal = this.onBufferOverflow.ordinal();
                if (iOrdinal == 0) {
                    return false;
                }
                if (iOrdinal == 1) {
                    h(obj);
                    i5 = this.f3851g + 1;
                    this.f3851g = i5;
                    if (i5 > i9) {
                        g();
                    }
                    j6 = j() + ((long) this.f3851g);
                    j7 = this.e;
                    if (((int) (j6 - j7)) > i7) {
                        p(1 + j7, this.f3850f, j() + ((long) this.f3851g), j() + ((long) this.f3851g) + ((long) this.f3852h));
                    }
                } else if (iOrdinal != 2) {
                    throw new C1937q();
                }
            }
        } else if (i7 != 0) {
            h(obj);
            int i10 = this.f3851g + 1;
            this.f3851g = i10;
            if (i10 > i7) {
                g();
            }
            this.f3850f = j() + ((long) this.f3851g);
            return true;
        }
        return true;
    }

    public final long n(d2 d2Var) {
        long j6 = d2Var.index;
        if (j6 < j() + ((long) this.f3851g)) {
            return j6;
        }
        if (this.d <= 0 && j6 <= j() && this.f3852h != 0) {
            return j6;
        }
        return -1L;
    }

    public final Object o(d2 d2Var) {
        Object obj;
        g<Q>[] gVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractC1114c.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jN = n(d2Var);
                if (jN < 0) {
                    obj = c2.NO_VALUE;
                } else {
                    long j6 = d2Var.index;
                    Object[] objArr = this.buffer;
                    E.c(objArr);
                    Object objA = c2.a(objArr, jN);
                    if (objA instanceof a) {
                        objA = ((a) objA).value;
                    }
                    d2Var.index = jN + 1;
                    Object obj2 = objA;
                    gVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j6);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (g<Q> gVar : gVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (gVar != null) {
                gVar.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
            }
        }
        return obj;
    }

    public final void p(long j6, long j7, long j8, long j9) {
        long jMin = Math.min(j7, j6);
        for (long j10 = j(); j10 < jMin; j10++) {
            Object[] objArr = this.buffer;
            E.c(objArr);
            c2.b(objArr, j10, null);
        }
        this.e = j6;
        this.f3850f = j7;
        this.f3851g = (int) (j8 - jMin);
        this.f3852h = (int) (j9 - j8);
    }

    @Override // p023d4.U1
    public final void resetReplayCache() throws Throwable {
        synchronized (this) {
            try {
                try {
                    p(j() + ((long) this.f3851g), this.f3850f, j() + ((long) this.f3851g), j() + ((long) this.f3851g) + ((long) this.f3852h));
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final g<Q>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j6) {
        long j7;
        long j8;
        long j9;
        AbstractC1115d[] abstractC1115dArr;
        if (j6 > this.f3850f) {
            return AbstractC1114c.EMPTY_RESUMES;
        }
        long j10 = j();
        long j11 = ((long) this.f3851g) + j10;
        int i5 = this.d;
        if (i5 == 0 && this.f3852h > 0) {
            j11++;
        }
        int i6 = 0;
        if (this.f5706a != 0 && (abstractC1115dArr = ((AbstractC1113b) this).slots) != null) {
            for (AbstractC1115d abstractC1115d : abstractC1115dArr) {
                if (abstractC1115d != null) {
                    long j12 = ((d2) abstractC1115d).index;
                    if (j12 >= 0 && j12 < j11) {
                        j11 = j12;
                    }
                }
            }
        }
        if (j11 <= this.f3850f) {
            return AbstractC1114c.EMPTY_RESUMES;
        }
        long j13 = j() + ((long) this.f3851g);
        int iMin = this.f5706a > 0 ? Math.min(this.f3852h, i5 - ((int) (j13 - j11))) : this.f3852h;
        g<Q>[] gVarArr = AbstractC1114c.EMPTY_RESUMES;
        long j14 = ((long) this.f3852h) + j13;
        if (iMin > 0) {
            gVarArr = new g[iMin];
            Object[] objArr = this.buffer;
            E.c(objArr);
            j9 = 1;
            long j15 = j13;
            while (true) {
                if (j13 >= j14) {
                    j7 = j10;
                    j8 = j11;
                    j13 = j15;
                    break;
                }
                j7 = j10;
                Object objA = c2.a(objArr, j13);
                H h6 = c2.NO_VALUE;
                j8 = j11;
                if (objA != h6) {
                    E.d(objA, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objA;
                    int i7 = i6 + 1;
                    gVarArr[i6] = aVar.cont;
                    c2.b(objArr, j13, h6);
                    c2.b(objArr, j15, aVar.value);
                    long j16 = j15 + 1;
                    if (i7 >= iMin) {
                        j13 = j16;
                        break;
                    }
                    j15 = j16;
                    i6 = i7;
                }
                j13++;
                j10 = j7;
                j11 = j8;
            }
        } else {
            j7 = j10;
            j8 = j11;
            j9 = 1;
        }
        int i8 = (int) (j13 - j7);
        long j17 = this.f5706a == 0 ? j13 : j8;
        long jMax = Math.max(this.e, j13 - ((long) Math.min(this.c, i8)));
        if (i5 == 0 && jMax < j14) {
            Object[] objArr2 = this.buffer;
            E.c(objArr2);
            if (E.a(c2.a(objArr2, jMax), c2.NO_VALUE)) {
                j13 += j9;
                jMax += j9;
            }
        }
        p(jMax, j17, j13, j14);
        e();
        return gVarArr.length == 0 ? gVarArr : i(gVarArr);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1113b
    public d2 createSlot() {
        d2 d2Var = new d2();
        d2Var.index = -1L;
        return d2Var;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1113b
    public d2[] createSlotArray(int i5) {
        return new d2[i5];
    }
}
