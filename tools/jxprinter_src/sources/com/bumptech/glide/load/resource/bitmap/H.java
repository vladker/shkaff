package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class H implements com.bumptech.glide.load.engine.O, com.bumptech.glide.load.engine.K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f3089a;
    public final com.bumptech.glide.load.engine.O b;

    private H(@NonNull Resources resources, @NonNull com.bumptech.glide.load.engine.O o6) {
        this.f3089a = (Resources) L0.q.checkNotNull(resources);
        this.b = (com.bumptech.glide.load.engine.O) L0.q.checkNotNull(o6);
    }

    @Deprecated
    public static H obtain(Context context, Bitmap bitmap) {
        return (H) obtain(context.getResources(), C0510e.obtain(bitmap, com.bumptech.glide.c.get(context).getBitmapPool()));
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return this.b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.K
    public final void initialize() {
        com.bumptech.glide.load.engine.O o6 = this.b;
        if (o6 instanceof com.bumptech.glide.load.engine.K) {
            ((com.bumptech.glide.load.engine.K) o6).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
        this.b.recycle();
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f3089a, (Bitmap) this.b.get());
    }

    @Deprecated
    public static H obtain(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap) {
        return (H) obtain(resources, C0510e.obtain(bitmap, cVar));
    }

    @Nullable
    public static com.bumptech.glide.load.engine.O obtain(@NonNull Resources resources, @Nullable com.bumptech.glide.load.engine.O o6) {
        if (o6 == null) {
            return null;
        }
        return new H(resources, o6);
    }
}
