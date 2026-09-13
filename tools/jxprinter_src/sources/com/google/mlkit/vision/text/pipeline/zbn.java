package com.google.mlkit.vision.text.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zbn {
    public static zbn zbe(zbo zboVar) {
        return new zba(zboVar, new zbok("", zbkx.zbh()), zbkx.zbh(), false);
    }

    public abstract zbkx zba();

    public abstract zbok zbb();

    public abstract zbo zbc();

    public abstract boolean zbd();
}
