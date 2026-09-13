package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.auth.api.accounttransfer.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbvf {
    private final zbve zba;

    private zbvf(zbww zbwwVar, Object obj, zbww zbwwVar2, Object obj2) {
        this.zba = new zbve(zbwwVar, obj, zbwwVar2, obj2);
    }

    public static int zbb(zbve zbveVar, Object obj, Object obj2) {
        return zbtu.zba(zbveVar.zba, 1, obj) + zbtu.zba(zbveVar.zbc, 2, obj2);
    }

    public static zbvf zbd(zbww zbwwVar, Object obj, zbww zbwwVar2, Object obj2) {
        return new zbvf(zbwwVar, obj, zbwwVar2, obj2);
    }

    public static void zbe(zbtk zbtkVar, zbve zbveVar, Object obj, Object obj2) {
        zbtu.zbk(zbtkVar, zbveVar.zba, 1, obj);
        zbtu.zbk(zbtkVar, zbveVar.zbc, 2, obj2);
    }

    public final int zba(int i5, Object obj, Object obj2) {
        zbve zbveVar = this.zba;
        int iZbD = zbtk.zbD(i5 << 3);
        int iZbb = zbb(zbveVar, obj, obj2);
        return a.A(iZbb, iZbb, iZbD);
    }

    public final zbve zbc() {
        return this.zba;
    }
}
