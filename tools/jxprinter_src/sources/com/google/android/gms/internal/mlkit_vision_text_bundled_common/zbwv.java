package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwv {
    public static final /* synthetic */ int zba = 0;

    static {
        if (zbws.zbx() && zbws.zby()) {
            int i5 = zbsm.zba;
        }
    }

    public static /* bridge */ /* synthetic */ int zba(byte[] bArr, int i5, int i6) {
        int i7 = i6 - i5;
        byte b = bArr[i5 - 1];
        if (i7 == 0) {
            if (b <= -12) {
                return b;
            }
            return -1;
        }
        if (i7 == 1) {
            byte b6 = bArr[i5];
            if (b > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        byte b7 = bArr[i5];
        byte b8 = bArr[i5 + 1];
        if (b > -12 || b7 > -65 || b8 > -65) {
            return -1;
        }
        return (b8 << 16) ^ ((b7 << 8) ^ b);
    }

    public static int zbb(String str, byte[] bArr, int i5, int i6) {
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
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i8 = i10 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i8)))) {
                            throw new zbwu(i10, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i11);
                    }
                    int i12 = i10 + 1;
                    if (i12 != str.length()) {
                        char cCharAt3 = str.charAt(i12);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i13 = i11 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i11 += 4;
                            bArr[i13] = (byte) ((codePoint & 63) | 128);
                            i10 = i12;
                        } else {
                            i10 = i12;
                        }
                    }
                    throw new zbwu(i10 - 1, length);
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

    public static int zbc(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt >= 2048) {
                int length2 = str.length();
                while (i6 < length2) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 < 2048) {
                        i5 += (127 - cCharAt2) >>> 31;
                    } else {
                        i5 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new zbwu(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i7 += i5;
                break;
            }
            i7 += (127 - cCharAt) >>> 31;
            i6++;
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i7) + 4294967296L));
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zbd(byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return true;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            int iZba = bArr[i5];
            if (iZba >= 0) {
                i5 = i7;
            } else if (iZba < -32) {
                if (i7 >= i6) {
                    if (iZba != 0) {
                        return false;
                    }
                    return true;
                }
                if (iZba < -62) {
                    return false;
                }
                i5 += 2;
                if (bArr[i7] > -65) {
                    return false;
                }
            } else if (iZba < -16) {
                if (i7 >= i6 - 1) {
                    iZba = zba(bArr, i7, i6);
                    if (iZba != 0) {
                        return false;
                    }
                    return true;
                }
                int i8 = i5 + 2;
                char c = bArr[i7];
                if (c > -65) {
                    return false;
                }
                if (iZba == -32 && c < -96) {
                    return false;
                }
                if (iZba == -19 && c >= -96) {
                    return false;
                }
                i5 += 3;
                if (bArr[i8] > -65) {
                    return false;
                }
            } else {
                if (i7 >= i6 - 2) {
                    iZba = zba(bArr, i7, i6);
                    if (iZba != 0) {
                        return false;
                    }
                    return true;
                }
                int i9 = i5 + 2;
                int i10 = bArr[i7];
                if (i10 > -65) {
                    return false;
                }
                if ((((i10 + 112) + (iZba << 28)) >> 30) != 0) {
                    return false;
                }
                int i11 = i5 + 3;
                if (bArr[i9] > -65) {
                    return false;
                }
                i5 += 4;
                if (bArr[i11] > -65) {
                    return false;
                }
            }
        }
        return true;
    }
}
