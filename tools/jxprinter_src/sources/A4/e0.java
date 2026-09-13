package A4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends C0173p {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(byte[][] segments, int[] directory) {
        super(C0173p.EMPTY.getData$okio());
        kotlin.jvm.internal.E.f(segments, "segments");
        kotlin.jvm.internal.E.f(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final Object writeReplace() {
        return d();
    }

    @Override // A4.C0173p
    public final int a() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // A4.C0173p
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        kotlin.jvm.internal.E.e(byteBufferAsReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // A4.C0173p
    public final byte b(int i5) {
        AbstractC0159b.a(getDirectory$okio()[getSegments$okio().length - 1], i5, 1L);
        int iSegment = B4.h.segment(this, i5);
        return getSegments$okio()[iSegment][(i5 - (iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1])) + getDirectory$okio()[getSegments$okio().length + iSegment]];
    }

    @Override // A4.C0173p
    public String base64() {
        return d().base64();
    }

    @Override // A4.C0173p
    public String base64Url() {
        return d().base64Url();
    }

    @Override // A4.C0173p
    public void copyInto(int i5, byte[] target, int i6, int i7) {
        kotlin.jvm.internal.E.f(target, "target");
        long j6 = i7;
        AbstractC0159b.a(size(), i5, j6);
        AbstractC0159b.a(target.length, i6, j6);
        int i8 = i7 + i5;
        int iSegment = B4.h.segment(this, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i10 = getDirectory$okio()[iSegment] - i9;
            int i11 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            int i12 = (i5 - i9) + i11;
            AbstractC0151t.copyInto(getSegments$okio()[iSegment], target, i6, i12, i12 + iMin);
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
    }

    public final C0173p d() {
        return new C0173p(toByteArray());
    }

    @Override // A4.C0173p
    public C0173p digest$okio(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = getDirectory$okio()[length + i5];
            int i8 = getDirectory$okio()[i5];
            messageDigest.update(getSegments$okio()[i5], i7, i8 - i6);
            i5++;
            i6 = i8;
        }
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.E.e(digestBytes, "digestBytes");
        return new C0173p(digestBytes);
    }

    @Override // A4.C0173p
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0173p) {
            C0173p c0173p = (C0173p) obj;
            if (c0173p.size() == size() && rangeEquals(0, c0173p, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // A4.C0173p
    public final int hashCode() {
        int i5 = this.f77a;
        if (i5 != 0) {
            return i5;
        }
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            int i9 = getDirectory$okio()[length + i6];
            int i10 = getDirectory$okio()[i6];
            byte[] bArr = getSegments$okio()[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        this.f77a = i7;
        return i7;
    }

    @Override // A4.C0173p
    public String hex() {
        return d().hex();
    }

    @Override // A4.C0173p
    public C0173p hmac$okio(String algorithm, C0173p key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        kotlin.jvm.internal.E.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = getDirectory$okio()[length + i5];
                int i8 = getDirectory$okio()[i5];
                mac.update(getSegments$okio()[i5], i7, i8 - i6);
                i5++;
                i6 = i8;
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.E.e(bArrDoFinal, "mac.doFinal()");
            return new C0173p(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // A4.C0173p
    public int indexOf(byte[] other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        return d().indexOf(other, i5);
    }

    @Override // A4.C0173p
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // A4.C0173p
    public int lastIndexOf(byte[] other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        return d().lastIndexOf(other, i5);
    }

    @Override // A4.C0173p
    public boolean rangeEquals(int i5, C0173p other, int i6, int i7) {
        kotlin.jvm.internal.E.f(other, "other");
        if (i5 < 0 || i5 > size() - i7) {
            return false;
        }
        int i8 = i7 + i5;
        int iSegment = B4.h.segment(this, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i10 = getDirectory$okio()[iSegment] - i9;
            int i11 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            if (!other.rangeEquals(i6, getSegments$okio()[iSegment], (i5 - i9) + i11, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // A4.C0173p
    public String string(Charset charset) {
        kotlin.jvm.internal.E.f(charset, "charset");
        return d().string(charset);
    }

    @Override // A4.C0173p
    public C0173p substring(int i5, int i6) {
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(this, i6);
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "beginIndex=", " < 0").toString());
        }
        if (iResolveDefaultParameter > size()) {
            StringBuilder sbT = AbstractC0157z.t(iResolveDefaultParameter, "endIndex=", " > length(");
            sbT.append(size());
            sbT.append(')');
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        int i7 = iResolveDefaultParameter - i5;
        if (i7 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.h(iResolveDefaultParameter, i5, "endIndex=", " < beginIndex=").toString());
        }
        if (i5 == 0 && iResolveDefaultParameter == size()) {
            return this;
        }
        if (i5 == iResolveDefaultParameter) {
            return C0173p.EMPTY;
        }
        int iSegment = B4.h.segment(this, i5);
        int iSegment2 = B4.h.segment(this, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) AbstractC0151t.copyOfRange(getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i8 = iSegment;
            int i9 = 0;
            while (true) {
                iArr[i9] = Math.min(getDirectory$okio()[i8] - i5, i7);
                int i10 = i9 + 1;
                iArr[i9 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i8];
                if (i8 == iSegment2) {
                    break;
                }
                i8++;
                i9 = i10;
            }
        }
        int i11 = iSegment != 0 ? getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i5 - i11) + iArr[length];
        return new e0(bArr, iArr);
    }

    @Override // A4.C0173p
    public C0173p toAsciiLowercase() {
        return d().toAsciiLowercase();
    }

    @Override // A4.C0173p
    public C0173p toAsciiUppercase() {
        return d().toAsciiUppercase();
    }

    @Override // A4.C0173p
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int i8 = getDirectory$okio()[length + i5];
            int i9 = getDirectory$okio()[i5];
            int i10 = i9 - i6;
            AbstractC0151t.copyInto(getSegments$okio()[i5], bArr, i7, i8, i8 + i10);
            i7 += i10;
            i5++;
            i6 = i9;
        }
        return bArr;
    }

    @Override // A4.C0173p
    public String toString() {
        return d().toString();
    }

    @Override // A4.C0173p
    public void write(OutputStream out) throws IOException {
        kotlin.jvm.internal.E.f(out, "out");
        int length = getSegments$okio().length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = getDirectory$okio()[length + i5];
            int i8 = getDirectory$okio()[i5];
            out.write(getSegments$okio()[i5], i7, i8 - i6);
            i5++;
            i6 = i8;
        }
    }

    @Override // A4.C0173p
    public void write$okio(C0169l buffer, int i5, int i6) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        int i7 = i5 + i6;
        int iSegment = B4.h.segment(this, i5);
        while (i5 < i7) {
            int i8 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i9 = getDirectory$okio()[iSegment] - i8;
            int i10 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i7, i9 + i8) - i5;
            int i11 = (i5 - i8) + i10;
            c0 c0Var = new c0(getSegments$okio()[iSegment], i11, i11 + iMin, true, false);
            c0 c0Var2 = buffer.head;
            if (c0Var2 == null) {
                c0Var.prev = c0Var;
                c0Var.next = c0Var;
                buffer.head = c0Var;
            } else {
                kotlin.jvm.internal.E.c(c0Var2);
                c0 c0Var3 = c0Var2.prev;
                kotlin.jvm.internal.E.c(c0Var3);
                c0Var3.push(c0Var);
            }
            i5 += iMin;
            iSegment++;
        }
        buffer.f76a = buffer.size() + ((long) i6);
    }

    @Override // A4.C0173p
    public boolean rangeEquals(int i5, byte[] other, int i6, int i7) {
        kotlin.jvm.internal.E.f(other, "other");
        if (i5 < 0 || i5 > size() - i7 || i6 < 0 || i6 > other.length - i7) {
            return false;
        }
        int i8 = i7 + i5;
        int iSegment = B4.h.segment(this, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i10 = getDirectory$okio()[iSegment] - i9;
            int i11 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            if (!AbstractC0159b.arrayRangeEquals(getSegments$okio()[iSegment], (i5 - i9) + i11, other, i6, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
        return true;
    }
}
