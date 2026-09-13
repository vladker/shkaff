package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzum extends LazyInstanceMap {
    private zzum() {
        throw null;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zztu zztuVar = (zztu) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzuc(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zztv(MlKitContext.getInstance().getApplicationContext(), zztuVar), zztuVar.zzb());
    }

    public /* synthetic */ zzum(zzul zzulVar) {
    }
}
