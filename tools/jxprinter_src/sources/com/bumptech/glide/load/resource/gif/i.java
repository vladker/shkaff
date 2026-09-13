package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import com.bumptech.glide.load.resource.bitmap.C0510e;
import java.security.MessageDigest;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements z {
    public final z b;

    public i(z zVar) {
        this.b = (z) L0.q.checkNotNull(zVar);
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.b.equals(((i) obj).b);
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // p126w0.z
    @NonNull
    public O transform(@NonNull Context context, @NonNull O o6, int i5, int i6) {
        f fVar = (f) o6.get();
        O c0510e = new C0510e(fVar.b(), com.bumptech.glide.c.get(context).getBitmapPool());
        z zVar = this.b;
        O oTransform = zVar.transform(context, c0510e, i5, i6);
        if (!c0510e.equals(oTransform)) {
            c0510e.recycle();
        }
        fVar.f3137a.frameLoader.b(zVar, (Bitmap) oTransform.get());
        return o6;
    }

    @Override // p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
