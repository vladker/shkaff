package kotlin.jvm.internal;

import A3.e0;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1093g extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5700a;
    private final int[] array;

    public C1093g(int[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5700a < this.array.length;
    }

    @Override // A3.e0
    public final int nextInt() {
        try {
            int[] iArr = this.array;
            int i5 = this.f5700a;
            this.f5700a = i5 + 1;
            return iArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5700a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
