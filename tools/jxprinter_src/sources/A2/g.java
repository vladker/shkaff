package A2;

import F3.i;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.F;
import p134x2.H;
import p134x2.M0;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements H {
    private final h device;
    private InputStream inputStream;
    private Socket mSocket;
    private OutputStream outputStream;

    public g(h device) {
        E.f(device, "device");
        this.device = device;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p134x2.H
    /* JADX INFO: renamed from: close-IoAF18A, reason: not valid java name */
    public Object mo0closeIoAF18A(E3.g<? super u> gVar) {
        c cVar;
        if (gVar instanceof c) {
            cVar = (c) gVar;
            int i5 = cVar.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                cVar.c = i5 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, gVar);
            }
        } else {
            cVar = new c(this, gVar);
        }
        Object objWithContext = cVar.f24a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = cVar.c;
        if (i6 == 0) {
            v.throwOnFailure(objWithContext);
            F io2 = C0276f0.getIO();
            d dVar = new d(this, null);
            cVar.c = 1;
            objWithContext = AbstractC0272e.withContext(io2, dVar, cVar);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p134x2.H
    /* JADX INFO: renamed from: connect-IoAF18A, reason: not valid java name */
    public Object mo1connectIoAF18A(E3.g<? super u> gVar) {
        e eVar;
        if (gVar instanceof e) {
            eVar = (e) gVar;
            int i5 = eVar.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                eVar.c = i5 - Integer.MIN_VALUE;
            } else {
                eVar = new e(this, gVar);
            }
        } else {
            eVar = new e(this, gVar);
        }
        Object objWithContext = eVar.f26a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = eVar.c;
        if (i6 == 0) {
            v.throwOnFailure(objWithContext);
            F io2 = C0276f0.getIO();
            f fVar = new f(this, null);
            eVar.c = 1;
            objWithContext = AbstractC0272e.withContext(io2, fVar, eVar);
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

    @Override // p134x2.H
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // p134x2.H
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // p134x2.H
    public M0 getPrinterDevice() {
        return this.device;
    }
}
