package com.google.mlkit.vision.text.pipeline;

import android.os.RemoteException;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zbo {
    public static zbo zbc(int i5, RemoteException remoteException) {
        return new zbb(i5, zbki.zbe(remoteException));
    }

    public abstract int zba();

    public abstract zbki zbb();

    public final boolean zbd() {
        return !zbb().zbc();
    }
}
