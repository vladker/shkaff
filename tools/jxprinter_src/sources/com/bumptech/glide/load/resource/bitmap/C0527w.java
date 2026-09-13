package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0527w implements p126w0.z {
    public final p126w0.z b;
    public final boolean c;

    public C0527w(p126w0.z zVar, boolean z6) {
        this.b = zVar;
        this.c = z6;
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof C0527w) {
            return this.b.equals(((C0527w) obj).b);
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // p126w0.z
    @NonNull
    public com.bumptech.glide.load.engine.O transform(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.O o6, int i5, int i6) {
        com.bumptech.glide.load.engine.bitmap_recycle.c bitmapPool = com.bumptech.glide.c.get(context).getBitmapPool();
        Drawable drawable = (Drawable) o6.get();
        com.bumptech.glide.load.engine.O oConvert = AbstractC0526v.convert(bitmapPool, drawable, i5, i6);
        if (oConvert != null) {
            com.bumptech.glide.load.engine.O oTransform = this.b.transform(context, oConvert, i5, i6);
            if (!oTransform.equals(oConvert)) {
                return H.obtain(context.getResources(), oTransform);
            }
            oTransform.recycle();
            return o6;
        }
        if (!this.c) {
            return o6;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
