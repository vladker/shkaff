package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i5, int i6, int i7) {
        int i8;
        int i9 = i5;
        while (true) {
            i8 = (i6 & (-4)) + i5;
            if (i9 >= i8) {
                break;
            }
            int i10 = ((bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16) | (bArr[i9 + 3] << 24)) * ScatterMapKt.MurmurHashC1;
            int i11 = i7 ^ (((i10 >>> 17) | (i10 << 15)) * 461845907);
            i7 = (((i11 >>> 19) | (i11 << 13)) * 5) - 430675100;
            i9 += 4;
        }
        int i12 = i6 & 3;
        int i13 = 0;
        if (i12 == 1) {
            int i14 = ((bArr[i8] & 255) | i13) * ScatterMapKt.MurmurHashC1;
            i7 ^= ((i14 >>> 17) | (i14 << 15)) * 461845907;
        } else {
            if (i12 != 2) {
                i13 = i12 == 3 ? (bArr[i8 + 2] & 255) << 16 : 0;
            }
            i13 |= (bArr[i8 + 1] & 255) << 8;
            int i15 = ((bArr[i8] & 255) | i13) * ScatterMapKt.MurmurHashC1;
            i7 ^= ((i15 >>> 17) | (i15 << 15)) * 461845907;
        }
        int i16 = i7 ^ i6;
        int i17 = (i16 ^ (i16 >>> 16)) * (-2048144789);
        int i18 = (i17 ^ (i17 >>> 13)) * (-1028477387);
        return i18 ^ (i18 >>> 16);
    }
}
