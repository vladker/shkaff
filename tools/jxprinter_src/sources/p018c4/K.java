package p018c4;

import E3.g;
import O3.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0305u0;
import p044h4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class K {
    public static final void cancelConsumed(B0 b1, Throwable th) {
        CancellationException CancellationException = null;
        if (th != null) {
            CancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            if (CancellationException == null) {
                CancellationException = AbstractC0305u0.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        b1.cancel(CancellationException);
    }

    public static final <E, R> R consume(B0 b1, l lVar) {
        try {
            R r6 = (R) lVar.invoke(b1);
            F.cancelConsumed(b1, null);
            return r6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                F.cancelConsumed(b1, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:24:0x0056, B:26:0x005e), top: B:41:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0051 -> B:24:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <E> java.lang.Object consumeEach(p018c4.B0 r5, O3.l r6, E3.g<? super p147z3.Q> r7) {
        /*
            boolean r0 = r7 instanceof p018c4.I
            if (r0 == 0) goto L13
            r0 = r7
            c4.I r0 = (p018c4.I) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            c4.I r0 = new c4.I
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
            O3.l r2 = r0.f1104a
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
            r0.f1104a = r6     // Catch: java.lang.Throwable -> L76
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
            if (r7 == 0) goto L6b
            r7 = r5
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r7.a()     // Catch: java.lang.Throwable -> L2f
            r2.invoke(r5)     // Catch: java.lang.Throwable -> L2f
            r5 = r6
            r6 = r2
            goto L40
        L6b:
            r5 = 0
            p018c4.F.cancelConsumed(r6, r5)
            z3.Q r5 = p147z3.Q.INSTANCE
            return r5
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
        throw new UnsupportedOperationException("Method not decompiled: p018c4.K.consumeEach(c4.B0, O3.l, E3.g):java.lang.Object");
    }

    public static final /* synthetic */ h onReceiveOrNull(B0 b1) {
        E.d(b1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return b1.getOnReceiveOrNull();
    }

    public static final /* synthetic */ Object receiveOrNull(B0 b1, g gVar) {
        E.d(b1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return b1.receiveOrNull(gVar);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0068 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:12:0x002d, B:24:0x0060, B:26:0x0068), top: B:39:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:24:0x0060). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <E> java.lang.Object toList(p018c4.B0 r7, E3.g<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof p018c4.J
            if (r0 == 0) goto L13
            r0 = r8
            c4.J r0 = (p018c4.J) r0
            int r1 = r0.f1106f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1106f = r1
            goto L18
        L13:
            c4.J r0 = new c4.J
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1106f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            c4.z r7 = r0.d
            c4.B0 r2 = r0.c
            java.util.List r4 = r0.b
            java.util.List r5 = r0.f1105a
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L31
            goto L60
        L31:
            r7 = move-exception
            goto L83
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            p147z3.v.throwOnFailure(r8)
            java.util.List r8 = A3.G.createListBuilder()
            c4.z r2 = r7.iterator()     // Catch: java.lang.Throwable -> L81
            r4 = r8
            r5 = r4
        L48:
            r0.f1105a = r5     // Catch: java.lang.Throwable -> L81
            r0.b = r4     // Catch: java.lang.Throwable -> L81
            r0.c = r7     // Catch: java.lang.Throwable -> L81
            r0.d = r2     // Catch: java.lang.Throwable -> L81
            r0.f1106f = r3     // Catch: java.lang.Throwable -> L81
            r8 = r2
            c4.e r8 = (p018c4.C0374e) r8     // Catch: java.lang.Throwable -> L81
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L81
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L60:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L31
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L75
            c4.e r7 = (p018c4.C0374e) r7     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r7.a()     // Catch: java.lang.Throwable -> L31
            r4.add(r8)     // Catch: java.lang.Throwable -> L31
            r6 = r2
            r2 = r7
            r7 = r6
            goto L48
        L75:
            r7 = 0
            p018c4.F.cancelConsumed(r2, r7)
            java.util.List r7 = A3.G.build(r5)
            return r7
        L7e:
            r2 = r7
            r7 = r8
            goto L83
        L81:
            r8 = move-exception
            goto L7e
        L83:
            throw r7     // Catch: java.lang.Throwable -> L84
        L84:
            r8 = move-exception
            p018c4.F.cancelConsumed(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.K.toList(c4.B0, E3.g):java.lang.Object");
    }
}
