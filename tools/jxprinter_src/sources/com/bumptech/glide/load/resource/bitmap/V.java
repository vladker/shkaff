package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class V implements p126w0.x {
    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull Bitmap bitmap, int i5, int i6, @NonNull p126w0.v vVar) {
        return new U(bitmap);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Bitmap bitmap, @NonNull p126w0.v vVar) {
        return true;
    }
}
