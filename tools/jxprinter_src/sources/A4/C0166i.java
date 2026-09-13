package A4;

import java.io.Closeable;

/* JADX INFO: renamed from: A4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0166i implements Closeable {
    public C0169l buffer;
    public byte[] data;
    public boolean readWrite;
    private c0 segment;
    public long offset = -1;
    public int start = -1;
    public int end = -1;

    public final int a(long j6) {
        c0 c0VarPush;
        C0169l c0169l = this.buffer;
        if (c0169l == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j6 < -1 || j6 > c0169l.size()) {
            StringBuilder sbT = androidx.collection.a.t("offset=", j6, " > size=");
            sbT.append(c0169l.size());
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        if (j6 == -1 || j6 == c0169l.size()) {
            setSegment$okio(null);
            this.offset = j6;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        }
        long size = c0169l.size();
        c0 segment$okio = c0169l.head;
        long j7 = 0;
        if (getSegment$okio() != null) {
            long j8 = this.offset;
            int i5 = this.start;
            c0 segment$okio2 = getSegment$okio();
            kotlin.jvm.internal.E.c(segment$okio2);
            long j9 = j8 - ((long) (i5 - segment$okio2.pos));
            if (j9 > j6) {
                c0VarPush = segment$okio;
                segment$okio = getSegment$okio();
                size = j9;
            } else {
                c0VarPush = getSegment$okio();
                j7 = j9;
            }
        } else {
            c0VarPush = segment$okio;
        }
        if (size - j6 > j6 - j7) {
            while (true) {
                kotlin.jvm.internal.E.c(c0VarPush);
                int i6 = c0VarPush.limit;
                int i7 = c0VarPush.pos;
                if (j6 < ((long) (i6 - i7)) + j7) {
                    break;
                }
                j7 += (long) (i6 - i7);
                c0VarPush = c0VarPush.next;
            }
        } else {
            while (size > j6) {
                kotlin.jvm.internal.E.c(segment$okio);
                segment$okio = segment$okio.prev;
                kotlin.jvm.internal.E.c(segment$okio);
                size -= (long) (segment$okio.limit - segment$okio.pos);
            }
            j7 = size;
            c0VarPush = segment$okio;
        }
        if (this.readWrite) {
            kotlin.jvm.internal.E.c(c0VarPush);
            if (c0VarPush.shared) {
                c0 c0VarUnsharedCopy = c0VarPush.unsharedCopy();
                if (c0169l.head == c0VarPush) {
                    c0169l.head = c0VarUnsharedCopy;
                }
                c0VarPush = c0VarPush.push(c0VarUnsharedCopy);
                c0 c0Var = c0VarPush.prev;
                kotlin.jvm.internal.E.c(c0Var);
                c0Var.pop();
            }
        }
        setSegment$okio(c0VarPush);
        this.offset = j6;
        kotlin.jvm.internal.E.c(c0VarPush);
        this.data = c0VarPush.data;
        int i8 = c0VarPush.pos + ((int) (j6 - j7));
        this.start = i8;
        int i9 = c0VarPush.limit;
        this.end = i9;
        return i9 - i8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.buffer = null;
        setSegment$okio(null);
        this.offset = -1L;
        this.data = null;
        this.start = -1;
        this.end = -1;
    }

    public final c0 getSegment$okio() {
        return this.segment;
    }

    public final void setSegment$okio(c0 c0Var) {
        this.segment = c0Var;
    }
}
