package A4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import X3.C0241g;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: renamed from: A4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0169l implements InterfaceC0171n, InterfaceC0170m, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f76a;
    public c0 head;

    public static /* synthetic */ C0169l copyTo$default(C0169l c0169l, OutputStream outputStream, long j6, long j7, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            j6 = 0;
        }
        long j8 = j6;
        if ((i5 & 4) != 0) {
            j7 = c0169l.f76a - j8;
        }
        return c0169l.copyTo(outputStream, j8, j7);
    }

    public static /* synthetic */ C0169l writeTo$default(C0169l c0169l, OutputStream outputStream, long j6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            j6 = c0169l.f76a;
        }
        return c0169l.writeTo(outputStream, j6);
    }

    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m116deprecated_getByte(long j6) {
        return getByte(j6);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m117deprecated_size() {
        return this.f76a;
    }

    public final void a() throws EOFException {
        skip(size());
    }

    public final C0169l copy() {
        C0169l c0169l = new C0169l();
        if (size() == 0) {
            return c0169l;
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        c0 c0VarSharedCopy = c0Var.sharedCopy();
        c0169l.head = c0VarSharedCopy;
        c0VarSharedCopy.prev = c0VarSharedCopy;
        c0VarSharedCopy.next = c0VarSharedCopy;
        for (c0 c0Var2 = c0Var.next; c0Var2 != c0Var; c0Var2 = c0Var2.next) {
            c0 c0Var3 = c0VarSharedCopy.prev;
            kotlin.jvm.internal.E.c(c0Var3);
            kotlin.jvm.internal.E.c(c0Var2);
            c0Var3.push(c0Var2.sharedCopy());
        }
        c0169l.f76a = size();
        return c0169l;
    }

    public final C0169l copyTo(OutputStream out) {
        kotlin.jvm.internal.E.f(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, null);
    }

    public final long e() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        c0 c0Var2 = c0Var.prev;
        kotlin.jvm.internal.E.c(c0Var2);
        int i5 = c0Var2.limit;
        return (i5 >= 8192 || !c0Var2.owner) ? size : size - ((long) (i5 - c0Var2.pos));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0169l)) {
            return false;
        }
        C0169l c0169l = (C0169l) obj;
        if (size() != c0169l.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        c0 c0Var2 = c0169l.head;
        kotlin.jvm.internal.E.c(c0Var2);
        int i5 = c0Var.pos;
        int i6 = c0Var2.pos;
        long j6 = 0;
        while (j6 < size()) {
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
                kotlin.jvm.internal.E.c(c0Var);
                i5 = c0Var.pos;
            }
            if (i6 == c0Var2.limit) {
                c0Var2 = c0Var2.next;
                kotlin.jvm.internal.E.c(c0Var2);
                i6 = c0Var2.pos;
            }
            j6 += jMin;
        }
        return true;
    }

    @Override // A4.InterfaceC0171n
    public final boolean exhausted() {
        return this.f76a == 0;
    }

    public final C0173p f(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        c0 c0Var = this.head;
        if (c0Var != null) {
            byte[] bArr = c0Var.data;
            int i5 = c0Var.pos;
            messageDigest.update(bArr, i5, c0Var.limit - i5);
            c0 c0Var2 = c0Var.next;
            kotlin.jvm.internal.E.c(c0Var2);
            while (c0Var2 != c0Var) {
                byte[] bArr2 = c0Var2.data;
                int i6 = c0Var2.pos;
                messageDigest.update(bArr2, i6, c0Var2.limit - i6);
                c0Var2 = c0Var2.next;
                kotlin.jvm.internal.E.c(c0Var2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.E.e(bArrDigest, "messageDigest.digest()");
        return new C0173p(bArrDigest);
    }

    public final C0173p g(String str, C0173p c0173p) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(c0173p.internalArray$okio(), str));
            c0 c0Var = this.head;
            if (c0Var != null) {
                byte[] bArr = c0Var.data;
                int i5 = c0Var.pos;
                mac.update(bArr, i5, c0Var.limit - i5);
                c0 c0Var2 = c0Var.next;
                kotlin.jvm.internal.E.c(c0Var2);
                while (c0Var2 != c0Var) {
                    byte[] bArr2 = c0Var2.data;
                    int i6 = c0Var2.pos;
                    mac.update(bArr2, i6, c0Var2.limit - i6);
                    c0Var2 = c0Var2.next;
                    kotlin.jvm.internal.E.c(c0Var2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.E.e(bArrDoFinal, "mac.doFinal()");
            return new C0173p(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final byte getByte(long j6) {
        AbstractC0159b.a(size(), j6, 1L);
        c0 c0Var = this.head;
        if (c0Var == null) {
            kotlin.jvm.internal.E.throwJavaNpe();
            throw null;
        }
        if (size() - j6 < j6) {
            long size = size();
            while (size > j6) {
                c0Var = c0Var.prev;
                kotlin.jvm.internal.E.c(c0Var);
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
            kotlin.jvm.internal.E.c(c0Var);
            j7 = j8;
        }
    }

    public final int hashCode() {
        c0 c0Var = this.head;
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
            kotlin.jvm.internal.E.c(c0Var);
        } while (c0Var != this.head);
        return i5;
    }

    public final C0173p hmacSha1(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return g("HmacSHA1", key);
    }

    public final C0173p hmacSha256(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return g("HmacSHA256", key);
    }

    public final C0173p hmacSha512(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return g("HmacSHA512", key);
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b) {
        return indexOf(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public long indexOfElement(C0173p targetBytes) {
        kotlin.jvm.internal.E.f(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // A4.InterfaceC0171n
    public InputStream inputStream() {
        return new C0167j(this);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final C0173p md5() {
        return f(MessageDigestAlgorithms.MD5);
    }

    @Override // A4.InterfaceC0170m
    public OutputStream outputStream() {
        return new C0168k(this);
    }

    @Override // A4.InterfaceC0171n
    public InterfaceC0171n peek() {
        return N.buffer(new W(this));
    }

    @Override // A4.InterfaceC0171n
    public boolean rangeEquals(long j6, C0173p bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return rangeEquals(j6, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        c0 c0Var = this.head;
        if (c0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), c0Var.limit - c0Var.pos);
        sink.put(c0Var.data, c0Var.pos, iMin);
        int i5 = c0Var.pos + iMin;
        c0Var.pos = i5;
        this.f76a -= (long) iMin;
        if (i5 == c0Var.limit) {
            this.head = c0Var.pop();
            d0.recycle(c0Var);
        }
        return iMin;
    }

    @Override // A4.InterfaceC0171n
    public long readAll(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public final C0166i readAndWriteUnsafe() {
        return readAndWriteUnsafe(AbstractC0159b.getDEFAULT__new_UnsafeCursor());
    }

    @Override // A4.InterfaceC0171n
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        int i7 = i5 + 1;
        byte b = c0Var.data[i5];
        this.f76a = size() - 1;
        if (i7 != i6) {
            c0Var.pos = i7;
            return b;
        }
        this.head = c0Var.pop();
        d0.recycle(c0Var);
        return b;
    }

    @Override // A4.InterfaceC0171n
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // A4.InterfaceC0171n
    public C0173p readByteString() {
        return readByteString(size());
    }

    @Override // A4.InterfaceC0171n
    public long readDecimalLong() throws EOFException {
        long j6;
        byte b;
        long j7 = 0;
        if (size() == 0) {
            throw new EOFException();
        }
        int i5 = 0;
        boolean z6 = false;
        long j8 = 0;
        long j9 = -7;
        boolean z7 = false;
        loop0: while (true) {
            c0 c0Var = this.head;
            kotlin.jvm.internal.E.c(c0Var);
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
                this.head = c0Var.pop();
                d0.recycle(c0Var);
            } else {
                c0Var.pos = i6;
            }
            if (z7 || this.head == null) {
                this.f76a = size() - ((long) i5);
                if (i5 >= (z6 ? 2 : 1)) {
                    return z6 ? j8 : -j8;
                }
                if (size() == j6) {
                    throw new EOFException();
                }
                StringBuilder sbX = AbstractC0157z.x(z6 ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
                sbX.append(AbstractC0159b.toHexString(getByte(j6)));
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

    public final C0169l readFrom(InputStream input) throws IOException {
        kotlin.jvm.internal.E.f(input, "input");
        readFrom(input, LocationRequestCompat.PASSIVE_INTERVAL, true);
        return this;
    }

    @Override // A4.InterfaceC0171n
    public void readFully(C0169l sink, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (size() >= j6) {
            sink.write(this, j6);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // A4.InterfaceC0171n
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i5;
        if (size() == 0) {
            throw new EOFException();
        }
        int i6 = 0;
        boolean z6 = false;
        long j6 = 0;
        do {
            c0 c0Var = this.head;
            kotlin.jvm.internal.E.c(c0Var);
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
                this.head = c0Var.pop();
                d0.recycle(c0Var);
            } else {
                c0Var.pos = i7;
            }
            if (z6) {
                break;
            }
        } while (this.head != null);
        this.f76a = size() - ((long) i6);
        return j6;
    }

    @Override // A4.InterfaceC0171n
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 4) {
            return ((readByte() & UnsignedBytes.MAX_VALUE) << 24) | ((readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE);
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 3;
        int i8 = ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i5] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 8);
        int i9 = i5 + 4;
        int i10 = (bArr[i7] & UnsignedBytes.MAX_VALUE) | i8;
        this.f76a = size() - 4;
        if (i9 != i6) {
            c0Var.pos = i9;
            return i10;
        }
        this.head = c0Var.pop();
        d0.recycle(c0Var);
        return i10;
    }

    @Override // A4.InterfaceC0171n
    public int readIntLe() {
        return AbstractC0159b.b(readInt());
    }

    @Override // A4.InterfaceC0171n
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 8) {
            return ((((long) readInt()) & KeyboardMap.kValueMask) << 32) | (KeyboardMap.kValueMask & ((long) readInt()));
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 7;
        long j6 = ((((long) bArr[i5]) & 255) << 56) | ((((long) bArr[i5 + 1]) & 255) << 48) | ((((long) bArr[i5 + 2]) & 255) << 40) | ((((long) bArr[i5 + 3]) & 255) << 32) | ((((long) bArr[i5 + 4]) & 255) << 24) | ((((long) bArr[i5 + 5]) & 255) << 16) | ((((long) bArr[i5 + 6]) & 255) << 8);
        int i8 = i5 + 8;
        long j7 = j6 | (((long) bArr[i7]) & 255);
        this.f76a = size() - 8;
        if (i8 != i6) {
            c0Var.pos = i8;
            return j7;
        }
        this.head = c0Var.pop();
        d0.recycle(c0Var);
        return j7;
    }

    @Override // A4.InterfaceC0171n
    public long readLongLe() {
        return AbstractC0159b.c(readLong());
    }

    @Override // A4.InterfaceC0171n
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.pos;
        int i6 = c0Var.limit;
        if (i6 - i5 < 2) {
            return (short) (((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE));
        }
        byte[] bArr = c0Var.data;
        int i7 = i5 + 1;
        int i8 = (bArr[i5] & UnsignedBytes.MAX_VALUE) << 8;
        int i9 = i5 + 2;
        int i10 = (bArr[i7] & UnsignedBytes.MAX_VALUE) | i8;
        this.f76a = size() - 2;
        if (i9 == i6) {
            this.head = c0Var.pop();
            d0.recycle(c0Var);
        } else {
            c0Var.pos = i9;
        }
        return (short) i10;
    }

    @Override // A4.InterfaceC0171n
    public short readShortLe() throws EOFException {
        short s6 = readShort();
        return (short) (((s6 & 255) << 8) | ((65280 & s6) >>> 8));
    }

    @Override // A4.InterfaceC0171n
    public String readString(Charset charset) {
        kotlin.jvm.internal.E.f(charset, "charset");
        return readString(this.f76a, charset);
    }

    public final C0166i readUnsafe() {
        return readUnsafe(AbstractC0159b.getDEFAULT__new_UnsafeCursor());
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8() {
        return readString(this.f76a, C0241g.UTF_8);
    }

    @Override // A4.InterfaceC0171n
    public int readUtf8CodePoint() throws EOFException {
        int i5;
        int i6;
        int i7;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
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
                skip(1L);
                return 65533;
            }
            i5 = b & 7;
            i6 = 4;
            i7 = 65536;
        }
        long j6 = i6;
        if (size() < j6) {
            StringBuilder sbT = AbstractC0157z.t(i6, "size < ", ": ");
            sbT.append(size());
            sbT.append(" (to read code point prefixed 0x");
            sbT.append(AbstractC0159b.toHexString(b));
            sbT.append(')');
            throw new EOFException(sbT.toString());
        }
        for (int i8 = 1; i8 < i6; i8++) {
            long j7 = i8;
            byte b6 = getByte(j7);
            if ((b6 & 192) != 128) {
                skip(j7);
                return 65533;
            }
            i5 = (i5 << 6) | (b6 & 63);
        }
        skip(j6);
        if (i5 > 1114111) {
            return 65533;
        }
        if ((55296 > i5 || i5 >= 57344) && i5 >= i7) {
            return i5;
        }
        return 65533;
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return B4.a.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public final boolean request(long j6) {
        return this.f76a >= j6;
    }

    @Override // A4.InterfaceC0171n
    public void require(long j6) throws EOFException {
        if (this.f76a < j6) {
            throw new EOFException();
        }
    }

    @Override // A4.InterfaceC0171n
    public int select(S options) throws EOFException {
        kotlin.jvm.internal.E.f(options, "options");
        int iSelectPrefix = B4.a.selectPrefix(this, options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[iSelectPrefix].size());
        return iSelectPrefix;
    }

    public final C0173p sha1() {
        return f(MessageDigestAlgorithms.SHA_1);
    }

    public final C0173p sha256() {
        return f(MessageDigestAlgorithms.SHA_256);
    }

    public final C0173p sha512() {
        return f(MessageDigestAlgorithms.SHA_512);
    }

    public final long size() {
        return this.f76a;
    }

    @Override // A4.InterfaceC0171n
    public void skip(long j6) throws EOFException {
        while (j6 > 0) {
            c0 c0Var = this.head;
            if (c0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j6, c0Var.limit - c0Var.pos);
            long j7 = iMin;
            this.f76a = size() - j7;
            j6 -= j7;
            int i5 = c0Var.pos + iMin;
            c0Var.pos = i5;
            if (i5 == c0Var.limit) {
                this.head = c0Var.pop();
                d0.recycle(c0Var);
            }
        }
    }

    public final C0173p snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // A4.InterfaceC0171n, A4.h0
    public k0 timeout() {
        return k0.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final c0 writableSegment$okio(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        c0 c0Var = this.head;
        if (c0Var != null) {
            kotlin.jvm.internal.E.c(c0Var);
            c0 c0Var2 = c0Var.prev;
            kotlin.jvm.internal.E.c(c0Var2);
            return (c0Var2.limit + i5 > 8192 || !c0Var2.owner) ? c0Var2.push(d0.take()) : c0Var2;
        }
        c0 c0VarTake = d0.take();
        this.head = c0VarTake;
        c0VarTake.prev = c0VarTake;
        c0VarTake.next = c0VarTake;
        return c0VarTake;
    }

    @Override // A4.InterfaceC0170m
    public long writeAll(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        long j6 = 0;
        while (true) {
            long j7 = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j7 == -1) {
                return j6;
            }
            j6 += j7;
        }
    }

    public final C0169l writeTo(OutputStream out) {
        kotlin.jvm.internal.E.f(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C0169l m118clone() {
        return copy();
    }

    public final C0169l copyTo(OutputStream out, long j6) {
        kotlin.jvm.internal.E.f(out, "out");
        return copyTo$default(this, out, j6, 0L, 4, null);
    }

    @Override // A4.InterfaceC0170m
    public C0169l emit() {
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l emitCompleteSegments() {
        return this;
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b, long j6) {
        return indexOf(b, j6, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public long indexOfElement(C0173p targetBytes, long j6) {
        int i5;
        int i6;
        kotlin.jvm.internal.E.f(targetBytes, "targetBytes");
        long size = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "fromIndex < 0: ").toString());
        }
        c0 c0Var = this.head;
        if (c0Var == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            size = size();
            while (size > j6) {
                c0Var = c0Var.prev;
                kotlin.jvm.internal.E.c(c0Var);
                size -= (long) (c0Var.limit - c0Var.pos);
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b6 = targetBytes.getByte(1);
                while (size < size()) {
                    byte[] bArr = c0Var.data;
                    i5 = (int) ((((long) c0Var.pos) + j6) - size);
                    int i7 = c0Var.limit;
                    while (true) {
                        if (i5 >= i7) {
                            size += (long) (c0Var.limit - c0Var.pos);
                            c0Var = c0Var.next;
                            kotlin.jvm.internal.E.c(c0Var);
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
                while (size < size()) {
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
                            kotlin.jvm.internal.E.c(c0Var);
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
            kotlin.jvm.internal.E.c(c0Var);
            size = j7;
        }
        if (targetBytes.size() == 2) {
            byte b9 = targetBytes.getByte(0);
            byte b10 = targetBytes.getByte(1);
            while (size < size()) {
                byte[] bArr3 = c0Var.data;
                i5 = (int) ((((long) c0Var.pos) + j6) - size);
                int i10 = c0Var.limit;
                while (true) {
                    if (i5 >= i10) {
                        size += (long) (c0Var.limit - c0Var.pos);
                        c0Var = c0Var.next;
                        kotlin.jvm.internal.E.c(c0Var);
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
            while (size < size()) {
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
                        kotlin.jvm.internal.E.c(c0Var);
                        j6 = size;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i5 - i6)) + size;
    }

    @Override // A4.InterfaceC0171n
    public boolean rangeEquals(long j6, C0173p bytes, int i5, int i6) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        if (j6 < 0 || i5 < 0 || i6 < 0 || size() - j6 < i6 || bytes.size() - i5 < i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (getByte(((long) i7) + j6) != bytes.getByte(i5 + i7)) {
                return false;
            }
        }
        return true;
    }

    @Override // A4.InterfaceC0171n
    public byte[] readByteArray(long j6) throws EOFException {
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j6];
        readFully(bArr);
        return bArr;
    }

    @Override // A4.InterfaceC0171n
    public C0173p readByteString(long j6) throws EOFException {
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        if (j6 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new C0173p(readByteArray(j6));
        }
        C0173p c0173pSnapshot = snapshot((int) j6);
        skip(j6);
        return c0173pSnapshot;
    }

    public final C0169l readFrom(InputStream input, long j6) throws IOException {
        kotlin.jvm.internal.E.f(input, "input");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        readFrom(input, j6, false);
        return this;
    }

    @Override // A4.InterfaceC0171n
    public String readString(long j6, Charset charset) throws EOFException {
        kotlin.jvm.internal.E.f(charset, "charset");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount: ").toString());
        }
        if (this.f76a < j6) {
            throw new EOFException();
        }
        if (j6 == 0) {
            return "";
        }
        c0 c0Var = this.head;
        kotlin.jvm.internal.E.c(c0Var);
        int i5 = c0Var.pos;
        if (((long) i5) + j6 > c0Var.limit) {
            return new String(readByteArray(j6), charset);
        }
        int i6 = (int) j6;
        String str = new String(c0Var.data, i5, i6, charset);
        int i7 = c0Var.pos + i6;
        c0Var.pos = i7;
        this.f76a -= j6;
        if (i7 == c0Var.limit) {
            this.head = c0Var.pop();
            d0.recycle(c0Var);
        }
        return str;
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8(long j6) {
        return readString(j6, C0241g.UTF_8);
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8LineStrict(long j6) throws EOFException {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "limit < 0: ").toString());
        }
        long j7 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            j7 = j6 + 1;
        }
        long j8 = j7;
        long jIndexOf = indexOf((byte) 10, 0L, j8);
        if (jIndexOf != -1) {
            return B4.a.readUtf8Line(this, jIndexOf);
        }
        if (j8 < size() && getByte(j8 - 1) == 13 && getByte(j8) == 10) {
            return B4.a.readUtf8Line(this, j8);
        }
        C0169l c0169l = new C0169l();
        copyTo(c0169l, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j6) + " content=" + c0169l.readByteString().hex() + (char) 8230);
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeByte(int i5) {
        c0 c0VarWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        c0VarWritableSegment$okio.limit = i6 + 1;
        bArr[i6] = (byte) i5;
        this.f76a = size() + 1;
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeDecimalLong(long j6) {
        boolean z6;
        if (j6 == 0) {
            return writeByte(48);
        }
        int i5 = 1;
        if (j6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return writeUtf8("-9223372036854775808");
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
        c0 c0VarWritableSegment$okio = writableSegment$okio(i5);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit + i5;
        while (j6 != 0) {
            long j7 = 10;
            i6--;
            bArr[i6] = B4.a.getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z6) {
            bArr[i6 - 1] = 45;
        }
        c0VarWritableSegment$okio.limit += i5;
        this.f76a = size() + ((long) i5);
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeHexadecimalUnsignedLong(long j6) {
        if (j6 == 0) {
            return writeByte(48);
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
        c0 c0VarWritableSegment$okio = writableSegment$okio(i5);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        for (int i7 = (i6 + i5) - 1; i7 >= i6; i7--) {
            bArr[i7] = B4.a.getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        c0VarWritableSegment$okio.limit += i5;
        this.f76a = size() + ((long) i5);
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeInt(int i5) {
        c0 c0VarWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        c0VarWritableSegment$okio.limit = i6 + 4;
        this.f76a = size() + 4;
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeIntLe(int i5) {
        return writeInt(AbstractC0159b.b(i5));
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeLong(long j6) {
        c0 c0VarWritableSegment$okio = writableSegment$okio(8);
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
        this.f76a = size() + 8;
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeLongLe(long j6) {
        return writeLong(AbstractC0159b.c(j6));
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeShort(int i5) {
        c0 c0VarWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = c0VarWritableSegment$okio.data;
        int i6 = c0VarWritableSegment$okio.limit;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        c0VarWritableSegment$okio.limit = i6 + 2;
        this.f76a = size() + 2;
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeShortLe(int i5) {
        short s6 = (short) i5;
        return writeShort((int) ((short) (((s6 & 255) << 8) | ((65280 & s6) >>> 8))));
    }

    public final C0169l writeTo(OutputStream out, long j6) throws IOException {
        kotlin.jvm.internal.E.f(out, "out");
        AbstractC0159b.a(this.f76a, 0L, j6);
        c0 c0Var = this.head;
        long j7 = j6;
        while (j7 > 0) {
            kotlin.jvm.internal.E.c(c0Var);
            int iMin = (int) Math.min(j7, c0Var.limit - c0Var.pos);
            out.write(c0Var.data, c0Var.pos, iMin);
            int i5 = c0Var.pos + iMin;
            c0Var.pos = i5;
            long j8 = iMin;
            this.f76a -= j8;
            j7 -= j8;
            if (i5 == c0Var.limit) {
                c0 c0VarPop = c0Var.pop();
                this.head = c0VarPop;
                d0.recycle(c0Var);
                c0Var = c0VarPop;
            }
        }
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeUtf8CodePoint(int i5) {
        if (i5 < 128) {
            writeByte(i5);
            return this;
        }
        if (i5 < 2048) {
            c0 c0VarWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = c0VarWritableSegment$okio.data;
            int i6 = c0VarWritableSegment$okio.limit;
            bArr[i6] = (byte) ((i5 >> 6) | 192);
            bArr[i6 + 1] = (byte) ((i5 & 63) | 128);
            c0VarWritableSegment$okio.limit = i6 + 2;
            this.f76a = size() + 2;
            return this;
        }
        if (55296 <= i5 && i5 < 57344) {
            writeByte(63);
            return this;
        }
        if (i5 < 65536) {
            c0 c0VarWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = c0VarWritableSegment$okio2.data;
            int i7 = c0VarWritableSegment$okio2.limit;
            bArr2[i7] = (byte) ((i5 >> 12) | 224);
            bArr2[i7 + 1] = (byte) (((i5 >> 6) & 63) | 128);
            bArr2[i7 + 2] = (byte) ((i5 & 63) | 128);
            c0VarWritableSegment$okio2.limit = i7 + 3;
            this.f76a = size() + 3;
            return this;
        }
        if (i5 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC0159b.toHexString(i5));
        }
        c0 c0VarWritableSegment$okio3 = writableSegment$okio(4);
        byte[] bArr3 = c0VarWritableSegment$okio3.data;
        int i8 = c0VarWritableSegment$okio3.limit;
        bArr3[i8] = (byte) ((i5 >> 18) | 240);
        bArr3[i8 + 1] = (byte) (((i5 >> 12) & 63) | 128);
        bArr3[i8 + 2] = (byte) (((i5 >> 6) & 63) | 128);
        bArr3[i8 + 3] = (byte) ((i5 & 63) | 128);
        c0VarWritableSegment$okio3.limit = i8 + 4;
        this.f76a = size() + 4;
        return this;
    }

    public final C0169l copyTo(OutputStream out, long j6, long j7) throws IOException {
        kotlin.jvm.internal.E.f(out, "out");
        long j8 = j6;
        AbstractC0159b.a(this.f76a, j8, j7);
        if (j7 != 0) {
            c0 c0Var = this.head;
            while (true) {
                kotlin.jvm.internal.E.c(c0Var);
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
                kotlin.jvm.internal.E.c(c0Var2);
                int i7 = (int) (((long) c0Var2.pos) + j8);
                int iMin = (int) Math.min(c0Var2.limit - i7, j9);
                out.write(c0Var2.data, i7, iMin);
                j9 -= (long) iMin;
                c0Var2 = c0Var2.next;
                j8 = 0;
            }
        }
        return this;
    }

    @Override // A4.InterfaceC0171n
    public long indexOf(C0173p bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    public final C0166i readAndWriteUnsafe(C0166i unsafeCursor) {
        kotlin.jvm.internal.E.f(unsafeCursor, "unsafeCursor");
        return B4.a.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    public final C0166i readUnsafe(C0166i unsafeCursor) {
        kotlin.jvm.internal.E.f(unsafeCursor, "unsafeCursor");
        return B4.a.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeString(String string, Charset charset) {
        kotlin.jvm.internal.E.f(string, "string");
        kotlin.jvm.internal.E.f(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeUtf8(String string) {
        kotlin.jvm.internal.E.f(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b, long j6, long j7) {
        c0 c0Var;
        int i5;
        long size = 0;
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > size()) {
            j7 = size();
        }
        if (j6 == j7 || (c0Var = this.head) == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            size = size();
            while (size > j6) {
                c0Var = c0Var.prev;
                kotlin.jvm.internal.E.c(c0Var);
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
                kotlin.jvm.internal.E.c(c0Var);
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
            kotlin.jvm.internal.E.c(c0Var);
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
            kotlin.jvm.internal.E.c(c0Var);
            j6 = size;
        }
        return -1L;
        return ((long) (i5 - c0Var.pos)) + size;
    }

    public final C0173p snapshot(int i5) {
        if (i5 == 0) {
            return C0173p.EMPTY;
        }
        AbstractC0159b.a(size(), 0L, i5);
        c0 c0Var = this.head;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            kotlin.jvm.internal.E.c(c0Var);
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
        c0 c0Var2 = this.head;
        int i11 = 0;
        while (i6 < i5) {
            kotlin.jvm.internal.E.c(c0Var2);
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

    @Override // A4.InterfaceC0170m
    public C0169l writeUtf8(String string, int i5, int i6) {
        char cCharAt;
        kotlin.jvm.internal.E.f(string, "string");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "beginIndex < 0: ").toString());
        }
        if (i6 >= i5) {
            if (i6 > string.length()) {
                StringBuilder sbT = AbstractC0157z.t(i6, "endIndex > string.length: ", " > ");
                sbT.append(string.length());
                throw new IllegalArgumentException(sbT.toString().toString());
            }
            while (i5 < i6) {
                char cCharAt2 = string.charAt(i5);
                if (cCharAt2 < 128) {
                    c0 c0VarWritableSegment$okio = writableSegment$okio(1);
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
                    this.f76a = size() + ((long) i10);
                } else {
                    if (cCharAt2 < 2048) {
                        c0 c0VarWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = c0VarWritableSegment$okio2.data;
                        int i11 = c0VarWritableSegment$okio2.limit;
                        bArr2[i11] = (byte) ((cCharAt2 >> 6) | 192);
                        bArr2[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        c0VarWritableSegment$okio2.limit = i11 + 2;
                        this.f76a = size() + 2;
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i12 = i5 + 1;
                        char cCharAt3 = i12 < i6 ? string.charAt(i12) : (char) 0;
                        if (cCharAt2 <= 56319 && 56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i13 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            c0 c0VarWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = c0VarWritableSegment$okio3.data;
                            int i14 = c0VarWritableSegment$okio3.limit;
                            bArr3[i14] = (byte) ((i13 >> 18) | 240);
                            bArr3[i14 + 1] = (byte) (((i13 >> 12) & 63) | 128);
                            bArr3[i14 + 2] = (byte) (((i13 >> 6) & 63) | 128);
                            bArr3[i14 + 3] = (byte) ((i13 & 63) | 128);
                            c0VarWritableSegment$okio3.limit = i14 + 4;
                            this.f76a = size() + 4;
                            i5 += 2;
                        } else {
                            writeByte(63);
                            i5 = i12;
                        }
                    } else {
                        c0 c0VarWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = c0VarWritableSegment$okio4.data;
                        int i15 = c0VarWritableSegment$okio4.limit;
                        bArr4[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                        bArr4[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        c0VarWritableSegment$okio4.limit = i15 + 3;
                        this.f76a = size() + 3;
                    }
                    i5++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(androidx.collection.a.h(i6, i5, "endIndex < beginIndex: ", " < ").toString());
    }

    @Override // A4.InterfaceC0171n
    public void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.E.f(sink, "sink");
        int i5 = 0;
        while (i5 < sink.length) {
            int i6 = read(sink, i5, sink.length - i5);
            if (i6 == -1) {
                throw new EOFException();
            }
            i5 += i6;
        }
    }

    @Override // A4.InterfaceC0170m
    public C0169l writeString(String string, int i5, int i6, Charset charset) {
        kotlin.jvm.internal.E.f(string, "string");
        kotlin.jvm.internal.E.f(charset, "charset");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "beginIndex < 0: ").toString());
        }
        if (i6 >= i5) {
            if (i6 <= string.length()) {
                if (charset.equals(C0241g.UTF_8)) {
                    return writeUtf8(string, i5, i6);
                }
                String strSubstring = string.substring(i5, i6);
                kotlin.jvm.internal.E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                byte[] bytes = strSubstring.getBytes(charset);
                kotlin.jvm.internal.E.e(bytes, "this as java.lang.String).getBytes(charset)");
                return write(bytes, 0, bytes.length);
            }
            StringBuilder sbT = AbstractC0157z.t(i6, "endIndex > string.length: ", " > ");
            sbT.append(string.length());
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        throw new IllegalArgumentException(androidx.collection.a.h(i6, i5, "endIndex < beginIndex: ", " < ").toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.E.f(source, "source");
        int iRemaining = source.remaining();
        int i5 = iRemaining;
        while (i5 > 0) {
            c0 c0VarWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i5, 8192 - c0VarWritableSegment$okio.limit);
            source.get(c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, iMin);
            i5 -= iMin;
            c0VarWritableSegment$okio.limit += iMin;
        }
        this.f76a += (long) iRemaining;
        return iRemaining;
    }

    @Override // A4.InterfaceC0171n
    public int read(byte[] sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return read(sink, 0, sink.length);
    }

    private final void readFrom(InputStream inputStream, long j6, boolean z6) throws IOException {
        while (true) {
            if (j6 <= 0 && !z6) {
                return;
            }
            c0 c0VarWritableSegment$okio = writableSegment$okio(1);
            int i5 = inputStream.read(c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, (int) Math.min(j6, 8192 - c0VarWritableSegment$okio.limit));
            if (i5 == -1) {
                if (c0VarWritableSegment$okio.pos == c0VarWritableSegment$okio.limit) {
                    this.head = c0VarWritableSegment$okio.pop();
                    d0.recycle(c0VarWritableSegment$okio);
                }
                if (!z6) {
                    throw new EOFException();
                }
                return;
            }
            c0VarWritableSegment$okio.limit += i5;
            long j7 = i5;
            this.f76a += j7;
            j6 -= j7;
        }
    }

    @Override // A4.InterfaceC0171n
    public int read(byte[] sink, int i5, int i6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        AbstractC0159b.a(sink.length, i5, i6);
        c0 c0Var = this.head;
        if (c0Var == null) {
            return -1;
        }
        int iMin = Math.min(i6, c0Var.limit - c0Var.pos);
        byte[] bArr = c0Var.data;
        int i7 = c0Var.pos;
        AbstractC0151t.copyInto(bArr, sink, i5, i7, i7 + iMin);
        c0Var.pos += iMin;
        this.f76a = size() - ((long) iMin);
        if (c0Var.pos == c0Var.limit) {
            this.head = c0Var.pop();
            d0.recycle(c0Var);
        }
        return iMin;
    }

    public final C0169l copyTo(C0169l out, long j6) {
        kotlin.jvm.internal.E.f(out, "out");
        return copyTo(out, j6, this.f76a - j6);
    }

    @Override // A4.InterfaceC0170m
    public C0169l write(C0173p byteString) {
        kotlin.jvm.internal.E.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public final C0169l copyTo(C0169l out, long j6, long j7) {
        kotlin.jvm.internal.E.f(out, "out");
        long j8 = j6;
        AbstractC0159b.a(size(), j8, j7);
        if (j7 != 0) {
            out.f76a = out.size() + j7;
            c0 c0Var = this.head;
            while (true) {
                kotlin.jvm.internal.E.c(c0Var);
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
                kotlin.jvm.internal.E.c(c0Var2);
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
                    kotlin.jvm.internal.E.c(c0Var3);
                    c0 c0Var4 = c0Var3.prev;
                    kotlin.jvm.internal.E.c(c0Var4);
                    c0Var4.push(c0VarSharedCopy);
                }
                j9 -= (long) (c0VarSharedCopy.limit - c0VarSharedCopy.pos);
                c0Var2 = c0Var2.next;
                j8 = 0;
            }
        }
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l write(C0173p byteString, int i5, int i6) {
        kotlin.jvm.internal.E.f(byteString, "byteString");
        byteString.write$okio(this, i5, i6);
        return this;
    }

    @Override // A4.InterfaceC0170m
    public C0169l write(byte[] source) {
        kotlin.jvm.internal.E.f(source, "source");
        return write(source, 0, source.length);
    }

    @Override // A4.InterfaceC0170m
    public C0169l write(byte[] source, int i5, int i6) {
        kotlin.jvm.internal.E.f(source, "source");
        long j6 = i6;
        AbstractC0159b.a(source.length, i5, j6);
        int i7 = i6 + i5;
        while (i5 < i7) {
            c0 c0VarWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i7 - i5, 8192 - c0VarWritableSegment$okio.limit);
            int i8 = i5 + iMin;
            AbstractC0151t.copyInto(source, c0VarWritableSegment$okio.data, c0VarWritableSegment$okio.limit, i5, i8);
            c0VarWritableSegment$okio.limit += iMin;
            i5 = i8;
        }
        this.f76a = size() + j6;
        return this;
    }

    @Override // A4.InterfaceC0171n
    public C0169l buffer() {
        return this;
    }

    @Override // A4.InterfaceC0171n, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // A4.InterfaceC0170m, A4.f0, java.io.Flushable
    public final void flush() {
    }

    @Override // A4.InterfaceC0171n
    public C0169l getBuffer() {
        return this;
    }

    @Override // A4.InterfaceC0171n, A4.h0
    public long read(C0169l sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j6 > size()) {
            j6 = size();
        }
        sink.write(this, j6);
        return j6;
    }

    @Override // A4.InterfaceC0170m
    public C0169l write(h0 source, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(source, "source");
        while (j6 > 0) {
            long j7 = source.read(this, j6);
            if (j7 == -1) {
                throw new EOFException();
            }
            j6 -= j7;
        }
        return this;
    }

    @Override // A4.InterfaceC0171n
    public long indexOf(C0173p bytes, long j6) {
        int i5;
        long j7 = j6;
        kotlin.jvm.internal.E.f(bytes, "bytes");
        if (bytes.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long size = 0;
        if (j7 >= 0) {
            c0 c0Var = this.head;
            if (c0Var == null) {
                return -1L;
            }
            if (size() - j7 < j7) {
                size = size();
                while (size > j7) {
                    c0Var = c0Var.prev;
                    kotlin.jvm.internal.E.c(c0Var);
                    size -= (long) (c0Var.limit - c0Var.pos);
                }
                byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                byte b = bArrInternalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (size() - ((long) size2)) + 1;
                while (size < size3) {
                    byte[] bArr = c0Var.data;
                    long j8 = size3;
                    int iMin = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + size3) - size);
                    i5 = (int) ((((long) c0Var.pos) + j7) - size);
                    while (i5 < iMin) {
                        if (bArr[i5] != b || !B4.a.rangeEquals(c0Var, i5 + 1, bArrInternalArray$okio, 1, size2)) {
                            i5++;
                        }
                    }
                    size += (long) (c0Var.limit - c0Var.pos);
                    c0Var = c0Var.next;
                    kotlin.jvm.internal.E.c(c0Var);
                    j7 = size;
                    size3 = j8;
                }
                return -1L;
            }
            while (true) {
                long j9 = ((long) (c0Var.limit - c0Var.pos)) + size;
                if (j9 > j7) {
                    break;
                }
                c0Var = c0Var.next;
                kotlin.jvm.internal.E.c(c0Var);
                size = j9;
            }
            byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
            byte b6 = bArrInternalArray$okio2[0];
            int size4 = bytes.size();
            long size5 = (size() - ((long) size4)) + 1;
            while (size < size5) {
                byte[] bArr2 = c0Var.data;
                int iMin2 = (int) Math.min(c0Var.limit, (((long) c0Var.pos) + size5) - size);
                i5 = (int) ((((long) c0Var.pos) + j7) - size);
                while (i5 < iMin2) {
                    if (bArr2[i5] == b6 && B4.a.rangeEquals(c0Var, i5 + 1, bArrInternalArray$okio2, 1, size4)) {
                    }
                    i5++;
                }
                size += (long) (c0Var.limit - c0Var.pos);
                c0Var = c0Var.next;
                kotlin.jvm.internal.E.c(c0Var);
                j7 = size;
            }
            return -1L;
            return ((long) (i5 - c0Var.pos)) + size;
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j7, "fromIndex < 0: ").toString());
    }

    @Override // A4.InterfaceC0170m, A4.f0
    public void write(C0169l source, long j6) {
        c0 c0Var;
        kotlin.jvm.internal.E.f(source, "source");
        if (source != this) {
            AbstractC0159b.a(source.size(), 0L, j6);
            while (j6 > 0) {
                c0 c0Var2 = source.head;
                kotlin.jvm.internal.E.c(c0Var2);
                int i5 = c0Var2.limit;
                c0 c0Var3 = source.head;
                kotlin.jvm.internal.E.c(c0Var3);
                if (j6 < i5 - c0Var3.pos) {
                    c0 c0Var4 = this.head;
                    if (c0Var4 != null) {
                        kotlin.jvm.internal.E.c(c0Var4);
                        c0Var = c0Var4.prev;
                    } else {
                        c0Var = null;
                    }
                    if (c0Var != null && c0Var.owner) {
                        if ((((long) c0Var.limit) + j6) - ((long) (c0Var.shared ? 0 : c0Var.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            c0 c0Var5 = source.head;
                            kotlin.jvm.internal.E.c(c0Var5);
                            c0Var5.writeTo(c0Var, (int) j6);
                            source.f76a = source.size() - j6;
                            this.f76a = size() + j6;
                            return;
                        }
                    }
                    c0 c0Var6 = source.head;
                    kotlin.jvm.internal.E.c(c0Var6);
                    source.head = c0Var6.split((int) j6);
                }
                c0 c0Var7 = source.head;
                kotlin.jvm.internal.E.c(c0Var7);
                long j7 = c0Var7.limit - c0Var7.pos;
                source.head = c0Var7.pop();
                c0 c0Var8 = this.head;
                if (c0Var8 == null) {
                    this.head = c0Var7;
                    c0Var7.prev = c0Var7;
                    c0Var7.next = c0Var7;
                } else {
                    kotlin.jvm.internal.E.c(c0Var8);
                    c0 c0Var9 = c0Var8.prev;
                    kotlin.jvm.internal.E.c(c0Var9);
                    c0Var9.push(c0Var7).a();
                }
                source.f76a = source.size() - j7;
                this.f76a = size() + j7;
                j6 -= j7;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
