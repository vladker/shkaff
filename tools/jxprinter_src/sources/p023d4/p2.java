package p023d4;

import A3.G;
import E3.g;
import E3.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.flow.internal.AbstractC1113b;
import kotlinx.coroutines.flow.internal.AbstractC1115d;
import kotlinx.coroutines.flow.internal.B;
import kotlinx.coroutines.flow.internal.E;
import p018c4.EnumC0368b;
import p028e4.H;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p2 extends AbstractC1113b implements V1, InterfaceC0582e, B {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(p2.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int c;

    public p2(Object obj) {
        this._state$volatile = obj;
    }

    @Override // p023d4.U1
    public final boolean b(Object obj) {
        d(obj);
        return true;
    }

    public final boolean c(Object obj, Object obj2) {
        if (obj == null) {
            obj = E.NULL;
        }
        if (obj2 == null) {
            obj2 = E.NULL;
        }
        return e(obj, obj2);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0092 A[Catch: all -> 0x003a, PHI: r2 r6 r7 r8 r11
  0x0092: PHI (r2v8 a4.H0) = (r2v6 a4.H0), (r2v7 a4.H0), (r2v7 a4.H0), (r2v10 a4.H0) binds: [B:35:0x0083, B:51:0x00c4, B:53:0x00d6, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0092: PHI (r6v7 ??) = (r6v11 ??), (r6v12 ??), (r6v13 ??), (r6v14 ??) binds: [B:35:0x0083, B:51:0x00c4, B:53:0x00d6, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0092: PHI (r7v2 d4.p) = (r7v0 d4.p), (r7v1 d4.p), (r7v1 d4.p), (r7v4 d4.p) binds: [B:35:0x0083, B:51:0x00c4, B:53:0x00d6, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0092: PHI (r8v6 ??) = (r8v10 ??), (r8v11 ??), (r8v12 ??), (r8v13 ??) binds: [B:35:0x0083, B:51:0x00c4, B:53:0x00d6, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0092: PHI (r11v7 java.lang.Object) = (r11v5 java.lang.Object), (r11v6 java.lang.Object), (r11v6 java.lang.Object), (r11v17 java.lang.Object) binds: [B:35:0x0083, B:51:0x00c4, B:53:0x00d6, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003a, blocks: (B:14:0x0036, B:36:0x0092, B:38:0x009a, B:40:0x009f, B:50:0x00c0, B:52:0x00c6, B:42:0x00a5, B:46:0x00ac, B:21:0x004f, B:24:0x005a, B:35:0x0083), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009a A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:14:0x0036, B:36:0x0092, B:38:0x009a, B:40:0x009f, B:50:0x00c0, B:52:0x00c6, B:42:0x00a5, B:46:0x00ac, B:21:0x004f, B:24:0x005a, B:35:0x0083), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009f A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:14:0x0036, B:36:0x0092, B:38:0x009a, B:40:0x009f, B:50:0x00c0, B:52:0x00c6, B:42:0x00a5, B:46:0x00ac, B:21:0x004f, B:24:0x005a, B:35:0x0083), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:48:0x00be  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c6 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:14:0x0036, B:36:0x0092, B:38:0x009a, B:40:0x009f, B:50:0x00c0, B:52:0x00c6, B:42:0x00a5, B:46:0x00ac, B:21:0x004f, B:24:0x005a, B:35:0x0083), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.d] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [d4.r2] */
    /* JADX WARN: Type inference failed for: r6v7, types: [d4.r2] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.flow.internal.b] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [d4.p2] */
    /* JADX WARN: Type inference failed for: r8v6, types: [d4.p2, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00c4 -> B:36:0x0092). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00d6 -> B:36:0x0092). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @Override // p023d4.V1, p023d4.n2, p023d4.Z1, p023d4.InterfaceC0612o
    public java.lang.Object collect(p023d4.InterfaceC0615p r11, E3.g<?> r12) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.p2.collect(d4.p, E3.g):java.lang.Object");
    }

    public final void d(Object obj) {
        if (obj == null) {
            obj = E.NULL;
        }
        e(null, obj);
    }

    public final boolean e(Object obj, Object obj2) {
        int i5;
        AbstractC1115d[] slots;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.E.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.E.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i6 = this.c;
            if ((i6 & 1) != 0) {
                this.c = i6 + 2;
                return true;
            }
            int i7 = i6 + 1;
            this.c = i7;
            AbstractC1115d[] slots2 = getSlots();
            while (true) {
                r2[] r2VarArr = (r2[]) slots2;
                if (r2VarArr != null) {
                    for (r2 r2Var : r2VarArr) {
                        if (r2Var != null) {
                            r2Var.b();
                        }
                    }
                }
                synchronized (this) {
                    i5 = this.c;
                    if (i5 == i7) {
                        this.c = i7 + 1;
                        return true;
                    }
                    slots = getSlots();
                }
                slots2 = slots;
                i7 = i5;
            }
        }
    }

    @Override // p023d4.V1, p023d4.U1, p023d4.InterfaceC0615p
    public Object emit(Object obj, g<? super Q> gVar) {
        d(obj);
        return Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.B
    public InterfaceC0612o fuse(q qVar, int i5, EnumC0368b enumC0368b) {
        return q2.fuseStateFlow(this, qVar, i5, enumC0368b);
    }

    @Override // p023d4.V1, p023d4.n2, p023d4.Z1
    public List<Object> getReplayCache() {
        return G.listOf(getValue());
    }

    @Override // p023d4.n2
    public final Object getValue() {
        H h6 = E.NULL;
        Object obj = d.get(this);
        if (obj == h6) {
            return null;
        }
        return obj;
    }

    @Override // p023d4.V1, p023d4.U1
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1113b
    public r2 createSlot() {
        return new r2();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1113b
    public r2[] createSlotArray(int i5) {
        return new r2[i5];
    }
}
