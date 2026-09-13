package T3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends S3.a {
    @Override // S3.f
    public final int e(int i5, int i6) {
        return ThreadLocalRandom.current().nextInt(i5, i6);
    }

    @Override // S3.f
    public final long g(long j6, long j7) {
        return ThreadLocalRandom.current().nextLong(j6, j7);
    }

    @Override // S3.a
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        E.e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
