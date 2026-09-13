package com.google.common.base;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Beta
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int iEncodedLengthGeneral = length;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i5);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i5++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        long j6 = ((long) iEncodedLengthGeneral) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j6);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) == cCharAt) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i5));
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i5, int i6) {
        byte b;
        while (i5 < i6) {
            int i7 = i5 + 1;
            byte b6 = bArr[i5];
            if (b6 < 0) {
                if (b6 < -32) {
                    if (i7 != i6 && b6 >= -62) {
                        i5 += 2;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return false;
                }
                if (b6 < -16) {
                    int i8 = i5 + 2;
                    if (i8 < i6 && (b = bArr[i7]) <= -65 && ((b6 != -32 || b >= -96) && (b6 != -19 || -96 > b))) {
                        i5 += 3;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return false;
                }
                if (i5 + 3 >= i6) {
                    return false;
                }
                int i9 = i5 + 2;
                byte b7 = bArr[i7];
                if (b7 <= -65) {
                    if ((((b7 + 112) + (b6 << Ascii.FS)) >> 30) == 0) {
                        int i10 = i5 + 3;
                        if (bArr[i9] <= -65) {
                            i5 += 4;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                }
                return false;
            }
            i5 = i7;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i5) {
        return a.h(39, i5, "Unpaired surrogate at index ");
    }

    public static boolean isWellFormed(byte[] bArr, int i5, int i6) {
        int i7 = i6 + i5;
        Preconditions.checkPositionIndexes(i5, i7, bArr.length);
        while (i5 < i7) {
            if (bArr[i5] < 0) {
                return isWellFormedSlowPath(bArr, i5, i7);
            }
            i5++;
        }
        return true;
    }
}
