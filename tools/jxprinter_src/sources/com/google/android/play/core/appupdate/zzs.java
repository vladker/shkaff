package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzs implements zzaf {
    private final zzaf zza;
    private final zzaf zzb;

    public zzs(zzaf zzafVar, zzaf zzafVar2) {
        this.zza = zzafVar;
        this.zzb = zzafVar2;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzr(((zzk) this.zza).zzb(), (zzt) this.zzb.zza());
    }
}
