package B4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A4.AbstractC0158a;
import A4.AbstractC0159b;
import A4.C0169l;
import A4.C0173p;
import A4.n0;
import X3.W;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(byte[] bArr) {
        byte b;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            byte b6 = bArr[i6];
            if (b6 >= 0) {
                int i9 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if (b6 != 10 && b6 != 13) {
                    if (b6 >= 0 && b6 < 32) {
                        return -1;
                    }
                    if (127 <= b6 && b6 < 160) {
                        return -1;
                    }
                }
                if (b6 == 65533) {
                    return -1;
                }
                i7 += b6 < 65536 ? 1 : 2;
                i6++;
                while (true) {
                    i8 = i9;
                    if (i6 >= length || (b = bArr[i6]) < 0) {
                        break;
                    }
                    i6++;
                    i9 = i8 + 1;
                    if (i8 == 64) {
                        return i7;
                    }
                    if (b != 10 && b != 13) {
                        if (b >= 0 && b < 32) {
                            return -1;
                        }
                        if (127 <= b && b < 160) {
                            return -1;
                        }
                    }
                    if (b == 65533) {
                        return -1;
                    }
                    i7 += b < 65536 ? 1 : 2;
                }
            } else if ((b6 >> 5) == -2) {
                int i10 = i6 + 1;
                if (length <= i10) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b7 = bArr[i10];
                if ((b7 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                int i11 = (b6 << 6) ^ (b7 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                if (i11 < 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                int i12 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if (i11 != 10 && i11 != 13) {
                    if (i11 >= 0 && i11 < 32) {
                        return -1;
                    }
                    if (127 <= i11 && i11 < 160) {
                        return -1;
                    }
                }
                if (i11 == 65533) {
                    return -1;
                }
                i7 += i11 < 65536 ? 1 : 2;
                i6 += 2;
                i8 = i12;
            } else if ((b6 >> 4) == -2) {
                int i13 = i6 + 2;
                if (length <= i13) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b8 = bArr[i6 + 1];
                if ((b8 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b9 = bArr[i13];
                if ((b9 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                int i14 = (b6 << 12) ^ ((b9 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b8 << 6));
                if (i14 < 2048) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                if (55296 <= i14 && i14 < 57344) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                i5 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if (i14 != 10 && i14 != 13) {
                    if (i14 >= 0 && i14 < 32) {
                        return -1;
                    }
                    if (127 <= i14 && i14 < 160) {
                        return -1;
                    }
                }
                if (i14 == 65533) {
                    return -1;
                }
                i7 += i14 < 65536 ? 1 : 2;
                i6 += 3;
                i8 = i5;
            } else {
                if ((b6 >> 3) != -2) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                int i15 = i6 + 3;
                if (length <= i15) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b10 = bArr[i6 + 1];
                if ((b10 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b11 = bArr[i6 + 2];
                if ((b11 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                byte b12 = bArr[i15];
                if ((b12 & 192) != 128) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                int i16 = (b6 << 18) ^ (((b12 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b11 << 6)) ^ (b10 << 12));
                if (i16 > 1114111) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                if (55296 <= i16 && i16 < 57344) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                if (i16 < 65536) {
                    if (i8 == 64) {
                        break;
                    }
                    return -1;
                }
                i5 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if (i16 != 10 && i16 != 13) {
                    if (i16 >= 0 && i16 < 32) {
                        return -1;
                    }
                    if (127 <= i16 && i16 < 160) {
                        return -1;
                    }
                }
                if (i16 == 65533) {
                    return -1;
                }
                i7 += i16 < 65536 ? 1 : 2;
                i6 += 4;
                i8 = i5;
            }
        }
        return i7;
    }

    public static final int b(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Unexpected hex digit: ", c));
        }
        return c - '7';
    }

    public static final String commonBase64(C0173p c0173p) {
        E.f(c0173p, "<this>");
        return AbstractC0158a.encodeBase64(c0173p.getData$okio(), AbstractC0158a.BASE64);
    }

    public static final String commonBase64Url(C0173p c0173p) {
        E.f(c0173p, "<this>");
        return AbstractC0158a.encodeBase64(c0173p.getData$okio(), AbstractC0158a.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(C0173p c0173p, C0173p other) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        int size = c0173p.size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = c0173p.getByte(i5) & UnsignedBytes.MAX_VALUE;
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

    public static final void commonCopyInto(C0173p c0173p, int i5, byte[] target, int i6, int i7) {
        E.f(c0173p, "<this>");
        E.f(target, "target");
        AbstractC0151t.copyInto(c0173p.getData$okio(), target, i6, i5, i7 + i5);
    }

    public static final C0173p commonDecodeBase64(String str) {
        E.f(str, "<this>");
        byte[] bArrDecodeBase64ToArray = AbstractC0158a.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new C0173p(bArrDecodeBase64ToArray);
        }
        return null;
    }

    public static final C0173p commonDecodeHex(String str) {
        E.f(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) (b(str.charAt(i6 + 1)) + (b(str.charAt(i6)) << 4));
        }
        return new C0173p(bArr);
    }

    public static final C0173p commonEncodeUtf8(String str) {
        E.f(str, "<this>");
        C0173p c0173p = new C0173p(n0.asUtf8ToByteArray(str));
        c0173p.setUtf8$okio(str);
        return c0173p;
    }

    public static final boolean commonEndsWith(C0173p c0173p, C0173p suffix) {
        E.f(c0173p, "<this>");
        E.f(suffix, "suffix");
        return c0173p.rangeEquals(c0173p.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(C0173p c0173p, Object obj) {
        E.f(c0173p, "<this>");
        if (obj == c0173p) {
            return true;
        }
        if (obj instanceof C0173p) {
            C0173p c0173p2 = (C0173p) obj;
            if (c0173p2.size() == c0173p.getData$okio().length && c0173p2.rangeEquals(0, c0173p.getData$okio(), 0, c0173p.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(C0173p c0173p, int i5) {
        E.f(c0173p, "<this>");
        return c0173p.getData$okio()[i5];
    }

    public static final int commonGetSize(C0173p c0173p) {
        E.f(c0173p, "<this>");
        return c0173p.getData$okio().length;
    }

    public static final int commonHashCode(C0173p c0173p) {
        E.f(c0173p, "<this>");
        int i5 = c0173p.f77a;
        if (i5 != 0) {
            return i5;
        }
        int iHashCode = Arrays.hashCode(c0173p.getData$okio());
        c0173p.f77a = iHashCode;
        return iHashCode;
    }

    public static final String commonHex(C0173p c0173p) {
        E.f(c0173p, "<this>");
        char[] cArr = new char[c0173p.getData$okio().length * 2];
        int i5 = 0;
        for (byte b : c0173p.getData$okio()) {
            int i6 = i5 + 1;
            cArr[i5] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i5 += 2;
            cArr[i6] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return W.concatToString(cArr);
    }

    public static final int commonIndexOf(C0173p c0173p, byte[] other, int i5) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        int length = c0173p.getData$okio().length - other.length;
        int iMax = Math.max(i5, 0);
        if (iMax > length) {
            return -1;
        }
        while (!AbstractC0159b.arrayRangeEquals(c0173p.getData$okio(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public static final byte[] commonInternalArray(C0173p c0173p) {
        E.f(c0173p, "<this>");
        return c0173p.getData$okio();
    }

    public static final int commonLastIndexOf(C0173p c0173p, C0173p other, int i5) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        return c0173p.lastIndexOf(other.internalArray$okio(), i5);
    }

    public static final C0173p commonOf(byte[] data) {
        E.f(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        E.e(bArrCopyOf, "copyOf(this, size)");
        return new C0173p(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(C0173p c0173p, int i5, C0173p other, int i6, int i7) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        return other.rangeEquals(i6, c0173p.getData$okio(), i5, i7);
    }

    public static final boolean commonStartsWith(C0173p c0173p, C0173p prefix) {
        E.f(c0173p, "<this>");
        E.f(prefix, "prefix");
        return c0173p.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final C0173p commonSubstring(C0173p c0173p, int i5, int i6) {
        E.f(c0173p, "<this>");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(c0173p, i6);
        if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (iResolveDefaultParameter > c0173p.getData$okio().length) {
            throw new IllegalArgumentException(AbstractC0157z.p(new StringBuilder("endIndex > length("), c0173p.getData$okio().length, ')').toString());
        }
        if (iResolveDefaultParameter - i5 >= 0) {
            return (i5 == 0 && iResolveDefaultParameter == c0173p.getData$okio().length) ? c0173p : new C0173p(AbstractC0151t.copyOfRange(c0173p.getData$okio(), i5, iResolveDefaultParameter));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    public static final C0173p commonToAsciiLowercase(C0173p c0173p) {
        E.f(c0173p, "<this>");
        for (int i5 = 0; i5 < c0173p.getData$okio().length; i5++) {
            byte b = c0173p.getData$okio()[i5];
            if (b >= 65 && b <= 90) {
                byte[] data$okio = c0173p.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                E.e(bArrCopyOf, "copyOf(this, size)");
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
        return c0173p;
    }

    public static final C0173p commonToAsciiUppercase(C0173p c0173p) {
        E.f(c0173p, "<this>");
        for (int i5 = 0; i5 < c0173p.getData$okio().length; i5++) {
            byte b = c0173p.getData$okio()[i5];
            if (b >= 97 && b <= 122) {
                byte[] data$okio = c0173p.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                E.e(bArrCopyOf, "copyOf(this, size)");
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
        return c0173p;
    }

    public static final byte[] commonToByteArray(C0173p c0173p) {
        E.f(c0173p, "<this>");
        byte[] data$okio = c0173p.getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        E.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public static final C0173p commonToByteString(byte[] bArr, int i5, int i6) {
        E.f(bArr, "<this>");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(bArr, i6);
        AbstractC0159b.a(bArr.length, i5, iResolveDefaultParameter);
        return new C0173p(AbstractC0151t.copyOfRange(bArr, i5, iResolveDefaultParameter + i5));
    }

    public static final String commonToString(C0173p c0173p) {
        E.f(c0173p, "<this>");
        if (c0173p.getData$okio().length == 0) {
            return "[size=0]";
        }
        int iA = a(c0173p.getData$okio());
        if (iA != -1) {
            String strUtf8 = c0173p.utf8();
            String strSubstring = strUtf8.substring(0, iA);
            E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strReplace = W.replace(W.replace(W.replace(strSubstring, "\\", "\\\\", false), "\n", "\\n", false), "\r", "\\r", false);
            if (iA >= strUtf8.length()) {
                return "[text=" + strReplace + ']';
            }
            return "[size=" + c0173p.getData$okio().length + " text=" + strReplace + "…]";
        }
        if (c0173p.getData$okio().length <= 64) {
            return "[hex=" + c0173p.hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(c0173p.getData$okio().length);
        sb.append(" hex=");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(c0173p, 64);
        if (iResolveDefaultParameter > c0173p.getData$okio().length) {
            throw new IllegalArgumentException(AbstractC0157z.p(new StringBuilder("endIndex > length("), c0173p.getData$okio().length, ')').toString());
        }
        if (iResolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (iResolveDefaultParameter != c0173p.getData$okio().length) {
            c0173p = new C0173p(AbstractC0151t.copyOfRange(c0173p.getData$okio(), 0, iResolveDefaultParameter));
        }
        sb.append(c0173p.hex());
        sb.append("…]");
        return sb.toString();
    }

    public static final String commonUtf8(C0173p c0173p) {
        E.f(c0173p, "<this>");
        String utf8$okio = c0173p.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = n0.toUtf8String(c0173p.internalArray$okio());
        c0173p.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(C0173p c0173p, C0169l buffer, int i5, int i6) {
        E.f(c0173p, "<this>");
        E.f(buffer, "buffer");
        buffer.write(c0173p.getData$okio(), i5, i6);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(C0173p c0173p, byte[] suffix) {
        E.f(c0173p, "<this>");
        E.f(suffix, "suffix");
        return c0173p.rangeEquals(c0173p.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(C0173p c0173p, byte[] other, int i5) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        for (int iMin = Math.min(AbstractC0159b.resolveDefaultParameter(c0173p, i5), c0173p.getData$okio().length - other.length); -1 < iMin; iMin--) {
            if (AbstractC0159b.arrayRangeEquals(c0173p.getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(C0173p c0173p, int i5, byte[] other, int i6, int i7) {
        E.f(c0173p, "<this>");
        E.f(other, "other");
        return i5 >= 0 && i5 <= c0173p.getData$okio().length - i7 && i6 >= 0 && i6 <= other.length - i7 && AbstractC0159b.arrayRangeEquals(c0173p.getData$okio(), i5, other, i6, i7);
    }

    public static final boolean commonStartsWith(C0173p c0173p, byte[] prefix) {
        E.f(c0173p, "<this>");
        E.f(prefix, "prefix");
        return c0173p.rangeEquals(0, prefix, 0, prefix.length);
    }
}
