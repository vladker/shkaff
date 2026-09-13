package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String strName = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = strName;
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(strName) || EUC_JP.equalsIgnoreCase(strName);
    }

    private StringUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        boolean z6;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z7 = true;
        int i5 = 0;
        boolean z8 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z9 = true;
        boolean z10 = true;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i7 < length && (z7 || z9 || z10)) {
            byte b = bArr2[i7];
            int i17 = b & UnsignedBytes.MAX_VALUE;
            if (z10) {
                if (i8 <= 0) {
                    z6 = z8;
                    if ((b & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                        if ((b & 64) != 0) {
                            int i18 = i8 + 1;
                            if ((b & 32) == 0) {
                                i10++;
                            } else {
                                i18 = i8 + 2;
                                if ((b & 16) == 0) {
                                    i11++;
                                } else {
                                    i8 += 3;
                                    if ((b & 8) == 0) {
                                        i12++;
                                    }
                                }
                            }
                            i8 = i18;
                        }
                    }
                } else if ((b & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                    i8--;
                    z6 = z8;
                } else {
                    z6 = z8;
                }
                z10 = false;
            } else {
                z6 = z8;
            }
            if (z7) {
                if (i17 > 127 && i17 < 160) {
                    z7 = false;
                } else if (i17 > 159 && (i17 < 192 || i17 == 215 || i17 == 247)) {
                    i14++;
                }
            }
            if (z9) {
                if (i9 > 0) {
                    if (i17 < 64 || i17 == 127 || i17 > 252) {
                        z9 = false;
                    } else {
                        i9--;
                    }
                } else if (i17 == 128 || i17 == 160 || i17 > 239) {
                    z9 = false;
                } else if (i17 <= 160 || i17 >= 224) {
                    if (i17 > 127) {
                        i9++;
                        int i19 = i15 + 1;
                        if (i19 > i5) {
                            i5 = i19;
                            i15 = i5;
                        } else {
                            i15 = i19;
                        }
                    } else {
                        i15 = 0;
                    }
                    i16 = 0;
                } else {
                    i6++;
                    int i20 = i16 + 1;
                    if (i20 > i13) {
                        i13 = i20;
                        i16 = i13;
                    } else {
                        i16 = i20;
                    }
                    i15 = 0;
                }
            }
            i7++;
            bArr2 = bArr;
            z8 = z6;
        }
        boolean z11 = z8;
        if (z10 && i8 > 0) {
            z10 = false;
        }
        if (z9 && i9 > 0) {
            z9 = false;
        }
        if (z10 && (z11 || i10 + i11 + i12 > 0)) {
            return UTF8;
        }
        if (z9 && (ASSUME_SHIFT_JIS || i13 >= 3 || i5 >= 3)) {
            return SHIFT_JIS;
        }
        if (z7 && z9) {
            return (!(i13 == 2 && i6 == 2) && i14 * 10 < length) ? ISO88591 : SHIFT_JIS;
        }
        if (z7) {
            return ISO88591;
        }
        if (z9) {
            return SHIFT_JIS;
        }
        return z10 ? UTF8 : PLATFORM_DEFAULT_ENCODING;
    }
}
