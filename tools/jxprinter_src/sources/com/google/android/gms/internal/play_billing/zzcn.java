package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcn extends zzca {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzcn(Object[] objArr, int i5, int i6) {
        this.zza = objArr;
        this.zzb = i5;
        this.zzc = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzbl.zza(i5, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i5 + i5 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final boolean zzf() {
        return true;
    }
}
