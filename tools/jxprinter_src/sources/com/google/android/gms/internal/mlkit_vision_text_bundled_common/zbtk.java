package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zbtk extends zbst {
    private static final Logger zbb = Logger.getLogger(zbtk.class.getName());
    private static final boolean zbc = zbws.zbx();
    zbtl zba;

    private zbtk() {
        throw null;
    }

    public static int zbA(zbvm zbvmVar) {
        int iZbo = zbvmVar.zbo();
        return zbD(iZbo) + iZbo;
    }

    public static int zbB(zbvm zbvmVar, zbvx zbvxVar) {
        int iZbj = ((zbsj) zbvmVar).zbj(zbvxVar);
        return zbD(iZbj) + iZbj;
    }

    public static int zbC(String str) {
        int length;
        try {
            length = zbwv.zbc(str);
        } catch (zbwu unused) {
            length = str.getBytes(zbuo.zba).length;
        }
        return zbD(length) + length;
    }

    public static int zbD(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int zbE(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    @Deprecated
    public static int zbz(int i5, zbvm zbvmVar, zbvx zbvxVar) {
        int iZbD = zbD(i5 << 3);
        return ((zbsj) zbvmVar).zbj(zbvxVar) + iZbD + iZbD;
    }

    public final void zbF() {
        if (zba() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zbG(String str, zbwu zbwuVar) throws zbti {
        zbb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zbwuVar);
        byte[] bytes = str.getBytes(zbuo.zba);
        try {
            int length = bytes.length;
            zbw(length);
            zbn(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(e);
        }
    }

    public abstract int zba();

    public abstract void zbb(byte b);

    public abstract void zbd(int i5, boolean z6);

    public abstract void zbe(byte[] bArr, int i5, int i6);

    public abstract void zbf(int i5, zbtc zbtcVar);

    public abstract void zbg(zbtc zbtcVar);

    public abstract void zbh(int i5, int i6);

    public abstract void zbi(int i5);

    public abstract void zbj(int i5, long j6);

    public abstract void zbk(long j6);

    public abstract void zbl(int i5, int i6);

    public abstract void zbm(int i5);

    public abstract void zbn(byte[] bArr, int i5, int i6);

    public abstract void zbo(int i5, zbvm zbvmVar, zbvx zbvxVar);

    public abstract void zbp(zbvm zbvmVar);

    public abstract void zbq(int i5, zbvm zbvmVar);

    public abstract void zbr(int i5, zbtc zbtcVar);

    public abstract void zbs(int i5, String str);

    public abstract void zbt(String str);

    public abstract void zbu(int i5, int i6);

    public abstract void zbv(int i5, int i6);

    public abstract void zbw(int i5);

    public abstract void zbx(int i5, long j6);

    public abstract void zby(long j6);

    public /* synthetic */ zbtk(zbtj zbtjVar) {
    }
}
