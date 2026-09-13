package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkg extends zzgp implements zzhs {
    private static final zzkg zzb;
    private int zzd;
    private int zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzs;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        zzkg zzkgVar = new zzkg();
        zzb = zzkgVar;
        zzgp.zzB(zzkg.class, zzkgVar);
    }

    private zzkg() {
    }

    public static /* synthetic */ void zzG(zzkg zzkgVar, long j6) {
        zzkgVar.zzd |= 512;
        zzkgVar.zzn = 926300087L;
    }

    public static /* synthetic */ void zzH(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 4;
        zzkgVar.zzg = str;
    }

    public static /* synthetic */ void zzI(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 1024;
        zzkgVar.zzo = str;
    }

    public static /* synthetic */ void zzJ(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 8192;
        zzkgVar.zzr = str;
    }

    public static /* synthetic */ void zzK(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 4096;
        zzkgVar.zzq = str;
    }

    public static /* synthetic */ void zzL(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 2048;
        zzkgVar.zzp = str;
    }

    public static /* synthetic */ void zzM(zzkg zzkgVar, int i5) {
        zzkgVar.zzd |= 16384;
        zzkgVar.zzs = i5;
    }

    public static /* synthetic */ void zzN(zzkg zzkgVar, boolean z6) {
        zzkgVar.zzd |= 64;
        zzkgVar.zzk = z6;
    }

    public static /* synthetic */ void zzO(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 1;
        zzkgVar.zze = str;
    }

    public static /* synthetic */ void zzP(zzkg zzkgVar, String str) {
        zzkgVar.zzd |= 2;
        zzkgVar.zzf = str;
    }

    public static zzke zza() {
        return (zzke) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzkg zzkgVar, int i5) {
        zzkgVar.zzd |= 128;
        zzkgVar.zzl = i5;
    }

    public static /* synthetic */ void zze(zzkg zzkgVar, int i5) {
        zzkgVar.zzd |= 256;
        zzkgVar.zzm = i5;
    }

    public static /* synthetic */ void zzf(zzkg zzkgVar, int i5) {
        zzkgVar.zzd |= 8;
        zzkgVar.zzh = i5;
    }

    public static /* synthetic */ void zzg(zzkg zzkgVar, long j6) {
        zzkgVar.zzd |= 16;
        zzkgVar.zzi = j6;
    }

    public static /* synthetic */ void zzh(zzkg zzkgVar, long j6) {
        zzkgVar.zzd |= 32;
        zzkgVar.zzj = j6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003င\u0003\u0004ဂ\u0004\u0005ဈ\u0001\u0006ဂ\u0005\u0007ဇ\u0006\bင\u0007\tင\b\nဂ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r\u000fင\u000e", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzf", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i6 == 3) {
            return new zzkg();
        }
        zzkf zzkfVar = null;
        if (i6 == 4) {
            return new zzke(zzkfVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
