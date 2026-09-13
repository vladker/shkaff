package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class U implements com.bumptech.glide.load.engine.O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f3098a;

    public U(@NonNull Bitmap bitmap) {
        this.f3098a = bitmap;
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return L0.s.getBitmapByteSize(this.f3098a);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Bitmap get() {
        return this.f3098a;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
    }
}
