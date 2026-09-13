package com.google.android.gms.internal.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzaa(int i5) {
    }

    public final zzaa zza(Object obj) {
        int i5;
        obj.getClass();
        int length = this.zza.length;
        int i6 = this.zzb;
        int i7 = i6 + 1;
        if (i7 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i7 <= length) {
            i5 = length;
        } else {
            i5 = (length >> 1) + length + 1;
            if (i5 < i7) {
                int iHighestOneBit = Integer.highestOneBit(i6);
                i5 = iHighestOneBit + iHighestOneBit;
            }
            if (i5 < 0) {
                i5 = Integer.MAX_VALUE;
            }
        }
        if (i5 > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, i5);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        objArr[i8] = obj;
        return this;
    }
}
