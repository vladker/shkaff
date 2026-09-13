package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrg implements zzrf {
    public static final zzkm zza;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkgVarZzb.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzkgVarZzb.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzkgVarZzb.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzrf
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
