package p134x2;

import E3.g;
import F3.i;
import O3.l;
import O3.p;
import java.util.TimerTask;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0315z0;
import p007a4.InterfaceC0304u;
import p018c4.A;
import p018c4.InterfaceC0391v;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S0 {
    public static final R0 Companion = new R0();
    public static final String TAG = "QuenePrinterConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8877a;
    private X connection;
    private l listener;
    private byte[] recvCache;
    private InterfaceC0391v recvChannel;
    private a recvReq;
    private TimerTask recvTimer;
    private InterfaceC0391v sendChannel;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8878a;
        public final int b;
        public boolean c;
        private final p callback;
        private final byte[] data;
        private final InterfaceC0304u deferred;

        public a(byte[] data, p pVar, InterfaceC0304u deferred, boolean z6, int i5, boolean z7) {
            E.f(data, "data");
            E.f(deferred, "deferred");
            this.data = data;
            this.callback = pVar;
            this.deferred = deferred;
            this.f8878a = z6;
            this.b = i5;
            this.c = z7;
        }

        public final p getCallback() {
            return this.callback;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final InterfaceC0304u getDeferred() {
            return this.deferred;
        }
    }

    public S0(H connection) {
        E.f(connection, "connection");
        this.sendChannel = A.a(Integer.MAX_VALUE, 6, null);
        this.recvChannel = A.a(Integer.MAX_VALUE, 6, null);
        this.recvCache = new byte[4096];
        this.connection = new X(connection);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: close-IoAF18A, reason: not valid java name */
    public final Object m1116closeIoAF18A(g<? super u> gVar) {
        T0 t6;
        if (gVar instanceof T0) {
            t6 = (T0) gVar;
            int i5 = t6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                t6.c = i5 - Integer.MIN_VALUE;
            } else {
                t6 = new T0(this, gVar);
            }
        } else {
            t6 = new T0(this, gVar);
        }
        Object obj = t6.f8880a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = t6.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        this.sendChannel.close(null);
        X x6 = this.connection;
        t6.c = 1;
        Object objM1120closeIoAF18A = x6.m1120closeIoAF18A(t6);
        return objM1120closeIoAF18A == coroutine_suspended ? coroutine_suspended : objM1120closeIoAF18A;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: connect-IoAF18A, reason: not valid java name */
    public final Object m1117connectIoAF18A(g<? super u> gVar) {
        U0 u6;
        Object objM1121connectIoAF18A;
        S0 s6;
        if (gVar instanceof U0) {
            u6 = (U0) gVar;
            int i5 = u6.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                u6.d = i5 - Integer.MIN_VALUE;
            } else {
                u6 = new U0(this, gVar);
            }
        } else {
            u6 = new U0(this, gVar);
        }
        Object obj = u6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = u6.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            this.connection.setRecvListener(new V0(this));
            X x6 = this.connection;
            u6.f8882a = this;
            u6.d = 1;
            objM1121connectIoAF18A = x6.m1121connectIoAF18A(u6);
            if (objM1121connectIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
            s6 = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s6 = u6.f8882a;
            v.throwOnFailure(obj);
            objM1121connectIoAF18A = ((u) obj).b();
        }
        if (objM1121connectIoAF18A instanceof u.a) {
            return objM1121connectIoAF18A;
        }
        AbstractC0272e.b(C0315z0.INSTANCE, null, 3, new W0(s6, null));
        return u.m1361constructorimpl(Q.INSTANCE);
    }

    public final l getListener() {
        return this.listener;
    }

    public final M0 getPrinterDevice() {
        return this.connection.getPrinterDevice();
    }

    public final byte[] getRecvCache() {
        return this.recvCache;
    }

    public final a getRecvReq() {
        return this.recvReq;
    }

    public final TimerTask getRecvTimer() {
        return this.recvTimer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r0 == r2) goto L28;
     */
    /* JADX INFO: renamed from: send-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m1118send0E7RQCE(byte[] r15, O3.p r16, E3.g<? super p147z3.u> r17) {
        /*
            r14 = this;
            r0 = r17
            boolean r1 = r0 instanceof p134x2.X0
            if (r1 == 0) goto L15
            r1 = r0
            x2.X0 r1 = (p134x2.X0) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.d = r2
            goto L1a
        L15:
            x2.X0 r1 = new x2.X0
            r1.<init>(r14, r0)
        L1a:
            java.lang.Object r0 = r1.b
            java.lang.Object r2 = F3.i.getCOROUTINE_SUSPENDED()
            int r3 = r1.d
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L40
            if (r3 == r6) goto L3a
            if (r3 != r4) goto L32
            p147z3.v.throwOnFailure(r0)     // Catch: java.lang.Exception -> L2f
            goto L6b
        L2f:
            r0 = move-exception
            r15 = r0
            goto L7e
        L32:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L3a:
            a4.u r15 = r1.f8887a
            p147z3.v.throwOnFailure(r0)     // Catch: java.lang.Exception -> L2f
            goto L60
        L40:
            p147z3.v.throwOnFailure(r0)
            a4.u r10 = p007a4.AbstractC0308w.CompletableDeferred(r5)     // Catch: java.lang.Exception -> L2f
            c4.v r0 = r14.sendChannel     // Catch: java.lang.Exception -> L2f
            x2.S0$a r7 = new x2.S0$a     // Catch: java.lang.Exception -> L2f
            r12 = 0
            r13 = 0
            r11 = 0
            r8 = r15
            r9 = r16
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L2f
            r1.f8887a = r10     // Catch: java.lang.Exception -> L2f
            r1.d = r6     // Catch: java.lang.Exception -> L2f
            java.lang.Object r15 = r0.send(r7, r1)     // Catch: java.lang.Exception -> L2f
            if (r15 != r2) goto L5f
            goto L6a
        L5f:
            r15 = r10
        L60:
            r1.f8887a = r5     // Catch: java.lang.Exception -> L2f
            r1.d = r4     // Catch: java.lang.Exception -> L2f
            java.lang.Object r0 = r15.await(r1)     // Catch: java.lang.Exception -> L2f
            if (r0 != r2) goto L6b
        L6a:
            return r2
        L6b:
            z3.u r0 = (p147z3.u) r0     // Catch: java.lang.Exception -> L2f
            java.lang.Object r15 = r0.b()     // Catch: java.lang.Exception -> L2f
            boolean r0 = r15 instanceof z3.u.a     // Catch: java.lang.Exception -> L2f
            if (r0 != 0) goto L79
            byte[] r15 = (byte[]) r15     // Catch: java.lang.Exception -> L2f
            z3.Q r15 = p147z3.Q.INSTANCE     // Catch: java.lang.Exception -> L2f
        L79:
            java.lang.Object r15 = p147z3.u.m1361constructorimpl(r15)     // Catch: java.lang.Exception -> L2f
            return r15
        L7e:
            java.lang.Object r15 = p147z3.v.createFailure(r15)
            java.lang.Object r15 = p147z3.u.m1361constructorimpl(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.S0.m1118send0E7RQCE(byte[], O3.p, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        if (r0 == r2) goto L29;
     */
    /* JADX INFO: renamed from: sendWithResp-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m1119sendWithRespBWLJW6A(byte[] r15, int r16, O3.p r17, E3.g<? super p147z3.u> r18) {
        /*
            r14 = this;
            r0 = r18
            boolean r1 = r0 instanceof p134x2.Y0
            if (r1 == 0) goto L15
            r1 = r0
            x2.Y0 r1 = (p134x2.Y0) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.e = r2
            goto L1a
        L15:
            x2.Y0 r1 = new x2.Y0
            r1.<init>(r14, r0)
        L1a:
            java.lang.Object r0 = r1.c
            java.lang.Object r2 = F3.i.getCOROUTINE_SUSPENDED()
            int r3 = r1.e
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L48
            if (r3 == r6) goto L3e
            if (r3 != r4) goto L36
            java.lang.Object r15 = r1.f8888a
            x2.S0$a r15 = (x2.S0.a) r15
            p147z3.v.throwOnFailure(r0)     // Catch: java.lang.Exception -> L33
            goto L80
        L33:
            r0 = move-exception
            r15 = r0
            goto L9b
        L36:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L3e:
            x2.S0$a r15 = r1.b
            java.lang.Object r3 = r1.f8888a
            a4.u r3 = (p007a4.InterfaceC0304u) r3
            p147z3.v.throwOnFailure(r0)     // Catch: java.lang.Exception -> L33
            goto L6c
        L48:
            p147z3.v.throwOnFailure(r0)
            a4.u r10 = p007a4.AbstractC0308w.CompletableDeferred(r5)     // Catch: java.lang.Exception -> L33
            x2.S0$a r7 = new x2.S0$a     // Catch: java.lang.Exception -> L33
            r11 = 1
            r13 = 0
            r8 = r15
            r12 = r16
            r9 = r17
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L33
            c4.v r15 = r14.sendChannel     // Catch: java.lang.Exception -> L33
            r1.f8888a = r10     // Catch: java.lang.Exception -> L33
            r1.b = r7     // Catch: java.lang.Exception -> L33
            r1.e = r6     // Catch: java.lang.Exception -> L33
            java.lang.Object r15 = r15.send(r7, r1)     // Catch: java.lang.Exception -> L33
            if (r15 != r2) goto L6a
            goto L7f
        L6a:
            r15 = r7
            r3 = r10
        L6c:
            x2.Z0 r0 = new x2.Z0     // Catch: java.lang.Exception -> L33
            r0.<init>(r3, r5)     // Catch: java.lang.Exception -> L33
            r1.f8888a = r15     // Catch: java.lang.Exception -> L33
            r1.b = r5     // Catch: java.lang.Exception -> L33
            r1.e = r4     // Catch: java.lang.Exception -> L33
            r3 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r0 = p007a4.x1.withTimeoutOrNull(r3, r0, r1)     // Catch: java.lang.Exception -> L33
            if (r0 != r2) goto L80
        L7f:
            return r2
        L80:
            z3.u r0 = (p147z3.u) r0     // Catch: java.lang.Exception -> L33
            if (r0 != 0) goto L96
            r15.c = r6     // Catch: java.lang.Exception -> L33
            x2.b1 r15 = new x2.b1     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = "timeout"
            r15.<init>(r0)     // Catch: java.lang.Exception -> L33
            java.lang.Object r15 = p147z3.v.createFailure(r15)     // Catch: java.lang.Exception -> L33
            java.lang.Object r15 = p147z3.u.m1361constructorimpl(r15)     // Catch: java.lang.Exception -> L33
            return r15
        L96:
            java.lang.Object r15 = r0.b()     // Catch: java.lang.Exception -> L33
            return r15
        L9b:
            java.lang.Object r15 = p147z3.v.createFailure(r15)
            java.lang.Object r15 = p147z3.u.m1361constructorimpl(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.S0.m1119sendWithRespBWLJW6A(byte[], int, O3.p, E3.g):java.lang.Object");
    }

    public final void setListener(l lVar) {
        this.listener = lVar;
    }

    public final void setRecvCache(byte[] bArr) {
        E.f(bArr, "<set-?>");
        this.recvCache = bArr;
    }

    public final void setRecvListener(l listener) {
        E.f(listener, "listener");
        this.listener = listener;
    }

    public final void setRecvReq(a aVar) {
        this.recvReq = aVar;
    }

    public final void setRecvTimer(TimerTask timerTask) {
        this.recvTimer = timerTask;
    }
}
