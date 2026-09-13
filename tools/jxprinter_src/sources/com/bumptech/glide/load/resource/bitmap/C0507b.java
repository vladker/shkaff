package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0507b implements p126w0.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.c f3103a;
    public final C0508c b;

    public C0507b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, C0508c c0508c) {
        this.f3103a = cVar;
        this.b = c0508c;
    }

    @Override // p126w0.y
    @NonNull
    public p126w0.c getEncodeStrategy(@NonNull p126w0.v vVar) {
        return this.b.getEncodeStrategy(vVar);
    }

    @Override // p126w0.y, p126w0.d
    public boolean encode(@NonNull com.bumptech.glide.load.engine.O o6, @NonNull File file, @NonNull p126w0.v vVar) {
        return this.b.encode((Object) new C0510e(((BitmapDrawable) o6.get()).getBitmap(), this.f3103a), file, vVar);
    }
}
