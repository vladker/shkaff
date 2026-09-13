package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class E implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f3087a;
    public final List b;
    public final ParcelFileDescriptorRewinder c;

    public E(ParcelFileDescriptor parcelFileDescriptor, List list, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3087a = (com.bumptech.glide.load.engine.bitmap_recycle.a) L0.q.checkNotNull(aVar);
        this.b = (List) L0.q.checkNotNull(list);
        this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    @Nullable
    public Bitmap decodeBitmap(BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(this.c.rewindAndGet().getFileDescriptor(), null, options);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public int getImageOrientation() {
        return p126w0.p.getOrientation((List<p126w0.g>) this.b, this.c, this.f3087a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public ImageHeaderParser$ImageType getImageType() {
        return p126w0.p.getType((List<p126w0.g>) this.b, this.c, this.f3087a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public final void a() {
    }
}
