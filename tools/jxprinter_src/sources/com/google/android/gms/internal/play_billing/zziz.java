package com.google.android.gms.internal.play_billing;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zziz {
    public static final int zza(String str, byte[] bArr, int i5, int i6) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        if (length - i5 > i6) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i5, length);
        return i5 + length;
    }

    public static int zzb(String str) {
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
                try {
                    int i8 = zzjc.zza;
                    int length2 = str.length();
                    while (i6 < length2) {
                        char cCharAt2 = str.charAt(i6);
                        if (cCharAt2 < 2048) {
                            i5 += (127 - cCharAt2) >>> 31;
                        } else {
                            i5 += 2;
                            if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                                if (Character.codePointAt(str, i6) < 65536) {
                                    throw new zzjb(i6, length2);
                                }
                                i6++;
                            }
                        }
                        i6++;
                    }
                    i7 += i5;
                    break;
                } catch (zzjb unused) {
                    return str.getBytes(StandardCharsets.UTF_8).length;
                }
            }
            i7 += (127 - cCharAt) >>> 31;
            i6++;
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i7) + 4294967296L));
    }
}
