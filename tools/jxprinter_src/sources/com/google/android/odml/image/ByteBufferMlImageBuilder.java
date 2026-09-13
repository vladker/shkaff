package com.google.android.odml.image;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ByteBufferMlImageBuilder {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private int zze = 0;
    private Rect zzf;

    public ByteBufferMlImageBuilder(@NonNull ByteBuffer byteBuffer, int i5, int i6, int i7) {
        this.zza = byteBuffer;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zzf = new Rect(0, 0, i5, i6);
    }

    @NonNull
    public MlImage build() {
        return new MlImage(new zzf(this.zza, this.zzd), this.zze, this.zzf, 0L, this.zzb, this.zzc);
    }

    @NonNull
    public ByteBufferMlImageBuilder setRotation(int i5) {
        MlImage.zzc(i5);
        this.zze = i5;
        return this;
    }
}
