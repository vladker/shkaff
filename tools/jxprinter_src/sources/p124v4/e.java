package p124v4;

import A4.A;
import A4.C0169l;
import A4.f0;
import A4.k0;
import p107s4.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f8791a;
    public boolean b;
    public final /* synthetic */ g c;

    public e(g gVar) {
        this.c = gVar;
        this.f8791a = new A(gVar.d.timeout());
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        A a6 = this.f8791a;
        g gVar = this.c;
        g.a(gVar, a6);
        gVar.e = 3;
    }

    @Override // A4.f0, java.io.Flushable
    public void flush() {
        if (this.b) {
            return;
        }
        this.c.d.flush();
    }

    @Override // A4.f0
    public final k0 timeout() {
        return this.f8791a;
    }

    @Override // A4.f0
    public void write(C0169l c0169l, long j6) {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long size = c0169l.size();
        byte[] bArr = d.f8235a;
        if (j6 < 0 || 0 > size || size < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.c.d.write(c0169l, j6);
    }
}
