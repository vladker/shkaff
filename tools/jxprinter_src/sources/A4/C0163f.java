package A4;

import java.io.IOException;

/* JADX INFO: renamed from: A4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0163f implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0164g f70a;
    public final /* synthetic */ h0 b;

    public C0163f(C0164g c0164g, h0 h0Var) {
        this.f70a = c0164g;
        this.b = h0Var;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        h0 h0Var = this.b;
        C0164g c0164g = this.f70a;
        c0164g.j();
        try {
            try {
                h0Var.close();
                if (c0164g.k()) {
                    throw c0164g.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!c0164g.k()) {
                    throw e;
                }
                throw c0164g.access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            c0164g.k();
            throw th;
        }
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) throws IOException {
        kotlin.jvm.internal.E.f(sink, "sink");
        h0 h0Var = this.b;
        C0164g c0164g = this.f70a;
        c0164g.j();
        try {
            try {
                long j7 = h0Var.read(sink, j6);
                if (c0164g.k()) {
                    throw c0164g.access$newTimeoutException(null);
                }
                return j7;
            } catch (IOException e) {
                if (c0164g.k()) {
                    throw c0164g.access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            c0164g.k();
            throw th;
        }
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.b + ')';
    }

    @Override // A4.h0
    public C0164g timeout() {
        return this.f70a;
    }
}
