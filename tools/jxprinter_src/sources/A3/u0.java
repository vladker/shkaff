package A3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50a;
    public int b;
    private final Object[] buffer;
    public int c;

    public u0(Object[] buffer, int i5) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        this.buffer = buffer;
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "ring buffer filled size should not be negative but it is ").toString());
        }
        if (i5 <= buffer.length) {
            this.f50a = buffer.length;
            this.c = i5;
        } else {
            StringBuilder sbT = AbstractC0157z.t(i5, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
            sbT.append(buffer.length);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.c;
    }

    public final void d(Object obj) {
        int iB = b();
        int i5 = this.f50a;
        if (iB == i5) {
            throw new IllegalStateException("ring buffer is full");
        }
        Object[] objArr = this.buffer;
        int i6 = this.b;
        int i7 = this.c;
        objArr[(i6 + i7) % i5] = obj;
        this.c = i7 + 1;
    }

    public final void e(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "n shouldn't be negative but it is ").toString());
        }
        if (i5 > this.c) {
            StringBuilder sbT = AbstractC0157z.t(i5, "n shouldn't be greater than the buffer size: n = ", ", size = ");
            sbT.append(this.c);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        if (i5 > 0) {
            int i6 = this.b;
            int i7 = this.f50a;
            int i8 = (i6 + i5) % i7;
            if (i6 > i8) {
                AbstractC0151t.fill(this.buffer, (Object) null, i6, i7);
                AbstractC0151t.fill(this.buffer, (Object) null, 0, i8);
            } else {
                AbstractC0151t.fill(this.buffer, (Object) null, i6, i8);
            }
            this.b = i8;
            this.c -= i5;
        }
    }

    public final u0 expanded(int i5) {
        Object[] array;
        int i6 = this.f50a;
        int i7 = i6 + (i6 >> 1) + 1;
        if (i7 <= i5) {
            i5 = i7;
        }
        if (this.b == 0) {
            array = Arrays.copyOf(this.buffer, i5);
            kotlin.jvm.internal.E.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[i5]);
        }
        return new u0(array, b());
    }

    @Override // java.util.List
    public final Object get(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.c;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return this.buffer[(this.b + i5) % this.f50a];
    }

    @Override // A3.AbstractC0139g, A3.AbstractC0132b, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return new t0(this);
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[b()]);
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < b()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, b());
            kotlin.jvm.internal.E.e(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int iB = b();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = this.b; i6 < iB && i7 < this.f50a; i7++) {
            objArr[i6] = this.buffer[i7];
            i6++;
        }
        while (i6 < iB) {
            objArr[i6] = this.buffer[i5];
            i6++;
            i5++;
        }
        return (T[]) G.terminateCollectionToArray(iB, objArr);
    }
}
