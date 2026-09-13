package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1088b extends A3.D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5693a;
    private final boolean[] array;

    public C1088b(boolean[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5693a < this.array.length;
    }

    @Override // A3.D
    public final boolean nextBoolean() {
        try {
            boolean[] zArr = this.array;
            int i5 = this.f5693a;
            this.f5693a = i5 + 1;
            return zArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5693a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
