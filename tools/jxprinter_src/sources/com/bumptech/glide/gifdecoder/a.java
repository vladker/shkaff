package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @NonNull
    Bitmap obtain(int i5, int i6, @NonNull Bitmap.Config config);

    @NonNull
    byte[] obtainByteArray(int i5);

    @NonNull
    int[] obtainIntArray(int i5);

    void release(@NonNull Bitmap bitmap);

    void release(@NonNull byte[] bArr);

    void release(@NonNull int[] iArr);
}
