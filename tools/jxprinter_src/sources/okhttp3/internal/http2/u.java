package okhttp3.internal.http2;

import A4.C0169l;
import A4.InterfaceC0171n;
import A4.h0;
import A4.k0;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0171n f6646a;
    public int b;
    public byte c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short f6647f;

    public u(InterfaceC0171n interfaceC0171n) {
        this.f6646a = interfaceC0171n;
    }

    private void readContinuationHeader() throws IOException {
        int i5 = this.d;
        InterfaceC0171n interfaceC0171n = this.f6646a;
        int medium = w.readMedium(interfaceC0171n);
        this.e = medium;
        this.b = medium;
        byte b = (byte) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE);
        this.c = (byte) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE);
        Logger logger = w.e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(AbstractC1363g.a(true, this.d, this.b, b, this.c));
        }
        int i6 = interfaceC0171n.readInt() & Integer.MAX_VALUE;
        this.d = i6;
        if (b != 9) {
            throw AbstractC1363g.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b));
        }
        if (i6 != i5) {
            throw AbstractC1363g.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
    }

    @Override // A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        while (true) {
            int i5 = this.e;
            InterfaceC0171n interfaceC0171n = this.f6646a;
            if (i5 != 0) {
                long j7 = interfaceC0171n.read(c0169l, Math.min(j6, i5));
                if (j7 == -1) {
                    return -1L;
                }
                this.e = (int) (((long) this.e) - j7);
                return j7;
            }
            interfaceC0171n.skip(this.f6647f);
            this.f6647f = (short) 0;
            if ((this.c & 4) != 0) {
                return -1L;
            }
            readContinuationHeader();
        }
    }

    @Override // A4.h0
    public final k0 timeout() {
        return this.f6646a.timeout();
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
