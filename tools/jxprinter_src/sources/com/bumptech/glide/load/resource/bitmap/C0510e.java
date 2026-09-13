package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class C0510e implements com.bumptech.glide.load.engine.O, com.bumptech.glide.load.engine.K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f3106a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public C0510e(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f3106a = (Bitmap) L0.q.checkNotNull(bitmap, "Bitmap must not be null");
        this.b = (com.bumptech.glide.load.engine.bitmap_recycle.c) L0.q.checkNotNull(cVar, "BitmapPool must not be null");
    }

    @Nullable
    public static C0510e obtain(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new C0510e(bitmap, cVar);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return L0.s.getBitmapByteSize(this.f3106a);
    }

    @Override // com.bumptech.glide.load.engine.K
    public final void initialize() {
        this.f3106a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
        this.b.b(this.f3106a);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Bitmap get() {
        return this.f3106a;
    }
}
