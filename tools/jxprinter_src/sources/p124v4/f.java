package p124v4;

import A4.C0169l;
import androidx.collection.a;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends a {
    public boolean d;

    @Override // p124v4.a, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        if (!this.d) {
            a();
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
        if (this.d) {
            return -1L;
        }
        long j7 = super.read(c0169l, j6);
        if (j7 != -1) {
            return j7;
        }
        this.d = true;
        a();
        return -1L;
    }
}
