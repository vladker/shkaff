package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Triangle<T> {
    private final zzp zza;

    @KeepForSdk
    public Triangle(@NonNull T t6, @NonNull T t7, @NonNull T t8) {
        this.zza = zzp.zzj(t6, t7, t8);
    }

    @NonNull
    public List<T> getAllPoints() {
        return this.zza;
    }
}
