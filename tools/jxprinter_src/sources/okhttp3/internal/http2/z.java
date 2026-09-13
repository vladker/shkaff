package okhttp3.internal.http2;

import A4.C0164g;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class z extends C0164g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ A f6653h;

    public z(A a6) {
        this.f6653h = a6;
    }

    public void exitAndThrowIfTimedOut() {
        if (k()) {
            throw newTimeoutException(null);
        }
    }

    @Override // A4.C0164g
    public final void l() {
        this.f6653h.a(EnumC1358b.CANCEL);
        s sVar = this.f6653h.d;
        synchronized (sVar) {
            try {
                long j6 = sVar.f6630n;
                long j7 = sVar.f6629m;
                if (j6 < j7) {
                    return;
                }
                sVar.f6629m = j7 + 1;
                sVar.f6633q = System.nanoTime() + 1000000000;
                try {
                    sVar.f6624h.execute(new i(sVar, new Object[]{sVar.d}));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // A4.C0164g
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
