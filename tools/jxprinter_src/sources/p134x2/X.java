package p134x2;

import A3.C;
import E3.g;
import F3.i;
import O3.l;
import O3.p;
import U3.B;
import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0309w0;
import p007a4.C0276f0;
import p007a4.F;
import p007a4.N;
import p007a4.q1;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X {
    public static final Q Companion = new Q();
    private static final String TAG = "PrinterConnection";
    private l listener;
    private final H printerConnection;
    private AbstractC0309w0 threadContext;

    public X(H printerConnection) {
        E.f(printerConnection, "printerConnection");
        this.printerConnection = printerConnection;
    }

    public final void a() {
        InputStream inputStream = this.printerConnection.getInputStream();
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i5 = inputStream.read(bArr);
                if (i5 == -1) {
                    l lVar = this.listener;
                    if (lVar != null) {
                        lVar.invoke(null);
                        return;
                    }
                    return;
                }
                O.INSTANCE.i(TAG, "recv data len: " + i5);
                l lVar2 = this.listener;
                if (lVar2 != null) {
                    lVar2.invoke(C.sliceArray(bArr, B.until(0, i5)));
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException e) {
                O.INSTANCE.e(TAG, "recv error.", e);
                l lVar3 = this.listener;
                if (lVar3 != null) {
                    lVar3.invoke(null);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: close-IoAF18A, reason: not valid java name */
    public final Object m1120closeIoAF18A(g<? super u> gVar) throws Throwable {
        S s6;
        if (gVar instanceof S) {
            s6 = (S) gVar;
            int i5 = s6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                s6.c = i5 - Integer.MIN_VALUE;
            } else {
                s6 = new S(this, gVar);
            }
        } else {
            s6 = new S(this, gVar);
        }
        Object obj = s6.f8876a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = s6.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        H h6 = this.printerConnection;
        s6.c = 1;
        Object objMo0closeIoAF18A = h6.mo0closeIoAF18A(s6);
        return objMo0closeIoAF18A == coroutine_suspended ? coroutine_suspended : objMo0closeIoAF18A;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: connect-IoAF18A, reason: not valid java name */
    public final Object m1121connectIoAF18A(g<? super u> gVar) throws Throwable {
        T t6;
        Object objMo1connectIoAF18A;
        X x6;
        if (gVar instanceof T) {
            t6 = (T) gVar;
            int i5 = t6.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                t6.d = i5 - Integer.MIN_VALUE;
            } else {
                t6 = new T(this, gVar);
            }
        } else {
            t6 = new T(this, gVar);
        }
        Object obj = t6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = t6.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            H h6 = this.printerConnection;
            t6.f8879a = this;
            t6.d = 1;
            objMo1connectIoAF18A = h6.mo1connectIoAF18A(t6);
            if (objMo1connectIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
            x6 = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            x6 = t6.f8879a;
            v.throwOnFailure(obj);
            objMo1connectIoAF18A = ((u) obj).b();
        }
        if (objMo1connectIoAF18A instanceof u.a) {
            return objMo1connectIoAF18A;
        }
        AbstractC0309w0 abstractC0309w0NewSingleThreadContext = q1.newSingleThreadContext("recvThread");
        x6.threadContext = abstractC0309w0NewSingleThreadContext;
        E.c(abstractC0309w0NewSingleThreadContext);
        AbstractC0272e.b(N.CoroutineScope(abstractC0309w0NewSingleThreadContext), null, 3, new U(x6, null));
        return u.m1361constructorimpl(Q.INSTANCE);
    }

    public final l getListener() {
        return this.listener;
    }

    public final M0 getPrinterDevice() {
        return this.printerConnection.getPrinterDevice();
    }

    public final AbstractC0309w0 getThreadContext() {
        return this.threadContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: send-0E7RQCE, reason: not valid java name */
    public final Object m1122send0E7RQCE(byte[] bArr, p pVar, g<? super u> gVar) throws Throwable {
        V v6;
        if (gVar instanceof V) {
            v6 = (V) gVar;
            int i5 = v6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                v6.c = i5 - Integer.MIN_VALUE;
            } else {
                v6 = new V(this, gVar);
            }
        } else {
            v6 = new V(this, gVar);
        }
        Object objWithContext = v6.f8883a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = v6.c;
        if (i6 == 0) {
            v.throwOnFailure(objWithContext);
            OutputStream outputStream = this.printerConnection.getOutputStream();
            if (outputStream == null) {
                return a.g("Output stream is null");
            }
            F io2 = C0276f0.getIO();
            W w6 = new W(bArr, outputStream, pVar, null);
            v6.c = 1;
            objWithContext = AbstractC0272e.withContext(io2, w6, v6);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(objWithContext);
        }
        return ((u) objWithContext).b();
    }

    public final void setListener(l lVar) {
        this.listener = lVar;
    }

    public final void setRecvListener(l listener) {
        E.f(listener, "listener");
        this.listener = listener;
    }

    public final void setThreadContext(AbstractC0309w0 abstractC0309w0) {
        this.threadContext = abstractC0309w0;
    }
}
