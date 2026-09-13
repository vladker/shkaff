package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1091e extends A3.U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5698a;
    private final double[] array;

    public C1091e(double[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5698a < this.array.length;
    }

    @Override // A3.U
    public final double nextDouble() {
        try {
            double[] dArr = this.array;
            int i5 = this.f5698a;
            this.f5698a = i5 + 1;
            return dArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5698a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
