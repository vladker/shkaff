package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjc {
    public static final /* synthetic */ int zza = 0;

    static {
        int i5 = zzfc.zza;
    }

    public static int zza(String str, byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int length = str.length();
        int i10 = 0;
        while (true) {
            i7 = i5 + i6;
            if (i10 >= length || (i9 = i10 + i5) >= i7 || (cCharAt = str.charAt(i10)) >= 128) {
                break;
            }
            bArr[i9] = (byte) cCharAt;
            i10++;
        }
        if (i10 == length) {
            return i5 + length;
        }
        int i11 = i5 + i10;
        while (i10 < length) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 128 && i11 < i7) {
                bArr[i11] = (byte) cCharAt2;
                i11++;
            } else if (cCharAt2 < 2048 && i11 <= i7 - 2) {
                bArr[i11] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i11 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i11 > i7 - 3) {
                    if (i11 > i7 - 4) {
                        if (cCharAt2 < 55296 || cCharAt2 > 57343 || ((i8 = i10 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i8)))) {
                            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                        }
                        return zziz.zza(str, bArr, i5, i6);
                    }
                    i10++;
                    if (i10 != str.length()) {
                        char cCharAt3 = str.charAt(i10);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i12 = i11 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i11 += 4;
                            bArr[i12] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    return zziz.zza(str, bArr, i5, i6);
                }
                bArr[i11] = (byte) ((cCharAt2 >>> '\f') | Videoio.CAP_PROP_XI_CC_MATRIX_01);
                bArr[i11 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i11 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i11 += 3;
            }
            i10++;
        }
        return i11;
    }

    public static boolean zzb(byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return true;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            byte b = bArr[i5];
            if (b >= 0) {
                i5 = i7;
            } else {
                if (b < -32) {
                    if (i7 < i6 && b >= -62) {
                        i5 += 2;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return false;
                }
                if (b >= -16) {
                    if (i7 >= i6 - 2) {
                        return false;
                    }
                    int i8 = i5 + 2;
                    byte b6 = bArr[i7];
                    if (b6 <= -65) {
                        if ((((b6 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                            int i9 = i5 + 3;
                            if (bArr[i8] <= -65) {
                                i5 += 4;
                                if (bArr[i9] > -65) {
                                }
                            }
                        }
                    }
                    return false;
                }
                if (i7 >= i6 - 1) {
                    return false;
                }
                int i10 = i5 + 2;
                byte b7 = bArr[i7];
                if (b7 > -65 || (b == -32 && b7 < -96)) {
                    return false;
                }
                if (b == -19 && b7 >= -96) {
                    return false;
                }
                i5 += 3;
                if (bArr[i10] > -65) {
                    return false;
                }
            }
        }
        return true;
    }
}
