package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1090d extends A3.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5696a;
    private final char[] array;

    public C1090d(char[] array) {
        E.f(array, "array");
        this.array = array;
    }

    @Override // A3.F
    public final char b() {
        try {
            char[] cArr = this.array;
            int i5 = this.f5696a;
            this.f5696a = i5 + 1;
            return cArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5696a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5696a < this.array.length;
    }
}
