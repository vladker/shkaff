package com.google.android.libraries.vision.visionkit.pipeline;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbf {
    private final int zba;
    private final Map zbb = new HashMap();

    @SuppressLint({"UseSparseArrays"})
    public zbbf(int i5) {
        this.zba = i5;
    }

    public final synchronized void zba(long j6) {
        this.zbb.remove(Long.valueOf(j6));
    }

    public final synchronized boolean zbb(Object obj, long j6) {
        if (this.zbb.size() != this.zba) {
            this.zbb.put(Long.valueOf(j6), obj);
            return true;
        }
        com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq.zba.zbc(this, "Buffer is full. Drop frame " + j6, new Object[0]);
        return false;
    }
}
