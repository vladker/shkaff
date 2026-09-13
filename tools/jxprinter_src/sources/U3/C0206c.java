package U3;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: U3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0206c extends A3.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f729a;
    public final int b;
    public boolean c;
    public int d;

    public C0206c(char c, char c6, int i5) {
        this.f729a = i5;
        this.b = c6;
        boolean z6 = false;
        if (i5 <= 0 ? kotlin.jvm.internal.E.h(c, c6) >= 0 : kotlin.jvm.internal.E.h(c, c6) <= 0) {
            z6 = true;
        }
        this.c = z6;
        this.d = z6 ? c : c6;
    }

    @Override // A3.F
    public final char b() {
        int i5 = this.d;
        if (i5 != this.b) {
            this.d = this.f729a + i5;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return (char) i5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }
}
