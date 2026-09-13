package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0528x implements p126w0.g {
    @Override // p126w0.g
    public int getOrientation(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // p126w0.g
    @NonNull
    public ImageHeaderParser$ImageType getType(@NonNull InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // p126w0.g
    @NonNull
    public ImageHeaderParser$ImageType getType(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // p126w0.g
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        return getOrientation(L0.c.toStream(byteBuffer), aVar);
    }
}
