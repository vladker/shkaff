package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzic {
    public static final /* synthetic */ int zza = 0;
    private static final zziq zzb;

    static {
        int i5 = zzfc.zza;
        zzb = new zzis();
    }

    public static void zzA(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzD(i5, list, z6);
    }

    public static void zzB(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzF(i5, list, z6);
    }

    public static void zzC(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzK(i5, list, z6);
    }

    public static void zzD(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzM(i5, list, z6);
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Deprecated
    public static int zza(int i5, zzhr zzhrVar, zzib zzibVar) {
        int iZzy = zzfx.zzy(i5 << 3);
        return ((zzfa) zzhrVar).zzi(zzibVar) + iZzy + iZzy;
    }

    public static int zzb(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzz = 0;
            while (i5 < size) {
                iZzz += zzfx.zzz(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzz;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzz2 = 0;
        while (i5 < size) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i5));
            i5++;
        }
        return iZzz2;
    }

    public static int zzc(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfx.zzy(i5 << 3) + 4) * size;
    }

    public static int zzd(List list) {
        return list.size() * 4;
    }

    public static int zze(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfx.zzy(i5 << 3) + 8) * size;
    }

    public static int zzf(List list) {
        return list.size() * 8;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzz = 0;
            while (i5 < size) {
                iZzz += zzfx.zzz(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzz;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzz2 = 0;
        while (i5 < size) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i5));
            i5++;
        }
        return iZzz2;
    }

    public static int zzh(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i5 < size) {
                iZzz += zzfx.zzz(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i5 < size) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i5));
            i5++;
        }
        return iZzz2;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzy = 0;
            while (i5 < size) {
                int iIntValue = ((Integer) list.get(i5)).intValue();
                iZzy += zzfx.zzy((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i5++;
            }
            return iZzy;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzy2 = 0;
        while (i5 < size) {
            int iZze = zzgqVar.zze(i5);
            iZzy2 += zzfx.zzy((iZze >> 31) ^ (iZze + iZze));
            i5++;
        }
        return iZzy2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i5 < size) {
                long jLongValue = ((Long) list.get(i5)).longValue();
                iZzz += zzfx.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i5++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i5 < size) {
            long jZze = zzhjVar.zze(i5);
            iZzz2 += zzfx.zzz((jZze >> 63) ^ (jZze + jZze));
            i5++;
        }
        return iZzz2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzy = 0;
            while (i5 < size) {
                iZzy += zzfx.zzy(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzy;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzy2 = 0;
        while (i5 < size) {
            iZzy2 += zzfx.zzy(zzgqVar.zze(i5));
            i5++;
        }
        return iZzy2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i5 < size) {
                iZzz += zzfx.zzz(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i5 < size) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i5));
            i5++;
        }
        return iZzz2;
    }

    public static zziq zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i5, int i6, Object obj2, zziq zziqVar) {
        if (obj2 == null) {
            obj2 = zzis.zza(obj);
        }
        ((zzir) obj2).zzj(i5 << 3, Long.valueOf(i6));
        return obj2;
    }

    public static void zzo(zzgd zzgdVar, Object obj, Object obj2) {
        if (((zzgm) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzp(zziq zziqVar, Object obj, Object obj2) {
        zzgp zzgpVar = (zzgp) obj;
        zzir zzirVarZze = zzgpVar.zzc;
        zzir zzirVar = ((zzgp) obj2).zzc;
        if (!zzir.zzc().equals(zzirVar)) {
            if (zzir.zzc().equals(zzirVarZze)) {
                zzirVarZze = zzir.zze(zzirVarZze, zzirVar);
            } else {
                zzirVarZze.zzd(zzirVar);
            }
        }
        zzgpVar.zzc = zzirVarZze;
    }

    public static void zzq(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzc(i5, list, z6);
    }

    public static void zzr(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzg(i5, list, z6);
    }

    public static void zzs(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzj(i5, list, z6);
    }

    public static void zzt(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzl(i5, list, z6);
    }

    public static void zzu(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzn(i5, list, z6);
    }

    public static void zzv(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzp(i5, list, z6);
    }

    public static void zzw(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzs(i5, list, z6);
    }

    public static void zzx(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzu(i5, list, z6);
    }

    public static void zzy(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzz(i5, list, z6);
    }

    public static void zzz(int i5, List list, zzji zzjiVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzB(i5, list, z6);
    }
}
