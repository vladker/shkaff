package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class M extends AbstractC0511f {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(p126w0.q.f8812a);
    public final int b;

    public M(int i5) {
        L0.q.checkArgument(i5 > 0, "roundingRadius must be greater than 0.");
        this.b = i5;
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        return (obj instanceof M) && this.b == ((M) obj).b;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return L0.s.c(-569625254, L0.s.c(this.b, 17));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.AbstractC0511f
    public Bitmap transform(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        return T.roundedCorners(cVar, bitmap, this.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.AbstractC0511f, p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
}
