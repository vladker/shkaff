package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdn extends zzcx {
    private static final Logger zzb = Logger.getLogger(zzdn.class.getName());
    private static final boolean zzc = zzgz.zzx();
    zzdo zza;

    private zzdn() {
        throw null;
    }

    public static int zzA(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int zzB(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i5, zzfm zzfmVar, zzge zzgeVar) {
        int iZzA = zzA(i5 << 3);
        return ((zzcq) zzfmVar).zzB(zzgeVar) + iZzA + iZzA;
    }

    public static int zzx(zzfm zzfmVar) {
        int iZzF = zzfmVar.zzF();
        return zzA(iZzF) + iZzF;
    }

    public static int zzy(zzfm zzfmVar, zzge zzgeVar) {
        int iZzB = ((zzcq) zzfmVar).zzB(zzgeVar);
        return zzA(iZzB) + iZzB;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzhe.zze(str);
        } catch (zzhd unused) {
            length = str.getBytes(zzep.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzhd zzhdVar) throws zzdl {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhdVar);
        byte[] bytes = str.getBytes(zzep.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i5, boolean z6);

    public abstract void zze(int i5, zzdf zzdfVar);

    public abstract void zzf(int i5, int i6);

    public abstract void zzg(int i5);

    public abstract void zzh(int i5, long j6);

    public abstract void zzi(long j6);

    public abstract void zzj(int i5, int i6);

    public abstract void zzk(int i5);

    public abstract void zzl(byte[] bArr, int i5, int i6);

    public abstract void zzm(int i5, zzfm zzfmVar, zzge zzgeVar);

    public abstract void zzn(int i5, zzfm zzfmVar);

    public abstract void zzo(int i5, zzdf zzdfVar);

    public abstract void zzp(int i5, String str);

    public abstract void zzr(int i5, int i6);

    public abstract void zzs(int i5, int i6);

    public abstract void zzt(int i5);

    public abstract void zzu(int i5, long j6);

    public abstract void zzv(long j6);

    public /* synthetic */ zzdn(zzdm zzdmVar) {
    }
}
