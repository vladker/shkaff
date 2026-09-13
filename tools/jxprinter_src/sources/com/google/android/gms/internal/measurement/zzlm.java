package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzlm extends zzkz {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzlm.class.getName());
    private static final boolean zzd = zzop.zza();
    zzln zza;

    private zzlm() {
        throw null;
    }

    public static int zzA(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzos.zzb(str);
        } catch (zzor unused) {
            length = str.getBytes(zzmp.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzC(zznm zznmVar) {
        int iZzcn = zznmVar.zzcn();
        return zzz(iZzcn) + iZzcn;
    }

    public static int zzD(zznm zznmVar, zznx zznxVar) {
        int iZzcd = ((zzks) zznmVar).zzcd(zznxVar);
        return zzz(iZzcd) + iZzcd;
    }

    @Deprecated
    public static int zzG(int i5, zznm zznmVar, zznx zznxVar) {
        int iZzz = zzz(i5 << 3);
        return ((zzks) zznmVar).zzcd(zznxVar) + iZzz + iZzz;
    }

    public static int zzz(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, zzor zzorVar) throws zzll {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzorVar);
        byte[] bytes = str.getBytes(zzmp.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(e);
        }
    }

    public abstract void zza(int i5, int i6);

    public abstract void zzb(int i5, int i6);

    public abstract void zzc(int i5, int i6);

    public abstract void zzd(int i5, int i6);

    public abstract void zze(int i5, long j6);

    public abstract void zzf(int i5, long j6);

    public abstract void zzg(int i5, boolean z6);

    public abstract void zzh(int i5, String str);

    public abstract void zzi(int i5, zzlh zzlhVar);

    public abstract void zzj(zzlh zzlhVar);

    public abstract void zzk(byte[] bArr, int i5, int i6);

    public abstract void zzl(int i5, zznm zznmVar, zznx zznxVar);

    public abstract void zzm(int i5, zznm zznmVar);

    public abstract void zzn(int i5, zzlh zzlhVar);

    public abstract void zzo(zznm zznmVar);

    public abstract void zzp(byte b);

    public abstract void zzq(int i5);

    public abstract void zzr(int i5);

    public abstract void zzs(int i5);

    public abstract void zzt(long j6);

    public abstract void zzu(long j6);

    public abstract void zzw(byte[] bArr, int i5, int i6);

    public abstract void zzx(String str);

    public abstract int zzy();

    public /* synthetic */ zzlm(byte[] bArr) {
    }
}
