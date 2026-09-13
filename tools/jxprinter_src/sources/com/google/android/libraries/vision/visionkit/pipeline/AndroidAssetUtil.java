package com.google.android.libraries.vision.visionkit.pipeline;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidAssetUtil {
    private static native boolean nativeInitializeAssetManager(Context context, String str);

    public static synchronized boolean zba(@NonNull Context context) {
        return nativeInitializeAssetManager(context, context.getCacheDir().getAbsolutePath());
    }
}
