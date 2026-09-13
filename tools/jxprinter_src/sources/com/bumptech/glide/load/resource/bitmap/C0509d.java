package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0509d implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.d f3105a = new com.bumptech.glide.load.engine.bitmap_recycle.d();

    @Override // p126w0.x
    public /* bridge */ /* synthetic */ com.bumptech.glide.load.engine.O decode(@NonNull Object obj, int i5, int i6, @NonNull p126w0.v vVar) {
        return decode(androidx.media.a.d(obj), i5, i6, vVar);
    }

    @Override // p126w0.x
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Object obj, @NonNull p126w0.v vVar) {
        return handles(androidx.media.a.d(obj), vVar);
    }

    public com.bumptech.glide.load.engine.O decode(@NonNull ImageDecoder.Source source, int i5, int i6, @NonNull p126w0.v vVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new B0.c(i5, i6, vVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i5 + "x" + i6 + "]");
        }
        return new C0510e(bitmapDecodeBitmap, this.f3105a);
    }

    public boolean handles(@NonNull ImageDecoder.Source source, @NonNull p126w0.v vVar) {
        return true;
    }
}
