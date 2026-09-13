package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PointF3D {
    @NonNull
    public static PointF3D from(float f6, float f7, float f8) {
        return new zza(f6, f7, f8);
    }

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
