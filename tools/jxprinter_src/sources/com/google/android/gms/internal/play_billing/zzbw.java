package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbw {
    public static int zza(int i5, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i6 <= i5) {
            return i5;
        }
        int i7 = i5 + (i5 >> 1) + 1;
        if (i7 < i6) {
            int iHighestOneBit = Integer.highestOneBit(i6 - 1);
            i7 = iHighestOneBit + iHighestOneBit;
        }
        if (i7 < 0) {
            return Integer.MAX_VALUE;
        }
        return i7;
    }
}
