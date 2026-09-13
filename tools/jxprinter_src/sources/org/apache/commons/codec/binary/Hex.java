package org.apache.commons.codec.binary;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private final Charset charset;
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Hex() {
        this.charset = DEFAULT_CHARSET;
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        byte[] bArr = new byte[cArr.length >> 1];
        decodeHex(cArr, bArr, 0);
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    private static byte[] toByteArray(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            byte[] bArrArray = byteBuffer.array();
            if (iRemaining == bArrArray.length) {
                byteBuffer.position(iRemaining);
                return bArrArray;
            }
        }
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int toDigit(char c, int i5) throws DecoderException {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new DecoderException("Illegal hexadecimal character " + c + " at index " + i5);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return decodeHex(new String(bArr, getCharset()).toCharArray());
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeHexString(bArr).getBytes(getCharset());
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.charset + "]";
    }

    public static char[] encodeHex(byte[] bArr, boolean z6) {
        return encodeHex(bArr, z6 ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static String encodeHexString(byte[] bArr, boolean z6) {
        return new String(encodeHex(bArr, z6));
    }

    public byte[] decode(ByteBuffer byteBuffer) {
        return decodeHex(new String(toByteArray(byteBuffer), getCharset()).toCharArray());
    }

    public byte[] encode(ByteBuffer byteBuffer) {
        return encodeHexString(byteBuffer).getBytes(getCharset());
    }

    public Hex(Charset charset) {
        this.charset = charset;
    }

    public static int decodeHex(char[] cArr, byte[] bArr, int i5) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            int i6 = length >> 1;
            if (bArr.length - i5 < i6) {
                throw new DecoderException("Output array is not large enough to accommodate decoded data.");
            }
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7 + 1;
                int digit = (toDigit(cArr[i7], i7) << 4) | toDigit(cArr[i8], i8);
                i7 += 2;
                bArr[i5] = (byte) (digit & 255);
                i5++;
            }
            return i6;
        }
        throw new DecoderException("Odd number of characters.");
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        encodeHex(bArr, 0, bArr.length, cArr, cArr2, 0);
        return cArr2;
    }

    public static String encodeHexString(ByteBuffer byteBuffer) {
        return new String(encodeHex(byteBuffer));
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof String) {
            return decode(((String) obj).toCharArray());
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof ByteBuffer) {
            return decode((ByteBuffer) obj);
        }
        try {
            return decodeHex((char[]) obj);
        } catch (ClassCastException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        byte[] byteArray;
        if (obj instanceof String) {
            byteArray = ((String) obj).getBytes(getCharset());
        } else if (obj instanceof ByteBuffer) {
            byteArray = toByteArray((ByteBuffer) obj);
        } else {
            try {
                byteArray = (byte[]) obj;
            } catch (ClassCastException e) {
                throw new EncoderException(e.getMessage(), e);
            }
        }
        return encodeHex(byteArray);
    }

    public static String encodeHexString(ByteBuffer byteBuffer, boolean z6) {
        return new String(encodeHex(byteBuffer, z6));
    }

    public Hex(String str) {
        this(Charset.forName(str));
    }

    public static char[] encodeHex(byte[] bArr, int i5, int i6, boolean z6) {
        char[] cArr = new char[i6 << 1];
        encodeHex(bArr, i5, i6, z6 ? DIGITS_LOWER : DIGITS_UPPER, cArr, 0);
        return cArr;
    }

    public static void encodeHex(byte[] bArr, int i5, int i6, boolean z6, char[] cArr, int i7) {
        encodeHex(bArr, i5, i6, z6 ? DIGITS_LOWER : DIGITS_UPPER, cArr, i7);
    }

    private static void encodeHex(byte[] bArr, int i5, int i6, char[] cArr, char[] cArr2, int i7) {
        for (int i8 = i5; i8 < i5 + i6; i8++) {
            int i9 = i7 + 1;
            byte b = bArr[i8];
            cArr2[i7] = cArr[(b & 240) >>> 4];
            i7 += 2;
            cArr2[i9] = cArr[b & 15];
        }
    }

    public static byte[] decodeHex(String str) {
        return decodeHex(str.toCharArray());
    }

    public static char[] encodeHex(ByteBuffer byteBuffer) {
        return encodeHex(byteBuffer, true);
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, boolean z6) {
        return encodeHex(byteBuffer, z6 ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, char[] cArr) {
        return encodeHex(toByteArray(byteBuffer), cArr);
    }
}
