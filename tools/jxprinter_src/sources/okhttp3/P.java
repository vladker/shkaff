package okhttp3;

import A4.InterfaceC0170m;
import A4.h0;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class P extends Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f6542a;
    public final /* synthetic */ File b;

    public P(B b, File file) {
        this.f6542a = b;
        this.b = file;
    }

    @Override // okhttp3.Q
    public final long contentLength() {
        return this.b.length();
    }

    @Override // okhttp3.Q
    public B contentType() {
        return this.f6542a;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) {
        h0 h0VarSource = A4.N.source(this.b);
        try {
            interfaceC0170m.writeAll(h0VarSource);
            if (h0VarSource != null) {
                h0VarSource.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (h0VarSource != null) {
                    try {
                        h0VarSource.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
