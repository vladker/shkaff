package A4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: renamed from: A4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class C0173p implements Serializable, Comparable {
    public static final C0172o Companion = new C0172o();
    public static final C0173p EMPTY = new C0173p(new byte[0]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f77a;
    private final byte[] data;
    private transient String utf8;

    public C0173p(byte[] data) {
        kotlin.jvm.internal.E.f(data, "data");
        this.data = data;
    }

    public static /* synthetic */ C0173p c(int i5, C0173p c0173p, int i6, int i7) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = -1234567890;
        }
        return c0173p.substring(i5, i6);
    }

    public static final C0173p decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final C0173p decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final C0173p encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final C0173p encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static final C0173p of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public static final C0173p read(InputStream inputStream, int i5) {
        return Companion.read(inputStream, i5);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        C0173p c0173p = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = C0173p.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, c0173p.data);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m126deprecated_getByte(int i5) {
        return getByte(i5);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m127deprecated_size() {
        return size();
    }

    public int a() {
        return getData$okio().length;
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        kotlin.jvm.internal.E.e(byteBufferAsReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public byte b(int i5) {
        return getData$okio()[i5];
    }

    public String base64() {
        return AbstractC0158a.encodeBase64(getData$okio(), AbstractC0158a.BASE64);
    }

    public String base64Url() {
        return AbstractC0158a.encodeBase64(getData$okio(), AbstractC0158a.getBASE64_URL_SAFE());
    }

    public void copyInto(int i5, byte[] target, int i6, int i7) {
        kotlin.jvm.internal.E.f(target, "target");
        AbstractC0151t.copyInto(getData$okio(), target, i6, i5, i7 + i5);
    }

    public C0173p digest$okio(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.E.e(digestBytes, "digestBytes");
        return new C0173p(digestBytes);
    }

    public final boolean endsWith(C0173p suffix) {
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0173p) {
            C0173p c0173p = (C0173p) obj;
            if (c0173p.size() == getData$okio().length && c0173p.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i5) {
        return b(i5);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int i5 = this.f77a;
        if (i5 != 0) {
            return i5;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        this.f77a = iHashCode;
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i5 = 0;
        for (byte b : getData$okio()) {
            int i6 = i5 + 1;
            cArr[i5] = B4.b.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i5 += 2;
            cArr[i6] = B4.b.getHEX_DIGIT_CHARS()[b & 15];
        }
        return X3.W.concatToString(cArr);
    }

    public C0173p hmac$okio(String algorithm, C0173p key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        kotlin.jvm.internal.E.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            kotlin.jvm.internal.E.e(bArrDoFinal, "mac.doFinal(data)");
            return new C0173p(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public C0173p hmacSha1(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public C0173p hmacSha256(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public C0173p hmacSha512(C0173p key) {
        kotlin.jvm.internal.E.f(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(C0173p other) {
        kotlin.jvm.internal.E.f(other, "other");
        return indexOf(other, 0);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public final int lastIndexOf(C0173p other) {
        kotlin.jvm.internal.E.f(other, "other");
        return lastIndexOf(other, -1234567890);
    }

    public final C0173p md5() {
        return digest$okio(MessageDigestAlgorithms.MD5);
    }

    public boolean rangeEquals(int i5, C0173p other, int i6, int i7) {
        kotlin.jvm.internal.E.f(other, "other");
        return other.rangeEquals(i6, getData$okio(), i5, i7);
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final C0173p sha1() {
        return digest$okio(MessageDigestAlgorithms.SHA_1);
    }

    public final C0173p sha256() {
        return digest$okio(MessageDigestAlgorithms.SHA_256);
    }

    public final C0173p sha512() {
        return digest$okio(MessageDigestAlgorithms.SHA_512);
    }

    public final int size() {
        return a();
    }

    public final boolean startsWith(C0173p prefix) {
        kotlin.jvm.internal.E.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        kotlin.jvm.internal.E.f(charset, "charset");
        return new String(this.data, charset);
    }

    public final C0173p substring() {
        return c(0, this, 0, 3);
    }

    public C0173p toAsciiLowercase() {
        for (int i5 = 0; i5 < getData$okio().length; i5++) {
            byte b = getData$okio()[i5];
            if (b >= 65 && b <= 90) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i5] = (byte) (b + 32);
                for (int i6 = i5 + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b6 = bArrCopyOf[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArrCopyOf[i6] = (byte) (b6 + 32);
                    }
                }
                return new C0173p(bArrCopyOf);
            }
        }
        return this;
    }

    public C0173p toAsciiUppercase() {
        for (int i5 = 0; i5 < getData$okio().length; i5++) {
            byte b = getData$okio()[i5];
            if (b >= 97 && b <= 122) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i5] = (byte) (b - 32);
                for (int i6 = i5 + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b6 = bArrCopyOf[i6];
                    if (b6 >= 97 && b6 <= 122) {
                        bArrCopyOf[i6] = (byte) (b6 - 32);
                    }
                }
                return new C0173p(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int iA = B4.b.a(getData$okio());
        if (iA != -1) {
            String strUtf8 = utf8();
            String strSubstring = strUtf8.substring(0, iA);
            kotlin.jvm.internal.E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strReplace = X3.W.replace(X3.W.replace(X3.W.replace(strSubstring, "\\", "\\\\", false), "\n", "\\n", false), "\r", "\\r", false);
            if (iA >= strUtf8.length()) {
                return "[text=" + strReplace + ']';
            }
            return "[size=" + getData$okio().length + " text=" + strReplace + "…]";
        }
        if (getData$okio().length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(getData$okio().length);
        sb.append(" hex=");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(this, 64);
        if (iResolveDefaultParameter > getData$okio().length) {
            throw new IllegalArgumentException(AbstractC0157z.p(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
        }
        if (iResolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        sb.append((iResolveDefaultParameter == getData$okio().length ? this : new C0173p(AbstractC0151t.copyOfRange(getData$okio(), 0, iResolveDefaultParameter))).hex());
        sb.append("…]");
        return sb.toString();
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = n0.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream out) throws IOException {
        kotlin.jvm.internal.E.f(out, "out");
        out.write(this.data);
    }

    public void write$okio(C0169l buffer, int i5, int i6) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        B4.b.commonWrite(this, buffer, i5, i6);
    }

    public static final C0173p of(byte... bArr) {
        return Companion.of(bArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(C0173p other) {
        kotlin.jvm.internal.E.f(other, "other");
        int size = size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = getByte(i5) & UnsignedBytes.MAX_VALUE;
            int i7 = other.getByte(i5) & UnsignedBytes.MAX_VALUE;
            if (i6 != i7) {
                return i6 < i7 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] suffix) {
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(C0173p other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        return indexOf(other.internalArray$okio(), i5);
    }

    public final int lastIndexOf(byte[] other) {
        kotlin.jvm.internal.E.f(other, "other");
        return lastIndexOf(other, -1234567890);
    }

    public boolean rangeEquals(int i5, byte[] other, int i6, int i7) {
        kotlin.jvm.internal.E.f(other, "other");
        return i5 >= 0 && i5 <= getData$okio().length - i7 && i6 >= 0 && i6 <= other.length - i7 && AbstractC0159b.arrayRangeEquals(getData$okio(), i5, other, i6, i7);
    }

    public final boolean startsWith(byte[] prefix) {
        kotlin.jvm.internal.E.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final C0173p substring(int i5) {
        return c(i5, this, 0, 2);
    }

    public static final C0173p of(byte[] bArr, int i5, int i6) {
        return Companion.of(bArr, i5, i6);
    }

    public final int indexOf(byte[] other) {
        kotlin.jvm.internal.E.f(other, "other");
        return indexOf(other, 0);
    }

    public final int lastIndexOf(C0173p other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        return lastIndexOf(other.internalArray$okio(), i5);
    }

    public C0173p substring(int i5, int i6) {
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(this, i6);
        if (i5 >= 0) {
            if (iResolveDefaultParameter > getData$okio().length) {
                throw new IllegalArgumentException(AbstractC0157z.p(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
            }
            if (iResolveDefaultParameter - i5 >= 0) {
                return (i5 == 0 && iResolveDefaultParameter == getData$okio().length) ? this : new C0173p(AbstractC0151t.copyOfRange(getData$okio(), i5, iResolveDefaultParameter));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public int indexOf(byte[] other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        int length = getData$okio().length - other.length;
        int iMax = Math.max(i5, 0);
        if (iMax > length) {
            return -1;
        }
        while (!AbstractC0159b.arrayRangeEquals(getData$okio(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public int lastIndexOf(byte[] other, int i5) {
        kotlin.jvm.internal.E.f(other, "other");
        for (int iMin = Math.min(AbstractC0159b.resolveDefaultParameter(this, i5), getData$okio().length - other.length); -1 < iMin; iMin--) {
            if (AbstractC0159b.arrayRangeEquals(getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }
}
