package com.google.android.gms.internal.mlkit_vision_text_common;

import A3.AbstractC0157z;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzx {
    public static int zza(int i5, int i6, String str) {
        String strZza;
        if (i5 >= 0 && i5 < i6) {
            return i5;
        }
        if (i5 < 0) {
            strZza = zzy.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i5));
        } else {
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0157z.k(i6, "negative size: "));
            }
            strZza = zzy.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(zze(i5, i6, FirebaseAnalytics.Param.INDEX));
        }
        return i5;
    }

    public static void zzc(int i5, int i6, int i7) {
        String strZze;
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            if (i5 < 0 || i5 > i7) {
                strZze = zze(i5, i7, "start index");
            } else {
                strZze = (i6 < 0 || i6 > i7) ? zze(i6, i7, "end index") : zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
            }
            throw new IndexOutOfBoundsException(strZze);
        }
    }

    public static void zzd(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zze(int i5, int i6, String str) {
        if (i5 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i6, "negative size: "));
    }
}
