package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @NonNull
    ByteBuffer getData();

    @Deprecated
    int getLoopCount();

    @Nullable
    Bitmap getNextFrame();

    int read(@Nullable InputStream inputStream, int i5);

    int read(@Nullable byte[] bArr);

    void setData(@NonNull d dVar, @NonNull ByteBuffer byteBuffer);

    void setData(@NonNull d dVar, @NonNull ByteBuffer byteBuffer, int i5);

    void setData(@NonNull d dVar, @NonNull byte[] bArr);

    void setDefaultBitmapConfig(@NonNull Bitmap.Config config);
}
