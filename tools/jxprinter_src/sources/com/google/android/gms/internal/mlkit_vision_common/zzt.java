package com.google.android.gms.internal.mlkit_vision_common;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzt {
    public static Object[] zza(Object[] objArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (objArr[i6] == null) {
                throw new NullPointerException(AbstractC0157z.k(i6, "at index "));
            }
        }
        return objArr;
    }
}
