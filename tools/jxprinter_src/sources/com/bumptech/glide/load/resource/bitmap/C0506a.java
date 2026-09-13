package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class C0506a implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p126w0.x f3102a;
    public final Resources b;

    @Deprecated
    public C0506a(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, p126w0.x xVar) {
        this(resources, xVar);
    }

    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull Object obj, int i5, int i6, @NonNull p126w0.v vVar) {
        return H.obtain(this.b, this.f3102a.decode(obj, i5, i6, vVar));
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Object obj, @NonNull p126w0.v vVar) {
        return this.f3102a.handles(obj, vVar);
    }

    public C0506a(@NonNull Resources resources, @NonNull p126w0.x xVar) {
        this.b = (Resources) L0.q.checkNotNull(resources);
        this.f3102a = (p126w0.x) L0.q.checkNotNull(xVar);
    }
}
