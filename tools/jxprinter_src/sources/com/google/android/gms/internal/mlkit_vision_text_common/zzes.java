package com.google.android.gms.internal.mlkit_vision_text_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzes {
    private final zzou zza;
    private final Boolean zzc;
    private final zzsd zze;
    private final Boolean zzb = null;
    private final zzod zzd = null;

    public /* synthetic */ zzes(zzeq zzeqVar, zzer zzerVar) {
        this.zza = zzeqVar.zza;
        this.zzc = zzeqVar.zzb;
        this.zze = zzeqVar.zzc;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzes)) {
            return false;
        }
        zzes zzesVar = (zzes) obj;
        return Objects.equal(this.zza, zzesVar.zza) && Objects.equal(null, null) && Objects.equal(this.zzc, zzesVar.zzc) && Objects.equal(null, null) && Objects.equal(this.zze, zzesVar.zze);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze);
    }

    @Nullable
    @zzcx(zza = 1)
    public final zzou zza() {
        return this.zza;
    }

    @Nullable
    @zzcx(zza = 5)
    public final zzsd zzb() {
        return this.zze;
    }

    @Nullable
    @zzcx(zza = 3)
    public final Boolean zzc() {
        return this.zzc;
    }
}
