package A4;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: renamed from: A4.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0162e implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0164g f69a;
    public final /* synthetic */ f0 b;

    public C0162e(C0164g c0164g, f0 f0Var) {
        this.f69a = c0164g;
        this.b = f0Var;
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        f0 f0Var = this.b;
        C0164g c0164g = this.f69a;
        c0164g.j();
        try {
            try {
                f0Var.close();
                if (c0164g.k()) {
                    throw c0164g.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!c0164g.k()) {
                    throw e;
                }
                throw c0164g.access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            c0164g.k();
            throw th;
        }
    }

    @Override // A4.f0, java.io.Flushable
    public final void flush() throws IOException {
        f0 f0Var = this.b;
        C0164g c0164g = this.f69a;
        c0164g.j();
        try {
            try {
                f0Var.flush();
                if (c0164g.k()) {
                    throw c0164g.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!c0164g.k()) {
                    throw e;
                }
                throw c0164g.access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            c0164g.k();
            throw th;
        }
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.b + ')';
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        AbstractC0159b.a(source.size(), 0L, j6);
        while (true) {
            long j7 = 0;
            if (j6 <= 0) {
                return;
            }
            c0 c0Var = source.head;
            kotlin.jvm.internal.E.c(c0Var);
            while (j7 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                j7 += (long) (c0Var.limit - c0Var.pos);
                if (j7 >= j6) {
                    j7 = j6;
                    break;
                } else {
                    c0Var = c0Var.next;
                    kotlin.jvm.internal.E.c(c0Var);
                }
            }
            f0 f0Var = this.b;
            C0164g c0164g = this.f69a;
            c0164g.j();
            try {
                try {
                    f0Var.write(source, j7);
                    if (c0164g.k()) {
                        throw c0164g.access$newTimeoutException(null);
                    }
                    j6 -= j7;
                } catch (IOException e) {
                    if (!c0164g.k()) {
                        throw e;
                    }
                    throw c0164g.access$newTimeoutException(e);
                }
            } catch (Throwable th) {
                c0164g.k();
                throw th;
            }
        }
    }

    @Override // A4.f0
    public C0164g timeout() {
        return this.f69a;
    }
}
