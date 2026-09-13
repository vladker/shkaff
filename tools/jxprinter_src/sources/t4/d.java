package t4;

import A4.AbstractC0182z;
import A4.C0169l;
import A4.h0;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends AbstractC0182z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8668a;
    public long b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ e e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, h0 h0Var, long j6) {
        super(h0Var);
        this.e = eVar;
        this.f8668a = j6;
        if (j6 == 0) {
            complete(null);
        }
    }

    @Override // A4.AbstractC0182z, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            super.close();
            complete(null);
        } catch (IOException e) {
            throw complete(e);
        }
    }

    public IOException complete(IOException iOException) {
        if (this.c) {
            return iOException;
        }
        this.c = true;
        return this.e.bodyComplete(this.b, true, false, iOException);
    }

    @Override // A4.AbstractC0182z, A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        try {
            long j7 = delegate().read(c0169l, j6);
            if (j7 == -1) {
                complete(null);
                return -1L;
            }
            long j8 = this.b + j7;
            long j9 = this.f8668a;
            if (j9 == -1 || j8 <= j9) {
                this.b = j8;
                if (j8 == j9) {
                    complete(null);
                }
                return j7;
            }
            throw new ProtocolException("expected " + j9 + " bytes but received " + j8);
        } catch (IOException e) {
            throw complete(e);
        }
    }
}
