package A4;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

/* JADX INFO: renamed from: A4.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0174q implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78a;
    public boolean b;
    private final Cipher cipher;
    private final InterfaceC0170m sink;

    public C0174q(InterfaceC0170m sink, Cipher cipher) {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.f78a = blockSize;
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.b) {
            return;
        }
        this.b = true;
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize != 0) {
            if (outputSize > 8192) {
                try {
                    InterfaceC0170m interfaceC0170m = this.sink;
                    byte[] bArrDoFinal = this.cipher.doFinal();
                    kotlin.jvm.internal.E.e(bArrDoFinal, "cipher.doFinal()");
                    interfaceC0170m.write(bArrDoFinal);
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                C0169l buffer = this.sink.getBuffer();
                c0 c0VarWritableSegment$okio = buffer.writableSegment$okio(outputSize);
                try {
                    int iDoFinal = this.cipher.doFinal(c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit);
                    c0VarWritableSegment$okio.limit += iDoFinal;
                    buffer.f76a = buffer.size() + ((long) iDoFinal);
                } catch (Throwable th3) {
                    th = th3;
                }
                if (c0VarWritableSegment$okio.pos == c0VarWritableSegment$okio.limit) {
                    buffer.head = c0VarWritableSegment$okio.pop();
                    d0.recycle(c0VarWritableSegment$okio);
                }
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        if (th != null) {
            throw th;
        }
    }

    @Override // A4.f0, java.io.Flushable
    public final void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // A4.f0
    public k0 timeout() {
        return this.sink.timeout();
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) throws ShortBufferException {
        int i5;
        kotlin.jvm.internal.E.f(source, "source");
        AbstractC0159b.a(source.size(), 0L, j6);
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        for (long j7 = j6; j7 > 0; j7 -= (long) i5) {
            c0 c0Var = source.head;
            kotlin.jvm.internal.E.c(c0Var);
            int iMin = (int) Math.min(j7, c0Var.limit - c0Var.pos);
            C0169l buffer = this.sink.getBuffer();
            int outputSize = this.cipher.getOutputSize(iMin);
            i5 = iMin;
            while (true) {
                if (outputSize <= 8192) {
                    c0 c0VarWritableSegment$okio = buffer.writableSegment$okio(outputSize);
                    int iUpdate = this.cipher.update(c0Var.data, c0Var.pos, i5, c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit);
                    c0VarWritableSegment$okio.limit += iUpdate;
                    buffer.f76a = buffer.size() + ((long) iUpdate);
                    if (c0VarWritableSegment$okio.pos == c0VarWritableSegment$okio.limit) {
                        buffer.head = c0VarWritableSegment$okio.pop();
                        d0.recycle(c0VarWritableSegment$okio);
                    }
                    this.sink.emitCompleteSegments();
                    source.f76a = source.size() - ((long) i5);
                    int i6 = c0Var.pos + i5;
                    c0Var.pos = i6;
                    if (i6 != c0Var.limit) {
                        break;
                    }
                    source.head = c0Var.pop();
                    d0.recycle(c0Var);
                    break;
                }
                int i7 = this.f78a;
                if (i5 <= i7) {
                    InterfaceC0170m interfaceC0170m = this.sink;
                    byte[] bArrUpdate = this.cipher.update(source.readByteArray(j7));
                    kotlin.jvm.internal.E.e(bArrUpdate, "cipher.update(source.readByteArray(remaining))");
                    interfaceC0170m.write(bArrUpdate);
                    i5 = (int) j7;
                    break;
                }
                i5 -= i7;
                outputSize = this.cipher.getOutputSize(i5);
            }
        }
    }
}
