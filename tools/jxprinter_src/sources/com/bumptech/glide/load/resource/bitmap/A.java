package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class A implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3083a;
    public final List b;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a c;

    public A(byte[] bArr, List list, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3083a = bArr;
        this.b = list;
        this.c = aVar;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    @Nullable
    public Bitmap decodeBitmap(BitmapFactory.Options options) {
        byte[] bArr = this.f3083a;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public int getImageOrientation() {
        return p126w0.p.getOrientation((List<p126w0.g>) this.b, ByteBuffer.wrap(this.f3083a), this.c);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public ImageHeaderParser$ImageType getImageType() {
        return p126w0.p.getType(this.b, ByteBuffer.wrap(this.f3083a));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public final void a() {
    }
}
