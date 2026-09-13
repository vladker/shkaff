package p124v4;

import A4.A;
import A4.C0169l;
import A4.InterfaceC0170m;
import A4.f0;
import A4.k0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f8788a;
    public boolean b;
    public final /* synthetic */ g c;

    public b(g gVar) {
        this.c = gVar;
        this.f8788a = new A(gVar.d.timeout());
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c.d.writeUtf8("0\r\n\r\n");
        g.a(this.c, this.f8788a);
        this.c.e = 3;
    }

    @Override // A4.f0, java.io.Flushable
    public synchronized void flush() {
        if (this.b) {
            return;
        }
        this.c.d.flush();
    }

    @Override // A4.f0
    public final k0 timeout() {
        return this.f8788a;
    }

    @Override // A4.f0
    public void write(C0169l c0169l, long j6) {
        InterfaceC0170m interfaceC0170m = this.c.d;
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j6 == 0) {
            return;
        }
        interfaceC0170m.writeHexadecimalUnsignedLong(j6);
        interfaceC0170m.writeUtf8("\r\n");
        interfaceC0170m.write(c0169l, j6);
        interfaceC0170m.writeUtf8("\r\n");
    }
}
