package S3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f implements Serializable {
    private final Object writeReplace() {
        return d.INSTANCE;
    }

    @Override // S3.f
    public final int b(int i5) {
        return f.defaultRandom.b(i5);
    }

    @Override // S3.f
    public final int c() {
        return f.defaultRandom.c();
    }

    @Override // S3.f
    public final int d(int i5) {
        return f.defaultRandom.d(i5);
    }

    @Override // S3.f
    public final int e(int i5, int i6) {
        return f.defaultRandom.e(i5, i6);
    }

    @Override // S3.f
    public final long f() {
        return f.defaultRandom.f();
    }

    @Override // S3.f
    public final long g(long j6, long j7) {
        return f.defaultRandom.g(j6, j7);
    }

    @Override // S3.f
    public byte[] nextBytes(byte[] array) {
        E.f(array, "array");
        return f.defaultRandom.nextBytes(array);
    }

    @Override // S3.f
    public byte[] nextBytes(int i5) {
        return f.defaultRandom.nextBytes(i5);
    }

    @Override // S3.f
    public byte[] nextBytes(byte[] array, int i5, int i6) {
        E.f(array, "array");
        return f.defaultRandom.nextBytes(array, i5, i6);
    }
}
