package org.apache.xmlbeans.impl.util;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class HexBin {
    private static final int BASELENGTH = 255;
    private static final int LOOKUPLENGTH = 16;
    private static final byte[] hexNumberTable = new byte[255];
    private static final byte[] lookUpHexAlphabet = new byte[16];

    static {
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < 255; i7++) {
            hexNumberTable[i7] = -1;
        }
        for (int i8 = 57; i8 >= 48; i8--) {
            hexNumberTable[i8] = (byte) (i8 - 48);
        }
        for (int i9 = 70; i9 >= 65; i9--) {
            hexNumberTable[i9] = (byte) (i9 - 55);
        }
        for (int i10 = 102; i10 >= 97; i10--) {
            hexNumberTable[i10] = (byte) (i10 - 87);
        }
        while (true) {
            if (i6 >= 10) {
                break;
            }
            lookUpHexAlphabet[i6] = (byte) (i6 + 48);
            i6++;
        }
        for (i5 = 10; i5 <= 15; i5++) {
            lookUpHexAlphabet[i5] = (byte) (i5 + 55);
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(encode(bArr), StandardCharsets.ISO_8859_1);
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length % 2 != 0) {
            return null;
        }
        int i5 = length / 2;
        byte[] bArr2 = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 * 2;
            if (isHex(bArr[i7])) {
                int i8 = i7 + 1;
                if (isHex(bArr[i8])) {
                    byte[] bArr3 = hexNumberTable;
                    bArr2[i6] = (byte) ((bArr3[bArr[i7]] << 4) | bArr3[bArr[i8]]);
                }
            }
            return null;
        }
        return bArr2;
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            byte[] bArr3 = lookUpHexAlphabet;
            bArr2[i6] = bArr3[(bArr[i5] >> 4) & 15];
            bArr2[i6 + 1] = bArr3[bArr[i5] & 15];
        }
        return bArr2;
    }

    public static boolean isHex(byte b) {
        return hexNumberTable[b] != -1;
    }

    public static byte[] stringToBytes(String str) {
        return decode(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static String encode(String str) {
        byte[] bArrEncode;
        if (str == null || (bArrEncode = encode(str.getBytes(StandardCharsets.UTF_8))) == null) {
            return null;
        }
        return new String(bArrEncode, StandardCharsets.ISO_8859_1);
    }

    public static String decode(String str) {
        byte[] bArrDecode;
        if (str == null || (bArrDecode = decode(str.getBytes(StandardCharsets.ISO_8859_1))) == null) {
            return null;
        }
        return new String(bArrDecode, StandardCharsets.UTF_8);
    }
}
