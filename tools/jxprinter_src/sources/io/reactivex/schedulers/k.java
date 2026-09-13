package io.reactivex.schedulers;

import java.util.concurrent.TimeUnit;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5371a;
    public final long b;
    public final TimeUnit c;

    public k(Object obj, long j6, TimeUnit timeUnit) {
        this.f5371a = obj;
        this.b = j6;
        A.b(timeUnit, "unit is null");
        this.c = timeUnit;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (A.a(this.f5371a, kVar.f5371a) && this.b == kVar.b && A.a(this.c, kVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f5371a;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        long j6 = this.b;
        return this.c.hashCode() + (((iHashCode * 31) + ((int) (j6 ^ (j6 >>> 31)))) * 31);
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.b, this.c);
    }

    public final String toString() {
        return "Timed[time=" + this.b + ", unit=" + this.c + ", value=" + this.f5371a + "]";
    }

    public TimeUnit unit() {
        return this.c;
    }

    public Object value() {
        return this.f5371a;
    }
}
