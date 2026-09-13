package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzce extends zzbv {
    public zzce() {
        super(4);
    }

    public final zzce zzb(Object obj) {
        obj.getClass();
        int length = this.zza.length;
        int iZza = zzbw.zza(length, this.zzb + 1);
        if (iZza > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i5 = this.zzb;
        this.zzb = i5 + 1;
        objArr[i5] = obj;
        return this;
    }

    public final zzcf zzc() {
        int i5 = this.zzb;
        if (i5 == 0) {
            return zzcp.zza;
        }
        if (i5 == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzcr(obj);
        }
        zzcf zzcfVarZzm = zzcf.zzm(i5, this.zza);
        this.zzb = zzcfVarZzm.size();
        this.zzc = true;
        return zzcfVarZzm;
    }
}
