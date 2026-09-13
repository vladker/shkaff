package t4;

import A4.AbstractC0181y;
import A4.C0169l;
import A4.f0;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AbstractC0181y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8667a;
    public final long b;
    public long c;
    public boolean d;
    public final /* synthetic */ e e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, f0 f0Var, long j6) {
        super(f0Var);
        this.e = eVar;
        this.b = j6;
    }

    private IOException complete(IOException iOException) {
        if (this.f8667a) {
            return iOException;
        }
        this.f8667a = true;
        return this.e.bodyComplete(this.c, false, true, iOException);
    }

    @Override // A4.AbstractC0181y, A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        long j6 = this.b;
        if (j6 != -1 && this.c != j6) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            complete(null);
        } catch (IOException e) {
            throw complete(e);
        }
    }

    @Override // A4.AbstractC0181y, A4.f0, java.io.Flushable
    public void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            throw complete(e);
        }
    }

    @Override // A4.AbstractC0181y, A4.f0
    public void write(C0169l c0169l, long j6) throws IOException {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        long j7 = this.b;
        if (j7 != -1 && this.c + j6 > j7) {
            StringBuilder sbT = androidx.collection.a.t("expected ", j7, " bytes but received ");
            sbT.append(this.c + j6);
            throw new ProtocolException(sbT.toString());
        }
        try {
            super.write(c0169l, j6);
            this.c += j6;
        } catch (IOException e) {
            throw complete(e);
        }
    }
}
