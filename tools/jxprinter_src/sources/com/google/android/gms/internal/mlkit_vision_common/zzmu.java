package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmu {
    @WorkerThread
    public static void zza(zzmj zzmjVar, int i5, int i6, long j6, int i7, int i8, int i9, int i10) {
        zzmjVar.zzc(zzc(i5, i6, j6, i7, i8, i9, i10), zziv.INPUT_IMAGE_CONSTRUCTION);
    }

    @WorkerThread
    public static void zzb(zzmj zzmjVar, int i5, int i6, long j6, int i7, int i8, int i9, int i10) {
        zzmjVar.zzc(zzc(i5, i6, j6, i7, i8, i9, i10), zziv.ODML_IMAGE);
    }

    private static zzmt zzc(int i5, int i6, long j6, int i7, int i8, int i9, int i10) {
        return new zzmt(i5, i6, i9, i7, i8, SystemClock.elapsedRealtime() - j6, i10);
    }
}
