package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void a(float f6);

    void b(Bitmap bitmap);

    void c();

    @NonNull
    Bitmap get(int i5, int i6, Bitmap.Config config);

    @NonNull
    Bitmap getDirty(int i5, int i6, Bitmap.Config config);

    void trimMemory(int i5);
}
