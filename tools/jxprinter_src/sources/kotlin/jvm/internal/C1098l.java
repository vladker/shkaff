package kotlin.jvm.internal;

import A3.y0;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1098l extends y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5703a;
    private final short[] array;

    public C1098l(short[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // A3.y0
    public final short b() {
        try {
            short[] sArr = this.array;
            int i5 = this.f5703a;
            this.f5703a = i5 + 1;
            return sArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5703a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5703a < this.array.length;
    }
}
