package okhttp3.internal.http2;

import A4.C0169l;
import A4.f0;
import A4.k0;
import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class x implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0169l f6649a = new C0169l();
    public boolean b;
    public boolean c;
    public final /* synthetic */ A d;

    public x(A a6) {
        this.d = a6;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    private void emitFrame(boolean z6) {
        A a6;
        long jMin;
        A a7;
        boolean z7;
        synchronized (this.d) {
            this.d.f6588j.j();
            while (true) {
                try {
                    a6 = this.d;
                    if (a6.b > 0 || this.c || this.b || a6.errorCode != null) {
                        break;
                    } else {
                        a6.waitForIo();
                    }
                } catch (Throwable th) {
                    this.d.f6588j.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            a6.f6588j.exitAndThrowIfTimedOut();
            this.d.checkOutNotClosed();
            jMin = Math.min(this.d.b, this.f6649a.size());
            a7 = this.d;
            a7.b -= jMin;
        }
        a7.f6588j.j();
        if (z6) {
            try {
                if (jMin == this.f6649a.size()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            } finally {
                this.d.f6588j.exitAndThrowIfTimedOut();
            }
        } else {
            z7 = false;
        }
        boolean z8 = z7;
        A a8 = this.d;
        a8.d.writeData(a8.c, z8, this.f6649a, jMin);
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.d) {
            try {
                if (this.b) {
                    return;
                }
                if (!this.d.f6586h.c) {
                    if (this.f6649a.size() > 0) {
                        while (this.f6649a.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        A a6 = this.d;
                        a6.d.writeData(a6.c, true, null, 0L);
                    }
                }
                synchronized (this.d) {
                    this.b = true;
                }
                this.d.d.flush();
                this.d.cancelStreamIfNecessary();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // A4.f0, java.io.Flushable
    public void flush() {
        synchronized (this.d) {
            this.d.checkOutNotClosed();
        }
        while (this.f6649a.size() > 0) {
            emitFrame(false);
            this.d.d.flush();
        }
    }

    @Override // A4.f0
    public final k0 timeout() {
        return this.d.f6588j;
    }

    @Override // A4.f0
    public void write(C0169l c0169l, long j6) {
        C0169l c0169l2 = this.f6649a;
        c0169l2.write(c0169l, j6);
        while (c0169l2.size() >= PlaybackStateCompat.ACTION_PREPARE) {
            emitFrame(false);
        }
    }
}
