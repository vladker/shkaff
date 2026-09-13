package com.google.mlkit.vision.common;

import android.media.Image;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb {
    private final Image zza;

    public zzb(Image image) {
        this.zza = image;
    }

    public final Image zza() {
        return this.zza;
    }

    public final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}
