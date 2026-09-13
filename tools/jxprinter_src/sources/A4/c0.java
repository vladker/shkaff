package A4;

import A3.AbstractC0151t;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {
    public static final b0 Companion = new b0();
    public final byte[] data;
    public int limit;
    public c0 next;
    public boolean owner;
    public int pos;
    public c0 prev;
    public boolean shared;

    public c0() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void a() {
        int i5;
        c0 c0Var = this.prev;
        if (c0Var == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.E.c(c0Var);
        if (c0Var.owner) {
            int i6 = this.limit - this.pos;
            c0 c0Var2 = this.prev;
            kotlin.jvm.internal.E.c(c0Var2);
            int i7 = 8192 - c0Var2.limit;
            c0 c0Var3 = this.prev;
            kotlin.jvm.internal.E.c(c0Var3);
            if (c0Var3.shared) {
                i5 = 0;
            } else {
                c0 c0Var4 = this.prev;
                kotlin.jvm.internal.E.c(c0Var4);
                i5 = c0Var4.pos;
            }
            if (i6 > i7 + i5) {
                return;
            }
            c0 c0Var5 = this.prev;
            kotlin.jvm.internal.E.c(c0Var5);
            writeTo(c0Var5, i6);
            pop();
            d0.recycle(this);
        }
    }

    public final c0 pop() {
        c0 c0Var = this.next;
        if (c0Var == this) {
            c0Var = null;
        }
        c0 c0Var2 = this.prev;
        kotlin.jvm.internal.E.c(c0Var2);
        c0Var2.next = this.next;
        c0 c0Var3 = this.next;
        kotlin.jvm.internal.E.c(c0Var3);
        c0Var3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return c0Var;
    }

    public final c0 push(c0 segment) {
        kotlin.jvm.internal.E.f(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        c0 c0Var = this.next;
        kotlin.jvm.internal.E.c(c0Var);
        c0Var.prev = segment;
        this.next = segment;
        return segment;
    }

    public final c0 sharedCopy() {
        this.shared = true;
        return new c0(this.data, this.pos, this.limit, true, false);
    }

    public final c0 split(int i5) {
        c0 c0VarTake;
        if (i5 <= 0 || i5 > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i5 >= 1024) {
            c0VarTake = sharedCopy();
        } else {
            c0VarTake = d0.take();
            byte[] bArr = this.data;
            byte[] bArr2 = c0VarTake.data;
            int i6 = this.pos;
            AbstractC0151t.copyInto(bArr, bArr2, 0, i6, i6 + i5);
        }
        c0VarTake.limit = c0VarTake.pos + i5;
        this.pos += i5;
        c0 c0Var = this.prev;
        kotlin.jvm.internal.E.c(c0Var);
        c0Var.push(c0VarTake);
        return c0VarTake;
    }

    public final c0 unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, size)");
        return new c0(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(c0 sink, int i5) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i6 = sink.limit;
        int i7 = i6 + i5;
        if (i7 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i8 = sink.pos;
            if (i7 - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            AbstractC0151t.copyInto(bArr, bArr, 0, i8, i6);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i9 = sink.limit;
        int i10 = this.pos;
        AbstractC0151t.copyInto(bArr2, bArr3, i9, i10, i10 + i5);
        sink.limit += i5;
        this.pos += i5;
    }

    public c0(byte[] data, int i5, int i6, boolean z6, boolean z7) {
        kotlin.jvm.internal.E.f(data, "data");
        this.data = data;
        this.pos = i5;
        this.limit = i6;
        this.shared = z6;
        this.owner = z7;
    }
}
