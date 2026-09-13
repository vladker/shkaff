package p124v4;

import A4.A;
import A4.C0169l;
import A4.h0;
import A4.k0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f8787a;
    public boolean b;
    public final /* synthetic */ g c;

    public a(g gVar) {
        this.c = gVar;
        this.f8787a = new A(gVar.c.timeout());
    }

    public final void a() {
        g gVar = this.c;
        int i5 = gVar.e;
        if (i5 == 6) {
            return;
        }
        if (i5 == 5) {
            g.a(gVar, this.f8787a);
            gVar.e = 6;
        } else {
            throw new IllegalStateException("state: " + gVar.e);
        }
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public abstract /* synthetic */ void close();

    @Override // A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        g gVar = this.c;
        try {
            return gVar.c.read(c0169l, j6);
        } catch (IOException e) {
            gVar.b.c();
            a();
            throw e;
        }
    }

    @Override // A4.h0
    public final k0 timeout() {
        return this.f8787a;
    }
}
