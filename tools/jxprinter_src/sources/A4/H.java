package A4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class H implements h0 {
    private final InputStream input;
    private final k0 timeout;

    public H(InputStream input, k0 timeout) {
        kotlin.jvm.internal.E.f(input, "input");
        kotlin.jvm.internal.E.f(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.input.close();
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) throws IOException {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 == 0) {
            return 0L;
        }
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        try {
            this.timeout.throwIfReached();
            c0 c0VarWritableSegment$okio = sink.writableSegment$okio(1);
            int i5 = this.input.read(c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, (int) Math.min(j6, 8192 - c0VarWritableSegment$okio.limit));
            if (i5 != -1) {
                c0VarWritableSegment$okio.limit += i5;
                long j7 = i5;
                sink.f76a = sink.size() + j7;
                return j7;
            }
            if (c0VarWritableSegment$okio.pos != c0VarWritableSegment$okio.limit) {
                return -1L;
            }
            sink.head = c0VarWritableSegment$okio.pop();
            d0.recycle(c0VarWritableSegment$okio);
            return -1L;
        } catch (AssertionError e) {
            if (N.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
