package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhe extends zzmf implements zznn {
    private static final zzhe zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzhe zzheVar = new zzhe();
        zzk = zzheVar;
        zzmf.zzcp(zzhe.class, zzheVar);
    }

    private zzhe() {
    }

    public static zzhd zzh() {
        return (zzhd) zzk.zzck();
    }

    public static zzhe zzi() {
        return zzk;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzj;
    }

    public final /* synthetic */ void zzj(boolean z6) {
        this.zzb |= 1;
        this.zzd = z6;
    }

    public final /* synthetic */ void zzk(boolean z6) {
        this.zzb |= 2;
        this.zze = z6;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzmf.zzcq(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i6 == 3) {
            return new zzhe();
        }
        byte[] bArr = null;
        if (i6 == 4) {
            return new zzhd(bArr);
        }
        if (i6 == 5) {
            return zzk;
        }
        throw null;
    }

    public final /* synthetic */ void zzm(boolean z6) {
        this.zzb |= 4;
        this.zzf = z6;
    }

    public final /* synthetic */ void zzn(boolean z6) {
        this.zzb |= 8;
        this.zzg = z6;
    }

    public final /* synthetic */ void zzo(boolean z6) {
        this.zzb |= 16;
        this.zzh = z6;
    }

    public final /* synthetic */ void zzp(boolean z6) {
        this.zzb |= 32;
        this.zzi = z6;
    }

    public final /* synthetic */ void zzq(boolean z6) {
        this.zzb |= 64;
        this.zzj = z6;
    }
}
