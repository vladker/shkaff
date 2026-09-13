package com.google.android.gms.internal.measurement;

import androidx.collection.a;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg {

    @VisibleForTesting
    public final zzg zza;

    @VisibleForTesting
    final zzaw zzb;

    @VisibleForTesting
    final Map zzc = new HashMap();

    @VisibleForTesting
    final Map zzd = new HashMap();

    public zzg(zzg zzgVar, zzaw zzawVar) {
        this.zza = zzgVar;
        this.zzb = zzawVar;
    }

    public final zzao zza(zzao zzaoVar) {
        return this.zzb.zzb(this, zzaoVar);
    }

    public final zzao zzb(zzae zzaeVar) {
        zzao zzaoVarZzb = zzao.zzf;
        Iterator itZzg = zzaeVar.zzg();
        while (itZzg.hasNext()) {
            zzaoVarZzb = this.zzb.zzb(this, zzaeVar.zzl(((Integer) itZzg.next()).intValue()));
            if (zzaoVarZzb instanceof zzag) {
                break;
            }
        }
        return zzaoVarZzb;
    }

    public final zzg zzc() {
        return new zzg(this, this.zzb);
    }

    public final boolean zzd(String str) {
        if (this.zzc.containsKey(str)) {
            return true;
        }
        zzg zzgVar = this.zza;
        if (zzgVar != null) {
            return zzgVar.zzd(str);
        }
        return false;
    }

    public final void zze(String str, zzao zzaoVar) {
        zzg zzgVar;
        Map map = this.zzc;
        if (!map.containsKey(str) && (zzgVar = this.zza) != null && zzgVar.zzd(str)) {
            zzgVar.zze(str, zzaoVar);
        } else {
            if (this.zzd.containsKey(str)) {
                return;
            }
            if (zzaoVar == null) {
                map.remove(str);
            } else {
                map.put(str, zzaoVar);
            }
        }
    }

    public final void zzf(String str, zzao zzaoVar) {
        if (this.zzd.containsKey(str)) {
            return;
        }
        if (zzaoVar == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, zzaoVar);
        }
    }

    public final void zzg(String str, zzao zzaoVar) {
        zzf(str, zzaoVar);
        this.zzd.put(str, Boolean.TRUE);
    }

    public final zzao zzh(String str) {
        Map map = this.zzc;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        zzg zzgVar = this.zza;
        if (zzgVar != null) {
            return zzgVar.zzh(str);
        }
        throw new IllegalArgumentException(a.n(str, " is not defined"));
    }
}
