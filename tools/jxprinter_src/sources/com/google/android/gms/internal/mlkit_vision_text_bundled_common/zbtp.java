package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbtp {
    static final zbtp zba = new zbtp(true);
    public static final /* synthetic */ int zbb = 0;
    private static volatile boolean zbc = false;
    private static volatile zbtp zbd;
    private final Map zbe;

    public zbtp() {
        this.zbe = new HashMap();
    }

    public static zbtp zba() {
        int i5 = zbvu.zba;
        return zba;
    }

    public static zbtp zbb() {
        zbtp zbtpVar = zbd;
        if (zbtpVar != null) {
            return zbtpVar;
        }
        synchronized (zbtp.class) {
            try {
                zbtp zbtpVar2 = zbd;
                if (zbtpVar2 != null) {
                    return zbtpVar2;
                }
                int i5 = zbvu.zba;
                zbtp zbtpVarZbb = zbtx.zbb(zbtp.class);
                zbd = zbtpVarZbb;
                return zbtpVarZbb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zbud zbc(zbvm zbvmVar, int i5) {
        return (zbud) this.zbe.get(new zbto(zbvmVar, i5));
    }

    public zbtp(boolean z6) {
        this.zbe = Collections.EMPTY_MAP;
    }
}
