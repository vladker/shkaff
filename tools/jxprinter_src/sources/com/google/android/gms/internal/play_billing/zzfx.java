package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfx extends zzfg {
    Object zza;

    private zzfx() {
        throw null;
    }

    public static int zzx(zzhr zzhrVar) {
        int iZzn = zzhrVar.zzn();
        return zzy(iZzn) + iZzn;
    }

    public static int zzy(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int zzz(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    public final void zzA() {
        if (zza() > 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        if (zza() < 0) {
            throw new IllegalStateException("Wrote more data than expected.");
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i5, boolean z6);

    public abstract void zze(byte[] bArr, int i5, int i6);

    public abstract void zzf(int i5, zzfp zzfpVar);

    public abstract void zzg(zzfp zzfpVar);

    public abstract void zzh(int i5, int i6);

    public abstract void zzi(int i5);

    public abstract void zzj(int i5, long j6);

    public abstract void zzk(long j6);

    public abstract void zzl(int i5, int i6);

    public abstract void zzm(int i5);

    public abstract void zzn(zzhr zzhrVar);

    public abstract void zzo(int i5, zzhr zzhrVar);

    public abstract void zzp(int i5, zzfp zzfpVar);

    public abstract void zzq(int i5, String str);

    public abstract void zzr(String str);

    public abstract void zzs(int i5, int i6);

    public abstract void zzt(int i5, int i6);

    public abstract void zzu(int i5);

    public abstract void zzv(int i5, long j6);

    public abstract void zzw(long j6);

    public /* synthetic */ zzfx(zzfw zzfwVar) {
    }
}
