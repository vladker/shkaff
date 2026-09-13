package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbpk extends zbuf implements zbvn {
    private static final zbpk zbb;
    private boolean zbh;
    private boolean zbi;
    private boolean zbn;
    private boolean zbo;
    private zbvg zbd = zbvg.zba();
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";
    private String zbj = "";
    private String zbk = "";
    private String zbl = "";
    private zbun zbm = zbuf.zby();
    private String zbp = "";
    private zbun zbq = zbuf.zby();

    static {
        zbpk zbpkVar = new zbpk();
        zbb = zbpkVar;
        zbuf.zbD(zbpk.class, zbpkVar);
    }

    private zbpk() {
    }

    public static zbpi zba() {
        return (zbpi) zbb.zbq();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u000e\u0000\u0000\u0001\u0010\u000e\u0001\u0002\u0000\u00012\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0007\tȈ\nȈ\u000bȚ\f\u0007\rȈ\u000e\u0007\u000fȈ\u0010Ț", new Object[]{"zbd", zbpj.zba, "zbi", "zbe", "zbf", "zbj", "zbh", "zbk", "zbl", "zbm", "zbn", "zbg", "zbo", "zbp", "zbq"});
        }
        if (i6 == 3) {
            return new zbpk();
        }
        zbph zbphVar = null;
        if (i6 == 4) {
            return new zbpi(zbphVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
