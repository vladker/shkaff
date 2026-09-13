package p018c4;

import A3.C0130a;
import E3.g;
import E3.q;
import F3.i;
import G3.b;
import O3.l;
import O3.p;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p007a4.P;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class p0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object any(B0 b1, g gVar) throws Throwable {
        L l6;
        if (gVar instanceof L) {
            l6 = (L) gVar;
            int i5 = l6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                l6.c = i5 - Integer.MIN_VALUE;
            } else {
                l6 = new L(gVar);
            }
        } else {
            l6 = new L(gVar);
        }
        Object objHasNext = l6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = l6.c;
        try {
            if (i6 == 0) {
                v.throwOnFailure(objHasNext);
                InterfaceC0395z it = b1.iterator();
                l6.f1107a = b1;
                l6.c = 1;
                objHasNext = ((C0374e) it).hasNext(l6);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b1 = l6.f1107a;
                v.throwOnFailure(objHasNext);
            }
            F.cancelConsumed(b1, null);
            return objHasNext;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                F.cancelConsumed(b1, th);
                throw th2;
            }
        }
    }

    public static final <E, R> R consume(InterfaceC0366a interfaceC0366a, l lVar) {
        B0 b0A = interfaceC0366a.a();
        try {
            return (R) lVar.invoke(b0A);
        } finally {
            b0A.cancel((CancellationException) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:24:0x005b, B:26:0x0063), top: B:35:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0056 -> B:24:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <E> java.lang.Object consumeEach(p018c4.InterfaceC0366a r6, O3.l r7, E3.g<? super p147z3.Q> r8) {
        /*
            boolean r0 = r8 instanceof p018c4.M
            if (r0 == 0) goto L13
            r0 = r8
            c4.M r0 = (p018c4.M) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.M r0 = new c4.M
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            O3.l r2 = r0.f1108a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L30:
            r6 = move-exception
            goto L7c
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            p147z3.v.throwOnFailure(r8)
            c4.B0 r6 = r6.a()
            c4.z r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7a
        L45:
            r0.f1108a = r7     // Catch: java.lang.Throwable -> L7a
            r0.b = r6     // Catch: java.lang.Throwable -> L7a
            r0.c = r8     // Catch: java.lang.Throwable -> L7a
            r0.e = r4     // Catch: java.lang.Throwable -> L7a
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L7a
            if (r2 != r1) goto L56
            return r1
        L56:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L5b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L30
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L70
            r8 = r6
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L30
            java.lang.Object r6 = r8.a()     // Catch: java.lang.Throwable -> L30
            r2.invoke(r6)     // Catch: java.lang.Throwable -> L30
            r6 = r7
            r7 = r2
            goto L45
        L70:
            r7.cancel(r3)
            z3.Q r6 = p147z3.Q.INSTANCE
            return r6
        L76:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L7c
        L7a:
            r7 = move-exception
            goto L76
        L7c:
            r7.cancel(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.consumeEach(c4.a, O3.l, E3.g):java.lang.Object");
    }

    private static final <E> Object consumeEach$$forInline(InterfaceC0366a interfaceC0366a, l lVar, g<? super Q> gVar) {
        B0 b0A = interfaceC0366a.a();
        try {
            InterfaceC0395z it = b0A.iterator();
            while (true) {
                C0374e c0374e = (C0374e) it;
                if (!((Boolean) c0374e.hasNext(null)).booleanValue()) {
                    b0A.cancel((CancellationException) null);
                    return Q.INSTANCE;
                }
                lVar.invoke(c0374e.a());
            }
        } catch (Throwable th) {
            b0A.cancel((CancellationException) null);
            throw th;
        }
    }

    public static final l consumes(B0 b1) {
        return new C0130a(b1, 11);
    }

    public static final l consumesAll(B0... b0Arr) {
        return new C0130a(b0Arr, 12);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:24:0x005c, B:26:0x0064), top: B:41:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:24:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object count(p018c4.B0 r6, E3.g r7) {
        /*
            boolean r0 = r7 instanceof p018c4.N
            if (r0 == 0) goto L13
            r0 = r7
            c4.N r0 = (p018c4.N) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.N r0 = new c4.N
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            c4.z r6 = r0.c
            c4.B0 r2 = r0.b
            kotlin.jvm.internal.Q r4 = r0.f1109a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2f
            goto L5c
        L2f:
            r6 = move-exception
            goto L82
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            p147z3.v.throwOnFailure(r7)
            kotlin.jvm.internal.Q r7 = new kotlin.jvm.internal.Q
            r7.<init>()
            c4.z r2 = r6.iterator()     // Catch: java.lang.Throwable -> L80
            r4 = r7
        L46:
            r0.f1109a = r4     // Catch: java.lang.Throwable -> L80
            r0.b = r6     // Catch: java.lang.Throwable -> L80
            r0.c = r2     // Catch: java.lang.Throwable -> L80
            r0.e = r3     // Catch: java.lang.Throwable -> L80
            r7 = r2
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L80
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L80
            if (r2 != r1) goto L58
            return r1
        L58:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L2f
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L72
            c4.e r6 = (p018c4.C0374e) r6     // Catch: java.lang.Throwable -> L2f
            r6.a()     // Catch: java.lang.Throwable -> L2f
            int r7 = r4.f5687a     // Catch: java.lang.Throwable -> L2f
            int r7 = r7 + r3
            r4.f5687a = r7     // Catch: java.lang.Throwable -> L2f
            r5 = r2
            r2 = r6
            r6 = r5
            goto L46
        L72:
            r6 = 0
            p018c4.F.cancelConsumed(r2, r6)
            int r6 = r4.f5687a
            java.lang.Integer r6 = G3.b.boxInt(r6)
            return r6
        L7d:
            r2 = r6
            r6 = r7
            goto L82
        L80:
            r7 = move-exception
            goto L7d
        L82:
            throw r6     // Catch: java.lang.Throwable -> L83
        L83:
            r7 = move-exception
            p018c4.F.cancelConsumed(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.count(c4.B0, E3.g):java.lang.Object");
    }

    public static final B0 distinct(B0 b1) {
        return F.distinctBy(b1, C0276f0.getUnconfined(), new O(2, null, 0));
    }

    public static final <E, K> B0 distinctBy(B0 b1, q qVar, p pVar) {
        return v0.produce(C0315z0.INSTANCE, qVar, 0, P.f943a, F.consumes(b1), new P(b1, pVar, null));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x0062, B:27:0x006a, B:33:0x007d, B:34:0x0094), top: B:46:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0062). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object elementAt(p018c4.B0 r9, int r10, E3.g r11) {
        /*
            boolean r0 = r11 instanceof p018c4.T
            if (r0 == 0) goto L13
            r0 = r11
            c4.T r0 = (p018c4.T) r0
            int r1 = r0.f1122f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1122f = r1
            goto L18
        L13:
            c4.T r0 = new c4.T
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1122f
            r3 = 46
            r4 = 1
            java.lang.String r5 = "ReceiveChannel doesn't contain element at index "
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            int r9 = r0.b
            int r10 = r0.f1121a
            c4.z r2 = r0.d
            c4.B0 r6 = r0.c
            p147z3.v.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L35
            goto L62
        L35:
            r9 = move-exception
            goto Laf
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            p147z3.v.throwOnFailure(r11)
            if (r10 < 0) goto L9a
            c4.z r11 = r9.iterator()     // Catch: java.lang.Throwable -> L98
            r2 = 0
        L4a:
            r0.c = r9     // Catch: java.lang.Throwable -> L98
            r0.d = r11     // Catch: java.lang.Throwable -> L98
            r0.f1121a = r10     // Catch: java.lang.Throwable -> L98
            r0.b = r2     // Catch: java.lang.Throwable -> L98
            r0.f1122f = r4     // Catch: java.lang.Throwable -> L98
            c4.e r11 = (p018c4.C0374e) r11     // Catch: java.lang.Throwable -> L98
            java.lang.Object r6 = r11.hasNext(r0)     // Catch: java.lang.Throwable -> L98
            if (r6 != r1) goto L5d
            return r1
        L5d:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L62:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L35
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r11 == 0) goto L7d
            r11 = r2
            c4.e r11 = (p018c4.C0374e) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r11.a()     // Catch: java.lang.Throwable -> L35
            int r7 = r9 + 1
            if (r10 != r9) goto L7a
            r9 = 0
            p018c4.F.cancelConsumed(r6, r9)
            return r2
        L7a:
            r9 = r6
            r2 = r7
            goto L4a
        L7d:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r11.<init>()     // Catch: java.lang.Throwable -> L35
            r11.append(r5)     // Catch: java.lang.Throwable -> L35
            r11.append(r10)     // Catch: java.lang.Throwable -> L35
            r11.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L35
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L35
            throw r9     // Catch: java.lang.Throwable -> L35
        L95:
            r6 = r9
            r9 = r10
            goto Laf
        L98:
            r10 = move-exception
            goto L95
        L9a:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L98
            r0.append(r10)     // Catch: java.lang.Throwable -> L98
            r0.append(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L98
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L98
            throw r11     // Catch: java.lang.Throwable -> L98
        Laf:
            throw r9     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r10 = move-exception
            p018c4.F.cancelConsumed(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.elementAt(c4.B0, int, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0060 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:29:0x006c A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #0 {all -> 0x0084, blocks: (B:27:0x0064, B:29:0x006c, B:23:0x004e, B:22:0x0049), top: B:44:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0077  */
    /* JADX WARN: Code duplicated, block: B:34:0x007b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0061 -> B:27:0x0064). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object elementAtOrNull(p018c4.B0 r8, int r9, E3.g r10) {
        /*
            boolean r0 = r10 instanceof p018c4.U
            if (r0 == 0) goto L13
            r0 = r10
            c4.U r0 = (p018c4.U) r0
            int r1 = r0.f1124f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1124f = r1
            goto L18
        L13:
            c4.U r0 = new c4.U
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1124f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r8 = r0.b
            int r9 = r0.f1123a
            c4.z r2 = r0.d
            c4.B0 r5 = r0.c
            p147z3.v.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L36
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r7
            goto L64
        L36:
            r8 = move-exception
            goto L86
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            p147z3.v.throwOnFailure(r10)
            if (r9 >= 0) goto L49
            p018c4.F.cancelConsumed(r8, r4)
            return r4
        L49:
            c4.z r10 = r8.iterator()     // Catch: java.lang.Throwable -> L84
            r2 = 0
        L4e:
            r0.c = r8     // Catch: java.lang.Throwable -> L84
            r0.d = r10     // Catch: java.lang.Throwable -> L84
            r0.f1123a = r9     // Catch: java.lang.Throwable -> L84
            r0.b = r2     // Catch: java.lang.Throwable -> L84
            r0.f1124f = r3     // Catch: java.lang.Throwable -> L84
            c4.e r10 = (p018c4.C0374e) r10     // Catch: java.lang.Throwable -> L84
            java.lang.Object r5 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> L84
            if (r5 != r1) goto L61
            return r1
        L61:
            r7 = r5
            r5 = r10
            r10 = r7
        L64:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L84
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L84
            if (r10 == 0) goto L80
            r10 = r5
            c4.e r10 = (p018c4.C0374e) r10     // Catch: java.lang.Throwable -> L84
            java.lang.Object r5 = r10.a()     // Catch: java.lang.Throwable -> L84
            int r6 = r2 + 1
            if (r9 != r2) goto L7b
            p018c4.F.cancelConsumed(r8, r4)
            return r5
        L7b:
            r2 = r6
            goto L4e
        L7d:
            r5 = r8
            r8 = r9
            goto L86
        L80:
            p018c4.F.cancelConsumed(r8, r4)
            return r4
        L84:
            r9 = move-exception
            goto L7d
        L86:
            throw r8     // Catch: java.lang.Throwable -> L87
        L87:
            r9 = move-exception
            p018c4.F.cancelConsumed(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.elementAtOrNull(c4.B0, int, E3.g):java.lang.Object");
    }

    public static final <E> B0 filter(B0 b1, q qVar, p pVar) {
        return v0.produce(C0315z0.INSTANCE, qVar, 0, P.f943a, F.consumes(b1), new S(b1, pVar, null, 1));
    }

    public static final <E> B0 filterNotNull(B0 b1) {
        B0 b0Filter = F.filter(b1, C0276f0.getUnconfined(), new O(2, null, 1));
        E.d(b0Filter, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return b0Filter;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c A[Catch: all -> 0x0032, TryCatch #1 {all -> 0x0032, blocks: (B:13:0x002e, B:28:0x0064, B:30:0x006c, B:32:0x0074, B:20:0x0043), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0074 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #1 {all -> 0x0032, blocks: (B:13:0x002e, B:28:0x0064, B:30:0x006c, B:32:0x0074, B:20:0x0043), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [c4.D0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [c4.D0] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [c4.D0] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0072 -> B:35:0x0083). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:35:0x0083). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object filterNotNullTo(p018c4.B0 r6, p018c4.D0 r7, E3.g r8) {
        /*
            boolean r0 = r8 instanceof p018c4.X
            if (r0 == 0) goto L13
            r0 = r8
            c4.X r0 = (p018c4.X) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.X r0 = new c4.X
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            c4.D0 r2 = r0.f1130a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L32
            goto L83
        L32:
            r6 = move-exception
            goto L92
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            c4.D0 r2 = r0.f1130a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L32
            goto L64
        L47:
            p147z3.v.throwOnFailure(r8)
            c4.z r8 = r6.iterator()     // Catch: java.lang.Throwable -> L90
        L4e:
            r0.f1130a = r7     // Catch: java.lang.Throwable -> L90
            r0.b = r6     // Catch: java.lang.Throwable -> L90
            r0.c = r8     // Catch: java.lang.Throwable -> L90
            r0.e = r4     // Catch: java.lang.Throwable -> L90
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L90
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L90
            if (r2 != r1) goto L5f
            goto L82
        L5f:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            if (r8 == 0) goto L87
            c4.e r6 = (p018c4.C0374e) r6     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r6.a()     // Catch: java.lang.Throwable -> L32
            if (r8 == 0) goto L83
            r0.f1130a = r2     // Catch: java.lang.Throwable -> L32
            r0.b = r7     // Catch: java.lang.Throwable -> L32
            r0.c = r6     // Catch: java.lang.Throwable -> L32
            r0.e = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r2.send(r8, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L83
        L82:
            return r1
        L83:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L4e
        L87:
            r6 = 0
            p018c4.F.cancelConsumed(r7, r6)
            return r2
        L8c:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L92
        L90:
            r7 = move-exception
            goto L8c
        L92:
            throw r6     // Catch: java.lang.Throwable -> L93
        L93:
            r8 = move-exception
            p018c4.F.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.filterNotNullTo(c4.B0, c4.D0, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #1 {all -> 0x002d, blocks: (B:12:0x0029, B:23:0x0051, B:25:0x0059, B:28:0x0064, B:29:0x006b), top: B:39:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0064 A[Catch: all -> 0x002d, TRY_ENTER, TryCatch #1 {all -> 0x002d, blocks: (B:12:0x0029, B:23:0x0051, B:25:0x0059, B:28:0x0064, B:29:0x006b), top: B:39:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object first(B0 b1, g gVar) throws Throwable {
        Y y6;
        B0 b6;
        Throwable th;
        InterfaceC0395z interfaceC0395z;
        if (gVar instanceof Y) {
            y6 = (Y) gVar;
            int i5 = y6.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                y6.d = i5 - Integer.MIN_VALUE;
            } else {
                y6 = new Y(gVar);
            }
        } else {
            y6 = new Y(gVar);
        }
        Object obj = y6.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = y6.d;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0395z = y6.b;
            b6 = y6.f1131a;
            try {
                v.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object objA = ((C0374e) interfaceC0395z).a();
                F.cancelConsumed(b6, null);
                return objA;
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    F.cancelConsumed(b6, th);
                    throw th3;
                }
            }
        }
        v.throwOnFailure(obj);
        try {
            InterfaceC0395z it = b1.iterator();
            y6.f1131a = b1;
            y6.b = it;
            y6.d = 1;
            C0374e c0374e = (C0374e) it;
            Object objHasNext = c0374e.hasNext(y6);
            if (objHasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            b6 = b1;
            interfaceC0395z = c0374e;
            obj = objHasNext;
            if (((Boolean) obj).booleanValue()) {
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
            Object objA2 = ((C0374e) interfaceC0395z).a();
            F.cancelConsumed(b6, null);
            return objA2;
        } catch (Throwable th4) {
            b6 = b1;
            th = th4;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object firstOrNull(B0 b1, g gVar) throws Throwable {
        Z z6;
        B0 b6;
        Throwable th;
        InterfaceC0395z interfaceC0395z;
        if (gVar instanceof Z) {
            z6 = (Z) gVar;
            int i5 = z6.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                z6.d = i5 - Integer.MIN_VALUE;
            } else {
                z6 = new Z(gVar);
            }
        } else {
            z6 = new Z(gVar);
        }
        Object obj = z6.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = z6.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            try {
                InterfaceC0395z it = b1.iterator();
                z6.f1132a = b1;
                z6.b = it;
                z6.d = 1;
                C0374e c0374e = (C0374e) it;
                Object objHasNext = c0374e.hasNext(z6);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                b6 = b1;
                interfaceC0395z = c0374e;
                obj = objHasNext;
            } catch (Throwable th2) {
                b6 = b1;
                th = th2;
                throw th;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0395z = z6.b;
            b6 = z6.f1132a;
            try {
                v.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    F.cancelConsumed(b6, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            F.cancelConsumed(b6, null);
            return null;
        }
        Object objA = ((C0374e) interfaceC0395z).a();
        F.cancelConsumed(b6, null);
        return objA;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:24:0x0061, B:26:0x006a, B:28:0x0076, B:31:0x0080), top: B:42:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0076 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:24:0x0061, B:26:0x006a, B:28:0x0076, B:31:0x0080), top: B:42:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0080 A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:24:0x0061, B:26:0x006a, B:28:0x0076, B:31:0x0080), top: B:42:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005b -> B:24:0x0061). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object indexOf(p018c4.B0 r7, java.lang.Object r8, E3.g r9) {
        /*
            boolean r0 = r9 instanceof p018c4.C0367a0
            if (r0 == 0) goto L13
            r0 = r9
            c4.a0 r0 = (p018c4.C0367a0) r0
            int r1 = r0.f1134f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1134f = r1
            goto L18
        L13:
            c4.a0 r0 = new c4.a0
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1134f
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            c4.z r7 = r0.d
            c4.B0 r8 = r0.c
            kotlin.jvm.internal.Q r2 = r0.b
            java.lang.Object r4 = r0.f1133a
            p147z3.v.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L31
            goto L61
        L31:
            r7 = move-exception
            goto L99
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            p147z3.v.throwOnFailure(r9)
            kotlin.jvm.internal.Q r9 = new kotlin.jvm.internal.Q
            r9.<init>()
            c4.z r2 = r7.iterator()     // Catch: java.lang.Throwable -> L97
        L48:
            r0.f1133a = r8     // Catch: java.lang.Throwable -> L97
            r0.b = r9     // Catch: java.lang.Throwable -> L97
            r0.c = r7     // Catch: java.lang.Throwable -> L97
            r0.d = r2     // Catch: java.lang.Throwable -> L97
            r0.f1134f = r3     // Catch: java.lang.Throwable -> L97
            c4.e r2 = (p018c4.C0374e) r2     // Catch: java.lang.Throwable -> L97
            java.lang.Object r4 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> L97
            if (r4 != r1) goto L5b
            return r1
        L5b:
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r4
            r4 = r6
        L61:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L31
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L31
            r5 = 0
            if (r9 == 0) goto L8a
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L31
            java.lang.Object r9 = r7.a()     // Catch: java.lang.Throwable -> L31
            boolean r9 = kotlin.jvm.internal.E.a(r4, r9)     // Catch: java.lang.Throwable -> L31
            if (r9 == 0) goto L80
            int r7 = r2.f5687a     // Catch: java.lang.Throwable -> L31
            java.lang.Integer r7 = G3.b.boxInt(r7)     // Catch: java.lang.Throwable -> L31
            p018c4.F.cancelConsumed(r8, r5)
            return r7
        L80:
            int r9 = r2.f5687a     // Catch: java.lang.Throwable -> L31
            int r9 = r9 + r3
            r2.f5687a = r9     // Catch: java.lang.Throwable -> L31
            r9 = r2
            r2 = r7
            r7 = r8
            r8 = r4
            goto L48
        L8a:
            p018c4.F.cancelConsumed(r8, r5)
            r7 = -1
            java.lang.Integer r7 = G3.b.boxInt(r7)
            return r7
        L93:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L99
        L97:
            r8 = move-exception
            goto L93
        L99:
            throw r7     // Catch: java.lang.Throwable -> L9a
        L9a:
            r9 = move-exception
            p018c4.F.cancelConsumed(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.indexOf(c4.B0, java.lang.Object, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0083  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002e, B:37:0x0087, B:39:0x008f), top: B:51:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0083 -> B:37:0x0087). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object last(p018c4.B0 r6, E3.g r7) {
        /*
            boolean r0 = r7 instanceof p018c4.C0369b0
            if (r0 == 0) goto L13
            r0 = r7
            c4.b0 r0 = (p018c4.C0369b0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.b0 r0 = new c4.b0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.c
            c4.z r2 = r0.b
            c4.B0 r4 = r0.f1136a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L32
            goto L87
        L32:
            r6 = move-exception
            r2 = r4
            goto La8
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            c4.z r6 = r0.b
            c4.B0 r2 = r0.f1136a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L46
            goto L63
        L46:
            r6 = move-exception
            goto La8
        L49:
            p147z3.v.throwOnFailure(r7)
            c4.z r7 = r6.iterator()     // Catch: java.lang.Throwable -> L9c
            r0.f1136a = r6     // Catch: java.lang.Throwable -> L9c
            r0.b = r7     // Catch: java.lang.Throwable -> L9c
            r0.e = r4     // Catch: java.lang.Throwable -> L9c
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L9c
            if (r2 != r1) goto L5f
            goto L82
        L5f:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L63:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L46
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L46
            if (r7 == 0) goto La0
            c4.e r6 = (p018c4.C0374e) r6     // Catch: java.lang.Throwable -> L46
            java.lang.Object r7 = r6.a()     // Catch: java.lang.Throwable -> L46
            r5 = r2
            r2 = r6
            r6 = r5
        L74:
            r0.f1136a = r6     // Catch: java.lang.Throwable -> L9c
            r0.b = r2     // Catch: java.lang.Throwable -> L9c
            r0.c = r7     // Catch: java.lang.Throwable -> L9c
            r0.e = r3     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r4 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> L9c
            if (r4 != r1) goto L83
        L82:
            return r1
        L83:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L87:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L32
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto L97
            c4.e r2 = (p018c4.C0374e) r2     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = r2.a()     // Catch: java.lang.Throwable -> L32
            r6 = r4
            goto L74
        L97:
            r7 = 0
            p018c4.F.cancelConsumed(r4, r7)
            return r6
        L9c:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto La8
        La0:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L46
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L46
            throw r6     // Catch: java.lang.Throwable -> L46
        La8:
            throw r6     // Catch: java.lang.Throwable -> La9
        La9:
            r7 = move-exception
            p018c4.F.cancelConsumed(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.last(c4.B0, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:12:0x002f, B:24:0x006d, B:26:0x0075, B:28:0x0081, B:29:0x0085), top: B:42:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:12:0x002f, B:24:0x006d, B:26:0x0075, B:28:0x0081, B:29:0x0085), top: B:42:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0067 -> B:24:0x006d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object lastIndexOf(p018c4.B0 r7, java.lang.Object r8, E3.g r9) {
        /*
            boolean r0 = r9 instanceof p018c4.C0371c0
            if (r0 == 0) goto L13
            r0 = r9
            c4.c0 r0 = (p018c4.C0371c0) r0
            int r1 = r0.f1140g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1140g = r1
            goto L18
        L13:
            c4.c0 r0 = new c4.c0
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f1139f
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1140g
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            c4.z r7 = r0.e
            c4.B0 r8 = r0.d
            kotlin.jvm.internal.Q r2 = r0.c
            kotlin.jvm.internal.Q r4 = r0.b
            java.lang.Object r5 = r0.f1138a
            p147z3.v.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L33
            goto L6d
        L33:
            r7 = move-exception
            goto La0
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            p147z3.v.throwOnFailure(r9)
            kotlin.jvm.internal.Q r9 = new kotlin.jvm.internal.Q
            r9.<init>()
            r2 = -1
            r9.f5687a = r2
            kotlin.jvm.internal.Q r2 = new kotlin.jvm.internal.Q
            r2.<init>()
            c4.z r4 = r7.iterator()     // Catch: java.lang.Throwable -> L9e
        L52:
            r0.f1138a = r8     // Catch: java.lang.Throwable -> L9e
            r0.b = r9     // Catch: java.lang.Throwable -> L9e
            r0.c = r2     // Catch: java.lang.Throwable -> L9e
            r0.d = r7     // Catch: java.lang.Throwable -> L9e
            r0.e = r4     // Catch: java.lang.Throwable -> L9e
            r0.f1140g = r3     // Catch: java.lang.Throwable -> L9e
            c4.e r4 = (p018c4.C0374e) r4     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r5 = r4.hasNext(r0)     // Catch: java.lang.Throwable -> L9e
            if (r5 != r1) goto L67
            return r1
        L67:
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r5
            r5 = r6
        L6d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L33
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r9 == 0) goto L8f
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L33
            java.lang.Object r9 = r7.a()     // Catch: java.lang.Throwable -> L33
            boolean r9 = kotlin.jvm.internal.E.a(r5, r9)     // Catch: java.lang.Throwable -> L33
            if (r9 == 0) goto L85
            int r9 = r2.f5687a     // Catch: java.lang.Throwable -> L33
            r4.f5687a = r9     // Catch: java.lang.Throwable -> L33
        L85:
            int r9 = r2.f5687a     // Catch: java.lang.Throwable -> L33
            int r9 = r9 + r3
            r2.f5687a = r9     // Catch: java.lang.Throwable -> L33
            r9 = r4
            r4 = r7
            r7 = r8
            r8 = r5
            goto L52
        L8f:
            r7 = 0
            p018c4.F.cancelConsumed(r8, r7)
            int r7 = r4.f5687a
            java.lang.Integer r7 = G3.b.boxInt(r7)
            return r7
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
            goto La0
        L9e:
            r8 = move-exception
            goto L9a
        La0:
            throw r7     // Catch: java.lang.Throwable -> La1
        La1:
            r9 = move-exception
            p018c4.F.cancelConsumed(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.lastIndexOf(c4.B0, java.lang.Object, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:41:0x0094 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #1 {all -> 0x0033, blocks: (B:13:0x002f, B:39:0x008c, B:41:0x0094), top: B:53:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0088 -> B:39:0x008c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object lastOrNull(p018c4.B0 r7, E3.g r8) {
        /*
            boolean r0 = r8 instanceof p018c4.C0373d0
            if (r0 == 0) goto L13
            r0 = r8
            c4.d0 r0 = (p018c4.C0373d0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.d0 r0 = new c4.d0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.c
            c4.z r2 = r0.b
            c4.B0 r4 = r0.f1142a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L33
            goto L8c
        L33:
            r7 = move-exception
            r2 = r4
            goto La3
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            c4.z r7 = r0.b
            c4.B0 r2 = r0.f1142a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L47
            goto L64
        L47:
            r7 = move-exception
            goto La3
        L4a:
            p147z3.v.throwOnFailure(r8)
            c4.z r8 = r7.iterator()     // Catch: java.lang.Throwable -> La0
            r0.f1142a = r7     // Catch: java.lang.Throwable -> La0
            r0.b = r8     // Catch: java.lang.Throwable -> La0
            r0.e = r4     // Catch: java.lang.Throwable -> La0
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> La0
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> La0
            if (r2 != r1) goto L60
            goto L87
        L60:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L47
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L70
            p018c4.F.cancelConsumed(r2, r5)
            return r5
        L70:
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L47
            java.lang.Object r8 = r7.a()     // Catch: java.lang.Throwable -> L47
            r6 = r2
            r2 = r7
            r7 = r6
        L79:
            r0.f1142a = r7     // Catch: java.lang.Throwable -> La0
            r0.b = r2     // Catch: java.lang.Throwable -> La0
            r0.c = r8     // Catch: java.lang.Throwable -> La0
            r0.e = r3     // Catch: java.lang.Throwable -> La0
            java.lang.Object r4 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> La0
            if (r4 != r1) goto L88
        L87:
            return r1
        L88:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L8c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L33
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r8 == 0) goto L9c
            c4.e r2 = (p018c4.C0374e) r2     // Catch: java.lang.Throwable -> L33
            java.lang.Object r8 = r2.a()     // Catch: java.lang.Throwable -> L33
            r7 = r4
            goto L79
        L9c:
            p018c4.F.cancelConsumed(r4, r5)
            return r7
        La0:
            r8 = move-exception
            r2 = r7
            r7 = r8
        La3:
            throw r7     // Catch: java.lang.Throwable -> La4
        La4:
            r8 = move-exception
            p018c4.F.cancelConsumed(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.lastOrNull(c4.B0, E3.g):java.lang.Object");
    }

    public static final <E, R> B0 map(B0 b1, q qVar, p pVar) {
        return v0.produce(C0315z0.INSTANCE, qVar, 0, P.f943a, F.consumes(b1), new C0375e0(b1, pVar, null));
    }

    public static final <E, R> B0 mapIndexed(B0 b1, q qVar, O3.q qVar2) {
        return v0.produce(C0315z0.INSTANCE, qVar, 0, P.f943a, F.consumes(b1), new V(b1, qVar2, null, 1));
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:40:0x009b, B:42:0x00a3, B:36:0x0086, B:26:0x0056), top: B:56:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0097 -> B:15:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object maxWith(p018c4.B0 r8, java.util.Comparator r9, E3.g r10) {
        /*
            boolean r0 = r10 instanceof p018c4.f0
            if (r0 == 0) goto L13
            r0 = r10
            c4.f0 r0 = (p018c4.f0) r0
            int r1 = r0.f1157f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1157f = r1
            goto L18
        L13:
            c4.f0 r0 = new c4.f0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1157f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L53
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r8 = r0.d
            c4.z r9 = r0.c
            c4.B0 r2 = r0.b
            java.util.Comparator r4 = r0.f1156a
            p147z3.v.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L3a
            r7 = r0
            r0 = r8
            r8 = r2
        L37:
            r2 = r7
            goto L9b
        L3a:
            r8 = move-exception
            r9 = r2
            goto Lbc
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            c4.z r8 = r0.c
            c4.B0 r9 = r0.b
            java.util.Comparator r2 = r0.f1156a
            p147z3.v.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L50
            goto L70
        L50:
            r8 = move-exception
            goto Lbc
        L53:
            p147z3.v.throwOnFailure(r10)
            c4.z r10 = r8.iterator()     // Catch: java.lang.Throwable -> Lb3
            r0.f1156a = r9     // Catch: java.lang.Throwable -> Lb3
            r0.b = r8     // Catch: java.lang.Throwable -> Lb3
            r0.c = r10     // Catch: java.lang.Throwable -> Lb3
            r0.f1157f = r4     // Catch: java.lang.Throwable -> Lb3
            c4.e r10 = (p018c4.C0374e) r10     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r2 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r2 != r1) goto L6b
            goto L96
        L6b:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L70:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L50
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L50
            if (r10 != 0) goto L7c
            p018c4.F.cancelConsumed(r9, r5)
            return r5
        L7c:
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L50
            java.lang.Object r10 = r8.a()     // Catch: java.lang.Throwable -> L50
            r4 = r9
            r9 = r8
            r8 = r4
            r4 = r2
        L86:
            r0.f1156a = r4     // Catch: java.lang.Throwable -> Lb3
            r0.b = r8     // Catch: java.lang.Throwable -> Lb3
            r0.c = r9     // Catch: java.lang.Throwable -> Lb3
            r0.d = r10     // Catch: java.lang.Throwable -> Lb3
            r0.f1157f = r3     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r2 = r9.hasNext(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r2 != r1) goto L97
        L96:
            return r1
        L97:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L37
        L9b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> Lb3
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> Lb3
            if (r10 == 0) goto Lb8
            c4.e r9 = (p018c4.C0374e) r9     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r10 = r9.a()     // Catch: java.lang.Throwable -> Lb3
            int r6 = r4.compare(r0, r10)     // Catch: java.lang.Throwable -> Lb3
            if (r6 >= 0) goto Lb1
        Laf:
            r0 = r2
            goto L86
        Lb1:
            r10 = r0
            goto Laf
        Lb3:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lbc
        Lb8:
            p018c4.F.cancelConsumed(r8, r5)
            return r0
        Lbc:
            throw r8     // Catch: java.lang.Throwable -> Lbd
        Lbd:
            r10 = move-exception
            p018c4.F.cancelConsumed(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.maxWith(c4.B0, java.util.Comparator, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:40:0x009b, B:42:0x00a3, B:36:0x0086, B:26:0x0056), top: B:56:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0097 -> B:15:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object minWith(p018c4.B0 r8, java.util.Comparator r9, E3.g r10) {
        /*
            boolean r0 = r10 instanceof p018c4.g0
            if (r0 == 0) goto L13
            r0 = r10
            c4.g0 r0 = (p018c4.g0) r0
            int r1 = r0.f1160f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1160f = r1
            goto L18
        L13:
            c4.g0 r0 = new c4.g0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1160f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L53
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r8 = r0.d
            c4.z r9 = r0.c
            c4.B0 r2 = r0.b
            java.util.Comparator r4 = r0.f1159a
            p147z3.v.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L3a
            r7 = r0
            r0 = r8
            r8 = r2
        L37:
            r2 = r7
            goto L9b
        L3a:
            r8 = move-exception
            r9 = r2
            goto Lbc
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            c4.z r8 = r0.c
            c4.B0 r9 = r0.b
            java.util.Comparator r2 = r0.f1159a
            p147z3.v.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L50
            goto L70
        L50:
            r8 = move-exception
            goto Lbc
        L53:
            p147z3.v.throwOnFailure(r10)
            c4.z r10 = r8.iterator()     // Catch: java.lang.Throwable -> Lb3
            r0.f1159a = r9     // Catch: java.lang.Throwable -> Lb3
            r0.b = r8     // Catch: java.lang.Throwable -> Lb3
            r0.c = r10     // Catch: java.lang.Throwable -> Lb3
            r0.f1160f = r4     // Catch: java.lang.Throwable -> Lb3
            c4.e r10 = (p018c4.C0374e) r10     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r2 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r2 != r1) goto L6b
            goto L96
        L6b:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L70:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L50
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L50
            if (r10 != 0) goto L7c
            p018c4.F.cancelConsumed(r9, r5)
            return r5
        L7c:
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L50
            java.lang.Object r10 = r8.a()     // Catch: java.lang.Throwable -> L50
            r4 = r9
            r9 = r8
            r8 = r4
            r4 = r2
        L86:
            r0.f1159a = r4     // Catch: java.lang.Throwable -> Lb3
            r0.b = r8     // Catch: java.lang.Throwable -> Lb3
            r0.c = r9     // Catch: java.lang.Throwable -> Lb3
            r0.d = r10     // Catch: java.lang.Throwable -> Lb3
            r0.f1160f = r3     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r2 = r9.hasNext(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r2 != r1) goto L97
        L96:
            return r1
        L97:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L37
        L9b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> Lb3
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> Lb3
            if (r10 == 0) goto Lb8
            c4.e r9 = (p018c4.C0374e) r9     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r10 = r9.a()     // Catch: java.lang.Throwable -> Lb3
            int r6 = r4.compare(r0, r10)     // Catch: java.lang.Throwable -> Lb3
            if (r6 <= 0) goto Lb1
        Laf:
            r0 = r2
            goto L86
        Lb1:
            r10 = r0
            goto Laf
        Lb3:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lbc
        Lb8:
            p018c4.F.cancelConsumed(r8, r5)
            return r0
        Lbc:
            throw r8     // Catch: java.lang.Throwable -> Lbd
        Lbd:
            r10 = move-exception
            p018c4.F.cancelConsumed(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.minWith(c4.B0, java.util.Comparator, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object none(B0 b1, g gVar) throws Throwable {
        h0 h0Var;
        if (gVar instanceof h0) {
            h0Var = (h0) gVar;
            int i5 = h0Var.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                h0Var.c = i5 - Integer.MIN_VALUE;
            } else {
                h0Var = new h0(gVar);
            }
        } else {
            h0Var = new h0(gVar);
        }
        Object objHasNext = h0Var.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = h0Var.c;
        try {
            if (i6 == 0) {
                v.throwOnFailure(objHasNext);
                InterfaceC0395z it = b1.iterator();
                h0Var.f1162a = b1;
                h0Var.c = 1;
                objHasNext = ((C0374e) it).hasNext(h0Var);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b1 = h0Var.f1162a;
                v.throwOnFailure(objHasNext);
            }
            Boolean boolBoxBoolean = b.boxBoolean(!((Boolean) objHasNext).booleanValue());
            F.cancelConsumed(b1, null);
            return boolBoxBoolean;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                F.cancelConsumed(b1, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006a A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #3 {all -> 0x0046, blocks: (B:20:0x0042, B:29:0x0062, B:31:0x006a, B:41:0x0096, B:42:0x009d), top: B:56:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e A[Catch: all -> 0x0030, TRY_ENTER, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002c, B:35:0x0081, B:39:0x008e, B:40:0x0095), top: B:50:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0096 A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #3 {all -> 0x0046, blocks: (B:20:0x0042, B:29:0x0062, B:31:0x006a, B:41:0x0096, B:42:0x009d), top: B:56:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object single(B0 b1, g gVar) throws Throwable {
        i0 i0Var;
        B0 b6;
        Throwable th;
        InterfaceC0395z interfaceC0395z;
        Object objA;
        Object objHasNext;
        Object obj;
        B0 b7;
        if (gVar instanceof i0) {
            i0Var = (i0) gVar;
            int i5 = i0Var.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                i0Var.d = i5 - Integer.MIN_VALUE;
            } else {
                i0Var = new i0(gVar);
            }
        } else {
            i0Var = new i0(gVar);
        }
        Object obj2 = i0Var.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = i0Var.d;
        if (i6 == 0) {
            v.throwOnFailure(obj2);
            try {
                InterfaceC0395z it = b1.iterator();
                i0Var.f1164a = b1;
                i0Var.b = it;
                i0Var.d = 1;
                C0374e c0374e = (C0374e) it;
                Object objHasNext2 = c0374e.hasNext(i0Var);
                if (objHasNext2 != coroutine_suspended) {
                    b6 = b1;
                    interfaceC0395z = c0374e;
                    obj2 = objHasNext2;
                    if (((Boolean) obj2).booleanValue()) {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                    C0374e c0374e2 = (C0374e) interfaceC0395z;
                    objA = c0374e2.a();
                    i0Var.f1164a = b6;
                    i0Var.b = objA;
                    i0Var.d = 2;
                    objHasNext = c0374e2.hasNext(i0Var);
                    if (objHasNext != coroutine_suspended) {
                        obj2 = objHasNext;
                        obj = objA;
                        b7 = b6;
                        if (((Boolean) obj2).booleanValue()) {
                            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                        }
                        F.cancelConsumed(b7, null);
                        return obj;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                b6 = b1;
                th = th2;
                throw th;
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = i0Var.b;
            b7 = i0Var.f1164a;
            try {
                v.throwOnFailure(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                }
                F.cancelConsumed(b7, null);
                return obj;
            } catch (Throwable th3) {
                th = th3;
                b6 = b7;
                try {
                    throw th;
                } catch (Throwable th4) {
                    F.cancelConsumed(b6, th);
                    throw th4;
                }
            }
        }
        interfaceC0395z = (InterfaceC0395z) i0Var.b;
        b6 = i0Var.f1164a;
        try {
            v.throwOnFailure(obj2);
            if (((Boolean) obj2).booleanValue()) {
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
            C0374e c0374e3 = (C0374e) interfaceC0395z;
            objA = c0374e3.a();
            i0Var.f1164a = b6;
            i0Var.b = objA;
            i0Var.d = 2;
            objHasNext = c0374e3.hasNext(i0Var);
            if (objHasNext != coroutine_suspended) {
                obj2 = objHasNext;
                obj = objA;
                b7 = b6;
                if (((Boolean) obj2).booleanValue()) {
                    throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                }
                F.cancelConsumed(b7, null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object singleOrNull(B0 b1, g gVar) throws Throwable {
        j0 j0Var;
        B0 b6;
        Throwable th;
        InterfaceC0395z interfaceC0395z;
        Object obj;
        B0 b7;
        if (gVar instanceof j0) {
            j0Var = (j0) gVar;
            int i5 = j0Var.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                j0Var.d = i5 - Integer.MIN_VALUE;
            } else {
                j0Var = new j0(gVar);
            }
        } else {
            j0Var = new j0(gVar);
        }
        Object obj2 = j0Var.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = j0Var.d;
        if (i6 == 0) {
            v.throwOnFailure(obj2);
            try {
                InterfaceC0395z it = b1.iterator();
                j0Var.f1166a = b1;
                j0Var.b = it;
                j0Var.d = 1;
                C0374e c0374e = (C0374e) it;
                Object objHasNext = c0374e.hasNext(j0Var);
                if (objHasNext != coroutine_suspended) {
                    b6 = b1;
                    interfaceC0395z = c0374e;
                    obj2 = objHasNext;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                b6 = b1;
                th = th2;
                throw th;
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = j0Var.b;
            b7 = j0Var.f1166a;
            try {
                v.throwOnFailure(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    F.cancelConsumed(b7, null);
                    return null;
                }
                F.cancelConsumed(b7, null);
                return obj;
            } catch (Throwable th3) {
                th = th3;
                b6 = b7;
                try {
                    throw th;
                } catch (Throwable th4) {
                    F.cancelConsumed(b6, th);
                    throw th4;
                }
            }
        }
        interfaceC0395z = (InterfaceC0395z) j0Var.b;
        b6 = j0Var.f1166a;
        try {
            v.throwOnFailure(obj2);
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
        if (!((Boolean) obj2).booleanValue()) {
            F.cancelConsumed(b6, null);
            return null;
        }
        C0374e c0374e2 = (C0374e) interfaceC0395z;
        Object objA = c0374e2.a();
        j0Var.f1166a = b6;
        j0Var.b = objA;
        j0Var.d = 2;
        Object objHasNext2 = c0374e2.hasNext(j0Var);
        if (objHasNext2 != coroutine_suspended) {
            obj2 = objHasNext2;
            obj = objA;
            b7 = b6;
            if (((Boolean) obj2).booleanValue()) {
                F.cancelConsumed(b7, null);
                return null;
            }
            F.cancelConsumed(b7, null);
            return obj;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    /* JADX WARN: Code duplicated, block: B:30:0x006e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x002e, B:28:0x0066, B:30:0x006e, B:20:0x0045), top: B:42:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        if (r2.send(r8, r0) == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [c4.D0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends c4.D0] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [c4.D0] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0080 -> B:14:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E, C extends p018c4.D0> java.lang.Object toChannel(p018c4.B0 r6, C r7, E3.g<? super C> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof p018c4.k0
            if (r0 == 0) goto L13
            r0 = r8
            c4.k0 r0 = (p018c4.k0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.k0 r0 = new c4.k0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            c4.D0 r2 = r0.f1168a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L35
        L31:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L50
        L35:
            r6 = move-exception
            goto L8e
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            c4.D0 r2 = r0.f1168a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L35
            goto L66
        L49:
            p147z3.v.throwOnFailure(r8)
            c4.z r8 = r6.iterator()     // Catch: java.lang.Throwable -> L8c
        L50:
            r0.f1168a = r7     // Catch: java.lang.Throwable -> L8c
            r0.b = r6     // Catch: java.lang.Throwable -> L8c
            r0.c = r8     // Catch: java.lang.Throwable -> L8c
            r0.e = r4     // Catch: java.lang.Throwable -> L8c
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L8c
            if (r2 != r1) goto L61
            goto L82
        L61:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L83
            c4.e r6 = (p018c4.C0374e) r6     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r6.a()     // Catch: java.lang.Throwable -> L35
            r0.f1168a = r2     // Catch: java.lang.Throwable -> L35
            r0.b = r7     // Catch: java.lang.Throwable -> L35
            r0.c = r6     // Catch: java.lang.Throwable -> L35
            r0.e = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r2.send(r8, r0)     // Catch: java.lang.Throwable -> L35
            if (r8 != r1) goto L31
        L82:
            return r1
        L83:
            r6 = 0
            p018c4.F.cancelConsumed(r7, r6)
            return r2
        L88:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L8e
        L8c:
            r7 = move-exception
            goto L88
        L8e:
            throw r6     // Catch: java.lang.Throwable -> L8f
        L8f:
            r8 = move-exception
            p018c4.F.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.toChannel(c4.B0, c4.D0, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:24:0x0056, B:26:0x005e), top: B:41:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0051 -> B:24:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object toCollection(p018c4.B0 r5, C r6, E3.g<? super C> r7) {
        /*
            boolean r0 = r7 instanceof p018c4.l0
            if (r0 == 0) goto L13
            r0 = r7
            c4.l0 r0 = (p018c4.l0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.l0 r0 = new c4.l0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            c4.z r5 = r0.c
            c4.B0 r6 = r0.b
            java.util.Collection r2 = r0.f1170a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2f
            goto L56
        L2f:
            r5 = move-exception
            goto L76
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            p147z3.v.throwOnFailure(r7)
            c4.z r7 = r5.iterator()     // Catch: java.lang.Throwable -> L74
        L40:
            r0.f1170a = r6     // Catch: java.lang.Throwable -> L74
            r0.b = r5     // Catch: java.lang.Throwable -> L74
            r0.c = r7     // Catch: java.lang.Throwable -> L74
            r0.e = r3     // Catch: java.lang.Throwable -> L74
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L74
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L74
            if (r2 != r1) goto L51
            return r1
        L51:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r2
            r2 = r4
        L56:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L2f
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L6b
            r7 = r5
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r7.a()     // Catch: java.lang.Throwable -> L2f
            r2.add(r5)     // Catch: java.lang.Throwable -> L2f
            r5 = r6
            r6 = r2
            goto L40
        L6b:
            r5 = 0
            p018c4.F.cancelConsumed(r6, r5)
            return r2
        L70:
            r4 = r6
            r6 = r5
            r5 = r4
            goto L76
        L74:
            r6 = move-exception
            goto L70
        L76:
            throw r5     // Catch: java.lang.Throwable -> L77
        L77:
            r7 = move-exception
            p018c4.F.cancelConsumed(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.toCollection(c4.B0, java.util.Collection, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:24:0x005b, B:26:0x0063), top: B:37:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0056 -> B:24:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object toMap(p018c4.B0 r6, M r7, E3.g<? super M> r8) {
        /*
            boolean r0 = r8 instanceof p018c4.m0
            if (r0 == 0) goto L13
            r0 = r8
            c4.m0 r0 = (p018c4.m0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.m0 r0 = new c4.m0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            java.util.Map r2 = r0.f1172a
            java.util.Map r2 = (java.util.Map) r2
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L31
            goto L5b
        L31:
            r6 = move-exception
            goto L81
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            p147z3.v.throwOnFailure(r8)
            c4.z r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7f
        L42:
            r2 = r7
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L7f
            r0.f1172a = r2     // Catch: java.lang.Throwable -> L7f
            r0.b = r6     // Catch: java.lang.Throwable -> L7f
            r0.c = r8     // Catch: java.lang.Throwable -> L7f
            r0.e = r3     // Catch: java.lang.Throwable -> L7f
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L7f
            if (r2 != r1) goto L56
            return r1
        L56:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L5b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L31
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L76
            r8 = r6
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L31
            java.lang.Object r6 = r8.a()     // Catch: java.lang.Throwable -> L31
            z3.s r6 = (p147z3.C1938s) r6     // Catch: java.lang.Throwable -> L31
            java.lang.Object r4 = r6.f9134a     // Catch: java.lang.Throwable -> L31
            java.lang.Object r6 = r6.b     // Catch: java.lang.Throwable -> L31
            r2.put(r4, r6)     // Catch: java.lang.Throwable -> L31
            r6 = r7
            r7 = r2
            goto L42
        L76:
            r6 = 0
            p018c4.F.cancelConsumed(r7, r6)
            return r2
        L7b:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L81
        L7f:
            r7 = move-exception
            goto L7b
        L81:
            throw r6     // Catch: java.lang.Throwable -> L82
        L82:
            r8 = move-exception
            p018c4.F.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.toMap(c4.B0, java.util.Map, E3.g):java.lang.Object");
    }

    public static final <E> Object toMutableSet(B0 b1, g<? super Set<E>> gVar) {
        return F.toCollection(b1, new LinkedHashSet(), gVar);
    }

    public static final <E, R, V> B0 zip(B0 b1, B0 b6, q qVar, p pVar) {
        return v0.produce(C0315z0.INSTANCE, qVar, 0, P.f943a, F.consumesAll(b1, b6), new o0(b6, b1, pVar, null));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e A[Catch: all -> 0x002f, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:24:0x0056, B:26:0x005e, B:28:0x0067), top: B:43:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0067 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:24:0x0056, B:26:0x005e, B:28:0x0067), top: B:43:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0051 -> B:24:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object filterNotNullTo(p018c4.B0 r5, java.util.Collection r6, E3.g r7) {
        /*
            boolean r0 = r7 instanceof p018c4.W
            if (r0 == 0) goto L13
            r0 = r7
            c4.W r0 = (p018c4.W) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.W r0 = new c4.W
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            c4.z r5 = r0.c
            c4.B0 r6 = r0.b
            java.util.Collection r2 = r0.f1129a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2f
            goto L56
        L2f:
            r5 = move-exception
            goto L78
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            p147z3.v.throwOnFailure(r7)
            c4.z r7 = r5.iterator()     // Catch: java.lang.Throwable -> L76
        L40:
            r0.f1129a = r6     // Catch: java.lang.Throwable -> L76
            r0.b = r5     // Catch: java.lang.Throwable -> L76
            r0.c = r7     // Catch: java.lang.Throwable -> L76
            r0.e = r3     // Catch: java.lang.Throwable -> L76
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L76
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L76
            if (r2 != r1) goto L51
            return r1
        L51:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r2
            r2 = r4
        L56:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L2f
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L6d
            r7 = r5
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r7.a()     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L6a
            r2.add(r5)     // Catch: java.lang.Throwable -> L2f
        L6a:
            r5 = r6
            r6 = r2
            goto L40
        L6d:
            r5 = 0
            p018c4.F.cancelConsumed(r6, r5)
            return r2
        L72:
            r4 = r6
            r6 = r5
            r5 = r4
            goto L78
        L76:
            r6 = move-exception
            goto L72
        L78:
            throw r5     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            p018c4.F.cancelConsumed(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.p0.filterNotNullTo(c4.B0, java.util.Collection, E3.g):java.lang.Object");
    }
}
