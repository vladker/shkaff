package p124v4;

import A4.InterfaceC0171n;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C1376w;
import okhttp3.C1378y;
import p107s4.d;
import p118u4.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends a {
    public final C1378y d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f8790g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, C1378y c1378y) {
        super(gVar);
        this.f8790g = gVar;
        this.e = -1L;
        this.f8789f = true;
        this.d = c1378y;
    }

    private void readChunkSize() throws ProtocolException {
        g gVar = this.f8790g;
        InterfaceC0171n interfaceC0171n = gVar.c;
        if (this.e != -1) {
            interfaceC0171n.readUtf8LineStrict();
        }
        try {
            this.e = interfaceC0171n.readHexadecimalUnsignedLong();
            String strTrim = interfaceC0171n.readUtf8LineStrict().trim();
            if (this.e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + strTrim + "\"");
            }
            if (this.e == 0) {
                this.f8789f = false;
                C1376w headers = gVar.readHeaders();
                gVar.f8794g = headers;
                e.d(gVar.f8792a.f6515h, this.d, headers);
                a();
            }
        } catch (NumberFormatException e) {
            throw new ProtocolException(e.getMessage());
        }
    }

    @Override // p124v4.a, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean zSkipAll;
        if (this.b) {
            return;
        }
        if (this.f8789f) {
            try {
                zSkipAll = d.skipAll(this, 100, TimeUnit.MILLISECONDS);
            } catch (IOException unused) {
                zSkipAll = false;
            }
            if (!zSkipAll) {
                this.f8790g.b.c();
                a();
            }
        }
        this.b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r7.f8789f == false) goto L15;
     */
    @Override // p124v4.a, A4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long read(A4.C0169l r8, long r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 < 0) goto L51
            boolean r2 = r7.b
            if (r2 != 0) goto L49
            boolean r2 = r7.f8789f
            r3 = -1
            if (r2 != 0) goto L11
            goto L22
        L11:
            long r5 = r7.e
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L1b
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L23
        L1b:
            r7.readChunkSize()
            boolean r0 = r7.f8789f
            if (r0 != 0) goto L23
        L22:
            return r3
        L23:
            long r0 = r7.e
            long r9 = java.lang.Math.min(r9, r0)
            long r8 = super.read(r8, r9)
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 == 0) goto L37
            long r0 = r7.e
            long r0 = r0 - r8
            r7.e = r0
            return r8
        L37:
            v4.g r8 = r7.f8790g
            t4.h r8 = r8.b
            r8.c()
            java.net.ProtocolException r8 = new java.net.ProtocolException
            java.lang.String r9 = "unexpected end of stream"
            r8.<init>(r9)
            r7.a()
            throw r8
        L49:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L51:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "byteCount < 0: "
            java.lang.String r9 = androidx.collection.a.j(r9, r0)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p124v4.c.read(A4.l, long):long");
    }
}
