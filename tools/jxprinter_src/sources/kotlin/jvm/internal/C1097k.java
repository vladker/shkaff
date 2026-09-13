package kotlin.jvm.internal;

import A3.f0;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1097k extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5702a;
    private final long[] array;

    public C1097k(long[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5702a < this.array.length;
    }

    @Override // A3.f0
    public final long nextLong() {
        try {
            long[] jArr = this.array;
            int i5 = this.f5702a;
            this.f5702a = i5 + 1;
            return jArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5702a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
