package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcc {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzcb zzc;

    public final zzcc zza(Object obj, Object obj2) {
        int i5 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i6 = i5 + i5;
        if (i6 > length) {
            this.zza = Arrays.copyOf(objArr, zzbw.zza(length, i6));
        }
        zzbt.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i7 = this.zzb;
        int i8 = i7 + i7;
        objArr2[i8] = obj;
        objArr2[i8 + 1] = obj2;
        this.zzb = i7 + 1;
        return this;
    }

    public final zzcd zzb() {
        zzcb zzcbVar = this.zzc;
        if (zzcbVar != null) {
            throw zzcbVar.zza();
        }
        zzco zzcoVarZzg = zzco.zzg(this.zzb, this.zza, this);
        zzcb zzcbVar2 = this.zzc;
        if (zzcbVar2 == null) {
            return zzcoVarZzg;
        }
        throw zzcbVar2.zza();
    }
}
