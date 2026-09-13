package p124v4;

import A4.C0169l;
import androidx.collection.a;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends a {
    public long d;
    public final /* synthetic */ g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, long j6) {
        super(gVar);
        this.e = gVar;
        this.d = j6;
        if (j6 == 0) {
            a();
        }
    }

    @Override // p124v4.a, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean zSkipAll;
        if (this.b) {
            return;
        }
        if (this.d != 0) {
            try {
                zSkipAll = p107s4.d.skipAll(this, 100, TimeUnit.MILLISECONDS);
            } catch (IOException unused) {
                zSkipAll = false;
            }
            if (!zSkipAll) {
                this.e.b.c();
                a();
            }
        }
        this.b = true;
    }

    @Override // p124v4.a, A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        if (j6 < 0) {
            throw new IllegalArgumentException(a.j(j6, "byteCount < 0: "));
        }
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long j7 = this.d;
        if (j7 == 0) {
            return -1L;
        }
        long j8 = super.read(c0169l, Math.min(j7, j6));
        if (j8 == -1) {
            this.e.b.c();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j9 = this.d - j8;
        this.d = j9;
        if (j9 == 0) {
            a();
        }
        return j8;
    }
}
