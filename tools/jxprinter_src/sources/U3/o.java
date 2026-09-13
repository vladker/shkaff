package U3;

import A3.e0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f733a;
    public final int b;
    public boolean c;
    public int d;

    public o(int i5, int i6, int i7) {
        this.f733a = i7;
        this.b = i6;
        boolean z6 = false;
        if (i7 <= 0 ? i5 >= i6 : i5 <= i6) {
            z6 = true;
        }
        this.c = z6;
        this.d = z6 ? i5 : i6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // A3.e0
    public final int nextInt() {
        int i5 = this.d;
        if (i5 != this.b) {
            this.d = this.f733a + i5;
            return i5;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i5;
    }
}
