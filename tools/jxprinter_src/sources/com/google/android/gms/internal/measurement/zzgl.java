package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgl extends zzmf implements zznn {
    private static final zzgl zzu;
    private int zzb;
    private long zzd;
    private int zzf;
    private boolean zzk;
    private zzgf zzp;
    private zzgp zzq;
    private zzgv zzr;
    private zzgr zzs;
    private zzgn zzt;
    private String zze = "";
    private zzmo zzg = zzmf.zzcv();
    private zzmo zzh = zzmf.zzcv();
    private zzmo zzi = zzmf.zzcv();
    private String zzj = "";
    private zzmo zzl = zzmf.zzcv();
    private zzmo zzm = zzmf.zzcv();
    private String zzn = "";
    private String zzo = "";

    static {
        zzgl zzglVar = new zzgl();
        zzu = zzglVar;
        zzmf.zzcp(zzgl.class, zzglVar);
    }

    private zzgl() {
    }

    public static zzgk zzr() {
        return (zzgk) zzu.zzck();
    }

    public static zzgl zzs() {
        return zzu;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List zze() {
        return this.zzg;
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final zzgj zzg(int i5) {
        return (zzgj) this.zzh.get(i5);
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzl;
    }

    public final int zzj() {
        return this.zzl.size();
    }

    public final List zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzmf.zzcq(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", zzgt.class, "zzh", zzgj.class, "zzi", zzfd.class, "zzj", "zzk", "zzl", zzja.class, "zzm", zzgh.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i6 == 3) {
            return new zzgl();
        }
        byte[] bArr = null;
        if (i6 == 4) {
            return new zzgk(bArr);
        }
        if (i6 == 5) {
            return zzu;
        }
        throw null;
    }

    public final String zzm() {
        return this.zzn;
    }

    public final boolean zzn() {
        return (this.zzb & 128) != 0;
    }

    public final zzgf zzo() {
        zzgf zzgfVar = this.zzp;
        return zzgfVar == null ? zzgf.zzg() : zzgfVar;
    }

    public final boolean zzp() {
        return (this.zzb & 512) != 0;
    }

    public final zzgv zzq() {
        zzgv zzgvVar = this.zzr;
        return zzgvVar == null ? zzgv.zze() : zzgvVar;
    }

    public final /* synthetic */ void zzt(int i5, zzgj zzgjVar) {
        zzgjVar.getClass();
        zzmo zzmoVar = this.zzh;
        if (!zzmoVar.zza()) {
            this.zzh = zzmf.zzcw(zzmoVar);
        }
        this.zzh.set(i5, zzgjVar);
    }

    public final /* synthetic */ void zzu() {
        this.zzi = zzmf.zzcv();
    }

    public final /* synthetic */ void zzv() {
        this.zzl = zzmf.zzcv();
    }
}
