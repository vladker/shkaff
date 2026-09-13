package com.google.mlkit.vision.text.pipeline;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public abstract class VkpTextRecognizerOptions {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @KeepForSdk
    public static abstract class Builder {
        @NonNull
        @KeepForSdk
        public abstract VkpTextRecognizerOptions build();

        @KeepForSdk
        public abstract Builder setConfigLabel(String str);

        @NonNull
        @KeepForSdk
        public abstract Builder setEnableLowLatencyInBackground(boolean z6);

        @NonNull
        @KeepForSdk
        public abstract Builder setLanguageHint(@NonNull String str);

        @NonNull
        @KeepForSdk
        public abstract Builder setModelDir(@NonNull String str);
    }

    @NonNull
    @KeepForSdk
    public static Builder builder(@NonNull String str, @Nullable String str2, @NonNull String str3) {
        zbc zbcVar = new zbc();
        zbcVar.setConfigLabel(str);
        if (str2 == null) {
            str2 = "mlkit-google-ocr-models";
        }
        zbcVar.setModelDir(str2);
        zbcVar.setLanguageHint(str3);
        zbcVar.setEnableLowLatencyInBackground(false);
        return zbcVar;
    }

    public abstract String zba();

    public abstract String zbb();

    public abstract String zbc();

    public abstract boolean zbd();
}
