package A4;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 extends k0 {
    @Override // A4.k0
    public k0 timeout(long j6, TimeUnit unit) {
        kotlin.jvm.internal.E.f(unit, "unit");
        return this;
    }

    @Override // A4.k0
    public final void throwIfReached() {
    }

    @Override // A4.k0
    public k0 deadlineNanoTime(long j6) {
        return this;
    }
}
