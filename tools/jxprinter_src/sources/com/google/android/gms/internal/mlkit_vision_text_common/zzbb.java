package com.google.android.gms.internal.mlkit_vision_text_common;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbb {
    public static int zza(int i5) {
        return (i5 + 1) * (i5 < 32 ? 4 : 2);
    }

    public static int zzb(Object obj, Object obj2, int i5, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iZza = zzbc.zza(obj);
        int i6 = iZza & i5;
        int iZzc = zzc(obj3, i6);
        if (iZzc != 0) {
            int i7 = ~i5;
            int i8 = iZza & i7;
            int i9 = -1;
            while (true) {
                int i10 = iZzc - 1;
                int i11 = iArr[i10];
                int i12 = i11 & i5;
                if ((i11 & i7) != i8 || !zzw.zza(obj, objArr[i10]) || (objArr2 != null && !zzw.zza(obj2, objArr2[i10]))) {
                    if (i12 == 0) {
                        break;
                    }
                    i9 = i10;
                    iZzc = i12;
                } else {
                    if (i9 == -1) {
                        zze(obj3, i6, i12);
                        return i10;
                    }
                    iArr[i9] = (iArr[i9] & i7) | (i12 & i5);
                    return i10;
                }
            }
        }
        return -1;
    }

    public static int zzc(Object obj, int i5) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i5] & UnsignedBytes.MAX_VALUE;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i5] : ((int[]) obj)[i5];
    }

    public static Object zzd(int i5) {
        if (i5 < 2 || i5 > 1073741824 || Integer.highestOneBit(i5) != i5) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i5 <= 256) {
            return new byte[i5];
        }
        return i5 <= 65536 ? new short[i5] : new int[i5];
    }

    public static void zze(Object obj, int i5, int i6) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i5] = (byte) i6;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i5] = (short) i6;
        } else {
            ((int[]) obj)[i5] = i6;
        }
    }
}
