package p134x2;

import X3.AbstractC0239e;
import X3.C0241g;
import X3.b0;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: x2.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1845a {
    public static final C1845a INSTANCE = new C1845a();

    public final byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        E.f(byte_1, "byte_1");
        E.f(byte_2, "byte_2");
        byte[] bArr = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, bArr, 0, byte_1.length);
        System.arraycopy(byte_2, 0, bArr, byte_1.length, byte_2.length);
        return bArr;
    }

    public final String byteToHex(byte b) {
        return String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
    }

    public final String byteToString(byte[] bytes) {
        E.f(bytes, "bytes");
        try {
            byte[] bArrFilterZeroBytes = filterZeroBytes(bytes);
            Charset charsetForName = Charset.forName("utf-8");
            E.e(charsetForName, "forName(charsetName)");
            return new String(bArrFilterZeroBytes, charsetForName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public final byte[] filterZeroBytes(byte[] bytes) {
        E.f(bytes, "bytes");
        ArrayList arrayList = new ArrayList();
        for (byte b : bytes) {
            if (b != 0) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        byte[] bArr = new byte[arrayList.size()];
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            bArr[i5] = ((Number) arrayList.get(i5)).byteValue();
        }
        return bArr;
    }

    public final byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Locale locale = Locale.getDefault();
        E.e(locale, "getDefault(...)");
        String upperCase = str.toUpperCase(locale);
        E.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        E.e(charArray, "this as java.lang.String).toCharArray()");
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) (((byte) b0.d("0123456789ABCDEF", charArray[i6 + 1], 0, false, 6)) | (((byte) b0.d("0123456789ABCDEF", charArray[i6], 0, false, 6)) << 4));
        }
        return bArr;
    }

    public final long unsignedLong(byte[] bytes) {
        E.f(bytes, "bytes");
        long j6 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            j6 |= (((long) bytes[i5]) & 255) << (i5 * 8);
        }
        return j6;
    }

    public final int unsignedShort(byte[] bytes) {
        E.f(bytes, "bytes");
        return (bytes[0] & UnsignedBytes.MAX_VALUE) | ((bytes[1] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public final byte byteToHex(String value) {
        E.f(value, "value");
        return (byte) Integer.parseInt(value, AbstractC0239e.checkRadix(16));
    }

    public final byte[] unsignedLong(long j6) {
        return new byte[]{(byte) (j6 & 255), (byte) ((j6 >> 8) & 255), (byte) ((j6 >> 16) & 255), (byte) ((j6 >> 24) & 255)};
    }

    public final byte[] byteToString(String value, int i5) {
        E.f(value, "value");
        byte[] bytes = value.getBytes(C0241g.UTF_8);
        E.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrCopyOf = Arrays.copyOf(bytes, i5);
        E.e(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public final byte[] unsignedShort(int i5) {
        return new byte[]{(byte) (((long) i5) & 255), (byte) (((long) (i5 >> 8)) & 255)};
    }
}
