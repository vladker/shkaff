package A4;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79a;
    public boolean b;
    private final C0169l buffer;
    public boolean c;
    private final Cipher cipher;
    private final InterfaceC0171n source;

    public r(InterfaceC0171n source, Cipher cipher) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.f79a = blockSize;
        this.buffer = new C0169l();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j6 == 0) {
            return 0L;
        }
        while (this.buffer.size() == 0 && !this.b) {
            if (!this.source.exhausted()) {
                c0 c0Var = this.source.getBuffer().head;
                kotlin.jvm.internal.E.c(c0Var);
                int i5 = c0Var.limit - c0Var.pos;
                int outputSize = this.cipher.getOutputSize(i5);
                int i6 = i5;
                while (true) {
                    if (outputSize <= 8192) {
                        c0 c0VarWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
                        int iUpdate = this.cipher.update(c0Var.data, c0Var.pos, i6, c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.pos);
                        this.source.skip(i6);
                        c0VarWritableSegment$okio.limit += iUpdate;
                        C0169l c0169l = this.buffer;
                        c0169l.f76a = c0169l.size() + ((long) iUpdate);
                        if (c0VarWritableSegment$okio.pos != c0VarWritableSegment$okio.limit) {
                            break;
                        }
                        this.buffer.head = c0VarWritableSegment$okio.pop();
                        d0.recycle(c0VarWritableSegment$okio);
                        break;
                    }
                    int i7 = this.f79a;
                    if (i6 <= i7) {
                        this.b = true;
                        C0169l c0169l2 = this.buffer;
                        byte[] bArrDoFinal = this.cipher.doFinal(this.source.readByteArray());
                        kotlin.jvm.internal.E.e(bArrDoFinal, "cipher.doFinal(source.readByteArray())");
                        c0169l2.write(bArrDoFinal);
                        break;
                    }
                    i6 -= i7;
                    outputSize = this.cipher.getOutputSize(i6);
                }
            } else {
                this.b = true;
                int outputSize2 = this.cipher.getOutputSize(0);
                if (outputSize2 == 0) {
                    break;
                }
                c0 c0VarWritableSegment$okio2 = this.buffer.writableSegment$okio(outputSize2);
                int iDoFinal = this.cipher.doFinal(c0VarWritableSegment$okio2.data, c0VarWritableSegment$okio2.pos);
                c0VarWritableSegment$okio2.limit += iDoFinal;
                C0169l c0169l3 = this.buffer;
                c0169l3.f76a = c0169l3.size() + ((long) iDoFinal);
                if (c0VarWritableSegment$okio2.pos != c0VarWritableSegment$okio2.limit) {
                    break;
                }
                this.buffer.head = c0VarWritableSegment$okio2.pop();
                d0.recycle(c0VarWritableSegment$okio2);
                break;
            }
        }
        return this.buffer.read(sink, j6);
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.source.timeout();
    }
}
