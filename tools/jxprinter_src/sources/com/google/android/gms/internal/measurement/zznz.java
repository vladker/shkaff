package com.google.android.gms.internal.measurement;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zznz {
    public static final /* synthetic */ int zza = 0;
    private static final zzoi zzb;

    static {
        int i5 = zznu.zza;
        zzb = new zzok();
    }

    public static zzoi zzA() {
        return zzb;
    }

    public static boolean zzB(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzC(zzls zzlsVar, Object obj, Object obj2) {
        if (((zzmc) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzD(zzoi zzoiVar, Object obj, Object obj2) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVarZzc = zzmfVar.zzc;
        zzoj zzojVar = ((zzmf) obj2).zzc;
        if (!zzoj.zza().equals(zzojVar)) {
            if (zzoj.zza().equals(zzojVarZzc)) {
                zzojVarZzc = zzoj.zzc(zzojVarZzc, zzojVar);
            } else {
                zzojVarZzc.zzl(zzojVar);
            }
        }
        zzmfVar.zzc = zzojVarZzc;
    }

    public static Object zzE(Object obj, int i5, int i6, Object obj2, zzoi zzoiVar) {
        if (obj2 == null) {
            obj2 = zzoiVar.zza(obj);
        }
        ((zzoj) obj2).zzk(i5 << 3, Long.valueOf(i6));
        return obj2;
    }

    public static void zza(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzC(i5, list, z6);
    }

    public static void zzb(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzB(i5, list, z6);
    }

    public static void zzc(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzy(i5, list, z6);
    }

    public static void zzd(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzz(i5, list, z6);
    }

    public static void zze(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzL(i5, list, z6);
    }

    public static void zzf(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzA(i5, list, z6);
    }

    public static void zzg(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzJ(i5, list, z6);
    }

    public static void zzh(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzw(i5, list, z6);
    }

    public static void zzi(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzH(i5, list, z6);
    }

    public static void zzj(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzK(i5, list, z6);
    }

    public static void zzk(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzx(i5, list, z6);
    }

    public static void zzl(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzI(i5, list, z6);
    }

    public static void zzm(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzD(i5, list, z6);
    }

    public static void zzn(int i5, List list, zzov zzovVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzE(i5, list, z6);
    }

    public static int zzo(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i5 < size) {
                iZzA += zzlm.zzA(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i5 < size) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i5));
            i5++;
        }
        return iZzA2;
    }

    public static int zzp(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i5 < size) {
                iZzA += zzlm.zzA(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i5 < size) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i5));
            i5++;
        }
        return iZzA2;
    }

    public static int zzq(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i5 < size) {
                long jLongValue = ((Long) list.get(i5)).longValue();
                iZzA += zzlm.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i5++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i5 < size) {
            long jZzc = zznaVar.zzc(i5);
            iZzA2 += zzlm.zzA((jZzc >> 63) ^ (jZzc + jZzc));
            i5++;
        }
        return iZzA2;
    }

    public static int zzr(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzA = 0;
            while (i5 < size) {
                iZzA += zzlm.zzA(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzA;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzA2 = 0;
        while (i5 < size) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i5));
            i5++;
        }
        return iZzA2;
    }

    public static int zzs(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzA = 0;
            while (i5 < size) {
                iZzA += zzlm.zzA(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzA;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzA2 = 0;
        while (i5 < size) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i5));
            i5++;
        }
        return iZzA2;
    }

    public static int zzt(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzz = 0;
            while (i5 < size) {
                iZzz += zzlm.zzz(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZzz;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzz2 = 0;
        while (i5 < size) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i5));
            i5++;
        }
        return iZzz2;
    }

    public static int zzu(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzz = 0;
            while (i5 < size) {
                int iIntValue = ((Integer) list.get(i5)).intValue();
                iZzz += zzlm.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i5++;
            }
            return iZzz;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzz2 = 0;
        while (i5 < size) {
            int iZzf = zzmgVar.zzf(i5);
            iZzz2 += zzlm.zzz((iZzf >> 31) ^ (iZzf + iZzf));
            i5++;
        }
        return iZzz2;
    }

    public static int zzv(List list) {
        return list.size() * 4;
    }

    public static int zzw(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzlm.zzz(i5 << 3) + 4) * size;
    }

    public static int zzx(List list) {
        return list.size() * 8;
    }

    public static int zzy(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzlm.zzz(i5 << 3) + 8) * size;
    }

    public static int zzz(int i5, Object obj, zznx zznxVar) {
        int i6 = i5 << 3;
        if (!(obj instanceof zzmw)) {
            return zzlm.zzD((zznm) obj, zznxVar) + zzlm.zzz(i6);
        }
        int iZzz = zzlm.zzz(i6);
        int iZzb = ((zzmw) obj).zzb();
        return a.b(iZzb, iZzb, iZzz);
    }
}
