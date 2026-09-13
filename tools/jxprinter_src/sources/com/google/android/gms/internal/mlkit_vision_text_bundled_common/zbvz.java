package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbvz {
    public static final /* synthetic */ int zba = 0;
    private static final zbwl zbb;

    static {
        int i5 = zbvu.zba;
        zbb = new zbwn();
    }

    public static void zbA(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbD(i5, list, z6);
    }

    public static void zbB(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbF(i5, list, z6);
    }

    public static void zbC(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbK(i5, list, z6);
    }

    public static void zbD(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbM(i5, list, z6);
    }

    public static boolean zbE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zba(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbE = 0;
            while (i5 < size) {
                iZbE += zbtk.zbE(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZbE;
        }
        zbug zbugVar = (zbug) list;
        int iZbE2 = 0;
        while (i5 < size) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i5));
            i5++;
        }
        return iZbE2;
    }

    public static int zbb(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zbtk.zbD(i5 << 3) + 4) * size;
    }

    public static int zbc(List list) {
        return list.size() * 4;
    }

    public static int zbd(int i5, List list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zbtk.zbD(i5 << 3) + 8) * size;
    }

    public static int zbe(List list) {
        return list.size() * 8;
    }

    public static int zbf(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbE = 0;
            while (i5 < size) {
                iZbE += zbtk.zbE(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZbE;
        }
        zbug zbugVar = (zbug) list;
        int iZbE2 = 0;
        while (i5 < size) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i5));
            i5++;
        }
        return iZbE2;
    }

    public static int zbg(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i5 < size) {
                iZbE += zbtk.zbE(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i5 < size) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i5));
            i5++;
        }
        return iZbE2;
    }

    public static int zbh(int i5, Object obj, zbvx zbvxVar) {
        int i6 = i5 << 3;
        if (!(obj instanceof zbuw)) {
            return zbtk.zbB((zbvm) obj, zbvxVar) + zbtk.zbD(i6);
        }
        int iZbD = zbtk.zbD(i6);
        int iZba = ((zbuw) obj).zba();
        return a.A(iZba, iZba, iZbD);
    }

    public static int zbi(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbD = 0;
            while (i5 < size) {
                int iIntValue = ((Integer) list.get(i5)).intValue();
                iZbD += zbtk.zbD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i5++;
            }
            return iZbD;
        }
        zbug zbugVar = (zbug) list;
        int iZbD2 = 0;
        while (i5 < size) {
            int iZbe = zbugVar.zbe(i5);
            iZbD2 += zbtk.zbD((iZbe >> 31) ^ (iZbe + iZbe));
            i5++;
        }
        return iZbD2;
    }

    public static int zbj(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i5 < size) {
                long jLongValue = ((Long) list.get(i5)).longValue();
                iZbE += zbtk.zbE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i5++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i5 < size) {
            long jZbe = zbvaVar.zbe(i5);
            iZbE2 += zbtk.zbE((jZbe >> 63) ^ (jZbe + jZbe));
            i5++;
        }
        return iZbE2;
    }

    public static int zbk(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbD = 0;
            while (i5 < size) {
                iZbD += zbtk.zbD(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return iZbD;
        }
        zbug zbugVar = (zbug) list;
        int iZbD2 = 0;
        while (i5 < size) {
            iZbD2 += zbtk.zbD(zbugVar.zbe(i5));
            i5++;
        }
        return iZbD2;
    }

    public static int zbl(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i5 < size) {
                iZbE += zbtk.zbE(((Long) list.get(i5)).longValue());
                i5++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i5 < size) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i5));
            i5++;
        }
        return iZbE2;
    }

    public static zbwl zbm() {
        return zbb;
    }

    public static Object zbn(Object obj, int i5, int i6, Object obj2, zbwl zbwlVar) {
        if (obj2 == null) {
            obj2 = zbwlVar.zba(obj);
        }
        ((zbwm) obj2).zbj(i5 << 3, Long.valueOf(i6));
        return obj2;
    }

    public static void zbo(zbtq zbtqVar, Object obj, Object obj2) {
        zbtu zbtuVar = ((zbub) obj2).zbb;
        if (zbtuVar.zba.isEmpty()) {
            return;
        }
        ((zbub) obj).zbg().zbi(zbtuVar);
    }

    public static void zbp(zbwl zbwlVar, Object obj, Object obj2) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVarZbe = zbufVar.zbc;
        zbwm zbwmVar = ((zbuf) obj2).zbc;
        if (!zbwm.zbc().equals(zbwmVar)) {
            if (zbwm.zbc().equals(zbwmVarZbe)) {
                zbwmVarZbe = zbwm.zbe(zbwmVarZbe, zbwmVar);
            } else {
                zbwmVarZbe.zbd(zbwmVar);
            }
        }
        zbufVar.zbc = zbwmVarZbe;
    }

    public static void zbq(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbc(i5, list, z6);
    }

    public static void zbr(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbg(i5, list, z6);
    }

    public static void zbs(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbj(i5, list, z6);
    }

    public static void zbt(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbl(i5, list, z6);
    }

    public static void zbu(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbn(i5, list, z6);
    }

    public static void zbv(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbp(i5, list, z6);
    }

    public static void zbw(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbs(i5, list, z6);
    }

    public static void zbx(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbu(i5, list, z6);
    }

    public static void zby(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbz(i5, list, z6);
    }

    public static void zbz(int i5, List list, zbwy zbwyVar, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbB(i5, list, z6);
    }
}
