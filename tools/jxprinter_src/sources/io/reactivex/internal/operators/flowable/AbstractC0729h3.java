package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0729h3 extends p094q3.b {
    private static final long serialVersionUID = -2252972430506210021L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4654a;
    public long b;
    public volatile boolean c;

    public AbstractC0729h3(long j6, long j7) {
        this.b = j6;
        this.f4654a = j7;
    }

    public abstract void a();

    @Override // p043h3.f
    public final int c(int i5) {
        return 1;
    }

    @Override // t5.d
    public final void cancel() {
        this.c = true;
    }

    @Override // p043h3.j
    public final void clear() {
        this.b = this.f4654a;
    }

    public abstract void e(long j6);

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.b == this.f4654a;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6) && p122v2.a.a(this, j6) == 0) {
            if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
                a();
            } else {
                e(j6);
            }
        }
    }

    @Override // p094q3.b, p043h3.g, p043h3.f, p043h3.j
    public final Long poll() {
        long j6 = this.b;
        if (j6 == this.f4654a) {
            return null;
        }
        this.b = 1 + j6;
        return Long.valueOf(j6);
    }
}
