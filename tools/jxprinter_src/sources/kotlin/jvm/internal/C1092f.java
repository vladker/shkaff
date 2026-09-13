package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1092f extends A3.Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5699a;
    private final float[] array;

    public C1092f(float[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // A3.Z
    public final float b() {
        try {
            float[] fArr = this.array;
            int i5 = this.f5699a;
            this.f5699a = i5 + 1;
            return fArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5699a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5699a < this.array.length;
    }
}
