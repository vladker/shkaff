package X3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p147z3.C1938s;

/* JADX INFO: renamed from: X3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0242h implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f858a = -1;
    public int b;
    public int c;
    public U3.q d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0243i f859f;

    public C0242h(C0243i c0243i) {
        this.f859f = c0243i;
        int i5 = c0243i.f860a;
        int length = c0243i.input.length();
        if (length < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 > length) {
            i5 = length;
        }
        this.b = i5;
        this.c = i5;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:18:0x007f  */
    public final void b() {
        C1938s c1938s;
        int i5 = this.c;
        if (i5 < 0) {
            this.f858a = 0;
            this.d = null;
            return;
        }
        C0243i c0243i = this.f859f;
        int i6 = c0243i.b;
        if (i6 > 0) {
            int i7 = this.e + 1;
            this.e = i7;
            if (i7 >= i6) {
                this.d = new U3.q(this.b, b0.getLastIndex(c0243i.input), 1);
                this.c = -1;
            } else if (i5 > c0243i.input.length() && (c1938s = (C1938s) c0243i.getNextMatch.invoke(c0243i.input, Integer.valueOf(this.c))) != null) {
                int iIntValue = ((Number) c1938s.f9134a).intValue();
                int iIntValue2 = ((Number) c1938s.b).intValue();
                this.d = U3.B.until(this.b, iIntValue);
                int i8 = iIntValue + iIntValue2;
                this.b = i8;
                this.c = i8 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.d = new U3.q(this.b, b0.getLastIndex(c0243i.input), 1);
                this.c = -1;
            }
        } else if (i5 > c0243i.input.length()) {
            this.d = new U3.q(this.b, b0.getLastIndex(c0243i.input), 1);
            this.c = -1;
        } else {
            int iIntValue3 = ((Number) c1938s.f9134a).intValue();
            int iIntValue4 = ((Number) c1938s.b).intValue();
            this.d = U3.B.until(this.b, iIntValue3);
            int i9 = iIntValue3 + iIntValue4;
            this.b = i9;
            this.c = i9 + (iIntValue4 == 0 ? 1 : 0);
        }
        this.f858a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f858a == -1) {
            b();
        }
        return this.f858a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f858a == -1) {
            b();
        }
        if (this.f858a == 0) {
            throw new NoSuchElementException();
        }
        U3.q qVar = this.d;
        kotlin.jvm.internal.E.d(qVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.f858a = -1;
        return qVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
