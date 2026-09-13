package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class L implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D0.h f3093a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public L(D0.h hVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f3093a = hVar;
        this.b = cVar;
    }

    @Override // p126w0.x
    @Nullable
    public com.bumptech.glide.load.engine.O decode(@NonNull Uri uri, int i5, int i6, @NonNull p126w0.v vVar) {
        com.bumptech.glide.load.engine.O oDecode = this.f3093a.decode(uri, i5, i6, vVar);
        if (oDecode == null) {
            return null;
        }
        return AbstractC0526v.convert(this.b, (Drawable) oDecode.get(), i5, i6);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Uri uri, @NonNull p126w0.v vVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
