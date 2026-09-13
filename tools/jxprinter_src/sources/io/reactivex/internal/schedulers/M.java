package io.reactivex.internal.schedulers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5343a;
    public final long b;
    public final int c;
    public volatile boolean d;

    public M(Runnable runnable, Long l6, int i5) {
        this.f5343a = runnable;
        this.b = l6.longValue();
        this.c = i5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i5;
        M m6 = (M) obj;
        long j6 = this.b;
        long j7 = m6.b;
        if (j6 < j7) {
            i5 = -1;
        } else {
            i5 = j6 > j7 ? 1 : 0;
        }
        if (i5 != 0) {
            return i5;
        }
        int i6 = m6.c;
        int i7 = this.c;
        if (i7 < i6) {
            return -1;
        }
        return i7 > i6 ? 1 : 0;
    }
}
