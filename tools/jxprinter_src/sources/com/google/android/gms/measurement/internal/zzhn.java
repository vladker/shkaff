package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzht zza;

    public zzhn(zzht zzhtVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i5, String str, List list, boolean z6, boolean z7) {
        zzgs zzgsVarZzj;
        int i6 = i5 - 1;
        if (i6 == 0) {
            zzgsVarZzj = this.zza.zzu.zzaV().zzj();
        } else if (i6 != 1) {
            if (i6 == 3) {
                zzgsVarZzj = this.zza.zzu.zzaV().zzk();
            } else if (i6 != 4) {
                zzgsVarZzj = this.zza.zzu.zzaV().zzi();
            } else if (z6) {
                zzgsVarZzj = this.zza.zzu.zzaV().zzf();
            } else {
                zzgsVarZzj = !z7 ? this.zza.zzu.zzaV().zzh() : this.zza.zzu.zzaV().zze();
            }
        } else if (z6) {
            zzgsVarZzj = this.zza.zzu.zzaV().zzc();
        } else {
            zzgsVarZzj = !z7 ? this.zza.zzu.zzaV().zzd() : this.zza.zzu.zzaV().zzb();
        }
        int size = list.size();
        if (size == 1) {
            zzgsVarZzj.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgsVarZzj.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgsVarZzj.zza(str);
        } else {
            zzgsVarZzj.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
