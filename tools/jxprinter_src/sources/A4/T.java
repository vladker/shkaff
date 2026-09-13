package A4;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class T implements f0 {
    private final OutputStream out;
    private final k0 timeout;

    public T(OutputStream out, k0 timeout) {
        kotlin.jvm.internal.E.f(out, "out");
        kotlin.jvm.internal.E.f(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.out.close();
    }

    @Override // A4.f0, java.io.Flushable
    public final void flush() throws IOException {
        this.out.flush();
    }

    @Override // A4.f0
    public k0 timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        AbstractC0159b.a(source.size(), 0L, j6);
        while (j6 > 0) {
            this.timeout.throwIfReached();
            c0 c0Var = source.head;
            kotlin.jvm.internal.E.c(c0Var);
            int iMin = (int) Math.min(j6, c0Var.limit - c0Var.pos);
            this.out.write(c0Var.data, c0Var.pos, iMin);
            c0Var.pos += iMin;
            long j7 = iMin;
            j6 -= j7;
            source.f76a = source.size() - j7;
            if (c0Var.pos == c0Var.limit) {
                source.head = c0Var.pop();
                d0.recycle(c0Var);
            }
        }
    }
}
