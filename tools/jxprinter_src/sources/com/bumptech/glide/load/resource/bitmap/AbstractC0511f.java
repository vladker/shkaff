package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0511f implements p126w0.z {
    public abstract Bitmap transform(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6);

    @Override // p126w0.z
    @NonNull
    public final com.bumptech.glide.load.engine.O transform(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.O o6, int i5, int i6) {
        if (!L0.s.e(i5, i6)) {
            throw new IllegalArgumentException(androidx.collection.a.m("Cannot apply transformation on width: ", i5, i6, " or height: ", " less than or equal to zero and not Target.SIZE_ORIGINAL"));
        }
        com.bumptech.glide.load.engine.bitmap_recycle.c bitmapPool = com.bumptech.glide.c.get(context).getBitmapPool();
        Bitmap bitmap = (Bitmap) o6.get();
        if (i5 == Integer.MIN_VALUE) {
            i5 = bitmap.getWidth();
        }
        if (i6 == Integer.MIN_VALUE) {
            i6 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(bitmapPool, bitmap, i5, i6);
        return bitmap.equals(bitmapTransform) ? o6 : C0510e.obtain(bitmapTransform, bitmapPool);
    }

    @Override // p126w0.z, p126w0.q
    public abstract /* synthetic */ void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
