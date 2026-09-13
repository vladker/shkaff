package com.google.mlkit.vision.text.bundled.common;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnz;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;
import com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions;
import com.google.mlkit.vision.text.pipeline.zbi;
import com.google.mlkit.vision.text.pipeline.zbn;
import com.google.mlkit.vision.text.pipeline.zbo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zba extends zbnz {
    private final Context zba;
    private final String zbb;
    private final boolean zbc;

    @Nullable
    private final String zbd;

    @Nullable
    private final String zbe;

    @Nullable
    private zbi zbf;

    public zba(Context context, String str, @Nullable String str2, @Nullable String str3, boolean z6) {
        this.zba = context;
        this.zbb = str;
        this.zbd = str2;
        this.zbe = str3;
        this.zbc = z6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final zbok zbb(IObjectWrapper iObjectWrapper, zbnx zbnxVar) throws RemoteException {
        zbi zbiVar = this.zbf;
        if (zbiVar == null) {
            throw new RemoteException("Process is started without initiation.");
        }
        zbn zbnVarZbb = ((zbi) Preconditions.checkNotNull(zbiVar)).zbb(iObjectWrapper, zbnxVar, true);
        zbo zboVarZbc = zbnVarZbb.zbc();
        if (zboVarZbc.zbd()) {
            return zbnVarZbb.zbb();
        }
        throw ((RemoteException) zboVarZbc.zbb().zba());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final void zbc() throws RemoteException {
        if (this.zbf == null) {
            System.loadLibrary("mlkit_google_ocr_pipeline");
            String str = this.zbe;
            String str2 = (str == null || str.isEmpty()) ? "" : this.zbe;
            String str3 = this.zbb;
            String str4 = this.zbd;
            boolean z6 = this.zbc;
            VkpTextRecognizerOptions.Builder builder = VkpTextRecognizerOptions.builder(str3, str4, str2);
            builder.setEnableLowLatencyInBackground(z6);
            zbi zbiVarZba = zbi.zba(this.zba, builder.build());
            this.zbf = zbiVarZba;
            zbo zboVarZbc = zbiVarZba.zbc();
            if (!zboVarZbc.zbd()) {
                throw ((RemoteException) zboVarZbc.zbb().zba());
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final void zbd() {
        zbi zbiVar = this.zbf;
        if (zbiVar != null) {
            zbiVar.zbd();
            this.zbf = null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final zbf[] zbe(IObjectWrapper iObjectWrapper, zbnx zbnxVar) throws RemoteException {
        throw new RemoteException("#recognizeBitmap should not be triggered from text thick client.");
    }
}
