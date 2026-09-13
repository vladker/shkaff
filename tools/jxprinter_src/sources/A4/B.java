package A4;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class B implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f61a;
    private final CRC32 crc;
    private final Inflater inflater;
    private final G inflaterSource;
    private final a0 source;

    public B(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        a0 a0Var = new a0(source);
        this.source = a0Var;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new G((InterfaceC0171n) a0Var, inflater);
        this.crc = new CRC32();
    }

    public static void a(int i5, int i6, String str) throws IOException {
        if (i6 != i5) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i5)}, 3)));
        }
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b = this.source.bufferField.getByte(3L);
        boolean z6 = ((b >> 1) & 1) == 1;
        if (z6) {
            b(0L, this.source.bufferField, 10L);
        }
        a(8075, this.source.readShort(), "ID1ID2");
        this.source.skip(8L);
        if (((b >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z6) {
                b(0L, this.source.bufferField, 2L);
            }
            long shortLe = this.source.bufferField.readShortLe() & 65535;
            this.source.require(shortLe);
            if (z6) {
                b(0L, this.source.bufferField, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z6) {
                b(0L, this.source.bufferField, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((b >> 4) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z6) {
                b(0L, this.source.bufferField, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z6) {
            a(this.source.readShortLe(), (short) this.crc.getValue(), "FHCRC");
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        a(this.source.readIntLe(), (int) this.crc.getValue(), "CRC");
        a(this.source.readIntLe(), (int) this.inflater.getBytesWritten(), "ISIZE");
    }

    public final void b(long j6, C0169l c0169l, long j7) {
        c0 c0Var = c0169l.head;
        kotlin.jvm.internal.E.c(c0Var);
        while (true) {
            int i5 = c0Var.limit;
            int i6 = c0Var.pos;
            if (j6 < i5 - i6) {
                break;
            }
            j6 -= (long) (i5 - i6);
            c0Var = c0Var.next;
            kotlin.jvm.internal.E.c(c0Var);
        }
        while (j7 > 0) {
            int i7 = (int) (((long) c0Var.pos) + j6);
            int iMin = (int) Math.min(c0Var.limit - i7, j7);
            this.crc.update(c0Var.data, i7, iMin);
            j7 -= (long) iMin;
            c0Var = c0Var.next;
            kotlin.jvm.internal.E.c(c0Var);
            j6 = 0;
        }
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) throws IOException {
        B b;
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (j6 == 0) {
            return 0L;
        }
        if (this.f61a == 0) {
            consumeHeader();
            this.f61a = (byte) 1;
        }
        if (this.f61a == 1) {
            long size = sink.size();
            long j7 = this.inflaterSource.read(sink, j6);
            if (j7 != -1) {
                b(size, sink, j7);
                return j7;
            }
            b = this;
            b.f61a = (byte) 2;
        } else {
            b = this;
        }
        if (b.f61a == 2) {
            consumeTrailer();
            b.f61a = (byte) 3;
            if (!b.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.source.timeout();
    }
}
