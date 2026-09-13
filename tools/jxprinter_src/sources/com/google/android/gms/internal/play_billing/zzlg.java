package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlg extends zzgp implements zzhs {
    private static final zzlg zzb;
    private int zzd;
    private zzju zze;
    private long zzf;

    static {
        zzlg zzlgVar = new zzlg();
        zzb = zzlgVar;
        zzgp.zzB(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    public static zzle zza() {
        return (zzle) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzlg zzlgVar, zzju zzjuVar) {
        zzjuVar.getClass();
        zzlgVar.zze = zzjuVar;
        zzlgVar.zzd |= 1;
    }

    public static /* synthetic */ void zze(zzlg zzlgVar, long j6) {
        zzlgVar.zzd |= 2;
        zzlgVar.zzf = j6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzlg();
        }
        zzlf zzlfVar = null;
        if (i6 == 4) {
            return new zzle(zzlfVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
