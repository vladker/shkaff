package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzds {
    static final zzds zza = new zzds(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzds() {
        this.zzd = new HashMap();
    }

    public static zzds zza() {
        int i5 = zzfu.zza;
        return zza;
    }

    public final zzef zzb(zzfm zzfmVar, int i5) {
        return (zzef) this.zzd.get(new zzdr(zzfmVar, i5));
    }

    public zzds(boolean z6) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
