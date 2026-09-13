package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1089c extends A3.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5694a;
    private final byte[] array;

    public C1089c(byte[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5694a < this.array.length;
    }

    @Override // A3.E
    public final byte nextByte() {
        try {
            byte[] bArr = this.array;
            int i5 = this.f5694a;
            this.f5694a = i5 + 1;
            return bArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5694a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
