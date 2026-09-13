package X3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: X3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0253t implements Iterator, P3.a {

    @Deprecated
    public static final int EXHAUSTED = 2;

    @Deprecated
    public static final int HAS_NEXT = 1;
    private static final C0252s State = new C0252s();

    @Deprecated
    public static final int UNKNOWN = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f867a;
    public int b;
    public int c;
    public int d;
    private final CharSequence string;

    public C0253t(CharSequence string) {
        kotlin.jvm.internal.E.f(string, "string");
        this.string = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5;
        int i6;
        int i7 = this.f867a;
        if (i7 != 0) {
            return i7 == 1;
        }
        if (this.d < 0) {
            this.f867a = 2;
            return false;
        }
        int length = this.string.length();
        int length2 = this.string.length();
        for (int i8 = this.b; i8 < length2; i8++) {
            char cCharAt = this.string.charAt(i8);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i5 = (cCharAt == '\r' && (i6 = i8 + 1) < this.string.length() && this.string.charAt(i6) == '\n') ? 2 : 1;
                length = i8;
                this.f867a = 1;
                this.d = i5;
                this.c = length;
                return true;
            }
        }
        i5 = -1;
        this.f867a = 1;
        this.d = i5;
        this.c = length;
        return true;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f867a = 0;
        int i5 = this.c;
        int i6 = this.b;
        this.b = this.d + i5;
        return this.string.subSequence(i6, i5).toString();
    }
}
