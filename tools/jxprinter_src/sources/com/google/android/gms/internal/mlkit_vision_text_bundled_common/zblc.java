package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zblc {
    public static List zba(List list, zbkf zbkfVar) {
        return list instanceof RandomAccess ? new zbkz(list, zbkfVar) : new zblb(list, zbkfVar);
    }
}
