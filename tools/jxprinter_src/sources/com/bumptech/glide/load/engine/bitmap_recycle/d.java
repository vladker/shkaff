package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class d implements c {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public void b(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @NonNull
    public Bitmap get(int i5, int i6, Bitmap.Config config) {
        return Bitmap.createBitmap(i5, i6, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @NonNull
    public Bitmap getDirty(int i5, int i6, Bitmap.Config config) {
        return get(i5, i6, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final void c() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final void a(float f6) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final void trimMemory(int i5) {
    }
}
