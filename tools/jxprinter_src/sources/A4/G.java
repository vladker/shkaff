package A4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class G implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62a;
    public boolean b;
    private final Inflater inflater;
    private final InterfaceC0171n source;

    public G(InterfaceC0171n source, Inflater inflater) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        this.inflater.end();
        this.b = true;
        this.source.close();
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) throws IOException {
        kotlin.jvm.internal.E.f(sink, "sink");
        do {
            long orInflate = readOrInflate(sink, j6);
            if (orInflate > 0) {
                return orInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(C0169l sink, long j6) throws IOException {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j6 != 0) {
            try {
                c0 c0VarWritableSegment$okio = sink.writableSegment$okio(1);
                int iMin = (int) Math.min(j6, 8192 - c0VarWritableSegment$okio.limit);
                refill();
                int iInflate = this.inflater.inflate(c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, iMin);
                int i5 = this.f62a;
                if (i5 != 0) {
                    int remaining = i5 - this.inflater.getRemaining();
                    this.f62a -= remaining;
                    this.source.skip(remaining);
                }
                if (iInflate > 0) {
                    c0VarWritableSegment$okio.limit += iInflate;
                    long j7 = iInflate;
                    sink.f76a = sink.size() + j7;
                    return j7;
                }
                if (c0VarWritableSegment$okio.pos == c0VarWritableSegment$okio.limit) {
                    sink.head = c0VarWritableSegment$okio.pop();
                    d0.recycle(c0VarWritableSegment$okio);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    public final boolean refill() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        c0 c0Var = this.source.getBuffer().head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.limit;
        int i6 = c0Var.pos;
        int i7 = i5 - i6;
        this.f62a = i7;
        this.inflater.setInput(c0Var.data, i6, i7);
        return false;
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public G(h0 source, Inflater inflater) {
        this(N.buffer(source), inflater);
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(inflater, "inflater");
    }
}
