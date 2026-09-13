package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0529y extends AbstractC0511f {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(p126w0.q.f8812a);

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        return obj instanceof C0529y;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return 1572326941;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.AbstractC0511f
    public Bitmap transform(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        return T.fitCenter(cVar, bitmap, i5, i6);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.AbstractC0511f, p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
