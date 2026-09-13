package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zber extends zbuf implements zbvn {
    private static final zber zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private zbun zbg = zbuf.zby();

    static {
        zber zberVar = new zber();
        zbb = zberVar;
        zbuf.zbD(zber.class, zberVar);
    }

    private zber() {
    }

    public static zber zbd(byte[] bArr, zbtp zbtpVar) {
        return (zber) zbuf.zbu(zbb, bArr, zbtpVar);
    }

    public final int zba() {
        return this.zbe;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", zbad.class});
        }
        if (i6 == 3) {
            return new zber();
        }
        zbep zbepVar = null;
        if (i6 == 4) {
            return new zbeq(zbepVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }

    public final String zbe() {
        return this.zbf;
    }

    public final List zbf() {
        return this.zbg;
    }
}
