package S3;

import java.util.Random;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends f {
    @Override // S3.f
    public final int b(int i5) {
        return ((-i5) >> 31) & (getImpl().nextInt() >>> (32 - i5));
    }

    @Override // S3.f
    public final int c() {
        return getImpl().nextInt();
    }

    @Override // S3.f
    public final int d(int i5) {
        return getImpl().nextInt(i5);
    }

    @Override // S3.f
    public final long f() {
        return getImpl().nextLong();
    }

    public abstract Random getImpl();

    @Override // S3.f
    public byte[] nextBytes(byte[] array) {
        E.f(array, "array");
        getImpl().nextBytes(array);
        return array;
    }
}
