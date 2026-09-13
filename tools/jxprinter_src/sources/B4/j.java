package B4;

import A4.AbstractC0182z;
import A4.C0169l;
import A4.h0;
import java.io.IOException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends AbstractC0182z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f109a;
    public final boolean b;
    public long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h0 delegate, long j6, boolean z6) {
        super(delegate);
        E.f(delegate, "delegate");
        this.f109a = j6;
        this.b = z6;
    }

    @Override // A4.AbstractC0182z, A4.h0
    public long read(C0169l sink, long j6) throws IOException {
        E.f(sink, "sink");
        long j7 = this.c;
        long j8 = this.f109a;
        if (j7 > j8) {
            j6 = 0;
        } else if (this.b) {
            long j9 = j8 - j7;
            if (j9 == 0) {
                return -1L;
            }
            j6 = Math.min(j6, j9);
        }
        long j10 = super.read(sink, j6);
        if (j10 != -1) {
            this.c += j10;
        }
        long j11 = this.c;
        if ((j11 >= j8 || j10 != -1) && j11 <= j8) {
            return j10;
        }
        if (j10 > 0 && j11 > j8) {
            long size = sink.size() - (this.c - j8);
            C0169l c0169l = new C0169l();
            c0169l.writeAll(sink);
            sink.write(c0169l, size);
            c0169l.a();
        }
        throw new IOException("expected " + j8 + " bytes but got " + this.c);
    }
}
