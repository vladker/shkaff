package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhy {
    private static final zzhy zza = new zzhy();
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    private zzhy() {
        zzgk.zza();
    }

    public static zzhy zza() {
        return zza;
    }

    private <T> zzib<T> zzc(Class<T> cls) {
        Class<T> cls2;
        zzib<T> zzibVarZzl;
        int i5 = zzic.zza;
        if (!zzgp.class.isAssignableFrom(cls)) {
            int i6 = zzfc.zza;
        }
        int i7 = zzfc.zza;
        if (!zzgp.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            zzhp zzhpVar = (zzhp) zzgp.zzr(cls.asSubclass(zzgp.class)).zzd(3, null, null);
            if (zzhpVar.zzb()) {
                zzibVarZzl = zzhv.zzc(zzic.zzm(), zzgf.zza(), zzhpVar.zza());
                cls2 = cls;
            } else {
                cls2 = cls;
                zzibVarZzl = zzhu.zzl(cls2, zzhpVar, zzhx.zza(), zzhf.zza(), zzic.zzm(), zzhpVar.zzc() + (-1) != 1 ? zzgf.zza() : null, zzho.zza());
            }
            zzib<T> zzibVar = (zzib) this.zzb.putIfAbsent(cls2, zzibVarZzl);
            return zzibVar != null ? zzibVar : zzibVarZzl;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    public final zzib zzb(Class cls) {
        Object obj = this.zzb.get(cls);
        return obj == null ? zzc(cls) : (zzib) obj;
    }
}
