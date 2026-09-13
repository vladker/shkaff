package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import com.bumptech.glide.load.resource.bitmap.C0510e;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.c f3158a;

    public o(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f3158a = cVar;
    }

    @Override // p126w0.x
    public O decode(@NonNull com.bumptech.glide.gifdecoder.b bVar, int i5, int i6, @NonNull v vVar) {
        return C0510e.obtain(bVar.getNextFrame(), this.f3158a);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull com.bumptech.glide.gifdecoder.b bVar, @NonNull v vVar) {
        return true;
    }
}
