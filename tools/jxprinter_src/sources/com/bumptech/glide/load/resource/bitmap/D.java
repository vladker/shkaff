package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class D implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.data.r f3086a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a b;
    public final List c;

    public D(List list, InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.b = (com.bumptech.glide.load.engine.bitmap_recycle.a) L0.q.checkNotNull(aVar);
        this.c = (List) L0.q.checkNotNull(list);
        this.f3086a = new com.bumptech.glide.load.data.r(inputStream, aVar);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public final void a() {
        K k6 = this.f3086a.f2925a;
        synchronized (k6) {
            k6.c = k6.f3091a.length;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    @Nullable
    public Bitmap decodeBitmap(BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(this.f3086a.rewindAndGet(), null, options);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public int getImageOrientation() {
        return p126w0.p.getOrientation((List<p126w0.g>) this.c, this.f3086a.rewindAndGet(), this.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public ImageHeaderParser$ImageType getImageType() {
        return p126w0.p.getType((List<p126w0.g>) this.c, this.f3086a.rewindAndGet(), this.b);
    }
}
