package B4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A4.AbstractC0159b;
import A4.C0166i;
import A4.C0169l;
import A4.C0173p;
import A4.S;
import A4.c0;
import A4.d0;
import A4.e0;
import A4.f0;
import A4.h0;
import A4.n0;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.EOFException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    private static final byte[] HEX_DIGIT_BYTES = n0.asUtf8ToByteArray("0123456789abcdef");

    public static final void commonClear(C0169l c0169l) throws EOFException {
        E.f(c0169l, "<this>");
        c0169l.skip(c0169l.size());
    }

    public static final void commonClose(C0166i c0166i) {
        E.f(c0166i, "<this>");
        if (c0166i.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        c0166i.buffer = null;
        c0166i.setSegment$okio(null);
        c0166i.offset = -1L;
        c0166i.data = null;
        c0166i.start = -1;
        c0166i.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(C0169l c0169l) {
        E.f(c0169l, "<this>");
        long size = c0169l.size();
        if (size == 0) {
            return 0L;
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        c0 c0Var2 = c0Var.prev;
        E.c(c0Var2);
        int i5 = c0Var2.limit;
        return (i5 >= 8192 || !c0Var2.owner) ? size : size - ((long) (i5 - c0Var2.pos));
    }

    public static final C0169l commonCopy(C0169l c0169l) {
        E.f(c0169l, "<this>");
        C0169l c0169l2 = new C0169l();
        if (c0169l.size() == 0) {
            return c0169l2;
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        c0 c0VarSharedCopy = c0Var.sharedCopy();
        c0169l2.head = c0VarSharedCopy;
        c0VarSharedCopy.prev = c0VarSharedCopy;
        c0VarSharedCopy.next = c0VarSharedCopy;
        for (c0 c0Var2 = c0Var.next; c0Var2 != c0Var; c0Var2 = c0Var2.next) {
            c0 c0Var3 = c0VarSharedCopy.prev;
            E.c(c0Var3);
            E.c(c0Var2);
            c0Var3.push(c0Var2.sharedCopy());
        }
        c0169l2.f76a = c0169l.size();
        return c0169l2;
    }

    public static final C0169l commonCopyTo(C0169l c0169l, C0169l out, long j6, long j7) {
        E.f(c0169l, "<this>");
        E.f(out, "out");
        long j8 = j6;
        AbstractC0159b.a(c0169l.size(), j8, j7);
        if (j7 != 0) {
            out.f76a = out.size() + j7;
            c0 c0Var = c0169l.head;
            while (true) {
                E.c(c0Var);
                int i5 = c0Var.limit;
                int i6 = c0Var.pos;
                if (j8 < i5 - i6) {
                    break;
                }
                j8 -= (long) (i5 - i6);
                c0Var = c0Var.next;
            }
            c0 c0Var2 = c0Var;
            long j9 = j7;
            while (j9 > 0) {
                E.c(c0Var2);
                c0 c0VarSharedCopy = c0Var2.sharedCopy();
                int i7 = c0VarSharedCopy.pos + ((int) j8);
                c0VarSharedCopy.pos = i7;
                c0VarSharedCopy.limit = Math.min(i7 + ((int) j9), c0VarSharedCopy.limit);
                c0 c0Var3 = out.head;
                if (c0Var3 == null) {
                    c0VarSharedCopy.prev = c0VarSharedCopy;
                    c0VarSharedCopy.next = c0VarSharedCopy;
                    out.head = c0VarSharedCopy;
                } else {
                    E.c(c0Var3);
                    c0 c0Var4 = c0Var3.prev;
                    E.c(c0Var4);
                    c0Var4.push(c0VarSharedCopy);
                }
                j9 -= (long) (c0VarSharedCopy.limit - c0VarSharedCopy.pos);
                c0Var2 = c0Var2.next;
                j8 = 0;
            }
        }
        return c0169l;
    }

    public static final boolean commonEquals(C0169l c0169l, Object obj) {
        E.f(c0169l, "<this>");
        if (c0169l == obj) {
            return true;
        }
        if (!(obj instanceof C0169l)) {
            return false;
        }
        C0169l c0169l2 = (C0169l) obj;
        if (c0169l.size() != c0169l2.size()) {
            return false;
        }
        if (c0169l.size() == 0) {
            return true;
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        c0 c0Var2 = c0169l2.head;
        E.c(c0Var2);
        int i5 = c0Var.pos;
        int i6 = c0Var2.pos;
        long j6 = 0;
        while (j6 < c0169l.size()) {
            long jMin = Math.min(c0Var.limit - i5, c0Var2.limit - i6);
            long j7 = 0;
            while (j7 < jMin) {
                int i7 = i5 + 1;
                int i8 = i6 + 1;
                if (c0Var.data[i5] != c0Var2.data[i6]) {
                    return false;
                }
                j7++;
                i5 = i7;
                i6 = i8;
            }
            if (i5 == c0Var.limit) {
                c0Var = c0Var.next;
                E.c(c0Var);
                i5 = c0Var.pos;
            }
            if (i6 == c0Var2.limit) {
                c0Var2 = c0Var2.next;
                E.c(c0Var2);
                i6 = c0Var2.pos;
            }
            j6 += jMin;
        }
        return true;
    }

    public static final long commonExpandBuffer(C0166i c0166i, int i5) {
        E.f(c0166i, "<this>");
        if (i5 <= 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "minByteCount <= 0: ").toString());
        }
        if (i5 > 8192) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "minByteCount > Segment.SIZE: ").toString());
        }
        C0169l c0169l = c0166i.buffer;
        if (c0169l == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!c0166i.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long size = c0169l.size();
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(i5);
        int i6 = 8192 - c0VarWritableSegment$okio.limit;
        c0VarWritableSegment$okio.limit = 8192;
        long j6 = i6;
        c0169l.f76a = size + j6;
        c0166i.setSegment$okio(c0VarWritableSegment$okio);
        c0166i.offset = size;
        c0166i.data = c0VarWritableSegment$okio.data;
        c0166i.start = 8192 - i6;
        c0166i.end = 8192;
        return j6;
    }

    public static final byte commonGet(C0169l c0169l, long j6) {
        E.f(c0169l, "<this>");
        AbstractC0159b.a(c0169l.size(), j6, 1L);
        c0 c0Var = c0169l.head;
        if (c0Var == null) {
            E.throwJavaNpe();
            throw null;
        }
        if (c0169l.size() - j6 < j6) {
            long size = c0169l.size();
            while (size > j6) {
                c0Var = c0Var.prev;
                E.c(c0Var);
                size -= (long) (c0Var.limit - c0Var.pos);
            }
            return c0Var.data[(int) ((((long) c0Var.pos) + j6) - size)];
        }
        long j7 = 0;
        while (true) {
            int i5 = c0Var.limit;
            int i6 = c0Var.pos;
            long j8 = ((long) (i5 - i6)) + j7;
            if (j8 > j6) {
                return c0Var.data[(int) ((((long) i6) + j6) - j7)];
            }
            c0Var = c0Var.next;
            E.c(c0Var);
            j7 = j8;
        }
    }

    public static final int commonHashCode(C0169l c0169l) {
        E.f(c0169l, "<this>");
        c0 c0Var = c0169l.head;
        if (c0Var == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = c0Var.limit;
            for (int i7 = c0Var.pos; i7 < i6; i7++) {
                i5 = (i5 * 31) + c0Var.data[i7];
            }
            c0Var = c0Var.next;
            E.c(c0Var);
        } while (c0Var != c0169l.head);
        return i5;
    }

    public static final long commonIndexOf(C0169l c0169l, byte b, long j6, long j7) {
        c0 c0Var;
        int i5;
        E.f(c0169l, "<this>");
        long size = 0;
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("size=" + c0169l.size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > c0169l.size()) {
            j7 = c0169l.size();
        }
        if (j6 == j7 || (c0Var = c0169l.head) == null) {
            return -1L;
        }
        if (c0169l.size() - j6 < j6) {
            size = c0169l.size();
            while (size > j6) {
                c0Var = c0Var.prev;
                E.c(c0Var);
                size -= (long) (c0Var.limit - c0Var.pos);
            }
            while (size < j7) {
                byte[] bArr = c0Var.data;
                int iMin = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + j7) - size);
                i5 = (int) ((((long) c0Var.pos) + j6) - size);
                while (i5 < iMin) {
                    if (bArr[i5] != b) {
                        i5++;
                    }
                }
                size += (long) (c0Var.limit - c0Var.pos);
                c0Var = c0Var.next;
                E.c(c0Var);
                j6 = size;
            }
            return -1L;
        }
        while (true) {
            long j8 = ((long) (c0Var.limit - c0Var.pos)) + size;
            if (j8 > j6) {
                break;
            }
            c0Var = c0Var.next;
            E.c(c0Var);
            size = j8;
        }
        while (size < j7) {
            byte[] bArr2 = c0Var.data;
            int iMin2 = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + j7) - size);
            i5 = (int) ((((long) c0Var.pos) + j6) - size);
            while (i5 < iMin2) {
                if (bArr2[i5] != b) {
                    i5++;
                }
            }
            size += (long) (c0Var.limit - c0Var.pos);
            c0Var = c0Var.next;
            E.c(c0Var);
            j6 = size;
        }
        return -1L;
        return ((long) (i5 - c0Var.pos)) + size;
    }

    public static final long commonIndexOfElement(C0169l c0169l, C0173p targetBytes, long j6) {
        int i5;
        int i6;
        E.f(c0169l, "<this>");
        E.f(targetBytes, "targetBytes");
        long size = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "fromIndex < 0: ").toString());
        }
        c0 c0Var = c0169l.head;
        if (c0Var == null) {
            return -1L;
        }
        if (c0169l.size() - j6 < j6) {
            size = c0169l.size();
            while (size > j6) {
                c0Var = c0Var.prev;
                E.c(c0Var);
                size -= (long) (c0Var.limit - c0Var.pos);
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b6 = targetBytes.getByte(1);
                while (size < c0169l.size()) {
                    byte[] bArr = c0Var.data;
                    i5 = (int) ((((long) c0Var.pos) + j6) - size);
                    int i7 = c0Var.limit;
                    while (true) {
                        if (i5 >= i7) {
                            size += (long) (c0Var.limit - c0Var.pos);
                            c0Var = c0Var.next;
                            E.c(c0Var);
                            j6 = size;
                        } else {
                            byte b7 = bArr[i5];
                            if (b7 == b || b7 == b6) {
                                i6 = c0Var.pos;
                            } else {
                                i5++;
                            }
                        }
                    }
                }
            } else {
                byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                while (size < c0169l.size()) {
                    byte[] bArr2 = c0Var.data;
                    i5 = (int) ((((long) c0Var.pos) + j6) - size);
                    int i8 = c0Var.limit;
                    while (true) {
                        if (i5 < i8) {
                            byte b8 = bArr2[i5];
                            int length = bArrInternalArray$okio.length;
                            int i9 = 0;
                            while (true) {
                                if (i9 >= length) {
                                    i5++;
                                } else if (b8 == bArrInternalArray$okio[i9]) {
                                    i6 = c0Var.pos;
                                } else {
                                    i9++;
                                }
                            }
                        } else {
                            size += (long) (c0Var.limit - c0Var.pos);
                            c0Var = c0Var.next;
                            E.c(c0Var);
                            j6 = size;
                        }
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j7 = ((long) (c0Var.limit - c0Var.pos)) + size;
            if (j7 > j6) {
                break;
            }
            c0Var = c0Var.next;
            E.c(c0Var);
            size = j7;
        }
        if (targetBytes.size() == 2) {
            byte b9 = targetBytes.getByte(0);
            byte b10 = targetBytes.getByte(1);
            while (size < c0169l.size()) {
                byte[] bArr3 = c0Var.data;
                i5 = (int) ((((long) c0Var.pos) + j6) - size);
                int i10 = c0Var.limit;
                while (true) {
                    if (i5 >= i10) {
                        size += (long) (c0Var.limit - c0Var.pos);
                        c0Var = c0Var.next;
                        E.c(c0Var);
                        j6 = size;
                    } else {
                        byte b11 = bArr3[i5];
                        if (b11 == b9 || b11 == b10) {
                            i6 = c0Var.pos;
                        } else {
                            i5++;
                        }
                    }
                }
            }
        } else {
            byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
            while (size < c0169l.size()) {
                byte[] bArr4 = c0Var.data;
                i5 = (int) ((((long) c0Var.pos) + j6) - size);
                int i11 = c0Var.limit;
                while (true) {
                    if (i5 < i11) {
                        byte b12 = bArr4[i5];
                        int length2 = bArrInternalArray$okio2.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length2) {
                                i5++;
                            } else if (b12 == bArrInternalArray$okio2[i12]) {
                                i6 = c0Var.pos;
                            } else {
                                i12++;
                            }
                        }
                    } else {
                        size += (long) (c0Var.limit - c0Var.pos);
                        c0Var = c0Var.next;
                        E.c(c0Var);
                        j6 = size;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i5 - i6)) + size;
    }

    public static final int commonNext(C0166i c0166i) {
        E.f(c0166i, "<this>");
        long j6 = c0166i.offset;
        C0169l c0169l = c0166i.buffer;
        E.c(c0169l);
        if (j6 == c0169l.size()) {
            throw new IllegalStateException("no more bytes");
        }
        long j7 = c0166i.offset;
        return c0166i.a(j7 == -1 ? 0L : j7 + ((long) (c0166i.end - c0166i.start)));
    }

    public static final boolean commonRangeEquals(C0169l c0169l, long j6, C0173p bytes, int i5, int i6) {
        E.f(c0169l, "<this>");
        E.f(bytes, "bytes");
        if (j6 < 0 || i5 < 0 || i6 < 0 || c0169l.size() - j6 < i6 || bytes.size() - i5 < i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (c0169l.getByte(((long) i7) + j6) != bytes.getByte(i5 + i7)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(C0169l c0169l, byte[] sink) {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        return c0169l.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(C0169l c0169l, f0 sink) {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        long size = c0169l.size();
        if (size > 0) {
            sink.write(c0169l, size);
        }
        return size;
    }

    public static final C0166i commonReadAndWriteUnsafe(C0169l c0169l, C0166i unsafeCursor) {
        E.f(c0169l, "<this>");
        E.f(unsafeCursor, "unsafeCursor");
        C0166i c0166iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(unsafeCursor);
        if (c0166iResolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0166iResolveDefaultParameter.buffer = c0169l;
        c0166iResolveDefaultParameter.readWrite = true;
        return c0166iResolveDefaultParameter;
    }

    public static final byte commonReadByte(C0169l c0169l) throws EOFException {
        E.f(c0169l, "<this>");
        if (c0169l.size() == 0) {
            throw new EOFException();
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        int i7 = i5 + 1;
        byte b = c0Var.data[i5];
        c0169l.f76a = c0169l.size() - 1;
        if (i7 != i6) {
            c0Var.pos = i7;
            return b;
        }
        c0169l.head = c0Var.pop();
        d0.recycle(c0Var);
        return b;
    }

    public static final byte[] commonReadByteArray(C0169l c0169l) {
        E.f(c0169l, "<this>");
        return c0169l.readByteArray(c0169l.size());
    }

    public static final C0173p commonReadByteString(C0169l c0169l) {
        E.f(c0169l, "<this>");
        return c0169l.readByteString(c0169l.size());
    }

    public static final long commonReadDecimalLong(C0169l c0169l) throws EOFException {
        long j6;
        byte b;
        E.f(c0169l, "<this>");
        long j7 = 0;
        if (c0169l.size() == 0) {
            throw new EOFException();
        }
        int i5 = 0;
        boolean z6 = false;
        long j8 = 0;
        long j9 = -7;
        boolean z7 = false;
        loop0: while (true) {
            c0 c0Var = c0169l.head;
            E.c(c0Var);
            byte[] bArr = c0Var.data;
            int i6 = c0Var.pos;
            int i7 = c0Var.limit;
            while (true) {
                if (i6 >= i7) {
                    j6 = j7;
                    break;
                }
                b = bArr[i6];
                if (b >= 48 && b <= 57) {
                    int i8 = 48 - b;
                    if (j8 < -922337203685477580L) {
                        break loop0;
                    }
                    j6 = j7;
                    if (j8 == -922337203685477580L && i8 < j9) {
                        break loop0;
                    }
                    j8 = (j8 * 10) + ((long) i8);
                } else {
                    j6 = j7;
                    if (b != 45 || i5 != 0) {
                        z7 = true;
                        break;
                    }
                    j9--;
                    z6 = true;
                }
                i6++;
                i5++;
                j7 = j6;
            }
            if (i6 == i7) {
                c0169l.head = c0Var.pop();
                d0.recycle(c0Var);
            } else {
                c0Var.pos = i6;
            }
            if (z7 || c0169l.head == null) {
                c0169l.f76a = c0169l.size() - ((long) i5);
                if (i5 >= (z6 ? 2 : 1)) {
                    return z6 ? j8 : -j8;
                }
                if (c0169l.size() == j6) {
                    throw new EOFException();
                }
                StringBuilder sbX = AbstractC0157z.x(z6 ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
                sbX.append(AbstractC0159b.toHexString(c0169l.getByte(j6)));
                throw new NumberFormatException(sbX.toString());
            }
            j7 = j6;
        }
        C0169l c0169lWriteByte = new C0169l().writeDecimalLong(j8).writeByte((int) b);
        if (!z6) {
            c0169lWriteByte.readByte();
        }
        throw new NumberFormatException("Number too large: " + c0169lWriteByte.readUtf8());
    }

    public static final void commonReadFully(C0169l c0169l, byte[] sink) throws EOFException {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        int i5 = 0;
        while (i5 < sink.length) {
            int i6 = c0169l.read(sink, i5, sink.length - i5);
            if (i6 == -1) {
                throw new EOFException();
            }
            i5 += i6;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(C0169l c0169l) throws EOFException {
        int i5;
        E.f(c0169l, "<this>");
        if (c0169l.size() == 0) {
            throw new EOFException();
        }
        int i6 = 0;
        boolean z6 = false;
        long j6 = 0;
        do {
            c0 c0Var = c0169l.head;
            E.c(c0Var);
            byte[] bArr = c0Var.data;
            int i7 = c0Var.pos;
            int i8 = c0Var.limit;
            while (i7 < i8) {
                byte b = bArr[i7];
                if (b >= 48 && b <= 57) {
                    i5 = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i5 = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        if (i6 != 0) {
                            z6 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + AbstractC0159b.toHexString(b));
                    }
                    i5 = b - 55;
                }
                if (((-1152921504606846976L) & j6) != 0) {
                    throw new NumberFormatException("Number too large: " + new C0169l().writeHexadecimalUnsignedLong(j6).writeByte((int) b).readUtf8());
                }
                j6 = (j6 << 4) | ((long) i5);
                i7++;
                i6++;
            }
            if (i7 == i8) {
                c0169l.head = c0Var.pop();
                d0.recycle(c0Var);
            } else {
                c0Var.pos = i7;
            }
            if (z6) {
                break;
            }
        } while (c0169l.head != null);
        c0169l.f76a = c0169l.size() - ((long) i6);
        return j6;
    }

    public static final int commonReadInt(C0169l c0169l) throws EOFException {
        E.f(c0169l, "<this>");
        if (c0169l.size() < 4) {
            throw new EOFException();
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 4) {
            return (c0169l.readByte() & UnsignedBytes.MAX_VALUE) | ((c0169l.readByte() & UnsignedBytes.MAX_VALUE) << 24) | ((c0169l.readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((c0169l.readByte() & UnsignedBytes.MAX_VALUE) << 8);
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 3;
        int i8 = ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i5] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 8);
        int i9 = i5 + 4;
        int i10 = (bArr[i7] & UnsignedBytes.MAX_VALUE) | i8;
        c0169l.f76a = c0169l.size() - 4;
        if (i9 != i6) {
            c0Var.pos = i9;
            return i10;
        }
        c0169l.head = c0Var.pop();
        d0.recycle(c0Var);
        return i10;
    }

    public static final long commonReadLong(C0169l c0169l) throws EOFException {
        E.f(c0169l, "<this>");
        if (c0169l.size() < 8) {
            throw new EOFException();
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 8) {
            return ((((long) c0169l.readInt()) & KeyboardMap.kValueMask) << 32) | (KeyboardMap.kValueMask & ((long) c0169l.readInt()));
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 7;
        long j6 = ((((long) bArr[i5]) & 255) << 56) | ((((long) bArr[i5 + 1]) & 255) << 48) | ((((long) bArr[i5 + 2]) & 255) << 40) | ((((long) bArr[i5 + 3]) & 255) << 32) | ((((long) bArr[i5 + 4]) & 255) << 24) | ((((long) bArr[i5 + 5]) & 255) << 16) | ((((long) bArr[i5 + 6]) & 255) << 8);
        int i8 = i5 + 8;
        long j7 = j6 | (((long) bArr[i7]) & 255);
        c0169l.f76a = c0169l.size() - 8;
        if (i8 != i6) {
            c0Var.pos = i8;
            return j7;
        }
        c0169l.head = c0Var.pop();
        d0.recycle(c0Var);
        return j7;
    }

    public static final short commonReadShort(C0169l c0169l) throws EOFException {
        E.f(c0169l, "<this>");
        if (c0169l.size() < 2) {
            throw new EOFException();
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 2) {
            return (short) ((c0169l.readByte() & UnsignedBytes.MAX_VALUE) | ((c0169l.readByte() & UnsignedBytes.MAX_VALUE) << 8));
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 1;
        int i8 = (bArr[i5] & UnsignedBytes.MAX_VALUE) << 8;
        int i9 = i5 + 2;
        int i10 = (bArr[i7] & UnsignedBytes.MAX_VALUE) | i8;
        c0169l.f76a = c0169l.size() - 2;
        if (i9 == i6) {
            c0169l.head = c0Var.pop();
            d0.recycle(c0Var);
        } else {
            c0Var.pos = i9;
        }
        return (short) i10;
    }

    public static final C0166i commonReadUnsafe(C0169l c0169l, C0166i unsafeCursor) {
        E.f(c0169l, "<this>");
        E.f(unsafeCursor, "unsafeCursor");
        C0166i c0166iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(unsafeCursor);
        if (c0166iResolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0166iResolveDefaultParameter.buffer = c0169l;
        c0166iResolveDefaultParameter.readWrite = false;
        return c0166iResolveDefaultParameter;
    }

    public static final String commonReadUtf8(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (c0169l.size() < j6) {
            throw new EOFException();
        }
        if (j6 == 0) {
            return "";
        }
        c0 c0Var = c0169l.head;
        E.c(c0Var);
        int i5 = c0Var.pos;
        if (((long) i5) + j6 > c0Var.limit) {
            byte[] byteArray = c0169l.readByteArray(j6);
            return u.commonToUtf8String(byteArray, 0, byteArray.length);
        }
        int i6 = (int) j6;
        String strCommonToUtf8String = u.commonToUtf8String(c0Var.data, i5, i5 + i6);
        c0Var.pos += i6;
        c0169l.f76a = c0169l.size() - j6;
        if (c0Var.pos == c0Var.limit) {
            c0169l.head = c0Var.pop();
            d0.recycle(c0Var);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(C0169l c0169l) throws EOFException {
        int i5;
        int i6;
        int i7;
        E.f(c0169l, "<this>");
        if (c0169l.size() == 0) {
            throw new EOFException();
        }
        byte b = c0169l.getByte(0L);
        if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
            i5 = b & Ascii.DEL;
            i7 = 0;
            i6 = 1;
        } else if ((b & 224) == 192) {
            i5 = b & 31;
            i6 = 2;
            i7 = 128;
        } else if ((b & 240) == 224) {
            i5 = b & 15;
            i6 = 3;
            i7 = 2048;
        } else {
            if ((b & 248) != 240) {
                c0169l.skip(1L);
                return 65533;
            }
            i5 = b & 7;
            i6 = 4;
            i7 = 65536;
        }
        long j6 = i6;
        if (c0169l.size() < j6) {
            StringBuilder sbT = AbstractC0157z.t(i6, "size < ", ": ");
            sbT.append(c0169l.size());
            sbT.append(" (to read code point prefixed 0x");
            sbT.append(AbstractC0159b.toHexString(b));
            sbT.append(')');
            throw new EOFException(sbT.toString());
        }
        for (int i8 = 1; i8 < i6; i8++) {
            long j7 = i8;
            byte b6 = c0169l.getByte(j7);
            if ((b6 & 192) != 128) {
                c0169l.skip(j7);
                return 65533;
            }
            i5 = (i5 << 6) | (b6 & 63);
        }
        c0169l.skip(j6);
        if (i5 > 1114111) {
            return 65533;
        }
        if ((55296 > i5 || i5 >= 57344) && i5 >= i7) {
            return i5;
        }
        return 65533;
    }

    public static final String commonReadUtf8Line(C0169l c0169l) {
        E.f(c0169l, "<this>");
        long jIndexOf = c0169l.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(c0169l, jIndexOf);
        }
        if (c0169l.size() != 0) {
            return c0169l.readUtf8(c0169l.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "limit < 0: ").toString());
        }
        long j7 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            j7 = j6 + 1;
        }
        long j8 = j7;
        long jIndexOf = c0169l.indexOf((byte) 10, 0L, j8);
        if (jIndexOf != -1) {
            return readUtf8Line(c0169l, jIndexOf);
        }
        if (j8 < c0169l.size() && c0169l.getByte(j8 - 1) == 13 && c0169l.getByte(j8) == 10) {
            return readUtf8Line(c0169l, j8);
        }
        C0169l c0169l2 = new C0169l();
        c0169l.copyTo(c0169l2, 0L, Math.min(32, c0169l.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(c0169l.size(), j6) + " content=" + c0169l2.readByteString().hex() + (char) 8230);
    }

    public static final long commonResizeBuffer(C0166i c0166i, long j6) {
        E.f(c0166i, "<this>");
        C0169l c0169l = c0166i.buffer;
        if (c0169l == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!c0166i.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long size = c0169l.size();
        if (j6 <= size) {
            if (j6 < 0) {
                throw new IllegalArgumentException(androidx.collection.a.j(j6, "newSize < 0: ").toString());
            }
            long j7 = size - j6;
            while (j7 > 0) {
                c0 c0Var = c0169l.head;
                E.c(c0Var);
                c0 c0Var2 = c0Var.prev;
                E.c(c0Var2);
                int i5 = c0Var2.limit;
                long j8 = i5 - c0Var2.pos;
                if (j8 > j7) {
                    c0Var2.limit = i5 - ((int) j7);
                    break;
                }
                c0169l.head = c0Var2.pop();
                d0.recycle(c0Var2);
                j7 -= j8;
            }
            c0166i.setSegment$okio(null);
            c0166i.offset = j6;
            c0166i.data = null;
            c0166i.start = -1;
            c0166i.end = -1;
        } else if (j6 > size) {
            long j9 = j6 - size;
            boolean z6 = true;
            while (j9 > 0) {
                c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(1);
                int iMin = (int) Math.min(j9, 8192 - c0VarWritableSegment$okio.limit);
                c0VarWritableSegment$okio.limit += iMin;
                j9 -= (long) iMin;
                if (z6) {
                    c0166i.setSegment$okio(c0VarWritableSegment$okio);
                    c0166i.offset = size;
                    c0166i.data = c0VarWritableSegment$okio.data;
                    int i6 = c0VarWritableSegment$okio.limit;
                    c0166i.start = i6 - iMin;
                    c0166i.end = i6;
                    z6 = false;
                }
            }
        }
        c0169l.f76a = j6;
        return size;
    }

    public static final int commonSeek(C0166i c0166i, long j6) {
        c0 c0VarPush;
        E.f(c0166i, "<this>");
        C0169l c0169l = c0166i.buffer;
        if (c0169l == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j6 < -1 || j6 > c0169l.size()) {
            StringBuilder sbT = androidx.collection.a.t("offset=", j6, " > size=");
            sbT.append(c0169l.size());
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        if (j6 == -1 || j6 == c0169l.size()) {
            c0166i.setSegment$okio(null);
            c0166i.offset = j6;
            c0166i.data = null;
            c0166i.start = -1;
            c0166i.end = -1;
            return -1;
        }
        long size = c0169l.size();
        c0 segment$okio = c0169l.head;
        long j7 = 0;
        if (c0166i.getSegment$okio() != null) {
            long j8 = c0166i.offset;
            int i5 = c0166i.start;
            c0 segment$okio2 = c0166i.getSegment$okio();
            E.c(segment$okio2);
            long j9 = j8 - ((long) (i5 - segment$okio2.pos));
            if (j9 > j6) {
                c0VarPush = segment$okio;
                segment$okio = c0166i.getSegment$okio();
                size = j9;
            } else {
                c0VarPush = c0166i.getSegment$okio();
                j7 = j9;
            }
        } else {
            c0VarPush = segment$okio;
        }
        if (size - j6 > j6 - j7) {
            while (true) {
                E.c(c0VarPush);
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
                E.c(segment$okio);
                segment$okio = segment$okio.prev;
                E.c(segment$okio);
                size -= (long) (segment$okio.limit - segment$okio.pos);
            }
            j7 = size;
            c0VarPush = segment$okio;
        }
        if (c0166i.readWrite) {
            E.c(c0VarPush);
            if (c0VarPush.shared) {
                c0 c0VarUnsharedCopy = c0VarPush.unsharedCopy();
                if (c0169l.head == c0VarPush) {
                    c0169l.head = c0VarUnsharedCopy;
                }
                c0VarPush = c0VarPush.push(c0VarUnsharedCopy);
                c0 c0Var = c0VarPush.prev;
                E.c(c0Var);
                c0Var.pop();
            }
        }
        c0166i.setSegment$okio(c0VarPush);
        c0166i.offset = j6;
        E.c(c0VarPush);
        c0166i.data = c0VarPush.data;
        int i8 = c0VarPush.pos + ((int) (j6 - j7));
        c0166i.start = i8;
        int i9 = c0VarPush.limit;
        c0166i.end = i9;
        return i9 - i8;
    }

    public static final int commonSelect(C0169l c0169l, S options) throws EOFException {
        E.f(c0169l, "<this>");
        E.f(options, "options");
        int iSelectPrefix = selectPrefix(c0169l, options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        c0169l.skip(options.getByteStrings$okio()[iSelectPrefix].size());
        return iSelectPrefix;
    }

    public static final void commonSkip(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        while (j6 > 0) {
            c0 c0Var = c0169l.head;
            if (c0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j6, c0Var.limit - c0Var.pos);
            long j7 = iMin;
            c0169l.f76a = c0169l.size() - j7;
            j6 -= j7;
            int i5 = c0Var.pos + iMin;
            c0Var.pos = i5;
            if (i5 == c0Var.limit) {
                c0169l.head = c0Var.pop();
                d0.recycle(c0Var);
            }
        }
    }

    public static final C0173p commonSnapshot(C0169l c0169l) {
        E.f(c0169l, "<this>");
        if (c0169l.size() <= 2147483647L) {
            return c0169l.snapshot((int) c0169l.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + c0169l.size()).toString());
    }

    public static final c0 commonWritableSegment(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        c0 c0Var = c0169l.head;
        if (c0Var != null) {
            E.c(c0Var);
            c0 c0Var2 = c0Var.prev;
            E.c(c0Var2);
            return (c0Var2.limit + i5 > 8192 || !c0Var2.owner) ? c0Var2.push(d0.take()) : c0Var2;
        }
        c0 c0VarTake = d0.take();
        c0169l.head = c0VarTake;
        c0VarTake.prev = c0VarTake;
        c0VarTake.next = c0VarTake;
        return c0VarTake;
    }

    public static final C0169l commonWrite(C0169l c0169l, C0173p byteString, int i5, int i6) {
        E.f(c0169l, "<this>");
        E.f(byteString, "byteString");
        byteString.write$okio(c0169l, i5, i6);
        return c0169l;
    }

    public static final long commonWriteAll(C0169l c0169l, h0 source) {
        E.f(c0169l, "<this>");
        E.f(source, "source");
        long j6 = 0;
        while (true) {
            long j7 = source.read(c0169l, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j7 == -1) {
                return j6;
            }
            j6 += j7;
        }
    }

    public static final C0169l commonWriteByte(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(1);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        c0VarWritableSegment$okio.limit = i6 + 1;
        bArr[i6] = (byte) i5;
        c0169l.f76a = c0169l.size() + 1;
        return c0169l;
    }

    public static final C0169l commonWriteDecimalLong(C0169l c0169l, long j6) {
        boolean z6;
        E.f(c0169l, "<this>");
        if (j6 == 0) {
            return c0169l.writeByte(48);
        }
        int i5 = 1;
        if (j6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return c0169l.writeUtf8("-9223372036854775808");
            }
            z6 = true;
        } else {
            z6 = false;
        }
        if (j6 < 100000000) {
            if (j6 < 10000) {
                if (j6 >= 100) {
                    i5 = j6 < 1000 ? 3 : 4;
                } else if (j6 >= 10) {
                    i5 = 2;
                }
            } else if (j6 < 1000000) {
                i5 = j6 < 100000 ? 5 : 6;
            } else {
                i5 = j6 < 10000000 ? 7 : 8;
            }
        } else if (j6 < 1000000000000L) {
            if (j6 < 10000000000L) {
                i5 = j6 < 1000000000 ? 9 : 10;
            } else {
                i5 = j6 < 100000000000L ? 11 : 12;
            }
        } else if (j6 < 1000000000000000L) {
            if (j6 < 10000000000000L) {
                i5 = 13;
            } else {
                i5 = j6 < 100000000000000L ? 14 : 15;
            }
        } else if (j6 < 100000000000000000L) {
            i5 = j6 < 10000000000000000L ? 16 : 17;
        } else {
            i5 = j6 < 1000000000000000000L ? 18 : 19;
        }
        if (z6) {
            i5++;
        }
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(i5);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit + i5;
        while (j6 != 0) {
            long j7 = 10;
            i6--;
            bArr[i6] = getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z6) {
            bArr[i6 - 1] = 45;
        }
        c0VarWritableSegment$okio.limit += i5;
        c0169l.f76a = c0169l.size() + ((long) i5);
        return c0169l;
    }

    public static final C0169l commonWriteHexadecimalUnsignedLong(C0169l c0169l, long j6) {
        E.f(c0169l, "<this>");
        if (j6 == 0) {
            return c0169l.writeByte(48);
        }
        long j7 = (j6 >>> 1) | j6;
        long j8 = j7 | (j7 >>> 2);
        long j9 = j8 | (j8 >>> 4);
        long j10 = j9 | (j9 >>> 8);
        long j11 = j10 | (j10 >>> 16);
        long j12 = j11 | (j11 >>> 32);
        long j13 = j12 - ((j12 >>> 1) & 6148914691236517205L);
        long j14 = ((j13 >>> 2) & 3689348814741910323L) + (j13 & 3689348814741910323L);
        long j15 = ((j14 >>> 4) + j14) & 1085102592571150095L;
        long j16 = j15 + (j15 >>> 8);
        long j17 = j16 + (j16 >>> 16);
        int i5 = (int) ((((j17 & 63) + ((j17 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(i5);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        for (int i7 = (i6 + i5) - 1; i7 >= i6; i7--) {
            bArr[i7] = getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        c0VarWritableSegment$okio.limit += i5;
        c0169l.f76a = c0169l.size() + ((long) i5);
        return c0169l;
    }

    public static final C0169l commonWriteInt(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(4);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        c0VarWritableSegment$okio.limit = i6 + 4;
        c0169l.f76a = c0169l.size() + 4;
        return c0169l;
    }

    public static final C0169l commonWriteLong(C0169l c0169l, long j6) {
        E.f(c0169l, "<this>");
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(8);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i5 = c0VarWritableSegment$okio.limit;
        bArr[i5] = (byte) ((j6 >>> 56) & 255);
        bArr[i5 + 1] = (byte) ((j6 >>> 48) & 255);
        bArr[i5 + 2] = (byte) ((j6 >>> 40) & 255);
        bArr[i5 + 3] = (byte) ((j6 >>> 32) & 255);
        bArr[i5 + 4] = (byte) ((j6 >>> 24) & 255);
        bArr[i5 + 5] = (byte) ((j6 >>> 16) & 255);
        bArr[i5 + 6] = (byte) ((j6 >>> 8) & 255);
        bArr[i5 + 7] = (byte) (j6 & 255);
        c0VarWritableSegment$okio.limit = i5 + 8;
        c0169l.f76a = c0169l.size() + 8;
        return c0169l;
    }

    public static final C0169l commonWriteShort(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(2);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        c0VarWritableSegment$okio.limit = i6 + 2;
        c0169l.f76a = c0169l.size() + 2;
        return c0169l;
    }

    public static final C0169l commonWriteUtf8(C0169l c0169l, String string, int i5, int i6) {
        char cCharAt;
        E.f(c0169l, "<this>");
        E.f(string, "string");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "beginIndex < 0: ").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(androidx.collection.a.h(i6, i5, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i6 > string.length()) {
            StringBuilder sbT = AbstractC0157z.t(i6, "endIndex > string.length: ", " > ");
            sbT.append(string.length());
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        while (i5 < i6) {
            char cCharAt2 = string.charAt(i5);
            if (cCharAt2 < 128) {
                c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(1);
                byte[] bArr = c0VarWritableSegment$okio.data;
                int i7 = c0VarWritableSegment$okio.limit - i5;
                int iMin = Math.min(i6, 8192 - i7);
                int i8 = i5 + 1;
                bArr[i5 + i7] = (byte) cCharAt2;
                while (true) {
                    i5 = i8;
                    if (i5 >= iMin || (cCharAt = string.charAt(i5)) >= 128) {
                        break;
                    }
                    i8 = i5 + 1;
                    bArr[i5 + i7] = (byte) cCharAt;
                }
                int i9 = c0VarWritableSegment$okio.limit;
                int i10 = (i7 + i5) - i9;
                c0VarWritableSegment$okio.limit = i9 + i10;
                c0169l.f76a = c0169l.size() + ((long) i10);
            } else {
                if (cCharAt2 < 2048) {
                    c0 c0VarWritableSegment$okio2 = c0169l.writableSegment$okio(2);
                    byte[] bArr2 = c0VarWritableSegment$okio2.data;
                    int i11 = c0VarWritableSegment$okio2.limit;
                    bArr2[i11] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c0VarWritableSegment$okio2.limit = i11 + 2;
                    c0169l.f76a = c0169l.size() + 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    c0 c0VarWritableSegment$okio3 = c0169l.writableSegment$okio(3);
                    byte[] bArr3 = c0VarWritableSegment$okio3.data;
                    int i12 = c0VarWritableSegment$okio3.limit;
                    bArr3[i12] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i12 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i12 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c0VarWritableSegment$okio3.limit = i12 + 3;
                    c0169l.f76a = c0169l.size() + 3;
                } else {
                    int i13 = i5 + 1;
                    char cCharAt3 = i13 < i6 ? string.charAt(i13) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        c0169l.writeByte(63);
                        i5 = i13;
                    } else {
                        int i14 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        c0 c0VarWritableSegment$okio4 = c0169l.writableSegment$okio(4);
                        byte[] bArr4 = c0VarWritableSegment$okio4.data;
                        int i15 = c0VarWritableSegment$okio4.limit;
                        bArr4[i15] = (byte) ((i14 >> 18) | 240);
                        bArr4[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                        bArr4[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                        bArr4[i15 + 3] = (byte) ((i14 & 63) | 128);
                        c0VarWritableSegment$okio4.limit = i15 + 4;
                        c0169l.f76a = c0169l.size() + 4;
                        i5 += 2;
                    }
                }
                i5++;
            }
        }
        return c0169l;
    }

    public static final C0169l commonWriteUtf8CodePoint(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        if (i5 < 128) {
            c0169l.writeByte(i5);
            return c0169l;
        }
        if (i5 < 2048) {
            c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(2);
            byte[] bArr = c0VarWritableSegment$okio.data;
            int i6 = c0VarWritableSegment$okio.limit;
            bArr[i6] = (byte) ((i5 >> 6) | 192);
            bArr[i6 + 1] = (byte) ((i5 & 63) | 128);
            c0VarWritableSegment$okio.limit = i6 + 2;
            c0169l.f76a = c0169l.size() + 2;
            return c0169l;
        }
        if (55296 <= i5 && i5 < 57344) {
            c0169l.writeByte(63);
            return c0169l;
        }
        if (i5 < 65536) {
            c0 c0VarWritableSegment$okio2 = c0169l.writableSegment$okio(3);
            byte[] bArr2 = c0VarWritableSegment$okio2.data;
            int i7 = c0VarWritableSegment$okio2.limit;
            bArr2[i7] = (byte) ((i5 >> 12) | 224);
            bArr2[i7 + 1] = (byte) (((i5 >> 6) & 63) | 128);
            bArr2[i7 + 2] = (byte) ((i5 & 63) | 128);
            c0VarWritableSegment$okio2.limit = i7 + 3;
            c0169l.f76a = c0169l.size() + 3;
            return c0169l;
        }
        if (i5 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC0159b.toHexString(i5));
        }
        c0 c0VarWritableSegment$okio3 = c0169l.writableSegment$okio(4);
        byte[] bArr3 = c0VarWritableSegment$okio3.data;
        int i8 = c0VarWritableSegment$okio3.limit;
        bArr3[i8] = (byte) ((i5 >> 18) | 240);
        bArr3[i8 + 1] = (byte) (((i5 >> 12) & 63) | 128);
        bArr3[i8 + 2] = (byte) (((i5 >> 6) & 63) | 128);
        bArr3[i8 + 3] = (byte) ((i5 & 63) | 128);
        c0VarWritableSegment$okio3.limit = i8 + 4;
        c0169l.f76a = c0169l.size() + 4;
        return c0169l;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(c0 segment, int i5, byte[] bytes, int i6, int i7) {
        E.f(segment, "segment");
        E.f(bytes, "bytes");
        int i8 = segment.limit;
        byte[] bArr = segment.data;
        while (i6 < i7) {
            if (i5 == i8) {
                segment = segment.next;
                E.c(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i5 = segment.pos;
                i8 = segment.limit;
            }
            if (bArr[i5] != bytes[i6]) {
                return false;
            }
            i5++;
            i6++;
        }
        return true;
    }

    public static final String readUtf8Line(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        if (j6 > 0) {
            long j7 = j6 - 1;
            if (c0169l.getByte(j7) == 13) {
                String utf8 = c0169l.readUtf8(j7);
                c0169l.skip(2L);
                return utf8;
            }
        }
        String utf9 = c0169l.readUtf8(j6);
        c0169l.skip(1L);
        return utf9;
    }

    public static final <T> T seek(C0169l c0169l, long j6, O3.p lambda) {
        E.f(c0169l, "<this>");
        E.f(lambda, "lambda");
        c0 c0Var = c0169l.head;
        if (c0Var == null) {
            return (T) lambda.invoke(null, -1L);
        }
        if (c0169l.size() - j6 < j6) {
            long size = c0169l.size();
            while (size > j6) {
                c0Var = c0Var.prev;
                E.c(c0Var);
                size -= (long) (c0Var.limit - c0Var.pos);
            }
            return (T) lambda.invoke(c0Var, Long.valueOf(size));
        }
        long j7 = 0;
        while (true) {
            long j8 = ((long) (c0Var.limit - c0Var.pos)) + j7;
            if (j8 > j6) {
                return (T) lambda.invoke(c0Var, Long.valueOf(j7));
            }
            c0Var = c0Var.next;
            E.c(c0Var);
            j7 = j8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a5 A[LOOP:0: B:8:0x0026->B:46:0x00a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a4 A[SYNTHETIC] */
    public static final int selectPrefix(C0169l c0169l, S options, boolean z6) {
        int i5;
        int i6;
        c0 c0Var;
        int i7;
        int i8;
        E.f(c0169l, "<this>");
        E.f(options, "options");
        c0 c0Var2 = c0169l.head;
        if (c0Var2 == null) {
            return z6 ? -2 : -1;
        }
        byte[] bArr = c0Var2.data;
        int i9 = c0Var2.pos;
        int i10 = c0Var2.limit;
        int[] trie$okio = options.getTrie$okio();
        c0 c0Var3 = c0Var2;
        int i11 = -1;
        int i12 = 0;
        loop0: while (true) {
            int i13 = i12 + 1;
            int i14 = trie$okio[i12];
            int i15 = i12 + 2;
            int i16 = trie$okio[i13];
            if (i16 != -1) {
                i11 = i16;
            }
            if (c0Var3 == null) {
                break;
            }
            if (i14 >= 0) {
                i5 = i9 + 1;
                int i17 = bArr[i9] & UnsignedBytes.MAX_VALUE;
                int i18 = i15 + i14;
                while (i15 != i18) {
                    if (i17 == trie$okio[i15]) {
                        i6 = trie$okio[i15 + i14];
                        if (i5 == i10) {
                            c0Var3 = c0Var3.next;
                            E.c(c0Var3);
                            i5 = c0Var3.pos;
                            bArr = c0Var3.data;
                            i10 = c0Var3.limit;
                            if (c0Var3 == c0Var2) {
                                c0Var3 = null;
                            }
                        }
                        if (i6 >= 0) {
                            return i6;
                        }
                        i12 = -i6;
                        i9 = i5;
                    } else {
                        i15++;
                    }
                }
                return i11;
            }
            int i19 = (i14 * (-1)) + i15;
            while (true) {
                int i20 = i9 + 1;
                int i21 = i15 + 1;
                if ((bArr[i9] & UnsignedBytes.MAX_VALUE) == trie$okio[i15]) {
                    boolean z7 = i21 == i19;
                    if (i20 == i10) {
                        E.c(c0Var3);
                        c0 c0Var4 = c0Var3.next;
                        E.c(c0Var4);
                        i8 = c0Var4.pos;
                        byte[] bArr2 = c0Var4.data;
                        i7 = c0Var4.limit;
                        if (c0Var4 != c0Var2) {
                            c0Var = c0Var4;
                            bArr = bArr2;
                        } else {
                            if (!z7) {
                                break loop0;
                            }
                            bArr = bArr2;
                            c0Var = null;
                        }
                    } else {
                        c0Var = c0Var3;
                        i7 = i10;
                        i8 = i20;
                    }
                    if (z7) {
                        i6 = trie$okio[i21];
                        i5 = i8;
                        i10 = i7;
                        c0Var3 = c0Var;
                        break;
                    }
                    i9 = i8;
                    i10 = i7;
                    c0Var3 = c0Var;
                    i15 = i21;
                }
                return i11;
            }
            if (i6 >= 0) {
                return i6;
            }
            i12 = -i6;
            i9 = i5;
        }
        if (z6) {
            return -2;
        }
        return i11;
    }

    public static final int commonRead(C0169l c0169l, byte[] sink, int i5, int i6) {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        AbstractC0159b.a(sink.length, i5, i6);
        c0 c0Var = c0169l.head;
        if (c0Var == null) {
            return -1;
        }
        int iMin = Math.min(i6, c0Var.limit - c0Var.pos);
        byte[] bArr = c0Var.data;
        int i7 = c0Var.pos;
        AbstractC0151t.copyInto(bArr, sink, i5, i7, i7 + iMin);
        c0Var.pos += iMin;
        c0169l.f76a = c0169l.size() - ((long) iMin);
        if (c0Var.pos == c0Var.limit) {
            c0169l.head = c0Var.pop();
            d0.recycle(c0Var);
        }
        return iMin;
    }

    public static final byte[] commonReadByteArray(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (c0169l.size() < j6) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j6];
        c0169l.readFully(bArr);
        return bArr;
    }

    public static final C0173p commonReadByteString(C0169l c0169l, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (c0169l.size() < j6) {
            throw new EOFException();
        }
        if (j6 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new C0173p(c0169l.readByteArray(j6));
        }
        C0173p c0173pSnapshot = c0169l.snapshot((int) j6);
        c0169l.skip(j6);
        return c0173pSnapshot;
    }

    public static final C0169l commonWrite(C0169l c0169l, byte[] source) {
        E.f(c0169l, "<this>");
        E.f(source, "source");
        return c0169l.write(source, 0, source.length);
    }

    public static final C0169l commonWrite(C0169l c0169l, byte[] source, int i5, int i6) {
        E.f(c0169l, "<this>");
        E.f(source, "source");
        long j6 = i6;
        AbstractC0159b.a(source.length, i5, j6);
        int i7 = i6 + i5;
        while (i5 < i7) {
            c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(1);
            int iMin = Math.min(i7 - i5, 8192 - c0VarWritableSegment$okio.limit);
            int i8 = i5 + iMin;
            AbstractC0151t.copyInto(source, c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, i5, i8);
            c0VarWritableSegment$okio.limit += iMin;
            i5 = i8;
        }
        c0169l.f76a = c0169l.size() + j6;
        return c0169l;
    }

    public static final void commonReadFully(C0169l c0169l, C0169l sink, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        if (c0169l.size() >= j6) {
            sink.write(c0169l, j6);
        } else {
            sink.write(c0169l, c0169l.size());
            throw new EOFException();
        }
    }

    public static final C0173p commonSnapshot(C0169l c0169l, int i5) {
        E.f(c0169l, "<this>");
        if (i5 == 0) {
            return C0173p.EMPTY;
        }
        AbstractC0159b.a(c0169l.size(), 0L, i5);
        c0 c0Var = c0169l.head;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            E.c(c0Var);
            int i9 = c0Var.limit;
            int i10 = c0Var.pos;
            if (i9 != i10) {
                i7 += i9 - i10;
                i8++;
                c0Var = c0Var.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i8][];
        int[] iArr = new int[i8 * 2];
        c0 c0Var2 = c0169l.head;
        int i11 = 0;
        while (i6 < i5) {
            E.c(c0Var2);
            bArr[i11] = c0Var2.data;
            i6 += c0Var2.limit - c0Var2.pos;
            iArr[i11] = Math.min(i6, i5);
            iArr[i11 + i8] = c0Var2.pos;
            c0Var2.shared = true;
            i11++;
            c0Var2 = c0Var2.next;
        }
        return new e0(bArr, iArr);
    }

    public static final C0169l commonWrite(C0169l c0169l, h0 source, long j6) throws EOFException {
        E.f(c0169l, "<this>");
        E.f(source, "source");
        while (j6 > 0) {
            long j7 = source.read(c0169l, j6);
            if (j7 == -1) {
                throw new EOFException();
            }
            j6 -= j7;
        }
        return c0169l;
    }

    public static final long commonRead(C0169l c0169l, C0169l sink, long j6) {
        E.f(c0169l, "<this>");
        E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (c0169l.size() == 0) {
            return -1L;
        }
        if (j6 > c0169l.size()) {
            j6 = c0169l.size();
        }
        sink.write(c0169l, j6);
        return j6;
    }

    public static final void commonWrite(C0169l c0169l, C0169l source, long j6) {
        c0 c0Var;
        E.f(c0169l, "<this>");
        E.f(source, "source");
        if (source != c0169l) {
            AbstractC0159b.a(source.size(), 0L, j6);
            while (j6 > 0) {
                c0 c0Var2 = source.head;
                E.c(c0Var2);
                int i5 = c0Var2.limit;
                c0 c0Var3 = source.head;
                E.c(c0Var3);
                if (j6 < i5 - c0Var3.pos) {
                    c0 c0Var4 = c0169l.head;
                    if (c0Var4 != null) {
                        E.c(c0Var4);
                        c0Var = c0Var4.prev;
                    } else {
                        c0Var = null;
                    }
                    if (c0Var != null && c0Var.owner) {
                        if ((((long) c0Var.limit) + j6) - ((long) (c0Var.shared ? 0 : c0Var.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            c0 c0Var5 = source.head;
                            E.c(c0Var5);
                            c0Var5.writeTo(c0Var, (int) j6);
                            source.f76a = source.size() - j6;
                            c0169l.f76a = c0169l.size() + j6;
                            return;
                        }
                    }
                    c0 c0Var6 = source.head;
                    E.c(c0Var6);
                    source.head = c0Var6.split((int) j6);
                }
                c0 c0Var7 = source.head;
                E.c(c0Var7);
                long j7 = c0Var7.limit - c0Var7.pos;
                source.head = c0Var7.pop();
                c0 c0Var8 = c0169l.head;
                if (c0Var8 == null) {
                    c0169l.head = c0Var7;
                    c0Var7.prev = c0Var7;
                    c0Var7.next = c0Var7;
                } else {
                    E.c(c0Var8);
                    c0 c0Var9 = c0Var8.prev;
                    E.c(c0Var9);
                    c0Var9.push(c0Var7).a();
                }
                source.f76a = source.size() - j7;
                c0169l.f76a = c0169l.size() + j7;
                j6 -= j7;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public static final long commonIndexOf(C0169l c0169l, C0173p bytes, long j6) {
        int i5;
        long j7 = j6;
        E.f(c0169l, "<this>");
        E.f(bytes, "bytes");
        if (bytes.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long size = 0;
        if (j7 >= 0) {
            c0 c0Var = c0169l.head;
            if (c0Var == null) {
                return -1L;
            }
            if (c0169l.size() - j7 < j7) {
                size = c0169l.size();
                while (size > j7) {
                    c0Var = c0Var.prev;
                    E.c(c0Var);
                    size -= (long) (c0Var.limit - c0Var.pos);
                }
                byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                byte b = bArrInternalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (c0169l.size() - ((long) size2)) + 1;
                while (size < size3) {
                    byte[] bArr = c0Var.data;
                    int iMin = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + size3) - size);
                    i5 = (int) ((((long) c0Var.pos) + j7) - size);
                    while (i5 < iMin) {
                        if (bArr[i5] != b || !rangeEquals(c0Var, i5 + 1, bArrInternalArray$okio, 1, size2)) {
                            i5++;
                        }
                    }
                    size += (long) (c0Var.limit - c0Var.pos);
                    c0Var = c0Var.next;
                    E.c(c0Var);
                    j7 = size;
                }
                return -1L;
            }
            while (true) {
                long j8 = ((long) (c0Var.limit - c0Var.pos)) + size;
                if (j8 > j7) {
                    break;
                }
                c0Var = c0Var.next;
                E.c(c0Var);
                size = j8;
            }
            byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
            byte b6 = bArrInternalArray$okio2[0];
            int size4 = bytes.size();
            long size5 = (c0169l.size() - ((long) size4)) + 1;
            while (size < size5) {
                byte[] bArr2 = c0Var.data;
                long j9 = size5;
                int iMin2 = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + size5) - size);
                i5 = (int) ((((long) c0Var.pos) + j7) - size);
                while (i5 < iMin2) {
                    if (bArr2[i5] == b6 && rangeEquals(c0Var, i5 + 1, bArrInternalArray$okio2, 1, size4)) {
                    }
                    i5++;
                }
                size += (long) (c0Var.limit - c0Var.pos);
                c0Var = c0Var.next;
                E.c(c0Var);
                size5 = j9;
                j7 = size;
            }
            return -1L;
            return ((long) (i5 - c0Var.pos)) + size;
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j7, "fromIndex < 0: ").toString());
    }
}
