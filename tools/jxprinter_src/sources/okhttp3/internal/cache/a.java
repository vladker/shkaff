package okhttp3.internal.cache;

import A4.C0169l;
import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import A4.h0;
import A4.k0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6582a;
    public final /* synthetic */ InterfaceC0171n b;
    public final /* synthetic */ InterfaceC0170m c;

    public a(InterfaceC0171n interfaceC0171n, InterfaceC0170m interfaceC0170m) {
        this.b = interfaceC0171n;
        this.c = interfaceC0170m;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean zSkipAll;
        if (!this.f6582a) {
            try {
                zSkipAll = p107s4.d.skipAll(this, 100, TimeUnit.MILLISECONDS);
            } catch (IOException unused) {
                zSkipAll = false;
            }
            if (!zSkipAll) {
                this.f6582a = true;
                throw null;
            }
        }
        this.b.close();
    }

    @Override // A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        try {
            long j7 = this.b.read(c0169l, j6);
            InterfaceC0170m interfaceC0170m = this.c;
            if (j7 != -1) {
                c0169l.copyTo(interfaceC0170m.buffer(), c0169l.size() - j7, j7);
                interfaceC0170m.emitCompleteSegments();
                return j7;
            }
            if (!this.f6582a) {
                this.f6582a = true;
                interfaceC0170m.close();
            }
            return -1L;
        } catch (IOException e) {
            if (this.f6582a) {
                throw e;
            }
            this.f6582a = true;
            throw null;
        }
    }

    @Override // A4.h0
    public final k0 timeout() {
        return this.b.timeout();
    }
}
