package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjf extends zzgp implements zzhs {
    private static final zzjf zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzjf zzjfVar = new zzjf();
        zzb = zzjfVar;
        zzgp.zzB(zzjf.class, zzjfVar);
    }

    private zzjf() {
    }

    public static zzjd zza() {
        return (zzjd) zzb.zzp();
    }

    public static zzjf zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzjf zzjfVar, String str) {
        str.getClass();
        zzjfVar.zzd = 3;
        zzjfVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new zzia(zzb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzim.class, zzhi.class});
        }
        if (i6 == 3) {
            return new zzjf();
        }
        zzje zzjeVar = null;
        if (i6 == 4) {
            return new zzjd(zzjeVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
