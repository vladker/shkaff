package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
public final class zzc {
    public static int zza(int i5) {
        int[] iArr = {1, 2, 3};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr[i6];
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            }
            if (i8 == i5) {
                return i7;
            }
        }
        return 1;
    }
}
